import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @FXML
    private Button savebutton;

    public void toHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void toLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }
}
