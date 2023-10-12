/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnectionJava;
import Model.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CtrlEntity {
    
     public CtrlEntity() {

    }

    public void createEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "INSERT INTO entities (legalId, name, email, phoneNumber, address, description) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, entity.getLegalId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setInt(4, entity.getPhoneNumber());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setString(6, entity.getDescription());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la entidad");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente la entidad, error: " + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
    }

    public List<Entity> readEntities() {
        DBConnectionJava db = new DBConnectionJava();
        List<Entity> entities = new ArrayList<>();
        String sql = "SELECT * FROM entities";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int legalId = resultSet.getInt("legalId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                entities.add(new Entity(id,legalId, name, email, phoneNumber, address, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
        return entities;
    }

    public void updateEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "UPDATE entities SET legalId=?, name=?, email=?, phoneNumber=?, address=?, description=? WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, entity.getLegalId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setInt(4, entity.getPhoneNumber());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setString(6, entity.getDescription());
            preparedStatement.setInt(8, entity.getId());
            preparedStatement.execute();
             JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
    }

    public void deleteEntity(int id) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "DELETE FROM entities WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Se eliminó correctamente la entidad ");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.getMessage());
        } finally {
            db.disconnect(); // Disconnects data base
        }
    }
}
