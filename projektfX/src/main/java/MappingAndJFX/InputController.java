package MappingAndJFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainProjekt.Company;
import mainProjekt.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class InputController implements ControlledScreenInterface {


    @FXML
    public TextField unternehmennameDB;
    @FXML
    public TextField jahresueberschussDB;
    @FXML
    public TextField eigenkapitalDB;
    @FXML
    public TextField idDB;
    @FXML
    public TextField datumDB;
    @FXML
    public TextField gewinnschaetzungDB;
    @FXML
    public TextField gewinnavgDB;
    @FXML
    public TextField kursamtagderveroeffentlichungDB;
    @FXML
    public TextField perfinjedemmonatDB;
    @FXML
    public TextField gewinnVor3JahrenDB;
    @FXML
    public TextField gewinnVor2JahrenDB;
    @FXML
    public TextField gewinnVor1JahrDB;
    @FXML
    public TextField aktuellerErwarteterKursgewinnDB;
    @FXML
    public TextField kursgewinnschaetzungNaechstesJahrDB;
    @FXML
    public TextField jahresumsatzDB;
    @FXML
    private TextField gewinnEBITDB;
    @FXML
    private TextField fremdkapitalDB;
    @FXML
    private TextField aktuellerAktienkursDB;
    @FXML
    private TextField geschaetzterGewinnDB;
    @FXML
    private TextField analystenKaufenDB;
    @FXML
    private TextField analystenVerkaufenDB;
    @FXML
    private TextField analystenHaltenDB;
    @FXML
    private TextField kursanstiegUnternehmenDB;
    @FXML
    private TextField kursanstiegAktienindexDB;
    @FXML
    private TextField gewinnschaetzungVor4WochenDB;
    @FXML
    private TextField aktuelleGewinnschaetzungDB;
    @FXML
    private TextField aktienkursVor6MonatenDB;
    @FXML
    private TextField aktienkursVor12MonatenDB;
    @FXML
    private TextField kursVor1MonatDB;
    @FXML
    private TextField kursVor2MonatenDB;
    @FXML
    private TextField kursVor3MonatenDB;
    @FXML
    private TextField aktienkursVor1MonatDB;
    @FXML
    private TextField aktienkursVor2MonatenDB;
    @FXML
    private TextField aktienkursVor3MonatenDB;
    @FXML
    private TextField gewinnschaetzungNaechstesJahrDB;
    @FXML
    private TextField gewinnschaetzungDiesesJahrDB;
    @FXML
    private CheckBox smallCapDB;
    @FXML
    private CheckBox finanzwerteDB;

    ScreensController myController;
    private Connection con;

    public ObservableList<Company> addtoDB = FXCollections.observableArrayList(
            new Company()
    );
    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }


    @FXML
    private void switchToShowResult() throws IOException {
        fillDBvalues();
        //App.setRoot("showResult");
       // setValues();
        myController.setScreen(App.showResultID);
        App.setStageTitle("Unternehmensergebnisse");
    }

    public void switchToPrimaryPage(ActionEvent actionEvent) throws IOException {
        //App.setRoot("startPage");
        //TODO Schließe die Session, zurück zu Startseite
        myController.setScreen(App.startPageID);
        App.setStageTitle("Hauptmenü");
    }

    private void fillDBvalues() {
        //TODO Die vom Benutzer eingegebenen Daten in die MySQL Datenbank schreiben
        //Load the jdbc diver
        System.out.println("Trying to load the JDBC driver...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) {
            System.err.println("Cound not load JDBC driver...");
            System.err.println(e);
            throw new IllegalStateException("Failed loading the JDBC driver!");
        }

        //connect to the levermann database
        System.out.println("Trying to connect to Levermann database...");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/levermann?useSSL=false&serverTimezone=UTC", "Levermann", "Levermann");
            System.out.println("Levermann database connected!");
        } catch (Exception e) {
            System.err.println("Could not connect to Leverman database...");
            System.err.println(e);
            throw new IllegalStateException("Failed connecting to Levermann database!");
        }
    }

        //TODO Füge hier SQL-Queries ein, die die jeweiligen Datensätze in die Table "Company" hinzufügen
private void disconnectToDB(){
        System.out.println("Trying to close the connection to Levermann database...");
        try{
            con.close();
            System.out.println("Levermann database disconnected!");
        }catch(Exception e){
            System.err.println("Could not disconnect Leverman database...");
            System.err.println(e);
            throw new IllegalStateException("Failed disconnecting Levermann database!");
        }
    }

        /**
         *
         * MysqlDataSource dataSource = new MysqlDataSource();
         * dataSource.setUser("Levermann");
         * dataSource.setPassword("Levermann");
         * dataSource.setServerName("jdbc:mysql://localhost:3306/levermann");
         * Connection conn = dataSource.getconnection();**/
         //TODO Füge hier SQL-Queries ein, die die jeweiligen Datensätze in die Table "Company" hinzufügen

        /**
         * conn.close();
         */

        @FXML
        public void someMethod (ActionEvent event){
            fillDBvalues();

            String companyname = unternehmennameDB.getText();
            String datum = "12.32.42";
            float eigenkapital = Float.parseFloat(eigenkapitalDB.getText());
            float jahresueberschuss = Float.parseFloat(jahresueberschussDB.getText());
            float gewinnEBIT = Float.parseFloat(gewinnEBITDB.getText());
            float jahresumsatz = Float.parseFloat(jahresumsatzDB.getText());
            float fremdkapital = Float.parseFloat(fremdkapitalDB.getText());
            float aktuellerAktienkurs = Float.parseFloat(aktuellerAktienkursDB.getText());
            float gewinnschaezung = Float.parseFloat(aktuelleGewinnschaetzungDB.getText());
            float gewinnAVG = Float.parseFloat(gewinnavgDB.getText());
            float halten = 1;
            float verkaufen = 0;
            float kaufen = 0;
            float kursanstiegUnternehmen = Float.parseFloat(kursanstiegUnternehmenDB.getText());
            float kursanstiegIndex = Float.parseFloat(kursanstiegAktienindexDB.getText());
            float gewinnschaezungVor4Wochen = Float.parseFloat(gewinnEBITDB.getText());
            float aktienkursTagVeroeffentlichungQartalszahlen = Float.parseFloat(gewinnEBITDB.getText());
            float kursVor6Monaten = Float.parseFloat(aktienkursVor6MonatenDB.getText());
            float kursVor12Monaten = Float.parseFloat(aktienkursVor12MonatenDB.getText());
            float kursVor3Monaten = Float.parseFloat(kursVor3MonatenDB.getText());
            float kursVor2Monaten = Float.parseFloat(kursVor2MonatenDB.getText());
            float kursVor1Monat = Float.parseFloat(kursVor1MonatDB.getText());
            float daxVor1Monat = Float.parseFloat(aktienkursVor1MonatDB.getText());
            float daxVor2Monaten = Float.parseFloat(aktienkursVor2MonatenDB.getText());
            float daxVor3Monaten = Float.parseFloat(aktienkursVor3MonatenDB.getText());
            float gewinnschaezungDiesesJahr = Float.parseFloat(gewinnschaetzungDiesesJahrDB.getText());
            float gewinnschaezungNaechstesJahr = Float.parseFloat(gewinnschaetzungNaechstesJahrDB.getText());
            float finanzsektor = 1;
            int perfInJedemMonat = Integer.parseInt(perfinjedemmonatDB.getText());
            int kursgewinnVor3Jahren = Integer.parseInt(gewinnVor3JahrenDB.getText());
            int kursgewinnVor2Jahren = Integer.parseInt(gewinnVor2JahrenDB.getText());
            int kursgewinnVor1Jahr = Integer.parseInt(gewinnVor1JahrDB.getText());
            int aktuellenErwartetenKursgewinn = Integer.parseInt(aktuellerErwarteterKursgewinnDB.getText());
            int kursgewinnschaezungNaechstesJahr = Integer.parseInt(kursgewinnschaetzungNaechstesJahrDB.getText());

            Company company = new Company(companyname,  datum,  eigenkapital,  jahresueberschuss,  gewinnEBIT,
             jahresumsatz,  fremdkapital,  aktuellerAktienkurs,  gewinnschaezung,
             gewinnAVG,  halten,  verkaufen,  kaufen,  kursanstiegUnternehmen,
             kursanstiegIndex,  gewinnschaezungVor4Wochen,
             aktienkursTagVeroeffentlichungQartalszahlen,  kursVor6Monaten,  kursVor12Monaten,
             kursVor3Monaten,  kursVor2Monaten,  kursVor1Monat,  daxVor1Monat,
             daxVor2Monaten,  daxVor3Monaten,  gewinnschaezungNaechstesJahr,
             gewinnschaezungDiesesJahr,  finanzsektor, perfInJedemMonat,
                     kursgewinnVor3Jahren,  kursgewinnVor2Jahren,  kursgewinnVor1Jahr,
                     aktuellenErwartetenKursgewinn,  kursgewinnschaezungNaechstesJahr);
            addtoDB.add(company);


            Session session1 = HibernateUtil.getSessionFactory().openSession();
            session1.beginTransaction();
            session1.save(company);
            session1.getTransaction().commit();
            session1.close();

            disconnectToDB();
        }
    }

