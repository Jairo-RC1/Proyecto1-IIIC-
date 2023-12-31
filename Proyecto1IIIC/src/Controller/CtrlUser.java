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
import Model.*;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlUser {

    UserDAO dao = new UserDAO();
    int id;
    // Load user data into a JTable

    public void loadUserData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        CtrlEntity entityDAO = new CtrlEntity(); // Instance CtrlEntity
        CtrlRol rolDAO = new CtrlRol(); // Instance CtrlRol

        List<User> users = dao.readUser();

        for (User user : users) {
            // Get the name of the entity and the corresponding role
            String entityName = entityDAO.getEntityNameById(user.getEntityId());
            String roleName = rolDAO.getRoleNameById(user.getRoleId());

            Object[] row = {user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), entityName, roleName};
            model.addRow(row);
        }
    }

    // Add a new user
    public void addUser(JTextField txtName, JTextField txtLastName, JTextField txtEmail, JTextField txtPassword, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
        String name = txtName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        Validations validator = new Validations();

        // Validation of txtName and txtLastName
        if (!(validator.validateABCWithSpaces(name) && validator.validateABCWithSpaces(lastName))) {
            JOptionPane.showMessageDialog(null, "Nombre o apellido no válidos");
            return; // Stops process if not valid
        }

        // Validation of txtEmail by using validateMail
        if (!validator.validateMail(email)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido");
            return; // Stops process if not valid
        }

        // Validation of  txtPassword by using validateAllSpecialCharacters
        if (!validator.validateAllSpecialCharacters(password)) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida");
            return; // Stops process if not valid
        }

        try {

            // Get the entity and role names selected from ComboBoxes
            String entityName = (String) cbxEntity.getSelectedItem();
            String roleName = (String) cbxRole.getSelectedItem();

            // Use the CtrlEntity and CtrlRol classes to get the corresponding IDs
            CtrlRol ctrlRol = new CtrlRol();
            CtrlEntity ctrlEntity = new CtrlEntity();
            int entityId = ctrlEntity.getEntityIdByName2(entityName);
            int roleId = ctrlRol.getRoleIdByName2(roleName);

            // Create a new user with IDs instead of names
            User user = new User(name, lastName, email, password, entityId, roleId);

            // Add the user to the database
            UserDAO userDAO = new UserDAO();
            userDAO.createUser(user);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    // Update user data
    public void updateUser(JTextField name, JTextField lastName, JTextField email, JTextField password, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
       String userName = name.getText();
    String userLastName = lastName.getText();
    String userEmail = email.getText();
    String userPassword = password.getText();

    Validations validator = new Validations();

    // Validation for userName and userLastName
    if (!(validator.validateABCWithSpaces(userName) && validator.validateABCWithSpaces(userLastName))) {
        JOptionPane.showMessageDialog(null, "Nombre o Apellido no valido");
        return; // Stop the process if they are not valid
    }

    // Validation for userEmail using the validateMail method
    if (!validator.validateMail(userEmail)) {
        JOptionPane.showMessageDialog(null, "Email no valido");
        return; // Stop the process if it is not valid
    }

    // Validation for userPassword using the validateAllSpecialCharacters method
    if (!validator.validateAllSpecialCharacters(userPassword)) {
        JOptionPane.showMessageDialog(null, "Contraseña no valida");
        return; // Stop the process if it is not valid
    }

    try {
        User user = new User(this.id, userName, userLastName, userEmail, userPassword);

        // Instances of CtrlEntity and CtrlRol classes
        CtrlEntity ctrlEntity = new CtrlEntity();
        CtrlRol ctrlRol = new CtrlRol();

        // Get the selected values in the JComboBox for entityId and roleId
        String entityName = (String) cbxEntity.getSelectedItem();
        String roleName = (String) cbxRole.getSelectedItem();

        // Convert entity and role names into their respective IDs
        int entityId = ctrlEntity.getEntityIdByName(entityName);
        int roleId = ctrlRol.getRoleIdByName(roleName);

        user.setEntityId(entityId);
        user.setRoleId(roleId);

        dao.updateUser(user);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error de formato en algún campo");
    }
}

    // Delete a user
    public void deleteUser() {
        dao.deleteUser(this.id);
    }
    // Select a row in the JTable

    public void selectRow(JTable table, JTextField name, JTextField lastName, JTextField email, JTextField password, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                lastName.setText(table.getValueAt(row, 2).toString());
                email.setText(table.getValueAt(row, 3).toString());
                password.setText(table.getValueAt(row, 4).toString());

                // Get the values of the ComboBoxes (comboboxes)
                String entityName = table.getValueAt(row, 5).toString();
                String roleName = table.getValueAt(row, 6).toString();

                // Set the selected values in the ComboBoxes
                cbxEntity.setSelectedItem(entityName);
                cbxRole.setSelectedItem(roleName);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
    // Clear text fields

    public void clearFields(JTextField name, JTextField lastName, JTextField email, JTextField password) {
        name.setText("");
        lastName.setText("");
        email.setText("");
        password.setText("");

    }
    // Load roles to the JComboBox

    public void loadRolesToUserComboBox(JComboBox<String> comboBox) {
        CtrlRol ctrlRol = new CtrlRol();
        ctrlRol.loadRolesToComboBox(comboBox);
    }

}
