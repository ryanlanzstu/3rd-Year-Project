/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author ryanl
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class databaseConnection {
    
    static final String DB_URL = "jdbc:mysql://localhost:3307/project";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection openConnection(){
        Connection conn = null;
        try{
            //Open connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        }catch(Exception ex){
            System.out.println("There were errors while connecting to db.");
            return null;
        }
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error while closing the connection.");
        }
    }
    
}
