package com.archivos.fitmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author vicente
 */
public class DBConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/fitmanager?currentSchema=fitmanager,public";
    private static final String USER = "vm";
    private static final String PASS = "C325MTV";
    
    
    public static Connection getConnection() throws SQLException{
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASS);
        props.setProperty("ssl", "false");
        props.setProperty("currentSchema", "fitmanager");
        return DriverManager.getConnection(URL, props);
    }
            
      
}
