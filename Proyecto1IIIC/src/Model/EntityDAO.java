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

/**
 *
 * @author JRS
 */
public class EntityDAO {
       public EntityDAO() {
    }

    public void entity(Entity entity) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO entities (legal_id, name, email, phone_number, address, description) VALUES (?, ?. ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Integer.toString(entity.getLegalId()));
            ps.setString(2, entity.getName());
            ps.setString(3, Integer.toString(entity.getPhoneNumber()));
            ps.setString(4, entity.getAddress());
            ps.setString(5, entity.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la entidad");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente la entidad, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<Entity> read() {

        DBConnectionJava db = new DBConnectionJava();
        List<Entity> entities = new ArrayList<>();
        String sql = "SELECT * FROM entities";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int legal_id = Integer.parseInt(resultSet.getString("legal_id"));
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int phone_number = Integer.parseInt(resultSet.getString("phone_number"));
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                entities.add(new Entity(id, legal_id, name, email, phone_number, address, description));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return entities;
    }

    public void update(Entity entity) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE entities SET legal_id=?, name=?, email=?, phone_number=?, address=?, description=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Integer.toString(entity.getLegalId()));
            ps.setString(2, entity.getName());
            ps.setString(3, Integer.toString(entity.getPhoneNumber()));
            ps.setString(4, entity.getAddress());
            ps.setString(5, entity.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.toString());
        }finally {
            db.disconnect();
        }
        
    }

    public void delete(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM entities WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente la entidad");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        }
        
    }
}
