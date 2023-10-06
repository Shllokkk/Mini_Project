import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button usernamebutton;
    @FXML
    private Button logoutbutton;
    @FXML
    private Button addincomebutton;
    @FXML
    private Button addexpensebutton;
    @FXML
    private Button investmentbutton;
    @FXML
    private Button monitorbutton;
    @FXML
    private Button sharebutton;

    public void onAddIncomeButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IncomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }
    
    public void onAddExpenseButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpensePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onInvestmentButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvestPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onMonitorButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MonitorPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onShareButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReviewPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onLogoutButtonClick() throws IOException {
        Stage currentstage=(Stage)usernamebutton.getScene().getWindow();
        currentstage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }
}

