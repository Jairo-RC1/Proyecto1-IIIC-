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

public class CtrlUser {

    UserDAO dao = new UserDAO();
    int id;

    public void loadUserData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<User> users = dao.readUser();
        for (User user : users) {
            Object[] row = {user.getId(), user.getName(), user.getLastName(), user.getEmail()};
            model.addRow(row);
        }
    }

    public void addUser(JTextField name, JTextField lastName, JTextField email, JTextField password, JTextField entityId, JTextField roleId) {
        
        User user = new User(name.getText(), lastName.getText(), email.getText(), password.getText(), Integer.parseInt(entityId.getText()), Integer.parseInt(roleId.getText()));
        dao.createUser(user);
    }

    public void updateUser(JTextField name, JTextField lastName, JTextField email, JTextField password, JTextField entityId, JTextField roleId) {
        
        try {
            User user = new User(this.id, name.getText(), lastName.getText(), email.getText(), password.getText(), Integer.parseInt(entityId.getText()), Integer.parseInt(roleId.getText()));
            dao.updateUser(user);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del usuario no es válido.");
        }
    }

    public void deleteUser() {
        dao.deleteUser(this.id);
    }

    public void selectRow(JTable table, JTextField name, JTextField lastName, JTextField email, JTextField password, JTextField entityId, JTextField roleId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                lastName.setText(table.getValueAt(row, 2).toString());
                email.setText(table.getValueAt(row, 3).toString());
                // Puedes cargar el resto de los campos (password, entityId, roleId) aquí si es necesario.
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

}
