/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import Model.WaterSpringDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlWaterSpring {

    WaterSpringDAO dao = new WaterSpringDAO();
    int id;

    // Load water spring data into a JTable
    public void loadDataWaterSprings(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        ProvinceDAO provincedao = new ProvinceDAO();
        CountyDAO countydao = new CountyDAO();
        DistrictDAO districtdao = new DistrictDAO();
        EntityDAO entitydao = new EntityDAO();

        List<WaterSpring> waterSprings = dao.readWaterSprings();
        for (WaterSpring waterSpring : waterSprings) {
            String provinceName = provincedao.getProvinceNameById(waterSpring.getProvinceId());
            String countyName = countydao.getCountyNameById(waterSpring.getCountyId());
            String districtName = districtdao.getDistrictNameById(waterSpring.getDistrictId());
            String entityName = entitydao.getEntityNameById(waterSpring.getEntityId());

            Object[] row = {
                waterSpring.getId(), waterSpring.getName(), waterSpring.getAddress(),
                waterSpring.getLatitude(), waterSpring.getLongitude(), waterSpring.getDescription(), provinceName,
                countyName, districtName, entityName
            };
            model.addRow(row);
        }
    }

    // Add a new water spring
     public void addWaterSpring(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
    String springName = name.getText();
    String springAddress = address.getText();
    String springLatitude = latitude.getText();
    String springLongitude = longitude.getText();
    String springDescription = description.getText();

    Validations validator = new Validations();

    // Validation for name (should only contain text)
    if (!validator.validateABC(springName)) {
        JOptionPane.showMessageDialog(null, "Nombre no valido. Solo se permite texto");
        return;
    }

    // Validation for address and description (should be alphanumeric)
    if (!validator.validateAlfanumeric(springAddress) || !validator.validateAlfanumeric(springDescription)) {
        JOptionPane.showMessageDialog(null, "Formato no valido. Solo se permiten numero y letras");
        return;
    }

    // Validation for latitude and longitude (should be in decimal format)
    if (!validator.validateDecimals(springLatitude) || !validator.validateDecimals(springLongitude)) {
        JOptionPane.showMessageDialog(null, "Latitude o longitud no valida. Debe ser decimal");
        return;
    }

    try {
        // Validation for provinceId, countyId, districtId, and entityId (should be numbers)
        int province = Integer.parseInt(provinceId.getText());
        int county = Integer.parseInt(countyId.getText());
        int district = Integer.parseInt(districtId.getText());
        int entity = Integer.parseInt(entityId.getText());

        this.dao.createWaterSpring(new WaterSpring(springName, springAddress, springLatitude, springLongitude, springDescription, province, county, district, entity));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos ");
    }
}

    // Update a water spring's data
     public void updateWaterSpring(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description, JTextField provinceId, JTextField countyId, JTextField districtId, JTextField entityId) {
    String springName = name.getText();
    String springAddress = address.getText();
    String springLatitude = latitude.getText();
    String springLongitude = longitude.getText();
    String springDescription = description.getText();

    Validations validator = new Validations();

    // Validation for name (should only contain text)
    if (!validator.validateABC(springName)) {
        JOptionPane.showMessageDialog(null, "Nombre no valido. Solo se permite texto");
        return;
    }

    // Validation for address and description (should be alphanumeric)
    if (!validator.validateAlfanumeric(springAddress) || !validator.validateAlfanumeric(springDescription)) {
        JOptionPane.showMessageDialog(null, "Formato no valido. Solo se permiten numero y letras");
        return;
    }

    // Validation for latitude and longitude (should be in decimal format)
    if (!validator.validateDecimals(springLatitude) || !validator.validateDecimals(springLongitude)) {
        JOptionPane.showMessageDialog(null, "Latitude o longitud no valida. Debe ser decimal");
        return;
    }

    try {
        // Validation for provinceId, countyId, districtId, and entityId (should be numbers)
        int province = Integer.parseInt(provinceId.getText());
        int county = Integer.parseInt(countyId.getText());
        int district = Integer.parseInt(districtId.getText());
        int entity = Integer.parseInt(entityId.getText());

        // Continue with the logic to update the water spring
        this.dao.updateWaterSpring(new WaterSpring(this.id, springName, springAddress, springLatitude, springLongitude, springDescription, province, county, district, entity));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos ");
    }
}

    // Delete a water spring
    public void deleteWaterSpring() {
        this.dao.deleteWaterSpring(this.id);
    }

    // Select a water spring's row in the JTable
    public void selectWaterSpringRow(JTable table, JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description,
            JComboBox<String> cbxProvinceId, JComboBox<String> cbxCountyId, JComboBox<String> cbxDistrictId, JComboBox<String> cbxEntityId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                address.setText(table.getValueAt(row, 2).toString());
                latitude.setText(table.getValueAt(row, 3).toString());
                longitude.setText(table.getValueAt(row, 4).toString());
                description.setText(table.getValueAt(row, 5).toString());
                String province = (table.getValueAt(row, 6).toString());
                String county = (table.getValueAt(row, 7).toString());
                String district = (table.getValueAt(row, 8).toString());
                String entity = (table.getValueAt(row, 9).toString());
                
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
    public void clearFields(JTextField name, JTextField address, JTextField latitude, JTextField longitude, JTextField description) {
        name.setText("");
        address.setText("");
        latitude.setText("");
        longitude.setText("");
        description.setText("");
    }

    // Load provinces to a JComboBox
    public void loadProvincesToWaterProvinceComboBox(JComboBox<String> comboBox) {
        CtrlProvince ctrlProvince = new CtrlProvince();
        ctrlProvince.loadProvincesToComboBox(comboBox);
    }
    // Load counties to a JComboBox based on the selected province

    public void loadCountiesToWaterCountyComboBox(JComboBox<String> comboBox, String selectedProvince) {
        CtrlCounty ctrlCounty = new CtrlCounty();
        ctrlCounty.loadCountiesToSamplingCountyComboBox(comboBox, selectedProvince);
    }
    // Load districts to a JComboBox based on the selected county

    public void loadDistrictsToWaterDistrictComboBox(JComboBox<String> comboBox, String countyName) {
        CtrlDistrict ctrlDistrict = new CtrlDistrict();
        ctrlDistrict.loadDistrictsForCounty(comboBox, countyName);
    }

    public void loadWaterSpringNamesToComboBox(JComboBox<String> comboBox) {
        WaterSpringDAO waterSpringDao = new WaterSpringDAO();
        List<WaterSpring> waterSprings = waterSpringDao.readWaterSprings();

        comboBox.removeAllItems(); // Limpia el ComboBox

        for (WaterSpring waterSpring : waterSprings) {
            comboBox.addItem(waterSpring.getName());
        }
    }

}
