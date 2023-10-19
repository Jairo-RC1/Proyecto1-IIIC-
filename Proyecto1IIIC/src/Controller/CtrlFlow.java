/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import Model.*;
import javax.swing.table.TableRowSorter;

// Store the ID of the selected flow
public class CtrlFlow {

    FlowDAO dao = new FlowDAO();
    int id;
    // Load flow data into the JTable

    public void loadFlowData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        WaterSpringDAO waterdao = new WaterSpringDAO();
        SamplingSiteDAO samplingdao = new SamplingSiteDAO();

        List<Flow> flows = dao.readFlows();
        for (Flow flow : flows) {
            String waterName = waterdao.getWaterSpringNameById(flow.getWaterSpringId());
            String samplingName = samplingdao.getSamplingSiteNameById(flow.getSamplingId());

            Object[] row = {flow.getId(), flow.getCapacity(), flow.getMethod(), flow.getObservation(), flow.getDate(), flow.getClimate(), flow.getDone(), waterName, samplingName};
            model.addRow(row);
        }
    }

    // Add a new flow
    public void addFlow(JTextField capacity, JComboBox<String> cbxMethod, JTextField observation, JTextField date, JComboBox<String> cbxClimate, JComboBox<String> cbxDone, JComboBox<String> cbxFlowWater, JComboBox<String> cbxFlowSampling) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(date.getText());
            
            String selectedMethod = (String) cbxMethod.getSelectedItem();
            String selectedClimate = (String) cbxClimate.getSelectedItem();
            String selectedDone = (String) cbxDone.getSelectedItem();
            String selectedWater = (String) cbxFlowWater.getSelectedItem();
            String selectedSampling = (String) cbxFlowSampling.getSelectedItem();

            WaterSpringDAO waterdao = new WaterSpringDAO();
            SamplingSiteDAO samplingdao = new SamplingSiteDAO();
            int waterName = waterdao.getWaterSpringIdByName(selectedWater);
            int samplingName = samplingdao.getSamplingSiteIdByName(selectedSampling);

            this.dao.createFlow(new Flow(Integer.parseInt(capacity.getText()), selectedMethod, observation.getText(), flowDate, selectedClimate, selectedDone, waterName, samplingName));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en capacidad.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha (debe ser yyyy-MM-dd).");
        }
    }

    // Update an existing flow
    public void updateFlow(JTextField capacity, JComboBox<String> cbxMethod, JTextField observation, JTextField date, JComboBox<String> cbxClimate, JComboBox<String> cbxDone, JComboBox<String> cbxFlowWater, JComboBox<String> cbxFlowSampling) {
        try {
            // Parse the capacity
            int flowCapacity = Integer.parseInt(capacity.getText());

            // Get the selected values in the JComboBox for climate, done, flowWater, and flowSampling
            String selectedMethod = (String) cbxMethod.getSelectedItem();
            String climate = (String) cbxClimate.getSelectedItem();
            String done = (String) cbxDone.getSelectedItem();
            String flowWaterName = (String) cbxFlowWater.getSelectedItem();
            String flowSamplingName = (String) cbxFlowSampling.getSelectedItem();

            // Instance of the WaterSpringDAO and SamplingSiteDAO classes
            WaterSpringDAO waterSpringDAO = new WaterSpringDAO();
            SamplingSiteDAO samplingSiteDAO = new SamplingSiteDAO();

            // Convert flowWaterName and flowSamplingName into their respective IDs
            int flowWaterId = waterSpringDAO.getWaterSpringIdByName(flowWaterName);
            int flowSamplingId = samplingSiteDAO.getSamplingSiteIdByName(flowSamplingName);

            // Parse the date (assuming it's in the format "yyyy-MM-dd")
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(date.getText());

            Flow flow = new Flow(this.id, flowCapacity, selectedMethod, observation.getText(), flowDate, climate, done, flowWaterId, flowSamplingId);

            dao.updateFlow(flow);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la capacidad.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha (debe ser yyyy-MM-dd).");
        }
    }

    // Delete the selected flow
    public void deleteFlow() {
        this.dao.deleteFlow(this.id);
    }

    // Select a row in the table to work with
    public void selectFlowRow(JTable table, JTextField capacity, JComboBox<String> cbxMethod, JTextField observation, JTextField date, JComboBox<String> cbxClimate, JComboBox<String> cbxDone, JComboBox<String> cbxFlowWater, JComboBox<String> cbxFlowSampling) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                capacity.setText(table.getValueAt(row, 1).toString());
                String method = (table.getValueAt(row, 2).toString());
                observation.setText(table.getValueAt(row, 3).toString());
                date.setText(table.getValueAt(row, 4).toString());

                // Get the values of the ComboBoxes (comboboxes)
                String climate = table.getValueAt(row, 5).toString();
                String done = table.getValueAt(row, 6).toString();
                String flowWaterName = table.getValueAt(row, 7).toString();
                String flowSamplingName = table.getValueAt(row, 8).toString();

                // Set the selected values in the ComboBoxes
                cbxMethod.setSelectedItem(method);
                cbxClimate.setSelectedItem(climate);
                cbxDone.setSelectedItem(done);
                cbxFlowWater.setSelectedItem(flowWaterName);
                cbxFlowSampling.setSelectedItem(flowSamplingName);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    // Clear input fields
    public void clearFields(JTextField capacity, JTextField observation, JTextField date) {
        capacity.setText("");
        observation.setText("");
        date.setText("");
    }
}
