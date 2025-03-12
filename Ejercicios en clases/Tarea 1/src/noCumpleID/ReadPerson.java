/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noCumpleID;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author jharif
 */
public class ReadPerson {
    public void ReadPerson(Connection connection){
        String query = "SELECT * FROM persona";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = Integer.parseInt(rs.getString("edad"));
                String correo = rs.getString("correo");
                System.out.println(new Person(id, nombre, edad, correo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
