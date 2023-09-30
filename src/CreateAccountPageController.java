import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountPageController {

    @FXML
    private TextField phonefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField unamefield;
    @FXML
    private TextField fnamefield;
    @FXML
    private TextField lnamefield;

    @FXML
    private PasswordField createpassfield;
    @FXML
    private PasswordField confpassfield;
    
    @FXML
    private Button redirectloginbutton;

    @FXML
    private Label successlabel;

}
