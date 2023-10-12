import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InvestPageController {

    @FXML
    private TextField typefield;
    @FXML
    private TextField amtfield;
    @FXML
    private TextField descfield;

    @FXML
    private Button savebutton;

    public void onSaveButtonClick(ActionEvent event) throws Exception{
        if(!typefield.getText().isEmpty()&&!amtfield.getText().isEmpty()) {
            saveDetails(event);
            typefield.setStyle("-fx-background-color: #e9f5f9;");
            amtfield.setStyle("-fx-background-color: #e9f5f9;");
            typefield.setText("");
            amtfield.setText("");
            descfield.setText("");
            typefield.setPromptText("");
            amtfield.setPromptText("In INR");
            descfield.setPromptText("Upto 100 words....");
        }
        else {
            typefield.setPromptText("⚠ Mandatory Field!");
            amtfield.setPromptText("⚠ Mandatory Field!");
            typefield.setStyle("-fx-border-color: red;");
            amtfield.setStyle("-fx-border-color: red;");
        }
    }

    private void saveDetails(ActionEvent event) throws Exception{
        String foreignkey=LoginPageController.foreignkey;

        JDBC connectnow=new JDBC();
        Connection connectdb=connectnow.getconnection();

        String datainsert="insert into userinvestment values ('"+foreignkey+"','"+typefield.getText()+"',"+Integer.parseInt(amtfield.getText())+",'"+descfield.getText()+"',curdate())";

        Statement statement=connectdb.createStatement();
        int x=statement.executeUpdate(datainsert);
        if(x!=0) 
            System.out.println("investment data inserted!");
        else 
            System.out.println("failed to insert investment data!");
    }
}