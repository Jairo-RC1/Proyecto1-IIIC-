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

public class CountyDAO {

    // Method to get the list of counties for a specific province
    public List<County> getCountiesForProvince(String selectedProvince) {
        DBConnectionJava db = new DBConnectionJava();
        List<County> counties = new ArrayList<>();
        String sql = "SELECT * FROM counties WHERE province_id = (SELECT id FROM provinces WHERE name = ?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, selectedProvince); // Sets a province name

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int provinceId = resultSet.getInt("province_id");

                County county = new County(id, name, provinceId);
                counties.add(county);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return counties;
    }

    public County getCountyByName(String cantonName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT * FROM counties WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, cantonName);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new County(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return null; // Return null if the canton is not found
    }

    public String getCountyNameById(int cantonId) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM counties WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, cantonId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("No se encontró un cantón con el ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException("Error al consultar el cantón por ID.");
        } finally {
            db.disconnect();
        }
    }

    public int getCountyIdByName(String cantonName) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM counties WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, cantonName);
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
