/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JRS
 */
public class LoginDAO {
      private final DBConnectionJava db;

        public LoginDAO(DBConnectionJava db) {
            this.db = db;}
     // Method to validate access
        public boolean validateAccess(String username, String password) {
            try (Connection connection = db.getConnection()) {
                String query = "SELECT role FROM users WHERE username = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String role = resultSet.getString("role");
                    return "Super_admin".equals(role) || "Admin".equals(role) || "Digitador".equals(role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                db.disconnect();
            }

            return false;
        }
    }

