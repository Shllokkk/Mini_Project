import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class CreateAccountPageController {

    @FXML
    private TextField fnamefield;
    @FXML
    private TextField lnamefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField phonefield;
    @FXML
    private TextField unamefield;
    

    @FXML
    private PasswordField createpassfield;
    @FXML
    private PasswordField confpassfield;

    @FXML
    private Label errorlabel;

    @FXML
    private Button redirectloginbutton;
    @FXML
    private Button signupbutton;


    public void onSignUpButtonClick(ActionEvent event) throws Exception {

        System.out.println("Button clicked!");
        if (!fnamefield.getText().isEmpty() && !lnamefield.getText().isEmpty() && !emailfield.getText().isEmpty() && 
        !phonefield.getText().isEmpty()&& !createpassfield.getText().isEmpty() && !confpassfield.getText().isEmpty()) {
 
            validateSignUp(event);
            errorlabel.setText("Sign Up successful!");
            fnamefield.setStyle("");
            lnamefield.setStyle("");
            emailfield.setStyle("");
            phonefield.setStyle("");
            unamefield.setStyle("");
            createpassfield.setStyle("");
            confpassfield.setStyle("");
        }

        else {
            if (fnamefield.getText().isEmpty() && lnamefield.getText().isEmpty() && emailfield.getText().isEmpty() && 
            phonefield.getText().isEmpty()&& createpassfield.getText().isEmpty() && confpassfield.getText().isEmpty()) {

                errorlabel.setText("⚠ Please enter details!");
                fnamefield.setStyle("-fx-border-color: red;");
                lnamefield.setStyle("-fx-border-color: red;");
                emailfield.setStyle("-fx-border-color: red;");
                phonefield.setStyle("-fx-border-color: red;");
                unamefield.setStyle("-fx-border-color: red;");
                createpassfield.setStyle("-fx-border-color: red;");
                confpassfield.setStyle("-fx-border-color: red;");
            }
            else {
                if(fnamefield.getText().isEmpty() || lnamefield.getText().isEmpty()){
                    fnamefield.setStyle("-fx-border-color: red;");
                    lnamefield.setStyle("-fx-border-color: red;");
                }
                else {
                    fnamefield.setStyle("");
                    lnamefield.setStyle("");
                }   

                if(emailfield.getText().isEmpty()) 
                    emailfield.setStyle("-fx-border-color: red;");
                else 
                    emailfield.setStyle("");
    
                if(phonefield.getText().isEmpty()) 
                    phonefield.setStyle("-fx-border-color: red;");
                else 
                    phonefield.setStyle("");
                
                if(unamefield.getText().isEmpty()) 
                    unamefield.setStyle("-fx-border-color: red;");
                else 
                    unamefield.setStyle("");

                if(createpassfield.getText().isEmpty() || confpassfield.getText().isEmpty()) {
                    errorlabel.setText("⚠ Please enter and confirm password!");
                    createpassfield.setStyle("-fx-border-color: red;");
                    confpassfield.setStyle("-fx-border-color: red;");
                }
            }
        }
    }

    private void validateSignUp(ActionEvent event) throws Exception{
        System.out.println("Inside validateSignUp....");
        JDBC connectnow=new JDBC();
        Connection connectdb=connectnow.getconnection();
        
        String recordcheck="select count(1) from userlogindetails where email = '" + emailfield.getText() +"'";

        Statement statement=null;
        statement=connectdb.createStatement();

        ResultSet result=statement.executeQuery(recordcheck);
        while(result.next()) {
            if(result.getInt(1)==1)
                errorlabel.setText("record exists!");
        }
    }

    public void onRedirectLoginButtonClick() throws IOException {
        Stage currentstage= (Stage)redirectloginbutton.getScene().getWindow();
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