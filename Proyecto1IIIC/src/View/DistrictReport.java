/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DistrictReport extends javax.swing.JFrame {

    CtrlProvince ctp = new CtrlProvince();
    CtrlCounty ctc = new CtrlCounty();
    CtrlDistrict ctd = new CtrlDistrict();
    SamplingSiteDAO samplingdao = new SamplingSiteDAO();
    WaterSpringDAO waterdao = new WaterSpringDAO();

    public DistrictReport() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.loadProvince();
        cbxReportProvince.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedProvince = cbxReportProvince.getSelectedItem().toString();

                // LCall the method to load the blocks
                ctc.loadCountiesToSamplingCountyComboBox(cbxReportCounty, selectedProvince);
            }
        });
        cbxReportCounty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedCounty = (String) cbxReportCounty.getSelectedItem();

                // Call the method to load the blocks
                ctd.loadDistrictsForCounty(cbxReportDistrict, selectedCounty);
            }
        });
    }

    public void loadProvince() {
        this.ctp.loadProvincesToComboBox(cbxReportProvince);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxReportProvince = new javax.swing.JComboBox<>();
        cbxReportDistrict = new javax.swing.JComboBox<>();
        cbxReportCounty = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDistrictReport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaReport = new javax.swing.JTextArea();
        btnReportPDF = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(cbxReportProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, -1));

        cbxReportDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        getContentPane().add(cbxReportDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 120, -1));

        cbxReportCounty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        getContentPane().add(cbxReportCounty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 120, -1));

        jLabel2.setText("Distrito:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel3.setText("Provincia:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel4.setText("Canton:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        btnDistrictReport.setText("Generar Reporte");
        btnDistrictReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistrictReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnDistrictReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Reporte por Distritos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 250, -1));

        txtAreaReport.setColumns(20);
        txtAreaReport.setRows(5);
        jScrollPane1.setViewportView(txtAreaReport);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 800, 430));

        btnReportPDF.setBackground(new java.awt.Color(30, 30, 30));
        btnReportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        btnReportPDF.setBorderPainted(false);
        btnReportPDF.setContentAreaFilled(false);
        btnReportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, 50, 70));

        btnExit.setBackground(new java.awt.Color(30, 30, 30));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 40, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Register register = new Register("Super Administrador");
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDistrictReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistrictReportActionPerformed
        String selectedDistrict = cbxReportDistrict.getSelectedItem().toString();

        // Llama al método para obtener los sitios de muestreo del distrito seleccionado
        List<SamplingSite> samplingSites = samplingdao.getSamplingSitesByDistrict(selectedDistrict);

        // Llama al método para obtener las nacientes del distrito seleccionado
        List<WaterSpring> waterSprings = waterdao.getWaterSpringsByDistrict(selectedDistrict);

        // Genera un informe que combine los sitios de muestreo y las nacientes
        String combinedReport = ctd.generateCombinedReport(selectedDistrict, samplingSites, waterSprings);

        // Muestra el informe en un área de texto, por ejemplo:
        txtAreaReport.setText(combinedReport);
    }//GEN-LAST:event_btnDistrictReportActionPerformed

    private void btnReportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPDFActionPerformed
        // Obtén la lista de sitios de muestreo y nacientes

        String selectedDistrict = (String) cbxReportDistrict.getSelectedItem();
        List<SamplingSite> samplingSites = samplingdao.getSamplingSitesByDistrict(selectedDistrict);
        List<WaterSpring> waterSprings = waterdao.getWaterSpringsByDistrict(selectedDistrict);

        // Llama al método generateSamplingSiteReportToPDF con la información correspondiente
        ctd.generateReportToPDF(samplingSites, waterSprings);
    }//GEN-LAST:event_btnReportPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistrictReport;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReportPDF;
    private javax.swing.JComboBox<String> cbxReportCounty;
    private javax.swing.JComboBox<String> cbxReportDistrict;
    private javax.swing.JComboBox<String> cbxReportProvince;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaReport;
    // End of variables declaration//GEN-END:variables
}
