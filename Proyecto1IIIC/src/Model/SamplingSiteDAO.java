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

public class SamplingSiteDAO {

    public void createSamplingSite(SamplingSite samplingSite) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO samplings_sities (name, province_id, county_id, district_id, entity_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, samplingSite.getName());
            ps.setInt(2, samplingSite.getProvinceId());
            ps.setInt(3, samplingSite.getCountyId());
            ps.setInt(4, samplingSite.getDistrictId());
            ps.setInt(5, samplingSite.getEntityId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Sitio de muestreo creado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el sitio de muestreo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public List<SamplingSite> readSamplingSites() {
        DBConnectionJava db = new DBConnectionJava();
        List<SamplingSite> samplingSites = new ArrayList<>();
        String sql = "SELECT * FROM samplings_sities";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int provinceId = resultSet.getInt("province_id");
                int countyId = resultSet.getInt("county_id");
                int districtId = resultSet.getInt("district_id");
                int entityId = resultSet.getInt("entity_id");
                samplingSites.add(new SamplingSite(id, name, provinceId, countyId, districtId, entityId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return samplingSites;
    }

    public void updateSamplingSite(SamplingSite samplingSite) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE samplings_sities SET name=?, province_id=?, county_id=?, district_id=?, entity_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, samplingSite.getName());
            ps.setInt(2, samplingSite.getProvinceId());
            ps.setInt(3, samplingSite.getCountyId());
            ps.setInt(4, samplingSite.getDistrictId());
            ps.setInt(5, samplingSite.getEntityId());
            ps.setInt(6, samplingSite.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el sitio de muestreo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public void deleteSamplingSite(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM samplings_sities WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Sitio de muestreo eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el sitio de muestreo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
}
