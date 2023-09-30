import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }
}
