/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CtrlEntity;
import java.util.List;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterReport extends javax.swing.JFrame {

    WaterSpringDAO waterdao = new WaterSpringDAO();
    CtrlEntity cte = new CtrlEntity();
    EntityDAO entitydao = new EntityDAO();
    // Method to populate the entity names in a combo box

    public void listEntity() {
        cte.loadEntityNamesToComboBox(cbxWaterEntity);
    }
    
    public WaterReport() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnWaterPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la entidad seleccionada del combo box
                String selectedEntityName = (String) cbxWaterEntity.getSelectedItem();

                // Llama al método generateReportToPDF con la entidad correspondiente
                Entity entity = entitydao.getEntityByName(selectedEntityName);
                entitydao.generateReportToPDF(entity);
            }
        });
        this.listEntity();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnReportWater = new javax.swing.JButton();
        cbxWaterEntity = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaWater = new javax.swing.JTextArea();
        btnWaterPDF = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Reporte de Nacientes por Entidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        btnReportWater.setText("Generar Reporte");
        btnReportWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportWaterActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportWater, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        getContentPane().add(cbxWaterEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaWater.setColumns(20);
        txtAreaWater.setRows(5);
        jScrollPane1.setViewportView(txtAreaWater);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 820, 440));

        btnWaterPDF.setBackground(new java.awt.Color(30, 30, 30));
        btnWaterPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        btnWaterPDF.setBorderPainted(false);
        btnWaterPDF.setContentAreaFilled(false);
        jPanel1.add(btnWaterPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, 50, 70));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 40, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Handle the action when the "Generate Report" button is clicked
    private void btnReportWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportWaterActionPerformed
       // Get the name of the selected entity from the combo box
        String selectedEntity = cbxWaterEntity.getSelectedItem().toString();

          // Call the method to retrieve water springs associated with the selected entity
        List<WaterSpring> waterSprings = waterdao.getWaterSpringsByEntity(selectedEntity);

         // Generate a representation of the report
        String report = waterdao.generateReport(waterSprings);

        // Display the report in a text area, or save it to a file, for example
        txtAreaWater.setText(report);
    }//GEN-LAST:event_btnReportWaterActionPerformed
     // Handle the action when the "Exit" button is clicked
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Register register = new Register("Super Administrador");
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReportWater;
    private javax.swing.JButton btnWaterPDF;
    private javax.swing.JComboBox<String> cbxWaterEntity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaWater;
    // End of variables declaration//GEN-END:variables
}
