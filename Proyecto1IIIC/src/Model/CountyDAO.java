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

}
