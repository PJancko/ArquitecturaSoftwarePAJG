/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noCumpleID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public class EditPerson {
    public void UpdatePerson(Connection connection, Person person) {
        String query = "UPDATE persona SET nombre = ?, edad= ? ,correo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getEmail());
            stmt.setInt(4, person.getId());
            stmt.executeUpdate();
            System.out.println("Persona actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
