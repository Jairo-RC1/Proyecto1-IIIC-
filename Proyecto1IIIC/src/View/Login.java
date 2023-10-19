/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DBConnectionJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends javax.swing.JFrame {

    DBConnectionJava db = new DBConnectionJava();

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
        txtUsuario1 = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Hack Nerd Font", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BIENVENIDO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        txtUsuario1.setBackground(new java.awt.Color(204, 255, 255));
        txtUsuario1.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        txtUsuario1.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(null);
        jPanel1.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 160, 150, 20));

        txtContrasena.setBackground(new java.awt.Color(204, 255, 255));
        txtContrasena.setFont(new java.awt.Font("Lucida Sans", 3, 14)); // NOI18N
        txtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasena.setBorder(null);
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 150, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile_account_user_icon_228272.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 50, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/security-protection-protect-lock-open-secure_108583.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 50, 50));

        btnIngresar.setBackground(new java.awt.Color(204, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login-square-arrow-button-outline_icon-icons.com_73220.png"))); // NOI18N
        btnIngresar.setBorder(null);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 70, 70));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
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
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        /*// Get the entered username and password from text fields
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();

        // Validate user access using CRUDUsuario
        if(crudUsuario.validarAcceso(usuario, contrasena)){
            // Check the role of the user
            if(crudUsuario.buscarRolUsuario(usuario)=="Administrador"){
                // Open the Administrator's room if the user is an administrator
                SalaAdministrador administrador = new SalaAdministrador();
                administrador.setVisible(true);
                this.dispose();
            }else{
                // Open the Customer's room if the user is not an administrator
                SalaCliente cliente = new SalaCliente();
                cliente.setVisible(true);
                this.dispose();
            }
        }else{
            // Show an error message if the username or password is incorrect
            JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
        }*/
    }//GEN-LAST:event_btnIngresarActionPerformed

    public class AccessValidator {

      
        }
        
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}
