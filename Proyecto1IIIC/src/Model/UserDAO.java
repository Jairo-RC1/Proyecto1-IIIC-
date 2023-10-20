/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.DBConnectionJava;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDAO {
    // Constructor for the UserDAO class
    public UserDAO() {

    }
      // Method to create a new user in the database
    public void createUser(User user) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO users (name, last_name, email, password, entity_id, role_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getEntityId());
            ps.setInt(6, user.getRoleId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    // Method to retrieve a list of all users from the database
    public List<User> readUser() {
        DBConnectionJava db = new DBConnectionJava();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int entityId = resultSet.getInt("entity_id");
                int roleId = resultSet.getInt("role_id");
                users.add(new User(id, name, lastName, email, password, entityId, roleId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return users;
    }
     // Method to update an existing user in the database
    public void updateUser(User user) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE users SET name=?, last_name=?, email=?, password=?, entity_id=?, role_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getEntityId());
            ps.setInt(6, user.getRoleId());
            ps.setInt(7, user.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    // Method to delete a user by their ID
    public void deleteUser(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM users WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

}
