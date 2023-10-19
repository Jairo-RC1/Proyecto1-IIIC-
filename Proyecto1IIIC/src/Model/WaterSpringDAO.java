/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Method to create a new water spring record
public class WaterSpringDAO {

    public void createWaterSpring(WaterSpring waterSpring) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO water_springs (name, address, latitude, longitude, description, province_id, county_id, district_id, entity_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, waterSpring.getName());
            ps.setString(2, waterSpring.getAddress());
            ps.setString(3, waterSpring.getLatitude());
            ps.setString(4, waterSpring.getLongitude());
            ps.setString(5, waterSpring.getDescription());
            ps.setInt(6, waterSpring.getProvinceId());
            ps.setInt(7, waterSpring.getCountyId());
            ps.setInt(8, waterSpring.getDistrictId());
            ps.setInt(9, waterSpring.getEntityId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Naciente insertada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar la Naciente, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
// Method to retrieve a list of all water springs

    public List<WaterSpring> readWaterSprings() {
        DBConnectionJava db = new DBConnectionJava();
        List<WaterSpring> waterSprings = new ArrayList<>();
        String sql = "SELECT * FROM water_springs";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String latitude = resultSet.getString("latitude");
                String longitude = resultSet.getString("longitude");
                String description = resultSet.getString("description");
                int provinceId = resultSet.getInt("province_id");
                int countyId = resultSet.getInt("county_id");
                int districtId = resultSet.getInt("district_id");
                int entityId = resultSet.getInt("entity_id");
                waterSprings.add(new WaterSpring(id, name, address, latitude, longitude, description, provinceId, countyId, districtId, entityId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return waterSprings;
    }
    // Method to update a water spring record

    public void updateWaterSpring(WaterSpring waterSpring) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE water_springs SET name=?, address=?, latitude=?, longitude=?, description=?, province_id=?, county_id=?, district_id=?, entity_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, waterSpring.getName());
            ps.setString(2, waterSpring.getAddress());
            ps.setString(3, waterSpring.getLatitude());
            ps.setString(4, waterSpring.getLongitude());
            ps.setString(5, waterSpring.getDescription());
            ps.setInt(6, waterSpring.getProvinceId());
            ps.setInt(7, waterSpring.getCountyId());
            ps.setInt(8, waterSpring.getDistrictId());
            ps.setInt(9, waterSpring.getEntityId());
            ps.setInt(10, waterSpring.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la Naciente, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
// Method to delete a water spring record by ID

    public void deleteWaterSpring(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM water_springs WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Naciente eliminada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la Naciente, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public WaterSpring getWaterSpringByName(String waterName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT * FROM water_springs WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, waterName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new WaterSpring(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // Return null if the sampling is not found
    }

    public String getWaterSpringNameById(int waterSpringId) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM water_springs WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, waterSpringId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("No se encontró un manantial con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException("Error al consultar el manantial por ID.");
        } finally {
            db.disconnect();
        }
    }

    public int getWaterSpringIdByName(String waterSpringName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM water_springs WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, waterSpringName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return -1;
    }

}
