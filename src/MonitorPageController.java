import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class MonitorPageController implements Initializable {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        incomeamtcolumn.setCellValueFactory(new PropertyValueFactory<>("Income Amount"));
        incometypecolumn.setCellValueFactory(new PropertyValueFactory<>("Income Type"));
        incomedesccolumn.setCellValueFactory(new PropertyValueFactory<>("Income Description"));

        expenseamtcolumn.setCellValueFactory(new PropertyValueFactory<>("Expense Amount"));
        expensetypecolumn.setCellValueFactory(new PropertyValueFactory<>("Expense Type"));
        expensedesccolumn.setCellValueFactory(new PropertyValueFactory<>("Income Description"));

        investamtcolumn.setCellValueFactory(new PropertyValueFactory<>("Investment Amount"));
        investtypecolumn.setCellValueFactory(new PropertyValueFactory<>("Investment Type"));
        investdesccolumn.setCellValueFactory(new PropertyValueFactory<>("Investment Description"));

        String foreignkey=LoginPageController.foreignkey;
        int income=0,expense=0;

        String getincomedata = "select incometype,incomeamt,incomedesc from userincome where uemail ='"+foreignkey+"'";
        String getexpensedata = "select expensetype,expenseamt,expensedesc from userexpense where uemail ='"+foreignkey+"'";
        String getinvestmentdata = "select investmenttype,investmentamt,investmentdesc from userinvestment where uemail ='"+foreignkey+"'";

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
            resultset.next();
            totalincomelabel.setText("₹ "+resultset.getString(1));
            income=Integer.parseInt(resultset.getString(1));

            resultset=statement.executeQuery(getexpensedata);

            while(resultset.next()) {
                String amount=resultset.getString("expenseamt");
                String type=resultset.getString("expensetype");
                String desc=resultset.getString("expensedesc");

                User expenseobj=new User(amount, type, desc);

                System.out.println(expenseobj.getAmount()+expenseobj.getType()+expenseobj.getDesc());
                
                expenselist.add(expenseobj);
            }
            resultset=statement.executeQuery(getexpenseamt);
            resultset.next();
            totalexpenselabel.setText("₹ "+resultset.getString(1));
            expense=Integer.parseInt(resultset.getString(1));

            resultset=statement.executeQuery(getinvestmentdata);

            while(resultset.next()) {
                String amount=resultset.getString("investmentamt");
                String type=resultset.getString("investmenttype");
                String desc=resultset.getString("investmentdesc");

                User investmentobj=new User(amount, type, desc);

                System.out.println(investmentobj.getAmount()+investmentobj.getType()+investmentobj.getDesc());
                
                investlist.add(investmentobj);
            }
            resultset=statement.executeQuery(getinvestmentamt);
            resultset.next();
            totalinvestlabel.setText("₹ "+resultset.getString(1));

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        incometable.setItems(incomelist);
        expensetable.setItems(expenselist);
        investmenttable.setItems(investlist);

        calculateFiscalLibility(income,expense);

        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    private void calculateFiscalLibility(int income,int expense) {
        
        if(expense>income*0.25) {
            flaglabel.setStyle("-fx-background-color: #ff0000");
            messagelabel.setTextFill(Color.RED);
            messagelabel.setText("Your Expenses are not within the advised range in accordance to your Income!");
        }
        else {
            flaglabel.setStyle("-fx-background-color: #00ff00");
            messagelabel.setTextFill(Color.GREEN);
            messagelabel.setText("Your expenses are within the advised limit in accordance to your Income!");
            messagelabel.setWrapText(true);
        }
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