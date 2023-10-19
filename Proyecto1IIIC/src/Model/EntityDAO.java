/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntityDAO {
    
     // Constructor
    public EntityDAO() {
    }
    // Method to create a new entity record in the database
    public void createEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO entities (legal_id, name, email, phone_number, address, description) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setLong(1, entity.getLegalId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getPhoneNumber());
            ps.setString(5, entity.getAddress());
            ps.setString(6, entity.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Entidad insertada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar la entidad, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
       // Method to retrieve a list of all entities from the database
    public List<Entity> readEntities() {
        DBConnectionJava db = new DBConnectionJava();
        List<Entity> entities = new ArrayList<>();
        String sql = "SELECT * FROM entities";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                long legalId = resultSet.getLong("legal_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                entities.add(new Entity(id, legalId, name, email, phoneNumber, address, description));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return entities;
    }
    // Method to update an existing entity record in the database
    public void updateEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE entities SET legal_id=?, name=?, email=?, phone_number=?, address=?, description=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setLong(1, entity.getLegalId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getPhoneNumber());
            ps.setString(5, entity.getAddress());
            ps.setString(6, entity.getDescription());
            ps.setInt(7, entity.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la entidad, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    // Method to delete an entity record from the database by ID
    public void deleteEntity(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM entities WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Entidad eliminada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la entidad, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    // Method to get an entity by its name
    public Entity getEntityByName(String entityName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT * FROM entities WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, entityName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Agrega aquí más columnas si es necesario
                return new Entity(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // Return null if the entity is not found
    }
    // Method to get the name of an entity by its ID
    public String getEntityNameById(int entityId) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM entities WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, entityId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("No se encontró una entidad con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException("Error al consultar la entidad por ID.");
        } finally {
            db.disconnect();
        }
    }
    // Method to retrieve a list of entity names
    public List<Entity> readEntitiesNames() {
        DBConnectionJava db = new DBConnectionJava();
        List<Entity> entities = new ArrayList<>();
        String sql = "SELECT * FROM entities"; // Assuming the entity table name is "entities"

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                entities.add(new Entity(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return entities;
    }
    // Method to retrieve the ID of an entity by its name
    public int getEntityIdByName(String entityName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM entities WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, entityName);
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
