import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        // Create the scene and set it on the primary stage
        Scene scene = new Scene(root, 844, 676);
        primaryStage.setScene(scene);
        // Set the title of the primary stage
        primaryStage.setTitle("JavaFX Application");
        // Show the primary stage
        primaryStage.show();
    }
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}