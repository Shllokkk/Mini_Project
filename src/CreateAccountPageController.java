import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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

        errorlabel.setText("");
        fnamefield.setStyle("");
        lnamefield.setStyle("");
        emailfield.setStyle("");
        phonefield.setStyle("");
        unamefield.setStyle("");
        createpassfield.setStyle("");
        confpassfield.setStyle("");

        if (!fnamefield.getText().isEmpty() && !lnamefield.getText().isEmpty() && !emailfield.getText().isEmpty() && 
        !phonefield.getText().isEmpty() && !createpassfield.getText().isEmpty() && !confpassfield.getText().isEmpty()) {
            
            if(createpassfield.getText().length()<8) {
                createpassfield.setStyle("-fx-border-color: red;");
                confpassfield.setStyle("-fx-border-color: red;");

                createpassfield.setText("");
                confpassfield.setText("");

                createpassfield.setPromptText("⚠ Minimum length is 8 characters!");
                confpassfield.setPromptText("⚠ Minimum length is 8 characters!");
            }
            else {
                fnamefield.setStyle("");
                lnamefield.setStyle("");
                emailfield.setStyle("");
                phonefield.setStyle("");
                unamefield.setStyle("");
                createpassfield.setStyle("");
                confpassfield.setStyle("");
                validateSignUp(event);
            }
            
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
                if(fnamefield.getText().isEmpty())
                    fnamefield.setStyle("-fx-border-color: red;");

                if(lnamefield.getText().isEmpty())
                    lnamefield.setStyle("-fx-border-color: red;");

                if(emailfield.getText().isEmpty()) 
                    emailfield.setStyle("-fx-border-color: red;");
    
                if(phonefield.getText().isEmpty()) 
                    phonefield.setStyle("-fx-border-color: red;");
                
                if(unamefield.getText().isEmpty()) 
                    unamefield.setStyle("-fx-border-color: red;");

                if(createpassfield.getText().isEmpty() || confpassfield.getText().isEmpty()) {
                    createpassfield.setStyle("-fx-border-color: red;");
                    confpassfield.setStyle("-fx-border-color: red;");
                }
            }
        }
    }

    private void validateSignUp(ActionEvent event) throws Exception{
        System.out.println("Inside validateSignUp....");

        String phoneno=phonefield.getText();
        String emailId=emailfield.getText();
        String password=createpassfield.getText();

        int flag=0;

        String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String passwordRegex="^[a-zA-Z0-9]+$";

        Pattern emailPattern=Pattern.compile(emailRegex);
        Pattern passwordPattern=Pattern.compile(passwordRegex);

        if(phoneno.length()!=10) {
            phonefield.setStyle("-fx-border-color: red;");
            phonefield.setText("");
            phonefield.setPromptText("⚠ Please enter valid phone number!");
            flag++;
        }
        if(!(emailPattern.matcher(emailId).matches())) {
            emailfield.setStyle("-fx-border-color: red;");
            emailfield.setText("");
            emailfield.setPromptText("⚠ Please enter valid email ID!");
            flag++;
        }

        if((passwordPattern.matcher(password).matches())) {
            createpassfield.setStyle("-fx-border-color: red;");
            confpassfield.setStyle("-fx-border-color: red;");

            createpassfield.setText("");
            confpassfield.setText("");

            createpassfield.setPromptText("⚠ Passowrd should be alphanumeric");
            confpassfield.setPromptText("⚠ Passowrd should be alphanumeric");
            flag++;
        }

        if(flag==0) {
            phonefield.setStyle("");
            errorlabel.setText("");

            int check=0;
            flag=0;

            JDBC connectnow=new JDBC();
            Connection connectdb=connectnow.getconnection();

            Statement statement=null;
            statement=connectdb.createStatement();
        
            String emailcheck="select count(1) from userdetails where useremail = '" + emailfield.getText() +"'";
            String phonecheck="select count(1) from userdetails where userphn= '" + phonefield.getText() +"'";
            String unamecheck="select count(1) from userdetails where username= '" + unamefield.getText() +"'";

            ResultSet emailresult=statement.executeQuery(emailcheck);
            while(emailresult.next()&&flag==0) {
                if(emailresult.getInt(1)==1) {
                    errorlabel.setText("Account for this email address already exists!");
                    flag++;
                }
                else
                    check++;
            }
            ResultSet phoneresult=statement.executeQuery(phonecheck);
            while(phoneresult.next()&&flag==0) {
                if(phoneresult.getInt(1)==1) {
                    errorlabel.setText("Account for this phone no. already exists!");
                    flag++;
                }
                else
                    check++;
            }
            ResultSet unameresult=statement.executeQuery(unamecheck);
            while(unameresult.next()&&flag==0) {
                if(unameresult.getInt(1)==1)
                    errorlabel.setText("Account for this username already exists!");
                else
                    check++;
            }

            if(check>2) {
                String insertusercredentials="insert into usercredentials (email,password) values ('"+emailfield.getText()+"','"+confpassfield.getText()+"')";
                String insertuserdetails="insert into userdetails (username,firstname,lastname,userphn,useremail,timestamp) values ('"+unamefield.getText()+"','"+fnamefield.getText()+"','"+lnamefield.getText()+"','"+phonefield.getText()+"','"+emailfield.getText()+"',curdate())";

                int x=statement.executeUpdate(insertusercredentials);
                int y=statement.executeUpdate(insertuserdetails);
                if(x==1&&y==1) {
                    System.out.println("data inserted!");

                    fnamefield.setText("");
                    lnamefield.setText("");
                    emailfield.setText("");
                    phonefield.setText("");
                    unamefield.setText("");
                    createpassfield.setText("");
                    confpassfield.setText("");

                    errorlabel.setTextFill(Color.GREEN);
                    errorlabel.setText("Sign up successful!");
                }
                else
                    System.out.println("failed to insert data!");
            }
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