/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends javax.swing.JFrame {

    CtrlEntity cte = new CtrlEntity();
    CtrlFlow ctf = new CtrlFlow();
    CtrlSamplingSite ctss = new CtrlSamplingSite();
    CtrlUser ctu = new CtrlUser();
    CtrlWaterSpring ctw = new CtrlWaterSpring();

    public Register() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.listTable();
        cbxSamplingProvince.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de la provincia seleccionada
                String selectedProvince = cbxSamplingProvince.getSelectedItem().toString();

                // Llamar al método para cargar los cantones
                ctss.loadCountiesToSamplingCountyComboBox(cbxSamplingCounty, selectedProvince);
            }
        });
        cbxSamplingCounty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de la provincia seleccionada
                String selectedCounty = (String) cbxSamplingCounty.getSelectedItem();

                // Llamar al método para cargar los cantones
                ctss.loadDistrictsToSamplingDistrictComboBox(cbxSamplingDistrict, selectedCounty);
            }
        });
        cbxWaterProvince.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de la provincia seleccionada
                String selectedProvince = cbxWaterProvince.getSelectedItem().toString();

                // Llamar al método para cargar los cantones
                ctss.loadCountiesToSamplingCountyComboBox(cbxWaterCounty, selectedProvince);
            }
        });
        cbxWaterCounty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de la provincia seleccionada
                String selectedCounty = (String) cbxWaterCounty.getSelectedItem();

                // Llamar al método para cargar los cantones
                ctss.loadDistrictsToSamplingDistrictComboBox(cbxWaterDistrict, selectedCounty);
            }
        });
        
       
        
    }

    public void listTable() {
        this.cte.loadDataEntities(tblEntity);
        this.ctf.loadFlowData(tblFlow);
        this.ctss.loadDataSamplingSites(tblSampling);
        this.ctu.loadUserData(tblUser);
        this.ctw.loadDataWaterSprings(tblWater);
        ctss.loadProvincesToSamplingProvinceComboBox(cbxSamplingProvince);
        ctw.loadProvincesToWaterProvinceComboBox(cbxWaterProvince);
    }

    public void clear() {
        this.cte.clearFields(txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
        this.ctf.clearFields(txtFlowCapacity, txtFlowMethod, txtFlowObservation, txtFlowDate, txtFlowClimate, txtFlowDone);
        this.ctss.clearFields(txtSamplingName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUserPassword = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtUserLastName = new javax.swing.JTextField();
        txtUserEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cbxUserRol = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbxUserEntity = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntity = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEntityAddress = new javax.swing.JTextField();
        txtEntityDescription = new javax.swing.JTextField();
        txtEntityName = new javax.swing.JTextField();
        txtEntityEmail = new javax.swing.JTextField();
        txtEntityPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLegalNumber = new javax.swing.JTextField();
        btnEntityDelete = new javax.swing.JButton();
        btnEntityAdd = new javax.swing.JButton();
        btnEntityEdit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFlow = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtFlowDone = new javax.swing.JTextField();
        txtFlowCapacity = new javax.swing.JTextField();
        txtFlowMethod = new javax.swing.JTextField();
        txtFlowObservation = new javax.swing.JTextField();
        txtFlowDate = new javax.swing.JTextField();
        txtFlowClimate = new javax.swing.JTextField();
        btnFlowDelete = new javax.swing.JButton();
        btnFlowAdd = new javax.swing.JButton();
        btnFlowEdit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSampling = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        txtSamplingName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbxSamplingProvince = new javax.swing.JComboBox<>();
        cbxSamplingCounty = new javax.swing.JComboBox<>();
        cbxSamplingDistrict = new javax.swing.JComboBox<>();
        cbxSamplingEntity = new javax.swing.JComboBox<>();
        btnSamplingDelete = new javax.swing.JButton();
        btnSamplingAdd = new javax.swing.JButton();
        btnSamplingEdit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblWater = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtWaterDescription = new javax.swing.JTextField();
        txtWaterName = new javax.swing.JTextField();
        txtWaterAddress = new javax.swing.JTextField();
        txtWaterLatitud = new javax.swing.JTextField();
        txtWaterLongitude = new javax.swing.JTextField();
        btnWaterDelete = new javax.swing.JButton();
        btnWaterAdd = new javax.swing.JButton();
        btnWaterEdit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbxWaterEntity = new javax.swing.JComboBox<>();
        cbxWaterProvince = new javax.swing.JComboBox<>();
        cbxWaterCounty = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbxWaterDistrict = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUser);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel1.setText("Correo Electronico:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setText("Apellidos: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jPanel1.add(txtUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 190, -1));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 190, -1));
        jPanel1.add(txtUserLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 190, -1));
        jPanel1.add(txtUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 190, -1));

        jButton1.setText("Agregar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 130, -1));

        jButton2.setText("Eliminar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 130, -1));

        jButton3.setText("Editar");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 130, -1));

        jLabel20.setText("Rol:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jPanel1.add(cbxUserRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabel21.setText("Entidad:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jPanel1.add(cbxUserEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        jTabbedPane1.addTab("Usuarios", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEntity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblEntity);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 970, 340));

        jLabel5.setText("Direccion:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setText("Cedula Juridica:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel7.setText("Nombre:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel8.setText("Correo Electronico:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel9.setText("Telefono:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel2.add(txtEntityAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 180, -1));
        jPanel2.add(txtEntityDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 180, -1));
        jPanel2.add(txtEntityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, -1));
        jPanel2.add(txtEntityEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, -1));
        jPanel2.add(txtEntityPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, -1));

        jLabel10.setText("Descripcion:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));
        jPanel2.add(txtLegalNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, -1));

        btnEntityDelete.setText("Eliminar");
        jPanel2.add(btnEntityDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 130, -1));

        btnEntityAdd.setText("Agregar");
        jPanel2.add(btnEntityAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, -1));

        btnEntityEdit.setText("Editar");
        jPanel2.add(btnEntityEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 130, -1));

        jTabbedPane1.addTab("Entidades", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFlow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblFlow);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel22.setText("Capacidad:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, -1, 20));

        jLabel23.setText("Metodo:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel24.setText("Realizado:");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel25.setText("Observacion:");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel26.setText("Fecha:");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel27.setText("Clima:");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel4.add(txtFlowDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, -1));
        jPanel4.add(txtFlowCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, -1));
        jPanel4.add(txtFlowMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, -1));
        jPanel4.add(txtFlowObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 160, -1));
        jPanel4.add(txtFlowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, -1));
        jPanel4.add(txtFlowClimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 160, -1));

        btnFlowDelete.setText("Eliminar");
        jPanel4.add(btnFlowDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 130, -1));

        btnFlowAdd.setText("Agregar");
        jPanel4.add(btnFlowAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 130, -1));

        btnFlowEdit.setText("Editar");
        jPanel4.add(btnFlowEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 130, -1));

        jTabbedPane1.addTab("Medicion", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSampling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblSampling);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel28.setText("Entidad:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jPanel5.add(txtSamplingName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 130, -1));

        jLabel29.setText("Nombre:");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel30.setText("Provincia:");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel31.setText("Canton:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel32.setText("Distrito");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cbxSamplingProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSamplingProvinceActionPerformed(evt);
            }
        });
        jPanel5.add(cbxSamplingProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        cbxSamplingCounty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jPanel5.add(cbxSamplingCounty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        cbxSamplingDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jPanel5.add(cbxSamplingDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jPanel5.add(cbxSamplingEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        btnSamplingDelete.setText("Eliminar");
        jPanel5.add(btnSamplingDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 120, -1));

        btnSamplingAdd.setText("Agregar");
        jPanel5.add(btnSamplingAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 120, -1));

        btnSamplingEdit.setText("Editar");
        jPanel5.add(btnSamplingEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 120, -1));

        jTabbedPane1.addTab("Muestreo", jPanel5);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblWater.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblWater);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel11.setText("Longitud");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel12.setText("Nombre:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel13.setText("Direccion:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel14.setText("Latitud:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 10));

        jLabel15.setText("Descripcion:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        jPanel3.add(txtWaterDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 180, -1));
        jPanel3.add(txtWaterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, -1));
        jPanel3.add(txtWaterAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, -1));
        jPanel3.add(txtWaterLatitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));
        jPanel3.add(txtWaterLongitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, -1));

        btnWaterDelete.setText("Eliminar");
        jPanel3.add(btnWaterDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 120, -1));

        btnWaterAdd.setText("Agregar");
        jPanel3.add(btnWaterAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 120, -1));

        btnWaterEdit.setText("Editar");
        jPanel3.add(btnWaterEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 120, -1));

        jLabel16.setText("Entidad:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel17.setText("Provincia:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel18.setText("Canton:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jPanel3.add(cbxWaterEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jPanel3.add(cbxWaterProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jPanel3.add(cbxWaterCounty, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabel19.setText("Distrito:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jPanel3.add(cbxWaterDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        jTabbedPane1.addTab("Nacientes", jPanel3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 0, 970, 671));
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSamplingProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSamplingProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSamplingProvinceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntityAdd;
    private javax.swing.JButton btnEntityDelete;
    private javax.swing.JButton btnEntityEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFlowAdd;
    private javax.swing.JButton btnFlowDelete;
    private javax.swing.JButton btnFlowEdit;
    private javax.swing.JButton btnSamplingAdd;
    private javax.swing.JButton btnSamplingDelete;
    private javax.swing.JButton btnSamplingEdit;
    private javax.swing.JButton btnWaterAdd;
    private javax.swing.JButton btnWaterDelete;
    private javax.swing.JButton btnWaterEdit;
    private javax.swing.JComboBox<String> cbxSamplingCounty;
    private javax.swing.JComboBox<String> cbxSamplingDistrict;
    private javax.swing.JComboBox<String> cbxSamplingEntity;
    private javax.swing.JComboBox<String> cbxSamplingProvince;
    private javax.swing.JComboBox<String> cbxUserEntity;
    private javax.swing.JComboBox<String> cbxUserRol;
    private javax.swing.JComboBox<String> cbxWaterCounty;
    private javax.swing.JComboBox<String> cbxWaterDistrict;
    private javax.swing.JComboBox<String> cbxWaterEntity;
    private javax.swing.JComboBox<String> cbxWaterProvince;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEntity;
    private javax.swing.JTable tblFlow;
    private javax.swing.JTable tblSampling;
    private javax.swing.JTable tblUser;
    private javax.swing.JTable tblWater;
    private javax.swing.JTextField txtEntityAddress;
    private javax.swing.JTextField txtEntityDescription;
    private javax.swing.JTextField txtEntityEmail;
    private javax.swing.JTextField txtEntityName;
    private javax.swing.JTextField txtEntityPhone;
    private javax.swing.JTextField txtFlowCapacity;
    private javax.swing.JTextField txtFlowClimate;
    private javax.swing.JTextField txtFlowDate;
    private javax.swing.JTextField txtFlowDone;
    private javax.swing.JTextField txtFlowMethod;
    private javax.swing.JTextField txtFlowObservation;
    private javax.swing.JTextField txtLegalNumber;
    private javax.swing.JTextField txtSamplingName;
    private javax.swing.JTextField txtUserEmail;
    private javax.swing.JTextField txtUserLastName;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserPassword;
    private javax.swing.JTextField txtWaterAddress;
    private javax.swing.JTextField txtWaterDescription;
    private javax.swing.JTextField txtWaterLatitud;
    private javax.swing.JTextField txtWaterLongitude;
    private javax.swing.JTextField txtWaterName;
    // End of variables declaration//GEN-END:variables
}
