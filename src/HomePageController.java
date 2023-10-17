import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private Button usernamebutton;
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

    @FXML
    private ChoiceBox<String> choicebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] array={"Logout","Delete Account"};
        choicebox.getItems().addAll(array);

        choicebox.setOnAction(event -> {
            try {
                onLogoutClick(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        choicebox.setOnAction(event -> {
            try {
                onDeleteAccountClick(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void onUsernameButtonClick(ActionEvent event) throws IOException{
        Stage currentstage=(Stage)usernamebutton.getScene().getWindow();
        currentstage.close();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onLogoutClick(ActionEvent event) throws IOException {
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

    public void onDeleteAccountClick(ActionEvent event) throws IOException {
        Stage currentstage=(Stage)usernamebutton.getScene().getWindow();
        currentstage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeletePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

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
}

