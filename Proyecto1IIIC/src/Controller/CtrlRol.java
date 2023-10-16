/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Rol;
import Model.RolDAO;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlRol {

    public void loadRolesToComboBox(JComboBox<String> comboBox) {
        RolDAO rolDAO = new RolDAO();
        List<Rol> roles = rolDAO.readRoles();

        comboBox.removeAllItems(); // Limpia el ComboBox

        for (Rol role : roles) {
            comboBox.addItem(role.getName());
        }
    }

    public int getRoleIdByName(String roleName) {
        RolDAO rolDAO = new RolDAO();
        Rol rol = rolDAO.getRolByName(roleName);

        if (rol != null) {
            return rol.getId();
        } else {
            // En caso de no encontrar el rol, puedes manejarlo como desees, por ejemplo, lanzar una excepción o devolver un valor predeterminado.
            return -1; // Valor predeterminado o manejo de error
        }
    }

    public String getRoleNameById(int roleId) {
        RolDAO rolDAO = new RolDAO();
        return rolDAO.getRoleNameById(roleId);
    }
    
    public int getRoleIdByName2(String roleName) {
    RolDAO rolDAO = new RolDAO();
    return rolDAO.getRoleIdByName(roleName);
}


}
