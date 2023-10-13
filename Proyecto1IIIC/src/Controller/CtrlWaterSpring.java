/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author JRS
 */
import Model.WaterSpring;
import Model.WaterSpringDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class CtrlWaterSpring {

    WaterSpringDAO dao = new WaterSpringDAO();
    int id;

    public void loadDataWaterSprings(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<WaterSpring> waterSprings = dao.readWaterSprings();
        for (WaterSpring waterSpring : waterSprings) {
            Object[] row = {
                waterSpring.getId(), waterSpring.getName(), waterSpring.getAddress(),
                waterSpring.getLatitude(), waterSpring.getLongitude(), waterSpring.getDescription(),
                waterSpring.getProvinceId(), waterSpring.getCountyId(), waterSpring.getDistrictId(),
                waterSpring.getEntityId()
            };
            model.addRow(row);
        }
    }
    public void addWaterSpring(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            this.dao.createWaterSpring(new WaterSpring(
                name.getText(), address.getText(), latitude.getText(), longitude.getText(),
                description.getText(), Integer.parseInt(provinceId.getText()), Integer.parseInt(countyId.getText()),
                Integer.parseInt(districtId.getText()), Integer.parseInt(entityId.getText())
            ));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    public void updateWaterSpring(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            this.dao.updateWaterSpring(new WaterSpring(
                this.id, name.getText(), address.getText(), latitude.getText(), longitude.getText(),
                description.getText(), Integer.parseInt(provinceId.getText()), Integer.parseInt(countyId.getText()),
                Integer.parseInt(districtId.getText()), Integer.parseInt(entityId.getText())
            ));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    public void deleteWaterSpring() {
        this.dao.deleteWaterSpring(this.id);
    }

    public void selectWaterSpringRow(JTable table, JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                address.setText(table.getValueAt(row, 2).toString());
                latitude.setText(table.getValueAt(row, 3).toString());
                longitude.setText(table.getValueAt(row, 4).toString());
                description.setText(table.getValueAt(row, 5).toString());
                provinceId.setText(table.getValueAt(row, 6).toString());
                countyId.setText(table.getValueAt(row, 7).toString());
                districtId.setText(table.getValueAt(row, 8).toString());
                entityId.setText(table.getValueAt(row, 9).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    public void clearFields(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        name.setText("");
        address.setText("");
        latitude.setText("");
        longitude.setText("");
        description.setText("");
        provinceId.setText("");
        countyId.setText("");
        districtId.setText("");
        entityId.setText("");
    }
}

