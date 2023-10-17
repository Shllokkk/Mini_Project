import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeletePageController {

    @FXML
    private TextField passfield;

    @FXML
    private Button redirectHomeButton;
    @FXML
    private Button yesbutton;
    @FXML
    private Button okbutton;
    @FXML
    private Button nobutton;

    public void onOkButtonClick(ActionEvent event) throws Exception{
        if(!passfield.getText().isEmpty()) {
            
            validatePassword(event);
        }
        else {
            passfield.setStyle("-fx-border-color: red;");
            passfield.setPromptText("⚠ Please Enter Password!");
        }
    }
    
    public void onYesButtonClick(ActionEvent event) throws Exception{
        String foreignkey=LoginPageController.foreignkey;

        JDBC connectnow= new JDBC();
        Connection connectdb=connectnow.getconnection();

        Statement statement=connectdb.createStatement();

        String deletecredentials="Delete from usercredentials where email='"+foreignkey+"'";
        String deleteincome="Delete from userincome where uemail='"+foreignkey+"'";
        String deleteexpense="Delete from userexpense where uemail='"+foreignkey+"'";
        String deleteinvestment="Delete from userinvestment where uemail='"+foreignkey+"'";
        String deletereview="Delete from userreview where uemail='"+foreignkey+"'";
        String deletedetails="Delete from userdetails where useremail='"+foreignkey+"'";

        int a=statement.executeUpdate(deletecredentials);
        int b=statement.executeUpdate(deleteincome);
        int c=statement.executeUpdate(deleteexpense);
        int d=statement.executeUpdate(deleteinvestment);
        int e=statement.executeUpdate(deletereview);
        int f=statement.executeUpdate(deletedetails);

        if(a!=0) {
            Stage currentstage= (Stage)passfield.getScene().getWindow();
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

    public void onNoButtonClick(ActionEvent event) throws Exception{
        Stage currentstage= (Stage)passfield.getScene().getWindow();
        currentstage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public void onRedirectHomeButtonClick(ActionEvent event) throws Exception{
        Stage currentstage= (Stage)passfield.getScene().getWindow();
        currentstage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    private void validatePassword(ActionEvent event) throws Exception{

        String checkpass="select * from usercredentials where password='"+passfield.getText()+"'";

        JDBC connectnow= new JDBC();
        Connection connectdb=connectnow.getconnection();

        Statement statement=connectdb.createStatement();

        ResultSet resultset=statement.executeQuery(checkpass);

        if(!resultset.next()) {
            passfield.setText("");
            passfield.setStyle("-fx-border-color: red;");
            passfield.setPromptText("⚠ Invalid Password!");
        }
        else {
            yesbutton.setDisable(false);
            nobutton.setDisable(false);
            passfield.setStyle("");
            passfield.setText("");
            passfield.setPromptText("");
        }
    }
}
    