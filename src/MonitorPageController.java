import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MonitorPageController {
    @FXML
    private Label totalincomelabel;
    @FXML
    private Label totalexpenselabel;
    @FXML
    private Label totalinvestlabel;
    @FXML
    private Label flaglabel;
    @FXML
    private Label messagelabel;

    @FXML
    private Button getfinances;





    public void onGetFinancesButtonClick() throws Exception{
        String foreignkey=LoginPageController.foreignkey;

        JDBC connectnow=new JDBC();
        Connection connectdb=connectnow.getconnection();

        //String datainsert="insert into userinvestment values ('"+foreignkey+"','"+typefield.getText()+"','"+amtfield.getText()+"','"+descfield.getText()+"')";
        String getdata="select (incomeamt) from userincome where uemail='"+foreignkey+"'";

        Statement statement=connectdb.createStatement();
        ResultSet result=statement.executeQuery(getdata);
    }
}
