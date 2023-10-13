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

    public EntityDAO() {
    }

    public void createEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO entities (legal_id, name, email, phone_number, address, description) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, entity.getLegalId());
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

    public List<Entity> readEntities() {
        DBConnectionJava db = new DBConnectionJava();
        List<Entity> entities = new ArrayList<>();
        String sql = "SELECT * FROM entities";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int legalId = resultSet.getInt("legal_id");
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

    public void updateEntity(Entity entity) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE entities SET legal_id=?, name=?, email=?, phone_number=?, address=?, description=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, entity.getLegalId());
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

}
