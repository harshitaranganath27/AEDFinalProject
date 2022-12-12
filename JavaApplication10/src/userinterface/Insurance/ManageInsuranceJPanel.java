/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Insurance;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Insurance.Insurance;
import Business.Enterprise.Insurance.InsuranceDetails;
import Business.Enterprise.Insurance.InsuranceDirectory;
import Business.Organization.OrganizationDirectory;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.DoctorRole;
import Business.Role.LabTechnicianRole;
import Business.Role.NurseRole;
import Business.Role.PatientRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class ManageInsuranceJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private PatientDirectory  patientDir;
    
    private UserAccount useraccount;
    private EcoSystem system;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageInsuranceJPanel(JPanel userProcessContainer,OrganizationDirectory 
            organizationDir, Enterprise enterprise, UserAccount useraccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.enterprise= enterprise;
        this.useraccount= useraccount;
        this.patientDir= ((Insurance)enterprise).getPatientDirectory();  //system.getPatientDirectory();//
        //populateMainMedicinesComboBox();
        //populateOrganizationEmpComboBox();
        populateOrganizationComboBox();
        viewMedicineJPanel.setVisible(false);
        addMedicineJPanel.setVisible(false);
        //this.system= system;
        
        populateTableALL();//(TOOL_TIP_TEXT_KEY);
    }
    
    public void populateOrganizationComboBox(){
        cmbSSN.removeAllItems();
        if(patientDir==null)
        {
            PatientDirectory d = new PatientDirectory();
            enterprise.setPatientDirectory(patientDir);
        }
        for ( Patient p: patientDir.getPatientList()){
            cmbSSN.addItem(p.getSSN());
        }
    }
    
    
    
    private void populateTableALL(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        if(((Insurance)enterprise).getIndir()==null)
        {
            InsuranceDirectory indr = new InsuranceDirectory();
            ((Insurance)enterprise).setIndir(indr);
        }
        
         List<InsuranceDetails> inList = ((Insurance)enterprise).getIndir().getInsuranceDir();
        
         if(inList==null)
         {
              List<InsuranceDetails> inlist1 = new ArrayList<InsuranceDetails>();
             ((Insurance)enterprise).getIndir().setInsuranceDir(inlist1);
         }
         
         for (InsuranceDetails med :inList){
            //if(med.getSSN().equals(SSN))
            {
            
            Object[] row = new Object[7];
            row[0] = med;//.getId();
            row[1] = med.getInsuranceDealer().getName();
            row[2] = med.getPatient().getName();
            row[3] = med.getType();
            row[4] = med.getPrice();
            row[5] = med.getValidity();
            row[6] = med.getCreatedOndate();
            model.addRow(row);
        //}
        }
    }
    }
   

    private void populateTable(String SSN){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        if(((Insurance)enterprise).getIndir()==null)
        {
            InsuranceDirectory indr = new InsuranceDirectory();
            ((Insurance)enterprise).setIndir(indr);
        }
        
         List<InsuranceDetails> inList = ((Insurance)enterprise).getIndir().getInsuranceDetailsBySSN(SSN);
        
         if(inList==null)
         {
             return;
         }
         
         for (InsuranceDetails med :inList){
            //if(med.getSSN().equals(SSN))
            {
            
            Object[] row = new Object[7];
            row[0] = med;//.getId();
            row[1] = med.getInsuranceDealer().getName();
            row[2] = med.getPatient().getName();
            row[3] = med.getType();
            row[4] = med.getPrice();
            row[5] = med.getValidity();
            row[6] = med.getCreatedOndate();
            model.addRow(row);
        //}
        }
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        cmbSSN = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        addMedicineJPanel = new javax.swing.JPanel();
        custNameJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        cmbInsuranceType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        validity = new javax.swing.JTextField();
        lblUserName2 = new javax.swing.JLabel();
        txtSSN = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        viewMedicineJPanel = new javax.swing.JPanel();
        customerJTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        priceTxt1 = new javax.swing.JTextField();
        nameJTextField1 = new javax.swing.JTextField();
        cmbInsuranceType1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        closebtn1 = new javax.swing.JButton();
        validity1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblUserName3 = new javax.swing.JLabel();
        txtSSN1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setBackground(new java.awt.Color(255, 193, 131));
        organizationJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        organizationJTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Customer Name", "Type", "Value", "Validity", "Created Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        organizationJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 720, 190));

        cmbSSN.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmbSSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSSNActionPerformed(evt);
            }
        });
        add(cmbSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 179, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("SSN:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        addMedicineJPanel.setBackground(new java.awt.Color(255, 255, 255));
        addMedicineJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Insurance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(68, 145, 157))); // NOI18N
        addMedicineJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        custNameJTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addMedicineJPanel.add(custNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 122, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Price");
        addMedicineJPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Insurance Dealer");
        addMedicineJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        priceTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addMedicineJPanel.add(priceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 122, -1));

        nameJTextField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        addMedicineJPanel.add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 122, -1));

        cmbInsuranceType.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbInsuranceType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Liquid", "Tablet", "Gel", "Injection", "Other" }));
        cmbInsuranceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInsuranceTypeActionPerformed(evt);
            }
        });
        addMedicineJPanel.add(cmbInsuranceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 122, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Type");
        addMedicineJPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 38, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Customer Name");
        addMedicineJPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        btnSave.setBackground(new java.awt.Color(102, 147, 255));
        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        addMedicineJPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 63, -1));

        closebtn.setBackground(new java.awt.Color(102, 147, 255));
        closebtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        closebtn.setText("Close");
        closebtn.setPreferredSize(new java.awt.Dimension(100, 40));
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        addMedicineJPanel.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Validity");
        addMedicineJPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        validity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addMedicineJPanel.add(validity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 122, -1));

        lblUserName2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblUserName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName2.setText("SSN");
        addMedicineJPanel.add(lblUserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 40, -1));

        txtSSN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSSNActionPerformed(evt);
            }
        });
        addMedicineJPanel.add(txtSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 120, -1));

        add(addMedicineJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 340, 380));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(255, 155, 54));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAdd.setText("New Insurance");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(255, 155, 54));
        btnView.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 170));

        viewMedicineJPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewMedicineJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(68, 145, 157))); // NOI18N
        viewMedicineJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerJTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewMedicineJPanel.add(customerJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 122, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Validity");
        viewMedicineJPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Insurance Dealer");
        viewMedicineJPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        priceTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewMedicineJPanel.add(priceTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 122, -1));

        nameJTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewMedicineJPanel.add(nameJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 122, -1));

        cmbInsuranceType1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbInsuranceType1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Liquid", "Tablet", "Gel", "Injection", "Other" }));
        cmbInsuranceType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInsuranceType1ActionPerformed(evt);
            }
        });
        viewMedicineJPanel.add(cmbInsuranceType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 122, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Type");
        viewMedicineJPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        btnSave1.setBackground(new java.awt.Color(102, 147, 255));
        btnSave1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave1.setText("Save");
        btnSave1.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        viewMedicineJPanel.add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 63, -1));

        btnUpdate1.setBackground(new java.awt.Color(102, 147, 255));
        btnUpdate1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate1.setText("Update Details");
        btnUpdate1.setPreferredSize(new java.awt.Dimension(167, 40));
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        viewMedicineJPanel.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 140, -1));

        closebtn1.setBackground(new java.awt.Color(102, 147, 255));
        closebtn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        closebtn1.setText("Close");
        closebtn1.setPreferredSize(new java.awt.Dimension(100, 40));
        closebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtn1ActionPerformed(evt);
            }
        });
        viewMedicineJPanel.add(closebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        validity1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewMedicineJPanel.add(validity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 122, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Price");
        viewMedicineJPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Customer Name");
        viewMedicineJPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblUserName3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblUserName3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName3.setText("SSN");
        viewMedicineJPanel.add(lblUserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 40, -1));

        txtSSN1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewMedicineJPanel.add(txtSSN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 120, -1));

        add(viewMedicineJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 310, 380));

        jPanel13.setBackground(new java.awt.Color(68, 145, 157));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(68, 145, 157));
        jLabel15.setText("Manage Insurance");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 270, 37));

        backJButton.setBackground(new java.awt.Color(102, 147, 255));
        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 103, 39));

        jPanel14.setBackground(new java.awt.Color(196, 224, 229));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 140));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
       String name= nameJTextField.getText();
       String custName = custNameJTextField.getText();
       //String type = cmb;
       
       if(cmbInsuranceType.getSelectedIndex() == 0)
       {
           JOptionPane.showMessageDialog(null, "Please select type","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       String type= (String) cmbInsuranceType.getSelectedItem();
       String date = validity.getText(); 
       
       boolean valid=Validation.validateDate(date);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter date properly","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       String priceString = priceTxt.getText();
        
       if(name ==  null || name.equals("")
               || 
               custName ==  null || custName.equals("")
               ||
                              date ==  null || date.equals("")
               ||
               priceString ==  null || priceString.equals("")
               ||
               txtSSN.getText().equals("")
               )
       {
            JOptionPane.showMessageDialog(null, "Please enter all details","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       //validation on data
        valid = Validation.validateString(name);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter name correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       valid = Validation.validateDouble(priceString);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter price correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       
       
       
       valid = Validation.validateDate(date);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter date correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       String ssnString = txtSSN.getText();
        boolean checkSSN = Validation.checkSNNValidAndUnique(ssnString);
        if(checkSSN == false)
        {
            JOptionPane.showMessageDialog(null, "SSN is invalid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
       
       
       //parse
           
       
        double price = Double.parseDouble(priceString);
        
        if(price == 0.0)
        {
            JOptionPane.showMessageDialog(null, "Please enter price correctly, cannot be zero","Warning",JOptionPane.WARNING_MESSAGE);
           return;
            
        }
        //Date parse
       
        Date date1=null;
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        try {
           date1 =formatter1.parse(date);
        } catch (ParseException ex) {
            System.out.println("Error in ManageMedicineJPanel for date paring");
            Logger.getLogger(ManageInsuranceJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Patient patient = new Patient();
        enterprise.getPatientDirectory().getPatientList().add(patient);
        //system.getPatientDirectory().getPatientList().add(patient);
        patient.setName(custName);
        patient.setSSN(ssnString);
        //patient.set
        InsuranceDetails insrdtl = new InsuranceDetails();
        //insrdtl.setCreatedOndate(date1);
        insrdtl.setPatient(patient);
        insrdtl.setPrice(price);
        insrdtl.setType(type);
        insrdtl.setValidity(date1);
        insrdtl.setSSN(ssnString);
        insrdtl.setInsuranceDealer(useraccount.getEmployee());
        
        if(((Insurance)enterprise).getIndir() == null)
        {
             InsuranceDirectory indr = new InsuranceDirectory();
            ((Insurance)enterprise).setIndir(indr);
        }
        
        ((Insurance)enterprise).getIndir().getInsuranceDir().add(insrdtl);
        
        
        
        JOptionPane.showMessageDialog(null, "Added successfully","Information",JOptionPane.INFORMATION_MESSAGE);
        
         
        
       //populate table by using main medicine cmb box 
        //String medType = (String) cmbSSN.getSelectedItem();
        populateTableALL();
        
        nameJTextField.setText("");
        custNameJTextField.setText("");
      priceTxt.setText("");
       //cmbMedicineType.setSelectedItem(med.getType());
        validity.setText("");       
         txtSSN.setText("");
        
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    
    public Role createObjectForRole(String roleString){
        Role role = null;
        if(roleString.equals("DoctorRole"))
        {
            role=new DoctorRole();
        }
        else if(roleString.equals("NurseRole"))
        {
            role=new NurseRole();
        }
        else if(roleString.equals("LabTechnicianRole"))
        {
            role=new LabTechnicianRole();
        }
        else if(roleString.equals("PatientRole"))
        {
            role=new PatientRole();
        }
        else if(roleString.equals("ReceptionistRole"))
        {
            role=new ReceptionistRole();
        }
        
        return role;
    }
    
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void cmbInsuranceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInsuranceTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInsuranceTypeActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        addMedicineJPanel.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

    private void cmbSSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSSNActionPerformed
        String medType = (String) cmbSSN.getSelectedItem();
        if (patientDir != null && !patientDir.getPatientList().isEmpty()){
            populateTable(medType);
            //populateOrganizationEmpComboBox();  //based on organization seleted, get the supported roles only
        }
    }//GEN-LAST:event_cmbSSNActionPerformed

    private void cmbInsuranceType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInsuranceType1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInsuranceType1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
         String name= nameJTextField1.getText();
       String custName = customerJTextField1.getText();
       //String type = cmb;
       
       if(cmbInsuranceType1.getSelectedIndex() == 0)
       {
           JOptionPane.showMessageDialog(null, "Please select type","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       String type= (String) cmbInsuranceType1.getSelectedItem();
       String date = validity1.getText(); 
       
       boolean valid=Validation.validateDate(date);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter date properly","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       String priceString = priceTxt1.getText();
        
       if(name ==  null || name.equals("")
               || 
               custName ==  null || custName.equals("")
               ||
                              date ==  null || date.equals("")
               ||
               priceString ==  null || priceString.equals("")
               ||
               txtSSN1.getText().equals("")
               )
       {
            JOptionPane.showMessageDialog(null, "Please enter all details","Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
       
       //validation on data
        valid = Validation.validateString(name);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter name correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       valid = Validation.validateDouble(priceString);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter price correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       
       
       
       valid = Validation.validateDate(date);
       if(valid == false)
       {
           JOptionPane.showMessageDialog(null, "Please enter date correctly","Warning",JOptionPane.WARNING_MESSAGE);
           return;
       }
       
       String ssnString = txtSSN1.getText();
        boolean checkSSN = Validation.checkSNNValidAndUnique(ssnString);
        if(checkSSN == false)
        {
            JOptionPane.showMessageDialog(null, "SSN is invalid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
       
       
       //parse
           
       
        double price = Double.parseDouble(priceString);
        
        if(price == 0.0)
        {
            JOptionPane.showMessageDialog(null, "Please enter price correctly, cannot be zero","Warning",JOptionPane.WARNING_MESSAGE);
           return;
            
        }
        //Date parse
       
        Date date1=null;
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        try {
           date1 =formatter1.parse(date);
        } catch (ParseException ex) {
            System.out.println("Error in ManageMedicineJPanel for date paring");
            Logger.getLogger(ManageInsuranceJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Patient patient = new Patient();
        enterprise.getPatientDirectory().getPatientList().add(patient);
        
        patient.setName(name);
        patient.setSSN(ssnString);
        //patient.set
        int row = organizationJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        InsuranceDetails insrdtl = (InsuranceDetails) organizationJTable.getValueAt(row,0);
        //insrdtl.setCreatedOndate(date1);
        insrdtl.setPatient(patient);
        insrdtl.setPrice(price);
        insrdtl.setType(type);
        insrdtl.setValidity(date1);
        insrdtl.setSSN(ssnString);
        insrdtl.setInsuranceDealer(useraccount.getEmployee());
        //((Insurance)enterprise).getIndir().getInsuranceDir().add(insrdtl);
        
        
     
       
        
        JOptionPane.showMessageDialog(null, "Updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
         
        
       //populate table by using main medicine cmb box 
        String medType = (String) cmbSSN.getSelectedItem();
        populateTable(medType);
        
        
        cmbInsuranceType1.setEnabled(false);
        nameJTextField1.setEditable(false);
        customerJTextField1.setEditable(false);
        txtSSN1.setEditable(false);
          validity1.setEditable(false);      
           priceTxt1.setEditable(false);     
         btnSave1.setEnabled(false);
           btnUpdate1.setEnabled(true);   
        
        nameJTextField1.setText("");
        customerJTextField1.setText("");
      priceTxt1.setText("");
       //cmbMedicineType.setSelectedItem(med.getType());
        validity1.setText("");       
         txtSSN1.setText("");
        
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void closebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtn1ActionPerformed
        // TODO add your handling code here:
        viewMedicineJPanel.setVisible(false);
    }//GEN-LAST:event_closebtn1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addMedicineJPanel.setVisible(true);
        nameJTextField.setText(useraccount.getEmployee().getName());
        nameJTextField.setEditable(false);
        populateInsuranceType();
    }//GEN-LAST:event_btnAddActionPerformed

    
    void populateInsuranceType(){
         cmbInsuranceType.removeAllItems();
        
        //for (Organization organization : organizationDir.getOrganizationList()){
            cmbInsuranceType.addItem("Select");
             cmbInsuranceType.addItem("Medical");
              cmbInsuranceType.addItem("Life");
               cmbInsuranceType.addItem("Health");
        //}
    }
    
    
     void populateInsuranceType1(){
         cmbInsuranceType1.removeAllItems();
        
        //for (Organization organization : organizationDir.getOrganizationList()){
            cmbInsuranceType1.addItem("Select");
             cmbInsuranceType1.addItem("Medical");
              cmbInsuranceType1.addItem("Life");
               cmbInsuranceType1.addItem("Health");
        //}
    }
    
    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
        
        cmbInsuranceType1.setEnabled(true);
        nameJTextField1.setEditable(true);
        customerJTextField1.setEditable(true);
        custNameJTextField.setEditable(true);
          validity1.setEditable(true);      
           priceTxt1.setEditable(true); 
           btnSave1.setEnabled(true);
           btnUpdate1.setEnabled(false);
           txtSSN.setEnabled(false);
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
          int row = organizationJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        viewMedicineJPanel.setVisible(true);
        
        //populate 
        InsuranceDetails med= (InsuranceDetails)  organizationJTable.getValueAt(row,0);
        populateInsuranceType1();
        populateDetails(med);
        
       // nameJTextField.setText(useraccount.getEmployee().getName());
        nameJTextField.setEditable(false);
    }//GEN-LAST:event_btnViewActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void txtSSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSSNActionPerformed

    
    void populateDetails(InsuranceDetails med){
        
        nameJTextField1.setText(med.getInsuranceDealer().getName());
        customerJTextField1.setText(med.getPatient().getName());
      //availableQtyTxt1.setText(String.valueOf(med.getQuantity()));
       cmbInsuranceType1.setSelectedItem(med.getType());
       txtSSN1.setText(med.getSSN());
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(med.getValidity());



        validity1.setText(strDate);       
         priceTxt1.setText(String.valueOf(med.getPrice()));
        
        cmbInsuranceType1.setEnabled(false);
        nameJTextField1.setEditable(false);
        customerJTextField1.setEditable(false);
        txtSSN1.setEditable(false);
        //availableQtyTxt1.setEditable(false);
          validity1.setEditable(false);      
           priceTxt1.setEditable(false);     
         btnSave1.setEnabled(false);
           btnUpdate1.setEnabled(true);        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMedicineJPanel;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnView;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton closebtn1;
    private javax.swing.JComboBox cmbInsuranceType;
    private javax.swing.JComboBox cmbInsuranceType1;
    private javax.swing.JComboBox cmbSSN;
    private javax.swing.JTextField custNameJTextField;
    private javax.swing.JTextField customerJTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserName2;
    private javax.swing.JLabel lblUserName3;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField priceTxt1;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtSSN1;
    private javax.swing.JTextField validity;
    private javax.swing.JTextField validity1;
    private javax.swing.JPanel viewMedicineJPanel;
    // End of variables declaration//GEN-END:variables
}
