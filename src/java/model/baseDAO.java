package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseDAO {
    Connection con;
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
       
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/quiz","rosh","rosh");
        return con;
    
}
}
