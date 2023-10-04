import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {
    
    @FXML
    private TextField emailfield;

    @FXML
    private PasswordField passfield;

    @FXML
    private Button loginbutton;
    @FXML
    private Button registerbutton;

    @FXML Label errorlabel;

    public void onLoginButonClick(ActionEvent event) throws Exception{
        if(!emailfield.getText().isEmpty()&&!passfield.getText().isEmpty()) {
            errorlabel.setText("");
            emailfield.setStyle("");
            passfield.setStyle("");

            validateLogin(event);
       }
        else if(emailfield.getText().length()==0&&passfield.getText().length()==0) {
            errorlabel.setText("⚠ Please enter UserEmail or Password!");
            emailfield.setStyle("-fx-border-color: red;");
            passfield.setStyle("-fx-border-color: red;");
        }

        else if(emailfield.getText().length()==0) {
            errorlabel.setText("⚠ Please enter UserEmail!");
            emailfield.setStyle("-fx-border-color: red;");
            passfield.setStyle("");
        }

        else if(passfield.getText().length()==0) {
            errorlabel.setText("⚠ Please enter Password!");
            emailfield.setStyle("");
            passfield.setStyle("-fx-border-color: red;");
        }
    }

    private void validateLogin(ActionEvent event) throws ClassNotFoundException,SQLException,IOException{
        JDBC connectnow = new JDBC();
        Connection connectdb = connectnow.getconnection();

        String verifylogin = "select count(1) from userlogindetails where email = '" + emailfield.getText() + "' and password  = '" + passfield.getText() + "'";

        Statement statement = null;
        statement = connectdb.createStatement();

        ResultSet queryResult = statement.executeQuery(verifylogin);
        
        while(queryResult.next()){
            if (queryResult.getInt(1)==1){
                errorlabel.setText("Login successful!");

                Stage currentstage=(Stage)registerbutton.getScene().getWindow();
                currentstage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 844, 676);
                Stage primaryStage=new Stage();
                primaryStage.setScene(scene);
                primaryStage.setTitle("JavaFX Application");
                primaryStage.show();
            }
            else {
                errorlabel.setText("⚠ Invalid User!");
                emailfield.setStyle("-fx-border-color: red;");
                emailfield.setText("");
                passfield.setText("");
                passfield.setStyle("-fx-border-color: red;");
            }
        }
    }

    public void onRegisterButtonClick() throws IOException {
        Stage currentstage=(Stage)registerbutton.getScene().getWindow();
        currentstage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccountPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 844, 676);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }
}