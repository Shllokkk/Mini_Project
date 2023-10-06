import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReviewPageController {

    @FXML
    private TextField sharefield;

    @FXML
    private Button submitbutton;
    @FXML
    private Button redirectToHomePagebutton;

    public void toHomePage() throws IOException {
        Stage currentstage=(Stage)submitbutton.getScene().getWindow();
        currentstage.close();
    }
}
