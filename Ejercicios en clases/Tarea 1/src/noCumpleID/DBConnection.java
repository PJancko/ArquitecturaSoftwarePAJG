/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noCumpleID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/db_persona?useSSL=false&serverTimezone=UTC";
    private static final String USER  = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    
    // constructor
    public DBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void CerrarConexion(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
