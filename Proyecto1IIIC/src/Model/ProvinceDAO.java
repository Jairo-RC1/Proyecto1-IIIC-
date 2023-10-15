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
}
