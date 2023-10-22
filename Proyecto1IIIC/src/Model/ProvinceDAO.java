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

public class ProvinceDAO {
     // Method to retrieve a list of all provinces
    public List<Province> readProvinces() {
        DBConnectionJava db = new DBConnectionJava();
        List<Province> provinces = new ArrayList<>();
        String sql = "SELECT * FROM provinces";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                provinces.add(new Province(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return provinces;
    }
    
    // Method to retrieve a province by name
    public Province getProvincesByName(String provinceName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT * FROM provinces WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, provinceName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Province(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // Return null if the province is not found
    }
     // Method to retrieve the name of a province by its ID
    public String getProvinceNameById(int provinceId) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM provinces WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, provinceId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("No se encontró una provincia con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException("Error al consultar la provincia por ID.");
        } finally {
            db.disconnect();
        }
    }
     // Method to retrieve the ID of a province by name
    public int getProvinceIdByName(String provinceName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM provinces WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, provinceName);
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
