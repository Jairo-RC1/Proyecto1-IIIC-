/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CtrlLogin;
import Model.DBConnectionJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    DBConnectionJava db = new DBConnectionJava();
    Register register = new Register();
    CtrlLogin CtrlLogin = new CtrlLogin();
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Hack Nerd Font", 1, 36)); // NOI18N
        jLabel1.setText("BIENVENIDO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        txtUsername.setBackground(new java.awt.Color(204, 255, 255));
        txtUsername.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(null);
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 160, 150, 20));

        txtPassword.setBackground(new java.awt.Color(204, 255, 255));
        txtPassword.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 150, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile_account_user_icon_228272.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 50, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/security-protection-protect-lock-open-secure_108583.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 50, 50));

        btnLogin.setBackground(new java.awt.Color(204, 255, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login-square-arrow-button-outline_icon-icons.com_73220.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 70, 70));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel6.setText("Sistema de control de nacientes");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     // Get the entered username and password
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    String username = txtUsername.getText();
    String password = new String(txtPassword.getPassword());

    // Verifica la autenticación y obtiene el nombre del rol
    String roleName = CtrlLogin.loginUser(username, password);
    
    if (roleName != null) {
        // Cierra LoginForm
        dispose();

        // Abre RegisterForm y pasa el nombre del rol
        Register registerForm = new Register(roleName);
        registerForm.setVisible(true);
    } else {
        // Muestra un mensaje de error
        JOptionPane.showMessageDialog(null, "Credenciales inválidas");
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    public class AccessValidator {

      
        }
        
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
