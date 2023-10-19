/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import Model.*;
import javax.swing.JComboBox;

public class CtrlEntity {

    EntityDAO dao = new EntityDAO();
    int id;
    // Load data of entities into the JTable
    public void loadDataEntities(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Entity> entities = dao.readEntities();
        for (Entity entity : entities) {
            Object[] row = {entity.getId(), entity.getLegalId(), entity.getName(),
                entity.getEmail(), entity.getPhoneNumber(), entity.getAddress(), entity.getDescription()};
            model.addRow(row);
        }
    }
     // Add a new entity
    public void addEntity(JTextField legalId, JTextField name, JTextField email, JTextField phoneNumber, JTextField address, JTextField description) {
        try {
            this.dao.createEntity(new Entity(Integer.parseInt(legalId.getText()), name.getText(), email.getText(), Integer.parseInt(phoneNumber.getText()), address.getText(), description.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en legal ID o número de teléfono.");
        }
    }
    // Update an existing entity
    public void updateEntity(JTextField legalId, JTextField name, JTextField email, JTextField phoneNumber, JTextField address, JTextField description) {
        try {
            this.dao.updateEntity(new Entity(this.id, Integer.parseInt(legalId.getText()), name.getText(), email.getText(), Integer.parseInt(phoneNumber.getText()), address.getText(), description.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en legal ID o número de teléfono.");
        }
    }
    // Delete the selected entity
    public void deleteEntity() {
        this.dao.deleteEntity(this.id);
    }
    // Select a row in the table to work with  
    public void selectEntityRow(JTable table, JTextField legalId, JTextField name, JTextField email, JTextField phoneNumber, JTextField address, JTextField description) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                legalId.setText(table.getValueAt(row, 1).toString());
                name.setText(table.getValueAt(row, 2).toString());
                email.setText(table.getValueAt(row, 3).toString());
                phoneNumber.setText(table.getValueAt(row, 4).toString());
                address.setText(table.getValueAt(row, 5).toString());
                description.setText(table.getValueAt(row, 6).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
        }
    }
     // Clear input fields
    public void clearFields(JTextField legalId, JTextField name, JTextField email, JTextField phoneNumber, JTextField address, JTextField description) {
        legalId.setText("");
        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        address.setText("");
        description.setText("");
    }
    // Get the ID of an entity by its name
    public int getEntityIdByName(String entityName) {
        EntityDAO entityDAO = new EntityDAO();
        Entity entity = entityDAO.getEntityByName(entityName);

        if (entity != null) {
            return entity.getId();
        } else {
            // In cse entity is empty, takes one out.
            return -1; 
        }
    }
     // Get the name of an entity by its ID
    public String getEntityNameById(int entityId) {
        EntityDAO entityDAO = new EntityDAO();
        return entityDAO.getEntityNameById(entityId);
    }
     // Load entity names into a JComboBox
    public void loadEntityNamesToComboBox(JComboBox<String> comboBox) {
        EntityDAO entityDao = new EntityDAO();
        List<Entity> entities = entityDao.readEntities();

        comboBox.removeAllItems(); // Cleans ComboBox

        for (Entity entity : entities) {
            comboBox.addItem(entity.getName());
        }
    }
    
    // Get the ID of an entity by its name
    public int getEntityIdByName2(String entityName) {
        EntityDAO entityDAO = new EntityDAO();
        return entityDAO.getEntityIdByName(entityName);
    }

}
