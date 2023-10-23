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
import java.util.Locale;
import java.util.Random;
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

            Object[] row = {flow.getId(), flow.getCapacity(), flow.getMethod(), flow.getObservation(),
                flow.getDate(), flow.getClimate(), flow.getDone(), waterName, samplingName};
            model.addRow(row);
        }
    }

    // Add a new flow
    public void addFlow(JTextField capacity, JComboBox<String> cbxMethod, JTextField observation, JTextField date, JComboBox<String> cbxClimate, JComboBox<String> cbxDone, JComboBox<String> cbxFlowWater, JComboBox<String> cbxFlowSampling) {
        Validations validator = new Validations();

        // Validation for capacity only alphanumeric
        String capacityText = capacity.getText();
        if (!validator.validateAlfanumeric(capacityText)) {
            JOptionPane.showMessageDialog(null, "Formato capacidad no válida. Debe contener solo caracteres alfanuméricos.");
            return;
        }

        // Validation for observation
        String observationText = observation.getText();
        if (!validator.validateABCWithSpaces(observationText)) {
            JOptionPane.showMessageDialog(null, "Observación no válida. Debe contener solo texto.");
            return;
        }

        // Validates date to be "yyyy-MM-dd"
        String dateText = date.getText();
        if (!validator.validateDate(dateText)) {
            JOptionPane.showMessageDialog(null, "Fecha no válida. Debe tener el formato aaaa-MM-dd.");
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(dateText);

            String selectedMethod = (String) cbxMethod.getSelectedItem();
            String selectedClimate = (String) cbxClimate.getSelectedItem();
            String selectedDone = (String) cbxDone.getSelectedItem();
            String selectedWater = (String) cbxFlowWater.getSelectedItem();
            String selectedSampling = (String) cbxFlowSampling.getSelectedItem();

            WaterSpringDAO waterdao = new WaterSpringDAO();
            SamplingSiteDAO samplingdao = new SamplingSiteDAO();
            int waterName = waterdao.getWaterSpringIdByName(selectedWater);
            int samplingName = samplingdao.getSamplingSiteIdByName(selectedSampling);

            this.dao.createFlow(new Flow(capacityText, selectedMethod, observationText, flowDate, selectedClimate, selectedDone, waterName, samplingName));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en capacidad.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha (debe ser yyyy-MM-dd).");
        }
    }

    // Update an existing flow
    public void updateFlow(JTextField capacity, JComboBox<String> cbxMethod, JTextField observation, JTextField date, JComboBox<String> cbxClimate, JComboBox<String> cbxDone, JComboBox<String> cbxFlowWater, JComboBox<String> cbxFlowSampling) {
        Validations validator = new Validations();

        //  Validation for capacity only alphanumeric
        String capacityText = capacity.getText();
        if (!validator.validateAlfanumeric(capacityText)) {
            JOptionPane.showMessageDialog(null, "Capacidad no válida. Debe contener solo caracteres alfanuméricos.");
            return;
        }

        // Validation for observation
        String observationText = observation.getText();
        if (!validator.validateABCWithSpaces(observationText)) {
            JOptionPane.showMessageDialog(null, "Observación no válida. Debe contener solo texto y espacios.");
            return;
        }

        // Validates date to be "yyyy-MM-dd"
        String dateText = date.getText();
        if (!validator.validateDate(dateText)) {
            JOptionPane.showMessageDialog(null, "Fecha no válida. Debe tener el formato yyyy-MM-dd.");
            return;
        }

        try {
            // Parse the capacity
            double flowCapacity = Double.parseDouble(capacityText);

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
            Date flowDate = dateFormat.parse(dateText);

            Flow flow = new Flow(this.id, capacityText, selectedMethod, observationText,
                    flowDate, climate, done, flowWaterId, flowSamplingId);

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

    public void generateRandomCapacity(JTextField txtFlowCapacity) {
        // Range of values ​​for capacity (between 0.1 and 100)
        double minValue = 0.1;
        double maxValue = 100.0;

        // Generate a random decimal number between the minimum and maximum value
        double randomCapacity = minValue + Math.random() * (maxValue - minValue);

        // Formats the number to two decimal places and sets it in the txtFlowCapacity field
        txtFlowCapacity.setText(String.format(Locale.ENGLISH, "%.2f", randomCapacity));
    }

    public void generateRandomDate(JTextField txtFlowDate) {
        try {
            Random rand = new Random();

            // Generate a random number for the day (1-31)
            int day = rand.nextInt(31) + 1;

            // Generate a random number for the month (1-12)
            int month = rand.nextInt(12) + 1;

            // Set the year as 2022
            int year = 2022;

            // Combine the values ​​into a date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date randomDate = dateFormat.parse(String.format("%04d-%02d-%02d", year, month, day));

            // Set the date in the txtFlowDate field
            txtFlowDate.setText(dateFormat.format(randomDate));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la fecha aleatoria.");
        }
    }
}
