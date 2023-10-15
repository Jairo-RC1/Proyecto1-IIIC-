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

public class DistrictDAO {

    public List<District> getDistrictsForCounty(String countyName) {
        DBConnectionJava db = new DBConnectionJava();
        List<District> districts = new ArrayList<>();
        String sql = "SELECT * FROM districts WHERE county_id = (SELECT id FROM counties WHERE name = ?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, countyName);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int countyId = resultSet.getInt("county_id");

                District district = new District(id, name, countyId);
                districts.add(district);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return districts;
    }
}
