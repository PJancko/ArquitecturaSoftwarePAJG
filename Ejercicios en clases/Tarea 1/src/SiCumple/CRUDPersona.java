/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SiCumple;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class CRUDPersona {

    DBConnection conexion;

    public CRUDPersona(DBConnection conexion) {
        this.conexion = conexion;
    }

    public boolean CreatePerson(Person person) {

        String query = "INSERT INTO persona (nombre,edad, correo) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeletePerson(int id) {
        String query = "DELETE FROM persona WHERE id = ?";
        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdatePerson(Person person) {
        String query = "UPDATE persona SET nombre = ?, edad= ? ,correo = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getEmail());
            stmt.setInt(4, person.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Person> ReadPersons() {
        String query = "SELECT * FROM persona";
        ArrayList<Person> personas = new ArrayList<>();

        Connection conn = conexion.getConnection();
        if (conn == null) {
            System.out.println("❌ Error: La conexión a la base de datos no está establecida.");
            return personas; // Retorna una lista vacía si la conexión es nula
        }

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad"); // ✅ Corrección: No es necesario convertir a String
                String correo = rs.getString("correo");

                personas.add(new Person(nombre, edad, correo));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al leer los registros de la tabla 'persona': " + e.getMessage());
            e.printStackTrace();
        }

        return personas;
    }

    public Person ReadPerson(int id) {
        String query = "SELECT * FROM persona where id =" + id;

        try (Statement stmt = conexion.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            String nombre = rs.getString("nombre");
            int edad = Integer.parseInt(rs.getString("edad"));
            String correo = rs.getString("correo");
            return new Person(nombre, edad, correo);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
