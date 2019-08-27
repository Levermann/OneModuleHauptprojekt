package MappingAndJFX;

import javafx.fxml.FXML;

import java.io.IOException;

public class StartPageController implements ControlledScreenInterface {

    ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void switchToEnterCompanyName() throws IOException {
        //App.setRoot("enterCompanyName");
        myController.setScreen(App.enterCompanyNameID);
        App.setStageTitle("Unternehmensnamen angeben");
        /**
         Image imageBackground = new Image(getClass().getResource("pictures/aktienchart.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

        ImageView imageView = new ImageView(imageBackground);
         **/
    }
    @FXML
    private void switchToCompanyOverview() throws IOException{
        //App.setRoot("companyOverview");
        myController.setScreen(App.companyOverviewID);
        App.setStageTitle("Allgemeine Unternehmensübersicht");
    }
    @FXML
    private void switchToInformations() throws IOException{
        //App.setRoot("companyOverview");
        myController.setScreen(App.informationID);
        App.setStageTitle("Allgemeine Unternehmensübersicht");
    }
}
