// JDBC (Java DataBase Connectivity) MySQL code 

import java.sql.*;                                                             // importing whole java.sql package to use its interfaces and classes

public class JDBC{     
    
    Connection connection=null;

    public Connection getconnection() throws ClassNotFoundException, SQLException{        // the main method may throw these checked exceptions 
                                                                             
        String url ="jdbc:mysql://localhost:3306/trial";                                            // if the url, username or password are incorrect
        String username ="root";                                                                     // it may throw SQLException
        String password ="Superfly23#";                   
        
        // load and register the MySQL Driver  
        Class.forName("com.mysql.cj.jdbc.Driver");                                         // this line may throw ClassNotFoundException                           

        // create connection to the database
        Connection connection =DriverManager.getConnection(url,username,password);                  
        System.out.println("Connection established!");

        //String query ="update sample set email='****Statement****' wher id=1";                       this line may throw SQLSyntaxErrorException

        //create a statement
        //Statement stmt =con.createStatement();
        // execute the statement
        //stmt.executeUpdate(query);
        //System.out.println("Statement executed!");

        //PreparedStatement prepstmt =con.prepareStatement("update sample set email='****PreparedStatement****' where id=2");  
        //prepstmt.executeUpdate();
        //System.out.println("PreparedStatement executed!");
        
        // close the connection
        //con.close();
        return connection;
    }
}