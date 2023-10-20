/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO {
    
    // Method to retrieve a list of all roles from the database
    public List<Rol> readRoles() {
        DBConnectionJava db = new DBConnectionJava();
        List<Rol> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles";

        try {
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                roles.add(new Rol(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return roles;
    }
    // Method to retrieve a role by its name
    public Rol getRolByName(String roleName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT * FROM roles WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, roleName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                
                return new Rol(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // Returns null if role not found
    }
    // Method to retrieve a role's name by its ID
    public String getRoleNameById(int roleId) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM roles WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, roleId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // If you do not find a name corresponding to the ID
    }
    // Method to retrieve a role's ID by its name
    public int getRoleIdByName(String roleName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM roles WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, roleName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return -1; // You can choose a default value if no corresponding ID is found
    }

}
