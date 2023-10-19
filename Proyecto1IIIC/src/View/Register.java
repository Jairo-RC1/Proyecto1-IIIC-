/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Register extends javax.swing.JFrame {

    CtrlEntity cte = new CtrlEntity();
    CtrlFlow ctf = new CtrlFlow();
    CtrlSamplingSite ctss = new CtrlSamplingSite();
    CtrlUser ctu = new CtrlUser();
    CtrlWaterSpring ctw = new CtrlWaterSpring();

    public Register(String roleName) {
 // Configura las pestañas y controles según el rol
        if (roleName.equals("Super Administrador")) {
            jpUser = new JPanel();
            jpUser.setVisible(true);
            jpEntity.setVisible(true);
            jpFlow.setVisible(true);
            jpSampling.setVisible(true);
            jpWater.setVisible(true);
            jpReport.setVisible(true);
        } else if (roleName.equals("Administrador")) {
            Tab.setVisible(true);
            Tab.setVisible(true);
            jpFlow.setVisible(false);
            jpSampling.setVisible(false);
            jpWater.setVisible(false);
            jpReport.setVisible(false);
        } else if (roleName.equals("Digitador")) {
            Tab.setVisible(false);
            Tab.setVisible(false);
            jpFlow.setVisible(true);
            jpSampling.setVisible(true);
            jpWater.setVisible(true);
            jpReport.setVisible(false);
        } else {
            // Trata el caso de un rol no válido o desconocido
        }
    }

    public Register() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.listUser();
        this.listCombobox();
        this.listEntity();
       
        cbxSamplingProvince.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedProvince = cbxSamplingProvince.getSelectedItem().toString();

                // LCall the method to load the blocks
                ctss.loadCountiesToSamplingCountyComboBox(cbxSamplingCounty, selectedProvince);
            }
        });
        cbxSamplingCounty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedCounty = (String) cbxSamplingCounty.getSelectedItem();

                // Call the method to load the blocks
                ctss.loadDistrictsToSamplingDistrictComboBox(cbxSamplingDistrict, selectedCounty);
            }
        });
        cbxWaterProvince.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedProvince = cbxWaterProvince.getSelectedItem().toString();

                // Call the method to load the blocks
                ctss.loadCountiesToSamplingCountyComboBox(cbxWaterCounty, selectedProvince);
            }
        });
        cbxWaterCounty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name of the selected province
                String selectedCounty = (String) cbxWaterCounty.getSelectedItem();

                // Call the method to load the blocks
                ctss.loadDistrictsToSamplingDistrictComboBox(cbxWaterDistrict, selectedCounty);
            }
        });

    }

    public void listUser() {
        //this.ctf.loadFlowData(tblFlow);
        //this.ctss.loadDataSamplingSites(tblSampling);
        this.ctu.loadUserData(tblUser);
        //this.ctw.loadDataWaterSprings(tblWater);
    }

    public void listEntity() {
        this.cte.loadDataEntities(tblEntity);
    }

    public void listCombobox() {
        ctss.loadProvincesToSamplingProvinceComboBox(cbxSamplingProvince);
        ctw.loadProvincesToWaterProvinceComboBox(cbxWaterProvince);
        ctu.loadRolesToUserComboBox(cbxUserRol);
        cte.loadEntityNamesToComboBox(cbxUserEntity);
        cte.loadEntityNamesToComboBox(cbxSamplingEntity);
        cte.loadEntityNamesToComboBox(cbxWaterEntity);
    }

    public void clear() {
        this.cte.clearFields(txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
        this.ctf.clearFields(txtFlowCapacity, txtFlowMethod, txtFlowObservation, txtFlowDate, txtFlowClimate, txtFlowDone);
        this.ctss.clearFields(txtSamplingName);
        this.ctu.clearFields(txtUserName, txtUserLastName, txtUserEmail, txtUserPassword);
        this.ctw.clearFields(txtWaterName, txtWaterAddress, txtWaterLatitude, txtWaterLongitude, txtWaterDescription);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tab = new javax.swing.JTabbedPane();
        jpUser = new javax.swing.JPanel();
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
        btnAddUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cbxUserRol = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbxUserEntity = new javax.swing.JComboBox<>();
        jpEntity = new javax.swing.JPanel();
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
        jpFlow = new javax.swing.JPanel();
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
        jpSampling = new javax.swing.JPanel();
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
        jpWater = new javax.swing.JPanel();
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
        txtWaterLatitude = new javax.swing.JTextField();
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
        jpReport = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Correo Electronico", "Contraseña", "Entidad", "Rol"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        jpUser.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel1.setText("Correo Electronico:");
        jpUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel2.setText("Nombre: ");
        jpUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setText("Apellidos: ");
        jpUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("Contraseña:");
        jpUser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jpUser.add(txtUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 190, -1));
        jpUser.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 190, -1));
        jpUser.add(txtUserLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 190, -1));
        jpUser.add(txtUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 190, -1));

        btnAddUser.setText("Agregar");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        jpUser.add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 130, -1));

        btnDeleteUser.setText("Eliminar");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        jpUser.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 130, -1));

        btnEditUser.setText("Editar");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        jpUser.add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 130, -1));

        jLabel20.setText("Rol:");
        jpUser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jpUser.add(cbxUserRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabel21.setText("Entidad:");
        jpUser.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jpUser.add(cbxUserEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Tab.addTab("Usuarios", jpUser);

        jpEntity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEntity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cedula Juridica", "Nombre", "Correo Electronico", "Telefono", "Direccion", "Descripcion"
            }
        ));
        tblEntity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntityMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEntity);

        jpEntity.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 970, 340));

        jLabel5.setText("Direccion:");
        jpEntity.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setText("Cedula Juridica:");
        jpEntity.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel7.setText("Nombre:");
        jpEntity.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel8.setText("Correo Electronico:");
        jpEntity.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel9.setText("Telefono:");
        jpEntity.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jpEntity.add(txtEntityAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 180, -1));
        jpEntity.add(txtEntityDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 180, -1));
        jpEntity.add(txtEntityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, -1));
        jpEntity.add(txtEntityEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, -1));
        jpEntity.add(txtEntityPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, -1));

        jLabel10.setText("Descripcion:");
        jpEntity.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));
        jpEntity.add(txtLegalNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, -1));

        btnEntityDelete.setText("Eliminar");
        btnEntityDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityDeleteActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 130, -1));

        btnEntityAdd.setText("Agregar");
        btnEntityAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityAddActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, -1));

        btnEntityEdit.setText("Editar");
        btnEntityEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityEditActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 130, -1));

        Tab.addTab("Entidades", jpEntity);

        jpFlow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFlow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblFlow);

        jpFlow.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel22.setText("Capacidad:");
        jpFlow.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, -1, 20));

        jLabel23.setText("Metodo:");
        jpFlow.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel24.setText("Realizado:");
        jpFlow.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel25.setText("Observacion:");
        jpFlow.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel26.setText("Fecha:");
        jpFlow.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel27.setText("Clima:");
        jpFlow.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jpFlow.add(txtFlowDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, -1));
        jpFlow.add(txtFlowCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, -1));
        jpFlow.add(txtFlowMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, -1));
        jpFlow.add(txtFlowObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 160, -1));
        jpFlow.add(txtFlowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, -1));
        jpFlow.add(txtFlowClimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 160, -1));

        btnFlowDelete.setText("Eliminar");
        jpFlow.add(btnFlowDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 130, -1));

        btnFlowAdd.setText("Agregar");
        jpFlow.add(btnFlowAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 130, -1));

        btnFlowEdit.setText("Editar");
        jpFlow.add(btnFlowEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 130, -1));

        Tab.addTab("Medicion", jpFlow);

        jpSampling.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSampling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblSampling);

        jpSampling.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel28.setText("Entidad:");
        jpSampling.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jpSampling.add(txtSamplingName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 130, -1));

        jLabel29.setText("Nombre:");
        jpSampling.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel30.setText("Provincia:");
        jpSampling.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel31.setText("Canton:");
        jpSampling.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel32.setText("Distrito");
        jpSampling.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cbxSamplingProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSamplingProvinceActionPerformed(evt);
            }
        });
        jpSampling.add(cbxSamplingProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 100, -1));

        cbxSamplingCounty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jpSampling.add(cbxSamplingCounty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        cbxSamplingDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jpSampling.add(cbxSamplingDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jpSampling.add(cbxSamplingEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 190, -1));

        btnSamplingDelete.setText("Eliminar");
        jpSampling.add(btnSamplingDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 120, -1));

        btnSamplingAdd.setText("Agregar");
        jpSampling.add(btnSamplingAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 120, -1));

        btnSamplingEdit.setText("Editar");
        jpSampling.add(btnSamplingEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 120, -1));

        Tab.addTab("Muestreo", jpSampling);

        jpWater.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblWater.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblWater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWaterMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblWater);

        jpWater.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 970, 340));

        jLabel11.setText("Longitud");
        jpWater.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel12.setText("Nombre:");
        jpWater.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel13.setText("Direccion:");
        jpWater.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel14.setText("Latitud:");
        jpWater.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 10));

        jLabel15.setText("Descripcion:");
        jpWater.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        jpWater.add(txtWaterDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 180, -1));
        jpWater.add(txtWaterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, -1));
        jpWater.add(txtWaterAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, -1));
        jpWater.add(txtWaterLatitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));
        jpWater.add(txtWaterLongitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, -1));

        btnWaterDelete.setText("Eliminar");
        jpWater.add(btnWaterDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 120, -1));

        btnWaterAdd.setText("Agregar");
        jpWater.add(btnWaterAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 120, -1));

        btnWaterEdit.setText("Editar");
        jpWater.add(btnWaterEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 120, -1));

        jLabel16.setText("Entidad:");
        jpWater.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel17.setText("Provincia:");
        jpWater.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel18.setText("Canton:");
        jpWater.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jpWater.add(cbxWaterEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 200, -1));

        jpWater.add(cbxWaterProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 100, -1));

        cbxWaterCounty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jpWater.add(cbxWaterCounty, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 100, -1));

        jLabel19.setText("Distrito:");
        jpWater.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        cbxWaterDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        jpWater.add(cbxWaterDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 100, -1));

        Tab.addTab("Nacientes", jpWater);

        javax.swing.GroupLayout jpReportLayout = new javax.swing.GroupLayout(jpReport);
        jpReport.setLayout(jpReportLayout);
        jpReportLayout.setHorizontalGroup(
            jpReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jpReportLayout.setVerticalGroup(
            jpReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        Tab.addTab("Reportes", jpReport);

        getContentPane().add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 0, 970, 671));
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSamplingProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSamplingProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSamplingProvinceActionPerformed

    private void tblWaterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWaterMouseClicked

    }//GEN-LAST:event_tblWaterMouseClicked

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        this.ctu.addUser(txtUserName, txtUserLastName, txtUserEmail, txtUserPassword, cbxUserEntity, cbxUserRol);
        this.clear();
        this.listUser();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        this.ctu.updateUser(txtUserName, txtUserName, txtUserEmail, txtUserPassword, cbxUserEntity, cbxUserRol);
        this.clear();
        this.listUser();
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        this.ctu.deleteUser();
        this.clear();
        this.listUser();
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnEntityAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityAddActionPerformed
        this.cte.addEntity(txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
        this.clear();
        this.listEntity();
    }//GEN-LAST:event_btnEntityAddActionPerformed

    private void tblEntityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntityMouseClicked
        this.cte.selectEntityRow(tblEntity, txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
    }//GEN-LAST:event_tblEntityMouseClicked

    private void btnEntityEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityEditActionPerformed
        this.cte.updateEntity(txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
        this.clear();
        this.listEntity();
    }//GEN-LAST:event_btnEntityEditActionPerformed

    private void btnEntityDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityDeleteActionPerformed
        this.cte.deleteEntity();
        this.clear();
        this.listEntity();
    }//GEN-LAST:event_btnEntityDeleteActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        this.ctu.selectRow(tblUser, txtUserName, txtUserLastName, txtUserEmail, txtUserPassword, cbxUserEntity, cbxUserRol);
    }//GEN-LAST:event_tblUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel jpEntity;
    private javax.swing.JPanel jpFlow;
    private javax.swing.JPanel jpReport;
    private javax.swing.JPanel jpSampling;
    private javax.swing.JPanel jpUser;
    private javax.swing.JPanel jpWater;
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
    private javax.swing.JTextField txtWaterLatitude;
    private javax.swing.JTextField txtWaterLongitude;
    private javax.swing.JTextField txtWaterName;
    // End of variables declaration//GEN-END:variables
}
