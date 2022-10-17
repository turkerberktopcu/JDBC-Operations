
package com.mycompany.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author turker
 */
public class DbHelper {
     //Declaring my DB infos
    private String userName = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306";
    
    public Connection connection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    
    public void showErrorMessage(SQLException e){
        System.out.println("Error: "+ e.getMessage());
        System.out.println("Error Code: "+ e.getErrorCode());

    }
    
}
