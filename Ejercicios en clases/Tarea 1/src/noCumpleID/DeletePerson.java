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
public class DeletePerson {
    public void DeletePerson(Connection connection, int id) {
        String query = "DELETE FROM persona WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Persona eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
