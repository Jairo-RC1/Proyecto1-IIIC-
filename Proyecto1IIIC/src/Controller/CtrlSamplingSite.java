/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
import Model.*;

public class CtrlSamplingSite {

    SamplingSiteDAO dao = new SamplingSiteDAO();
    int id;

    // Load data for Sampling Sites into a JTable
    public void loadDataSamplingSites(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        ProvinceDAO provincedao = new ProvinceDAO();
        CountyDAO countydao = new CountyDAO();
        DistrictDAO districtdao = new DistrictDAO();
        EntityDAO entitydao = new EntityDAO();

        List<SamplingSite> samplingSites = dao.readSamplingSites();
        for (SamplingSite samplingSite : samplingSites) {
            String provinceName = provincedao.getProvinceNameById(samplingSite.getProvinceId());
            String countyName = countydao.getCountyNameById(samplingSite.getCountyId());
            String districtName = districtdao.getDistrictNameById(samplingSite.getDistrictId());
            String entityName = entitydao.getEntityNameById(samplingSite.getEntityId());

            Object[] row = {samplingSite.getId(), samplingSite.getName(), provinceName, countyName,
                districtName, entityName};
            model.addRow(row);
        }
    }
    // Add a new Sampling Site

    public void addSamplingSite(JTextField name, JComboBox<String> cbxProvinceId, JComboBox<String> cbxCountyId, JComboBox<String> cbxDistrictId, JComboBox<String> cbxEntityId) {
        try {
            String selectedProvince = (String) cbxProvinceId.getSelectedItem();
            String selectedCounty = (String) cbxCountyId.getSelectedItem();
            String selectedDistrict = (String) cbxDistrictId.getSelectedItem();
            String selectedEntity = (String) cbxEntityId.getSelectedItem();

            ProvinceDAO provincedao = new ProvinceDAO();
            CountyDAO countydao = new CountyDAO();
            DistrictDAO districtdao = new DistrictDAO();
            EntityDAO entitydao = new EntityDAO();

            int provinceName = provincedao.getProvinceIdByName(selectedProvince);
            int countyName = countydao.getCountyIdByName(selectedCounty);
            int districtName = districtdao.getDistrictIdByName(selectedDistrict);
            int entityName = entitydao.getEntityIdByName(selectedEntity);

            this.dao.createSamplingSite(new SamplingSite(this.id, name.getText(), provinceName, countyName, districtName, entityName));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }
    // Update an existing Sampling Site

    public void updateSamplingSite(JTextField name, JComboBox<String> cbxProvinceId, JComboBox<String> cbxCountyId, JComboBox<String> cbxDistrictId, JComboBox<String> cbxEntityId) {
        try {
            String selectedProvince = (String) cbxProvinceId.getSelectedItem();
            String selectedCounty = (String) cbxCountyId.getSelectedItem();
            String selectedDistrict = (String) cbxDistrictId.getSelectedItem();
            String selectedEntity = (String) cbxEntityId.getSelectedItem();

            ProvinceDAO provincedao = new ProvinceDAO();
            CountyDAO countydao = new CountyDAO();
            DistrictDAO districtdao = new DistrictDAO();
            EntityDAO entitydao = new EntityDAO();
            int provinceName = provincedao.getProvinceIdByName(selectedProvince);
            int countyName = countydao.getCountyIdByName(selectedCounty);
            int districtName = districtdao.getDistrictIdByName(selectedDistrict);
            int entityName = entitydao.getEntityIdByName(selectedEntity);

            this.dao.updateSamplingSite(new SamplingSite(this.id, name.getText(), provinceName, countyName, districtName, entityName));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    // Delete a Sampling Site
    public void deleteSamplingSite() {
        this.dao.deleteSamplingSite(this.id);
    }

    // Select a Sampling Site from a JTable row
    public void selectSamplingSiteRow(JTable table, JTextField name, JComboBox<String> cbxProvinceId, JComboBox<String> cbxCountyId, JComboBox<String> cbxDistrictId, JComboBox<String> cbxEntityId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                String province = (table.getValueAt(row, 2).toString());
                String county = (table.getValueAt(row, 3).toString());
                String district = (table.getValueAt(row, 4).toString());
                String entity = (table.getValueAt(row, 5).toString());

                cbxProvinceId.setSelectedItem(province);
                cbxCountyId.setSelectedItem(county);
                cbxDistrictId.setSelectedItem(district);
                cbxEntityId.setSelectedItem(entity);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
    // Clear text fields

    public void clearFields(JTextField name) {
        name.setText("");
    }

    // Load provinces to JComboBox
    public void loadProvincesToSamplingProvinceComboBox(JComboBox<String> comboBox) {
        CtrlProvince ctrlProvince = new CtrlProvince();
        ctrlProvince.loadProvincesToComboBox(comboBox);
    }

    // Load counties to JComboBox based on the selected province
    public void loadCountiesToSamplingCountyComboBox(JComboBox<String> comboBox, String selectedProvince) {
        CtrlCounty ctrlCounty = new CtrlCounty();
        ctrlCounty.loadCountiesToSamplingCountyComboBox(comboBox, selectedProvince);
    }

    // Load districts to JComboBox based on the selected county
    public void loadDistrictsToSamplingDistrictComboBox(JComboBox<String> comboBox, String countyName) {
        CtrlDistrict ctrlDistrict = new CtrlDistrict();
        ctrlDistrict.loadDistrictsForCounty(comboBox, countyName);
    }

    public void loadSamplingSiteNamesToComboBox(JComboBox<String> comboBox) {
        SamplingSiteDAO samplingSiteDao = new SamplingSiteDAO();
        List<SamplingSite> samplingSites = samplingSiteDao.readSamplingSites();

        comboBox.removeAllItems(); // Limpia el ComboBox

        for (SamplingSite samplingSite : samplingSites) {
            comboBox.addItem(samplingSite.getName());
        }
    }

}
