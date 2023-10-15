/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import Model.*;
import javax.swing.table.TableRowSorter;


public class CtrlFlow {
   FlowDAO dao = new FlowDAO();
    int id;

    public void loadFlowData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Flow> flows = dao.readFlows();
        for (Flow flow : flows) {
            Object[] row = {flow.getId(), flow.getCapacity(), flow.getMethod(), flow.getObservation(), flow.getDate(), flow.getClimate(), flow.getDone(), flow.getWaterSpringId(), flow.getSamplingId()};
            model.addRow(row);
        }
    }

    public void addFlow(JTextField capacity, JTextField method, JTextField observation, JTextField date, JTextField climate, JTextField done, JTextField waterSpringId, JTextField samplingId) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(date.getText());
            int waterSpringIdValue = Integer.parseInt(waterSpringId.getText());
            int samplingIdValue = Integer.parseInt(samplingId.getText());

            this.dao.createFlow(new Flow(Integer.parseInt(capacity.getText()), method.getText(), observation.getText(), flowDate, climate.getText(), done.getText(), waterSpringIdValue, samplingIdValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en capacidad, ID de manantial o ID de sitio de muestreo.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha (debe ser yyyy-MM-dd).");
        }
    }

    public void updateFlow(JTextField capacity, JTextField method, JTextField observation, JTextField date, JTextField climate, JTextField done, JTextField waterSpringId, JTextField samplingId) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(date.getText());
            int waterSpringIdValue = Integer.parseInt(waterSpringId.getText());
            int samplingIdValue = Integer.parseInt(samplingId.getText());

            this.dao.updateFlow(new Flow(this.id, Integer.parseInt(capacity.getText()), method.getText(), observation.getText(), flowDate, climate.getText(), done.getText(), waterSpringIdValue, samplingIdValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en capacidad, ID de manantial o ID de sitio de muestreo.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha (debe ser yyyy-MM-dd).");
        }
    }

    public void deleteFlow() {
        this.dao.deleteFlow(this.id);
    }

    public void selectFlowRow(JTable table, JTextField capacity, JTextField method, JTextField observation, JTextField date, JTextField climate, JTextField done, JTextField waterSpringId, JTextField samplingId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                capacity.setText(table.getValueAt(row, 1).toString());
                method.setText(table.getValueAt(row, 2).toString());
                observation.setText(table.getValueAt(row, 3).toString());
                date.setText(table.getValueAt(row, 4).toString());
                climate.setText(table.getValueAt(row, 5).toString());
                done.setText(table.getValueAt(row, 6).toString());
                waterSpringId.setText(table.getValueAt(row, 7).toString());
                samplingId.setText(table.getValueAt(row, 8).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    public void clearFields(JTextField capacity, JTextField method, JTextField observation, JTextField date, JTextField climate, JTextField done) {
        capacity.setText("");
        method.setText("");
        observation.setText("");
        date.setText("");
        climate.setText("");
        done.setText("");
    } 
}
