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

    public void loadUserData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        CtrlEntity entityDAO = new CtrlEntity(); // Instancia CtrlEntity
        CtrlRol rolDAO = new CtrlRol(); // Instancia CtrlRol

        List<User> users = dao.readUser();

        for (User user : users) {
            // Obtiene el nombre de la entidad y el rol correspondiente
            String entityName = entityDAO.getEntityNameById(user.getEntityId());
            String roleName = rolDAO.getRoleNameById(user.getRoleId());

            Object[] row = {user.getId(), user.getName(), user.getLastName(), user.getEmail(), entityName, roleName};
            model.addRow(row);
        }
    }

    public void updateUser(JTextField name, JTextField lastName, JTextField email, JTextField password, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
        try {
            User user = new User(this.id, name.getText(), lastName.getText(), email.getText(), password.getText());

            // Instancia de las clases CtrlEntity y CtrlRol
            CtrlEntity ctrlEntity = new CtrlEntity();
            CtrlRol ctrlRol = new CtrlRol();

            // Obtener los valores seleccionados en los JComboBox para entityId y roleId
            String entityName = (String) cbxEntity.getSelectedItem();
            String roleName = (String) cbxRole.getSelectedItem();

            // Convertir los nombres de entidad y rol en sus respectivos IDs
            int entityId = ctrlEntity.getEntityIdByName(entityName);
            int roleId = ctrlRol.getRoleIdByName(roleName);

            user.setEntityId(entityId);
            user.setRoleId(roleId);

            dao.updateUser(user);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

    public void deleteUser() {
        dao.deleteUser(this.id);
    }

    public void selectRow(JTable table, JTextField name, JTextField lastName, JTextField email, JTextField password, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                lastName.setText(table.getValueAt(row, 2).toString());
                email.setText(table.getValueAt(row, 3).toString());

                // Obtener los valores de los ComboBox (comboboxes)
                String entityName = table.getValueAt(row, 4).toString();
                String roleName = table.getValueAt(row, 5).toString();

                // Establecer los valores seleccionados en los ComboBox
                cbxEntity.setSelectedItem(entityName);
                cbxRole.setSelectedItem(roleName);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    public void clearFields(JTextField name, JTextField lastName, JTextField email, JTextField password) {
        name.setText("");
        lastName.setText("");
        email.setText("");
        password.setText("");

    }

    public void loadRolesToUserComboBox(JComboBox<String> comboBox) {
        CtrlRol ctrlRol = new CtrlRol();
        ctrlRol.loadRolesToComboBox(comboBox);
    }

    public void addUser(JTextField txtName, JTextField txtLastName, JTextField txtEmail, JTextField txtPassword, JComboBox<String> cbxEntity, JComboBox<String> cbxRole) {
        try {
            // Obtener los valores de los campos de texto y los JComboBox
            String name = txtName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();
            String entityName = (String) cbxEntity.getSelectedItem(); // Obtener el nombre de la entidad seleccionada
            String roleName = (String) cbxRole.getSelectedItem(); // Obtener el nombre del rol seleccionado

            // Obtener los IDs de entidad y rol utilizando CtrlEntity y CtrlRol
            CtrlRol ctrlRol = new CtrlRol();
            CtrlEntity ctrlEntity = new CtrlEntity();
            int entityId = ctrlEntity.getEntityIdByName(entityName);
            int roleId = ctrlRol.getRoleIdByName(roleName);

            // Crear un nuevo usuario
            User user = new User(name, lastName, email, password, entityId, roleId);

            // Agregar el usuario a la base de datos
            UserDAO userDAO = new UserDAO();
            userDAO.createUser(user);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en alguno de los campos.");
        }
    }

}
