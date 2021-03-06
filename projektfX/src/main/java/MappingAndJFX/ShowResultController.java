package MappingAndJFX;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ShowResultController implements ControlledScreenInterface{

    //configure to the table
    @FXML private TableView<Object> tableView;

    ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void switchToCompanyOverview() throws IOException{
        //App.setRoot("companyOverview");
        myController.setScreen(App.companyOverviewID);
        App.setStageTitle("Allgemeine Unternehmensübersicht");
    }

    @FXML
    private void switchToShowUserInputs() throws IOException{
        //App.setRoot("companyOverview");
        myController.setScreen(App.showUserInputID);
        App.setStageTitle("Allgemeine Unternehmensübersicht");
    }
}