package MappingAndJFX;

import com.fasterxml.classmate.AnnotationConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainProjekt.Company;
import mainProjekt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowUserInputController implements ControlledScreenInterface {



    ScreensController myController;

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }


    @FXML
    public void switchToPrimaryPageAgain(ActionEvent actionEvent) throws IOException {
        //App.setRoot("startPage");
        //TODO Schließe die Session, zurück zu Startseite
        myController.setScreen(App.startPageID);
        App.setStageTitle("Hauptmenü");
    }


}