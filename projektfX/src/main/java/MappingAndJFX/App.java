package MappingAndJFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainProjekt.Company;
import mainProjekt.CompanyG;
import mainProjekt.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final Logger log = Logger.getLogger(HibernateUtil.class);
    static Transaction transaction;
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static  SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                /*
                 * Load up the configuration using the hibernate.cfg.xml
                 */
                org.hibernate.cfg.Configuration configuration = new Configuration()
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mavenjavafxcompany?useSSL=false&serverTimezone=UTC")
                        .setProperty("hibernate.connection.username", "MavenJFX")
                        .setProperty("hibernate.connection.password", "mavenjfx")
                        .setProperty("hibernate.connection.autoReconnect", "true")
                        .setProperty("hibernate.order_updates", "true")
                        .addAnnotatedClass(mainProjekt.Company.class)
                        .addAnnotatedClass(mainProjekt.AnalysisSteps.class)
                        .addAnnotatedClass(mainProjekt.AnalysisRating.class);
                //(HibernateUtil.class.getResource("/resources" +"/hibernate.cfg.xml"));

                /*
                 * Build the registry using the properties in the configuration
                 */
                StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
                serviceRegistryBuilder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed" + ex);
            ex.printStackTrace();
        }
        return sessionFactory;
    }
    public static SessionFactory getSessionFactory() {return sessionFactory;}
    public static void shutdown() {getSessionFactory().close();}

    /**
     * The main utility method to be used to retreive the transaction.
     *
     * @return {@link Transaction} The transaction of the current session
     */
    public static  Transaction getTransaction() throws Exception {
        Session s = getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();
        tx.setTimeout(10);
        return tx;

    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static <session> void main(String[] args) {
        launch();
        final Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            CompanyG companyG = new CompanyG();
            companyG.setSession(session);

            Company company = new Company();
            company.setCompanyname("LandFlorian");
            company.setEigenkapital(123214);
            company.setFremdkapital(324234);
            System.out.println("Got name with credentials " + company.getCompanyname());

            companyG.makePersistent(company);
            Company company1 = companyG.getACompanyByID(company.getCompanyname());
            System.out.println(company1.getCompanyname());

            session.save(company);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Done !");
        }

    }
    }


