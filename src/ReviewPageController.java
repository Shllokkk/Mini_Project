import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReviewPageController {

    @FXML
    private TextArea sharearea;

    @FXML
    private Button submitbutton;
    @FXML
    private Button redirectHomebutton;

<<<<<<< HEAD
    public void onRedirectHomeButtonClick() throws IOException {
=======
    @FXML
    private Label errorlabel;

    public void onSubmitButtonClick(ActionEvent event) throws Exception{

        String foreignkey=LoginPageController.foreignkey;
        sharearea.setWrapText(true);

        JDBC connectnow=new JDBC();
        Connection connectdb=connectnow.getconnection();

        String datainsert="insert into userreview values ('"+foreignkey+"','"+sharearea.getText()+"')";

        Statement statement=connectdb.createStatement();
        int x=statement.executeUpdate(datainsert);
        if(x!=0) {
            System.out.println("Review data inserted!");
            errorlabel.setText("Review recorded! ThankYou");
            sharearea.setText("");
        }
        else 
            System.out.println("failed to insert review data!");
    }

    public void toHomePage() throws IOException {
>>>>>>> 1ae252473308cf46d1f30575455e8c874a3f8fec
        Stage currentstage=(Stage)submitbutton.getScene().getWindow();
        currentstage.close();
    }
}
