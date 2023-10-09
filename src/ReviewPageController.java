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
    private Button redirectHomebutton;

    public void onRedirectHomeButtonClick() throws IOException {
        Stage currentstage=(Stage)submitbutton.getScene().getWindow();
        currentstage.close();
    }
}
