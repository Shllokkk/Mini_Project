import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {
    
    @FXML
    private TextField emailfield;

    @FXML
    private PasswordField passfield;

    @FXML
    private Button loginbutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button forgotpassbutton;

    @FXML Label label;

    public void click() {
        //String str=emailfield.getText();
        label.setText("User details added successfully!");
    }
}
