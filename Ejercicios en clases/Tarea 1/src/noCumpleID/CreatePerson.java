/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noCumpleID;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author jharif
 */
public class CreatePerson {

    public void CreatePerson(Connection connection, Person person) {

        String query = "INSERT INTO persona (nombre,edad, correo) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getEmail());
            stmt.executeUpdate();
            System.out.println("Persona creada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}