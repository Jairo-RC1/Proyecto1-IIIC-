/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnectionJava;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlUser {


    public CtrlUser() {

    }

    public void createUser(User user) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "INSERT INTO users (name, first_name, last_name, email, password, entity_id, role_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getEntityId());
            preparedStatement.setString(7, user.getRoleId());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el usuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
    }

    public List<User> readUsers() {
        DBConnectionJava db = new DBConnectionJava();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String entityId = resultSet.getString("entity_id");
                String roleId = resultSet.getString("role_id");
                users.add(new User(id, name, firstName, lastName, email, password, entityId, roleId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();// Disconnects data base
        }
        return users;
    }

    public void updateUser(User user) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "UPDATE users SET name=?, first_name=?, last_name=?, email=?, password=?, entity_id=?, role_id=? WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getEntityId());
            preparedStatement.setString(7, user.getRoleId());
            preparedStatement.setInt(8, user.getId());
            preparedStatement.execute();
             JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.getMessage());
        } finally {
            db.disconnect();// Disconnects data base
        }
    }

    public void deleteUser(int id) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "DELETE FROM users WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Se eliminó correctamente el usuario");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
    }
}
