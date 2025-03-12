/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SiCumple;

import java.sql.Connection;

import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public abstract class DBConnection {
    protected String URL = "";
    protected String USER  = "";
    protected String PASSWORD = "";

    protected Connection connection;
    
    
    // constructor
//    public DBConnection(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
//        }catch(ClassNotFoundException | SQLException e){
//            e.printStackTrace();
//        }
//    }
    
    public abstract void setConnection();
    
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
