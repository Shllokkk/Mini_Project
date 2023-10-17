import java.sql.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserPageController implements Initializable{

    @FXML
    private Label usernamelabel;
    @FXML
    private Label namelabel;
    @FXML
    private Label phonelabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label timestamplabel;

    @FXML
    private Button redirecthomebutton;

    @Override
    public void initialize(URL url,ResourceBundle rb) {
        try {
            String foreignkey=LoginPageController.foreignkey;

            JDBC connectnow=new JDBC();
            Connection connectdb=connectnow.getconnection();

            String getdetails=null;

            Statement statement=connectdb.createStatement();

            ResultSet resultset=statement.executeQuery(getdetails);

            

        }catch(ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }

    public void onRedirectHomeButtonClick() throws IOException {
        Stage currentstage=(Stage)redirecthomebutton.getScene().getWindow();
        currentstage.close();
    }
}
