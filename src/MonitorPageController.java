import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    @FXML
    private TableView<User> incometable;
    @FXML
    private TableView<User> expensetable;
    @FXML
    private TableView<User> investmenttable;

    @FXML 
    private TableColumn<User,String> incomeamtcolumn;
    @FXML 
    private TableColumn<User,String> incometypecolumn;
    @FXML 
    private TableColumn<User,String> incomedesccolumn;
    @FXML 
    private TableColumn<User,String> expenseamtcolumn;;
    @FXML 
    private TableColumn<User,String> expensetypecolumn;
    @FXML 
    private TableColumn<User,String> expensedesccolumn;
    @FXML 
    private TableColumn<User,String> investamtcolumn;
    @FXML 
    private TableColumn<User,String> investtypecolumn;
    @FXML 
    private TableColumn<User,String> investdesccolumn;

    public ObservableList<User> incomelist=FXCollections.observableArrayList();
    public ObservableList<User> expenselist=FXCollections.observableArrayList();
    public ObservableList<User> investlist=FXCollections.observableArrayList();


    public void onGetFinancesButtonClick(ActionEvent event)  {

        String foreignkey=LoginPageController.foreignkey;

        String getincomedata = "select incometype,incomeamt,incomedesc from userincome where uemail ='"+foreignkey+"'";
        String getexpensedata = "select expensetype,expenseamt,expensedesc from userexpense where uemail ='"+foreignkey+"'";
        String getinvestmentdata = "select investmentype,investmentamt,investmentdesc from userinvestment where uemail ='"+foreignkey+"'";

        String getincomeamt="select sum(incomeamt) from userincome where uemail='"+foreignkey+"'";
        String getexpenseamt="select sum(expenseamt) from userexpense where uemail='"+foreignkey+"'";
        String getinvestmentamt="select sum(investmentamt) from userinvestment where uemail='"+foreignkey+"'";

        
        try {
            JDBC connectnow = new JDBC();
            Connection connectdb = connectnow.getconnection();
            Statement statement = connectdb.createStatement();

            ResultSet resultset = statement.executeQuery(getincomedata);

            while(resultset.next()) {
                String amount=resultset.getString("incomeamt");
                String type=resultset.getString("incometype");
                String desc=resultset.getString("incomedesc");

                User incomeobj=new User(amount, type, desc);

                System.out.println(incomeobj.getAmount()+incomeobj.getType()+incomeobj.getDesc());
                
                incomelist.add(incomeobj);
            }
            resultset=statement.executeQuery(getincomeamt);
            totalincomelabel.setText(resultset.getString(1));
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        incometable.setItems(incomelist);
    }
}

class User {

    private String amount;
    private String type;
    private String desc;

    public User(String amount,String type,String desc) {
        this.amount=amount;
        this.type=type;
        this.desc=desc;
    }

    public String getAmount() {
        return this.amount;
    }
    public String getType() {
        return this.type;
    }
    public String getDesc() {
        return this.desc;
    }
}