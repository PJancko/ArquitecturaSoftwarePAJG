/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SiCumple;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janck
 */
public class ConexionPostgres extends DBConnection {

    public ConexionPostgres() {
        this.URL = "jdbc:postgresql://localhost:5432/db_persona";
        this.USER = "postgres";
        this.PASSWORD = "1234";
        setConnection();
    }
    
    @Override
    public void setConnection() {
        try {
            Class.forName("org.postgresql.Driver"); // ✅ Se debe cargar el driver de PostgreSQL
            this.connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            System.out.println("✅ Conexión exitosa a PostgreSQL");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a PostgreSQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
