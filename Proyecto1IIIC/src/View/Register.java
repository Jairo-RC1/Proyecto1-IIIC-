/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.*;
import java.awt.Dimension;
import javax.swing.JDialog;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Register extends javax.swing.JFrame {

    private String roleName;
    CtrlEntity cte = new CtrlEntity();
    CtrlFlow ctf = new CtrlFlow();
    CtrlSamplingSite ctss = new CtrlSamplingSite();
    CtrlUser ctu = new CtrlUser();
    CtrlWaterSpring ctw = new CtrlWaterSpring();

    public Register(String roleName) {
        initComponents();
        this.roleName = roleName;
        if (roleName.equals("Super Administrador")) {
            // Habilita todas las pestañas
            TabRegister.setEnabledAt(0, true); // Índice 0: User
            TabRegister.setEnabledAt(1, true); // Índice 1: Entity
            TabRegister.setEnabledAt(2, true); // Índice 2: Flow
            TabRegister.setEnabledAt(3, true); // Índice 3: Sampling
            TabRegister.setEnabledAt(4, true); // Índice 4: Water
            TabRegister.setEnabledAt(5, true); // Índice 5: Report
        } else if (roleName.equals("Administrador")) {
            // Habilita solo algunas pestañas
            TabRegister.setEnabledAt(0, true); // Índice 0: User
            TabRegister.setEnabledAt(1, true); // Índice 1: Entity
            TabRegister.setEnabledAt(2, false); // Índice 2: Flow
            TabRegister.setEnabledAt(3, false); // Índice 3: Sampling
            TabRegister.setEnabledAt(4, false); // Índice 4: Water
            TabRegister.setEnabledAt(5, false); // Índice 5: Report
        } else if (roleName.equals("Digitador")) {
            // Habilita otras pestañas
            TabRegister.setEnabledAt(0, true); // Índice 0: User
            TabRegister.setEnabledAt(1, false); // Índice 1: Entity
            TabRegister.setEnabledAt(2, true); // Índice 2: Flow
            TabRegister.setEnabledAt(3, false); // Índice 3: Sampling
            TabRegister.setEnabledAt(4, false); // Índice 4: Water
            TabRegister.setEnabledAt(5, false); // Índice 5: Report
            btnEditUser.setEnabled(false);
            btnDeleteUser.setEnabled(false);
            btnFlowEdit.setEnabled(false);
            btnFlowDelete.setEnabled(false);
        } else {

        }

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.listUser();
        this.listCombobox();
        this.listEntity();
        this.listFlow();
        this.listSampling();
        this.listWater();

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
        btnAddCapacity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para generar el valor aleatorio
                ctf.generateRandomCapacity(txtFlowCapacity);
            }
        });
        btnAddDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctf.generateRandomDate(txtFlowDate);
            }
        });

    }

    public void listUser() {
        this.ctu.loadUserData(tblUser);
    }

    public void listEntity() {
        this.cte.loadDataEntities(tblEntity);
    }

    public void listFlow() {
        this.ctf.loadFlowData(tblFlow);
    }

    public void listSampling() {
        this.ctss.loadDataSamplingSites(tblSampling);
    }

    public void listWater() {
        this.ctw.loadDataWaterSprings(tblWater);
    }

    public void listCombobox() {
        ctss.loadProvincesToSamplingProvinceComboBox(cbxSamplingProvince);
        ctw.loadProvincesToWaterProvinceComboBox(cbxWaterProvince);
        ctu.loadRolesToUserComboBox(cbxUserRol);
        cte.loadEntityNamesToComboBox(cbxUserEntity);
        cte.loadEntityNamesToComboBox(cbxSamplingEntity);
        cte.loadEntityNamesToComboBox(cbxWaterEntity);
        ctw.loadWaterSpringNamesToComboBox(cbxFlowWater);
        ctss.loadSamplingSiteNamesToComboBox(cbxFlowSampling);
    }

    public void clear() {
        this.cte.clearFields(txtLegalNumber, txtEntityName, txtEntityEmail, txtEntityPhone, txtEntityAddress, txtEntityDescription);
        this.ctf.clearFields(txtFlowCapacity, txtFlowObservation, txtFlowDate);
        this.ctss.clearFields(txtSamplingName);
        this.ctu.clearFields(txtUserName, txtUserLastName, txtUserEmail, txtUserPassword);
        this.ctw.clearFields(txtWaterName, txtWaterAddress, txtWaterLatitude, txtWaterLongitude, txtWaterDescription);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabRegister = new javax.swing.JTabbedPane();
        jpUser = new javax.swing.JPanel();
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
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jpEntity = new javax.swing.JPanel();
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
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntity = new javax.swing.JTable();
        jpFlow = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtFlowCapacity = new javax.swing.JTextField();
        txtFlowObservation = new javax.swing.JTextField();
        txtFlowDate = new javax.swing.JTextField();
        btnFlowDelete = new javax.swing.JButton();
        btnFlowAdd = new javax.swing.JButton();
        btnFlowEdit = new javax.swing.JButton();
        cbxFlowClimate = new javax.swing.JComboBox<>();
        cbxFlowDone = new javax.swing.JComboBox<>();
        cbxFlowSampling = new javax.swing.JComboBox<>();
        cbxFlowWater = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbxFlowMethod = new javax.swing.JComboBox<>();
        btnAddCapacity = new javax.swing.JButton();
        btnAddDate = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFlow = new javax.swing.JTable();
        jpSampling = new javax.swing.JPanel();
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
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSampling = new javax.swing.JTable();
        jpWater = new javax.swing.JPanel();
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
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblWater = new javax.swing.JTable();
        jpReport = new javax.swing.JPanel();
        btnGraphic = new javax.swing.JButton();
        btnWaterReport = new javax.swing.JButton();
        btnDistrictReport = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        btnAddUser.setBorderPainted(false);
        btnAddUser.setContentAreaFilled(false);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        jpUser.add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 40, 40));

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete (1).png"))); // NOI18N
        btnDeleteUser.setBorderPainted(false);
        btnDeleteUser.setContentAreaFilled(false);
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        jpUser.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 40, 40));

        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnEditUser.setBorderPainted(false);
        btnEditUser.setContentAreaFilled(false);
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        jpUser.add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, 40, 40));

        jLabel20.setText("Rol:");
        jpUser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jpUser.add(cbxUserRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabel21.setText("Entidad:");
        jpUser.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jpUser.add(cbxUserEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        jLabel47.setText("Eliminar");
        jpUser.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, -1, -1));

        jLabel48.setText("Agregar:");
        jpUser.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, -1, -1));

        jLabel49.setText("Editar:");
        jpUser.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, -1));

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

        jScrollPane10.setViewportView(jScrollPane1);

        jpUser.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 1070, 360));

        TabRegister.addTab("Usuarios", jpUser);

        jpEntity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnEntityDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete (1).png"))); // NOI18N
        btnEntityDelete.setBorderPainted(false);
        btnEntityDelete.setContentAreaFilled(false);
        btnEntityDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityDeleteActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 30, 40));

        btnEntityAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        btnEntityAdd.setBorderPainted(false);
        btnEntityAdd.setContentAreaFilled(false);
        btnEntityAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityAddActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 40, 40));

        btnEntityEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnEntityEdit.setBorderPainted(false);
        btnEntityEdit.setContentAreaFilled(false);
        btnEntityEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityEditActionPerformed(evt);
            }
        });
        jpEntity.add(btnEntityEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 40, 40));

        jLabel44.setText("Eliminar:");
        jpEntity.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, -1, -1));

        jLabel45.setText("Agregar:");
        jpEntity.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, -1, -1));

        jLabel46.setText("Editar:");
        jpEntity.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

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

        jScrollPane9.setViewportView(jScrollPane2);

        jpEntity.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1070, 330));

        TabRegister.addTab("Entidades", jpEntity);

        jpFlow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setText("Capacidad:");
        jpFlow.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, -1, 20));

        jLabel23.setText("Metodo:");
        jpFlow.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel24.setText("Sitio de Muestreo:");
        jpFlow.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel25.setText("Observacion:");
        jpFlow.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel26.setText("Fecha:");
        jpFlow.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel27.setText("Clima:");
        jpFlow.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jpFlow.add(txtFlowCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, -1));
        jpFlow.add(txtFlowObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 160, -1));
        jpFlow.add(txtFlowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, -1));

        btnFlowDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete (1).png"))); // NOI18N
        btnFlowDelete.setBorderPainted(false);
        btnFlowDelete.setContentAreaFilled(false);
        btnFlowDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlowDeleteActionPerformed(evt);
            }
        });
        jpFlow.add(btnFlowDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 30, 40));

        btnFlowAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        btnFlowAdd.setBorderPainted(false);
        btnFlowAdd.setContentAreaFilled(false);
        btnFlowAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlowAddActionPerformed(evt);
            }
        });
        jpFlow.add(btnFlowAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 40, 40));

        btnFlowEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnFlowEdit.setBorderPainted(false);
        btnFlowEdit.setContentAreaFilled(false);
        btnFlowEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlowEditActionPerformed(evt);
            }
        });
        jpFlow.add(btnFlowEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 40, 40));

        cbxFlowClimate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soleado", "Lluvioso", "Nublado" }));
        jpFlow.add(cbxFlowClimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 160, -1));

        cbxFlowDone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        jpFlow.add(cbxFlowDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 100, -1));

        jpFlow.add(cbxFlowSampling, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 190, -1));

        jpFlow.add(cbxFlowWater, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, -1));

        jLabel33.setText("Realizado:");
        jpFlow.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel34.setText("Naciente:");
        jpFlow.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        cbxFlowMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directo", "Indirecto" }));
        jpFlow.add(cbxFlowMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, -1));

        btnAddCapacity.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCapacity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mas.png"))); // NOI18N
        btnAddCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCapacityActionPerformed(evt);
            }
        });
        jpFlow.add(btnAddCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, 30));

        btnAddDate.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mas.png"))); // NOI18N
        btnAddDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDateActionPerformed(evt);
            }
        });
        jpFlow.add(btnAddDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, 30, 30));

        jLabel41.setText("Eliminar:");
        jpFlow.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        jLabel42.setText("Agregar:");
        jpFlow.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, -1, -1));

        jLabel43.setText("Editar:");
        jpFlow.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        tblFlow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Capacidad", "Metodo", "Observacion", "Fecha", "Clima", "Realizado", "Naciente", "Sitio"
            }
        ));
        tblFlow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFlowMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblFlow);

        jScrollPane4.setViewportView(jScrollPane5);

        jpFlow.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1070, 370));

        TabRegister.addTab("Medicion", jpFlow);

        jpSampling.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnSamplingDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete (1).png"))); // NOI18N
        btnSamplingDelete.setBorderPainted(false);
        btnSamplingDelete.setContentAreaFilled(false);
        btnSamplingDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSamplingDeleteActionPerformed(evt);
            }
        });
        jpSampling.add(btnSamplingDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 30, 40));

        btnSamplingAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        btnSamplingAdd.setBorderPainted(false);
        btnSamplingAdd.setContentAreaFilled(false);
        btnSamplingAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSamplingAddActionPerformed(evt);
            }
        });
        jpSampling.add(btnSamplingAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 40, 40));

        btnSamplingEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnSamplingEdit.setBorderPainted(false);
        btnSamplingEdit.setContentAreaFilled(false);
        btnSamplingEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSamplingEditActionPerformed(evt);
            }
        });
        jpSampling.add(btnSamplingEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, -1, 40));

        jLabel38.setText("Eliminar:");
        jpSampling.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, -1, -1));

        jLabel39.setText("Agregar:");
        jpSampling.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, -1));

        jLabel40.setText("Editar:");
        jpSampling.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, 20));

        tblSampling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Provincia", "Canton", "Distrito", "Entidad"
            }
        ));
        tblSampling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSamplingMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSampling);

        jScrollPane7.setViewportView(jScrollPane6);

        jpSampling.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1070, 340));

        TabRegister.addTab("Muestreo", jpSampling);

        jpWater.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnWaterDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete (1).png"))); // NOI18N
        btnWaterDelete.setBorderPainted(false);
        btnWaterDelete.setContentAreaFilled(false);
        btnWaterDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterDeleteActionPerformed(evt);
            }
        });
        jpWater.add(btnWaterDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 30, 40));

        btnWaterAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        btnWaterAdd.setBorderPainted(false);
        btnWaterAdd.setContentAreaFilled(false);
        btnWaterAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterAddActionPerformed(evt);
            }
        });
        jpWater.add(btnWaterAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 40, 50));

        btnWaterEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnWaterEdit.setBorderPainted(false);
        btnWaterEdit.setContentAreaFilled(false);
        btnWaterEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterEditActionPerformed(evt);
            }
        });
        jpWater.add(btnWaterEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 40, 40));

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

        jLabel35.setText("Eliminar:");
        jpWater.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, -1, -1));

        jLabel36.setText("Agregar:");
        jpWater.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, -1, -1));

        jLabel37.setText("Editar:");
        jpWater.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, -1));

        tblWater.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Direccion", "Latitud", "Longitud", "Descripcion", "Provincia", "Canton", "Distrito", "Entidad"
            }
        ));
        tblWater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWaterMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblWater);

        jScrollPane8.setViewportView(jScrollPane3);

        jpWater.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1070, 340));

        TabRegister.addTab("Nacientes", jpWater);

        jpReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGraphic.setText("Graficar Reporte");
        btnGraphic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphicActionPerformed(evt);
            }
        });
        jpReport.add(btnGraphic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, -1));

        btnWaterReport.setText("Reporte Naciente por Entidad");
        btnWaterReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaterReportActionPerformed(evt);
            }
        });
        jpReport.add(btnWaterReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 210, -1));

        btnDistrictReport.setText("Reporte por Distritos");
        btnDistrictReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistrictReportActionPerformed(evt);
            }
        });
        jpReport.add(btnDistrictReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 210, -1));

        TabRegister.addTab("Reportes", jpReport);

        getContentPane().add(TabRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 0, 1090, 671));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 50));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 1170, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSamplingProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSamplingProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSamplingProvinceActionPerformed

    private void tblWaterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWaterMouseClicked
        this.ctw.selectWaterSpringRow(tblWater, txtWaterName, txtWaterAddress, txtWaterLatitude, txtWaterLongitude, txtWaterDescription, cbxWaterProvince, cbxWaterCounty, cbxWaterDistrict, cbxWaterEntity);
    }//GEN-LAST:event_tblWaterMouseClicked

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        this.ctu.addUser(txtUserName, txtUserLastName, txtUserEmail, txtUserPassword, cbxUserEntity, cbxUserRol);
        this.clear();
        this.listUser();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        this.ctu.updateUser(txtUserName, txtUserLastName, txtUserEmail, txtUserPassword, cbxUserEntity, cbxUserRol);
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

    private void btnFlowAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlowAddActionPerformed
        this.ctf.addFlow(txtFlowCapacity, cbxFlowMethod, txtFlowObservation, txtFlowDate, cbxFlowClimate, cbxFlowDone, cbxFlowWater, cbxFlowSampling);
        this.clear();
        this.listFlow();
    }//GEN-LAST:event_btnFlowAddActionPerformed

    private void btnFlowEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlowEditActionPerformed
        this.ctf.updateFlow(txtFlowCapacity, cbxFlowMethod, txtFlowObservation, txtFlowDate, cbxFlowClimate, cbxFlowDone, cbxFlowWater, cbxFlowSampling);
        this.clear();
        this.listFlow();
    }//GEN-LAST:event_btnFlowEditActionPerformed

    private void btnFlowDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlowDeleteActionPerformed
        this.ctf.deleteFlow();
        this.clear();
        this.listFlow();
    }//GEN-LAST:event_btnFlowDeleteActionPerformed

    private void tblFlowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFlowMouseClicked
        this.ctf.selectFlowRow(tblFlow, txtFlowCapacity, cbxFlowMethod, txtFlowObservation, txtFlowDate, cbxFlowClimate, cbxFlowDone, cbxFlowWater, cbxFlowSampling);
    }//GEN-LAST:event_tblFlowMouseClicked

    private void btnSamplingAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSamplingAddActionPerformed
        this.ctss.addSamplingSite(txtSamplingName, cbxSamplingProvince, cbxSamplingCounty, cbxSamplingDistrict, cbxSamplingEntity);
        this.clear();
        this.listSampling();
    }//GEN-LAST:event_btnSamplingAddActionPerformed

    private void btnSamplingEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSamplingEditActionPerformed
        this.ctss.updateSamplingSite(txtSamplingName, cbxSamplingProvince, cbxSamplingCounty, cbxSamplingDistrict, cbxSamplingEntity);
        this.clear();
        this.listSampling();
    }//GEN-LAST:event_btnSamplingEditActionPerformed

    private void btnSamplingDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSamplingDeleteActionPerformed
        this.ctss.deleteSamplingSite();
    }//GEN-LAST:event_btnSamplingDeleteActionPerformed

    private void tblSamplingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSamplingMouseClicked
        this.ctss.selectSamplingSiteRow(tblSampling, txtSamplingName, cbxSamplingProvince, cbxSamplingCounty, cbxSamplingDistrict, cbxSamplingEntity);
    }//GEN-LAST:event_tblSamplingMouseClicked

    private void btnWaterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterAddActionPerformed
        this.ctw.addWaterSpring(txtWaterName, txtWaterAddress, txtWaterLatitude, txtWaterLongitude, txtWaterDescription, cbxWaterProvince, cbxWaterCounty, cbxWaterDistrict, cbxWaterEntity);
        this.clear();
        this.listWater();
    }//GEN-LAST:event_btnWaterAddActionPerformed

    private void btnWaterEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterEditActionPerformed
        this.ctw.updateWaterSpring(txtWaterName, txtWaterAddress, txtWaterLatitude, txtWaterLongitude, txtWaterDescription, cbxWaterProvince, cbxWaterCounty, cbxWaterDistrict, cbxWaterEntity);
        this.clear();
        this.listWater();
    }//GEN-LAST:event_btnWaterEditActionPerformed

    private void btnWaterDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterDeleteActionPerformed
        this.ctw.deleteWaterSpring();
        this.clear();
        this.listWater();
    }//GEN-LAST:event_btnWaterDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Login lo = new Login();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCapacityActionPerformed

    private void btnAddDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDateActionPerformed

    private void btnWaterReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterReportActionPerformed
        WaterReport water = new WaterReport();
        water.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnWaterReportActionPerformed

    private void btnGraphicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicActionPerformed
        FlowDAO flowdao = new FlowDAO();
        List<FlowWithWaterSpring> flowsWithWaterSpring = flowdao.getFlowsWithWaterSprings(); // Reemplaza 'flowDao' por la instancia de tu FlowDAO

        JFreeChart chart = FlowChart.createFlowChart(flowsWithWaterSpring);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Crea un diálogo o ventana emergente para mostrar el gráfico
        JDialog dialog = new JDialog();
        dialog.setTitle("Gráfico de Capacidad de Flujo por Naciente");
        dialog.add(chartPanel);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGraphicActionPerformed

    private void btnDistrictReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistrictReportActionPerformed
        DistrictReport dr = new DistrictReport();
        dr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDistrictReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabRegister;
    private javax.swing.JButton btnAddCapacity;
    private javax.swing.JButton btnAddDate;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnDistrictReport;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnEntityAdd;
    private javax.swing.JButton btnEntityDelete;
    private javax.swing.JButton btnEntityEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFlowAdd;
    private javax.swing.JButton btnFlowDelete;
    private javax.swing.JButton btnFlowEdit;
    private javax.swing.JButton btnGraphic;
    private javax.swing.JButton btnSamplingAdd;
    private javax.swing.JButton btnSamplingDelete;
    private javax.swing.JButton btnSamplingEdit;
    private javax.swing.JButton btnWaterAdd;
    private javax.swing.JButton btnWaterDelete;
    private javax.swing.JButton btnWaterEdit;
    private javax.swing.JButton btnWaterReport;
    private javax.swing.JComboBox<String> cbxFlowClimate;
    private javax.swing.JComboBox<String> cbxFlowDone;
    private javax.swing.JComboBox<String> cbxFlowMethod;
    private javax.swing.JComboBox<String> cbxFlowSampling;
    private javax.swing.JComboBox<String> cbxFlowWater;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
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
    private javax.swing.JTextField txtFlowDate;
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
