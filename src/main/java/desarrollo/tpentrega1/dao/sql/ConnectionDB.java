/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author imsac
 */
public class ConnectionDB {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/tp_desarrollo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "45215979";
    private static Connection connection = null;
    
    private ConnectionDB(){
        
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null)
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    
}
