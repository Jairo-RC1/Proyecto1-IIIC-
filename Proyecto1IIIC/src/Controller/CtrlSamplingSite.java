/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author JRS
 */
import Model.SamplingSite;
import Model.SamplingSiteDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlSamplingSite {

    SamplingSiteDAO dao = new SamplingSiteDAO();
    int id;

    public void loadDataSamplingSites(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<SamplingSite> samplingSites = dao.readSamplingSites();
        for (SamplingSite samplingSite : samplingSites) {
            Object[] row = {samplingSite.getId(), samplingSite.getName(),
                samplingSite.getProvinceId(), samplingSite.getCountyId(), samplingSite.getDistrictId(), samplingSite.getEntityId()};
            model.addRow(row);
        }
    }

    public void addSamplingSite(JTextField name, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            this.dao.createSamplingSite(new SamplingSite(this.id, name.getText(), Integer.parseInt(provinceId.getText()), Integer.parseInt(countyId.getText()), Integer.parseInt(districtId.getText()), Integer.parseInt(entityId.getText())));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    public void updateSamplingSite(JTextField name, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            this.dao.updateSamplingSite(new SamplingSite(this.id, name.getText(), Integer.parseInt(provinceId.getText()), Integer.parseInt(countyId.getText()), Integer.parseInt(districtId.getText()), Integer.parseInt(entityId.getText())));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    public void deleteSamplingSite() {
        this.dao.deleteSamplingSite(this.id);
    }

    public void selectSamplingSiteRow(JTable table, JTextField name, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                provinceId.setText(table.getValueAt(row, 2).toString());
                countyId.setText(table.getValueAt(row, 3).toString());
                districtId.setText(table.getValueAt(row, 4).toString());
                entityId.setText(table.getValueAt(row, 5).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    public void clearFields(JTextField name) {
        name.setText("");
    }

    public void loadProvincesToSamplingProvinceComboBox(JComboBox<String> comboBox) {
        CtrlProvince ctrlProvince = new CtrlProvince();
        ctrlProvince.loadProvincesToComboBox(comboBox);
    }

    public void loadCountiesToSamplingCountyComboBox(JComboBox<String> comboBox, String selectedProvince) {
        CtrlCounty ctrlCounty = new CtrlCounty();
        ctrlCounty.loadCountiesToSamplingCountyComboBox(comboBox, selectedProvince);
    }

    public void loadDistrictsToSamplingDistrictComboBox(JComboBox<String> comboBox, String countyName) {
        CtrlDistrict ctrlDistrict = new CtrlDistrict();
        ctrlDistrict.loadDistrictsForCounty(comboBox, countyName);
    }

}
