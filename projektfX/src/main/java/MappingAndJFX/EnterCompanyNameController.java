package MappingAndJFX;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EnterCompanyNameController implements ControlledScreenInterface {

    @FXML
    public static TextField Companyname;
    ScreensController myController;

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void switchToInput() throws IOException {
        //App.setRoot("input");
        myController.setScreen(App.inputID);
        App.setStageTitle("Kerndateneingabe");

        CompanyOverviewController.companyNameString = Companyname.getText();

        String UserEingabeCompany = Companyname.getText();
        Companyname.setText(String.valueOf(UserEingabeCompany));

    }

    public String getCompanyName(){
        return this.Companyname.getText();
    }
}