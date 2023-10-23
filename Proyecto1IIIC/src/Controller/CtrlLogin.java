/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class CtrlLogin {

    public void configureTabs(JTabbedPane TabRegister, String roleName, JButton btnEditUser,
            JButton btnDeleteUser, JButton btnFlowEdit, JButton btnFlowDelete) {
        if (roleName.equals("Super Administrador")) {

            TabRegister.setEnabledAt(0, true);
            TabRegister.setEnabledAt(1, true);
            TabRegister.setEnabledAt(2, true);
            TabRegister.setEnabledAt(3, true);
            TabRegister.setEnabledAt(4, true);
            TabRegister.setEnabledAt(5, true);
        } else if (roleName.equals("Administrador")) {

            TabRegister.setEnabledAt(0, true);
            TabRegister.setEnabledAt(1, true);
            TabRegister.setEnabledAt(2, false);
            TabRegister.setEnabledAt(3, true);
            TabRegister.setEnabledAt(4, false);
            TabRegister.setEnabledAt(5, true);
        } else if (roleName.equals("Digitador")) {

            TabRegister.setEnabledAt(0, true);
            TabRegister.setEnabledAt(1, false);
            TabRegister.setEnabledAt(2, true);
            TabRegister.setEnabledAt(3, false);
            TabRegister.setEnabledAt(4, false);
            TabRegister.setEnabledAt(5, true);
            btnEditUser.setEnabled(false);
            btnDeleteUser.setEnabled(false);
            btnFlowEdit.setEnabled(false);
            btnFlowDelete.setEnabled(false);
        } else {

        }
    }
}
