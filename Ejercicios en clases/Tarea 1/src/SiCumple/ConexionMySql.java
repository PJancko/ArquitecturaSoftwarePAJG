/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SiCumple;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public class ConexionMySql extends DBConnection {

    public ConexionMySql() {
        this.URL = "jdbc:mysql://localhost:3306/db_persona?useSSL=false&serverTimezone=UTC";
        this.USER = "root";
        this.PASSWORD = "";
        setConnection();
    }

    @Override
    public void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: Driver JDBC no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error: No se pudo conectar a MySQL. Verifica la URL, usuario y contraseña.");
            e.printStackTrace();
        }
    }

}
