package MappingAndJFX;

import java.io.IOException;

import mainProjekt.Company;
import javafx.fxml.FXML;

public class PrimaryController {
    Company company = new Company();
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
