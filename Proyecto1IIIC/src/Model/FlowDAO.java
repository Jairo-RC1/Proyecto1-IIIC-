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
import java.util.Date;
import javax.swing.JOptionPane;

public class FlowDAO {

    public void createFlow(Flow flow) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO flows (capacity, method, observation, date, climate, done, waterSpringId, samplingId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, flow.getCapacity());
            ps.setString(2, flow.getMethod());
            ps.setString(3, flow.getObservation());
            ps.setDate(4, new java.sql.Date(flow.getDate().getTime()));
            ps.setString(5, flow.getClimate());
            ps.setString(6, flow.getDone());
            ps.setInt(7, flow.getWaterSpringId());
            ps.setInt(8, flow.getSamplingId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Flujo creado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el flujo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public List<Flow> readFlows() {
        DBConnectionJava db = new DBConnectionJava();
        List<Flow> flows = new ArrayList<>();
        String sql = "SELECT * FROM flows";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int capacity = resultSet.getInt("capacity");
                String method = resultSet.getString("method");
                String observation = resultSet.getString("observation");
                Date date = resultSet.getDate("date");
                String climate = resultSet.getString("climate");
                String done = resultSet.getString("done");
                int waterSpringId = resultSet.getInt("waterSpringId");
                int samplingId = resultSet.getInt("samplingId");
                flows.add(new Flow(id, capacity, method, observation, date, climate, done, waterSpringId, samplingId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return flows;
    }

    public void updateFlow(Flow flow) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE flows SET capacity=?, method=?, observation=?, date=?, climate=?, done=?, waterSpringId=?, samplingId=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, flow.getCapacity());
            ps.setString(2, flow.getMethod());
            ps.setString(3, flow.getObservation());
            ps.setDate(4, new java.sql.Date(flow.getDate().getTime()));
            ps.setString(5, flow.getClimate());
            ps.setString(6, flow.getDone());
            ps.setInt(7, flow.getWaterSpringId());
            ps.setInt(8, flow.getSamplingId());
            ps.setInt(9, flow.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el flujo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public void deleteFlow(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM flows WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Flujo eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el flujo, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

}
