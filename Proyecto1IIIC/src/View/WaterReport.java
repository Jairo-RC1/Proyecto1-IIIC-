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

    public void listEntity() {
        cte.loadEntityNamesToComboBox(cbxWaterEntity);
    }

    public WaterReport() {
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaWater = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnReportWater = new javax.swing.JButton();
        cbxWaterEntity = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        btnWaterPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaWater.setColumns(20);
        txtAreaWater.setRows(5);
        jScrollPane1.setViewportView(txtAreaWater);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 820, 400));

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

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        btnWaterPDF.setText("PDF");
        getContentPane().add(btnWaterPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportWaterActionPerformed
        // Obtén el nombre de la entidad seleccionada en el JComboBox
        String selectedEntity = cbxWaterEntity.getSelectedItem().toString();

        // Llama al método para obtener las nacientes de la entidad seleccionada
        List<WaterSpring> waterSprings = waterdao.getWaterSpringsByEntity(selectedEntity);

        // Crea una representación del informe
        String report = waterdao.generateReport(waterSprings);

        // Puedes mostrar el informe en un área de texto o guardarlo como un archivo, por ejemplo:
        txtAreaWater.setText(report);
    }//GEN-LAST:event_btnReportWaterActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaWater;
    // End of variables declaration//GEN-END:variables
}
