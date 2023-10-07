/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnectionJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CtrlUser {

    private Connection connection;

    public CtrlUser(DBConnectionJava dbConnection) {
        connection = dbConnection.getConnection();
    }

    // Method to add a new user to the database
    public String addUser(String name, String firstName, String lastName, String email, String password, String entityId, String roleId) {
        String message = "User not added.";
        String sql = "INSERT INTO users (name, first_name, last_name, email, password, entity_id, role_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, entityId);
            preparedStatement.setString(7, roleId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                message = "User added successfully.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Method to edit an existing user in the database
    public String editUser(int idToUpdate, String name, String firstName, String lastName, String password, String entityId, String roleId) {
        String message = "User not updated.";
        String sql = "UPDATE users SET name=?, first_name=?, last_name=?, password=?, entity_id=?, role_id=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, entityId);
            preparedStatement.setString(6, roleId);
            preparedStatement.setInt(7, idToUpdate);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                message = "User updated successfully.";
            } else {
                message = "The searched user does not exist.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Method to delete a user from the database
    public String deleteUser(int idToDelete) {
        String message = "User not deleted.";
        String sql = "DELETE FROM users WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idToDelete);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                message = "The user has been deleted.";
            } else {
                message = "The searched user does not exist.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Method to validate user access
    public boolean validateAccess(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to search for a user's role
    public String searchUserRole(String firstName) {
        String sql = "SELECT role_id FROM users WHERE first_name=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("role_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Role not found.";
    }
}
