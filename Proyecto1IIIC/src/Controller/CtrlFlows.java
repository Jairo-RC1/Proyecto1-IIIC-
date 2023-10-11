package Controller;

import Model.DBConnectionJava;
import Model.Flows;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlFlows {


    public CtrlFlows() {

    }

    public void createFlows(Flows flows) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "INSERT INTO flows (name, address, latitude, longitude, descriptio, province_id, county_id,disctric_id, entity_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, flows.getName());
            preparedStatement.setString(2, flows.getAddress());
            preparedStatement.setDouble(3, flows.getLatitude());
            preparedStatement.setDouble(4, flows.getLongitude());
            preparedStatement.setString(5, flows.getDescription());
            preparedStatement.setInt(6, flows.getProvince_id());
            preparedStatement.setInt(7, flows.getCounty_id());
            preparedStatement.setInt(8, flows.getDisctric_id());
            preparedStatement.setInt(9, flows.getEntity_id());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el usuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect(); // Desconectar la base de datos
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
                String address = resultSet.getString("address");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                String description = resultSet.getString("description");
                int provinceId = resultSet.getInt("province_id");
                int countyId = resultSet.getInt("county_id");
                int disctricId = resultSet.getInt("disctric_id");
                int entityId = resultSet.getInt("entity_id");
                Flows.add(new Flows(id, name, address, latitude, longitude, description, provinceId, countyId, disctricId, entityId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect(); // Desconectar la base de datos
        }
        return users;
    }

    public void updateFlowes(Flows flows) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "UPDATE flows SET name=?, address=?, latitude=?, longitude=?, description=?, province_id=?, county_id=?, disctric_id=?,entity_id=?  WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, flows.getName());
            preparedStatement.setString(2, flows.getAddress());
            preparedStatement.setDouble(3, flows.getLatitude());
            preparedStatement.setDouble(4, flows.getLongitude());
            preparedStatement.setString(5, flows.getDescription());
            preparedStatement.setInt(6, flows.getProvince_id());
            preparedStatement.setInt(7, flows.getCounty_id());
            preparedStatement.setInt(7, flows.getDisctric_id());
            preparedStatement.setInt(7, flows.getEntity_id());
            preparedStatement.setInt(8, flows.getId());
            preparedStatement.execute();
             JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.getMessage());
        } finally {
            db.disconnect(); // Desconectar la base de datos
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
            db.disconnect(); // Desconectar la base de datos
        }
    }
}