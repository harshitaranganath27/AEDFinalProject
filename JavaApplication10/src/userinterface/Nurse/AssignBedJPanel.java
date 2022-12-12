/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Nurse;

import Business.Appointment.Appointment;
import Business.Bed.Bed;
import Business.Enterprise.Enterprise;
import Business.Operation.Operation;
import Business.Org.BedManagementDepartment;
import Business.Org.Organization;
import Business.Org.organizationDir;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harshita
 */
public class AssignBedJPanel extends javax.swing.JPanel {

    
    JPanel userProcessContainer;
    Enterprise enterprise;
    Appointment appointment;
    Patient patient;
    UserAccount doctor;
    UserAccount nurseUserAccount;
    WorkRequest workrequest;
    BedManagementDepartment bedorg;
    /**
     * Creates new form AssignBed
     */
    public AssignBedJPanel(JPanel userProcessContainer, Enterprise enterprise, Appointment appointment, Patient patient, UserAccount doctor, UserAccount nurseUserAccount, WorkRequest workrequest) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.enterprise= enterprise;
        this.doctor= doctor;
        this.patient= patient;
        this.appointment= appointment;
        this.nurseUserAccount= nurseUserAccount;
        this.workrequest= workrequest;
        this.bedorg= getBedDepartment();
        populateStatusCMB();
        populateDetails();
        assignJPanel.setVisible(false);
        
        viewAppnmtID.setEditable(false);
        viewDrTxt.setEditable(false);
        viewPatientNametxt.setEditable(false);
        viewRequestDateTxt.setEditable(false);
        viewpatientIdTxt.setEditable(false);
        phoneNumberTxt.setEditable(false);
        emailIDTxt.setEditable(false);
        txtAreaMessage.setEditable(false);
        
        txtBedIPrice.setEditable(false);
        txtBedId.setEditable(false);
        txtBedType.setEditable(false);
        txtBedAssignDate.setEditable(false);
              
    }

    
    BedManagementDepartment getBedDepartment(){
        //enterprise.getOrganizationDirectory().getOrganizationList();
        
        boolean flag=false;
        BedManagementDepartment bedOrg=null;
        organizationDir orgDir = enterprise.getOrgDirectory();
        for(Organization org : orgDir.getOrgList() ){
            if(org.getName().equals(Organization.Type.BedManagement.getValue()))
            {
                //if bed management departemtn is present then navigate to bed management screen
                flag = true;
                bedOrg = (BedManagementDepartment)org;
            }
        }
        
        if(flag == true)
        {
            return bedOrg;
        }
        return null;
    }
    
    
    void populateStatusCMB(){
          viewStatusCmb.removeAllItems();
        
        for (Appointment.AppointmentStatus status : Appointment.AppointmentStatus.values()){
            viewStatusCmb.addItem(status.getValue());
        }
        
        viewStatusCmb.setEnabled(false);

    }
    
void populateDetails(){
    viewPatientNametxt.setText(patient.getEmpName());
    viewAppnmtID.setText(String.valueOf(appointment.getAppntmentID()));
    viewDrTxt.setText(doctor.getEmployee().getEmpName());
    viewpatientIdTxt.setText(String.valueOf(patient.getId()));
    emailIDTxt.setText(patient.getEmailID());
    phoneNumberTxt.setText(patient.getPhoneNumber());
    viewStatusCmb.setSelectedItem(appointment.getStatus());
    
    Date sDate=( workrequest.getRequestDate().equals("") == true) ? new Date() : workrequest.getRequestDate();
    Date date1 = null;
    //String  = txtAppointmetDate.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(sDate);

    viewRequestDateTxt.setText(strDate);
           
   // viewRequestDateTxt.setText(workrequest.getRequestDate().toString() == null ? "" : workrequest.getRequestDate().toString());
    txtAreaMessage.setText(workrequest.getMessage());
    Operation oprtn = appointment.getOperation();
    if(oprtn != null && oprtn.getBedAssigned() !=null)
    {
        Bed bed = oprtn.getBedAssigned();
        txtBedId.setText(String.valueOf(bed.getBedID()));
        txtBedIPrice.setText(String.valueOf(bed.getPrice()));
        txtBedType.setText(bed.getBedType().toString());
        txtBedAssignDate.setText(oprtn.getOperationDate());
        btnviewBed.setEnabled(false);
    }
    else{
        btnviewBed.setEnabled(true);
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

        viewDetailsJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailIDTxt = new javax.swing.JTextField();
        viewPatientNametxt = new javax.swing.JTextField();
        viewpatientIdTxt = new javax.swing.JTextField();
        phoneNumberTxt = new javax.swing.JTextField();
        txtBedId = new javax.swing.JTextField();
        viewAppnmtID = new javax.swing.JTextField();
        viewStatusCmb = new javax.swing.JComboBox();
        viewRequestDateTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        viewDrTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMessage = new javax.swing.JTextArea();
        txtBedType = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBedIPrice = new javax.swing.JTextField();
        btnviewBed = new javax.swing.JButton();
        txtBedAssignDate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        assignJPanel = new javax.swing.JPanel();
        lblBedStatus = new javax.swing.JLabel();
        bedStatusCmb = new javax.swing.JComboBox();
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bedJTable = new javax.swing.JTable();
        txtBedDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        closebtn = new javax.swing.JButton();
        btnAssignBed = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bedTypeCmb = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewDetailsJPanel.setBackground(new java.awt.Color(164, 208, 215));
        viewDetailsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "View Appointment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        viewDetailsJPanel.setToolTipText("");
        viewDetailsJPanel.setAutoscrolls(true);
        viewDetailsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Status");
        viewDetailsJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Patient ID");
        viewDetailsJPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Patient Name");
        viewDetailsJPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Appointment ID");
        viewDetailsJPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Patient Email ID");
        viewDetailsJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Contact Number");
        viewDetailsJPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Bed ID");
        viewDetailsJPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Bed Type");
        viewDetailsJPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Request Date");
        viewDetailsJPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        emailIDTxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        emailIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIDTxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(emailIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 112, -1));

        viewPatientNametxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        viewPatientNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientNametxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(viewPatientNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 112, -1));

        viewpatientIdTxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        viewpatientIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpatientIdTxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(viewpatientIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 110, -1));

        phoneNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        phoneNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(phoneNumberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 112, -1));

        txtBedId.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtBedId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedIdActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(txtBedId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 122, -1));

        viewAppnmtID.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        viewAppnmtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppnmtIDActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(viewAppnmtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 141, -1));

        viewStatusCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        viewStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        viewDetailsJPanel.add(viewStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 141, -1));

        viewRequestDateTxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        viewRequestDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestDateTxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(viewRequestDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 145, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Doctor");
        viewDetailsJPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        viewDrTxt.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        viewDrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDrTxtActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(viewDrTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 145, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Message");
        viewDetailsJPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtAreaMessage.setColumns(20);
        txtAreaMessage.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtAreaMessage.setRows(5);
        jScrollPane1.setViewportView(txtAreaMessage);

        viewDetailsJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 381, -1));

        txtBedType.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtBedType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedTypeActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(txtBedType, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 122, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Price");
        viewDetailsJPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        txtBedIPrice.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtBedIPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedIPriceActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(txtBedIPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 122, -1));

        btnviewBed.setBackground(new java.awt.Color(255, 155, 54));
        btnviewBed.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnviewBed.setText("Assign Bed");
        btnviewBed.setPreferredSize(new java.awt.Dimension(100, 40));
        btnviewBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewBedActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(btnviewBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 160, -1));

        txtBedAssignDate.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtBedAssignDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedAssignDateActionPerformed(evt);
            }
        });
        viewDetailsJPanel.add(txtBedAssignDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 122, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Assigned Date");
        viewDetailsJPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BedMangmt.JPG"))); // NOI18N
        viewDetailsJPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 220, -1));

        add(viewDetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 580, 610));

        assignJPanel.setBackground(new java.awt.Color(164, 208, 215));
        assignJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assign Bed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        assignJPanel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        assignJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBedStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBedStatus.setText("Bed Status");
        assignJPanel.add(lblBedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        bedStatusCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 146, -1));

        btnView.setBackground(new java.awt.Color(255, 155, 54));
        btnView.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnView.setText("View");
        btnView.setPreferredSize(new java.awt.Dimension(100, 40));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        assignJPanel.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        bedJTable.setBackground(new java.awt.Color(255, 193, 131));
        bedJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        bedJTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bed ID", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bedJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(bedJTable);

        assignJPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 350, 210));

        txtBedDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedDateActionPerformed(evt);
            }
        });
        assignJPanel.add(txtBedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 145, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Date");
        assignJPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        closebtn.setBackground(new java.awt.Color(255, 155, 54));
        closebtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        closebtn.setText("Close");
        closebtn.setPreferredSize(new java.awt.Dimension(100, 40));
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        assignJPanel.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 103, -1));

        btnAssignBed.setBackground(new java.awt.Color(255, 155, 54));
        btnAssignBed.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAssignBed.setText("Assign");
        btnAssignBed.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAssignBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignBedActionPerformed(evt);
            }
        });
        assignJPanel.add(btnAssignBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Bed Type");
        assignJPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 20));

        bedTypeCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedTypeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        bedTypeCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedTypeCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedTypeCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 146, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_20px_1.png"))); // NOI18N
        jLabel17.setText("Search");
        assignJPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        add(assignJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 440, 600));

        btnBack.setBackground(new java.awt.Color(102, 147, 255));
        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jPanel14.setBackground(new java.awt.Color(196, 224, 229));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 180));

        jPanel13.setBackground(new java.awt.Color(68, 145, 157));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(68, 145, 157));
        jLabel18.setText("View Request - Bed Assignment");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 360, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        assignJPanel.setVisible(false);
        if(appointment.getOperation().getBedAssigned() != null){
            btnviewBed.setEnabled(false);
        }
    }//GEN-LAST:event_closebtnActionPerformed

    private void emailIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIDTxtActionPerformed

    private void viewPatientNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPatientNametxtActionPerformed

    private void viewpatientIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpatientIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewpatientIdTxtActionPerformed

    private void phoneNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtActionPerformed

    private void txtBedIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedIdActionPerformed

    private void viewAppnmtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppnmtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAppnmtIDActionPerformed

    private void viewRequestDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestDateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewRequestDateTxtActionPerformed

    private void viewDrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDrTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDrTxtActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        Component[] componentArray =userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NurseWorkAreaJPanel sysAdminwajp = (NurseWorkAreaJPanel) component;
        sysAdminwajp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void bedStatusCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmbActionPerformed
       // Organization organization = (Organization) bedStatusCmb.getSelectedItem();
        //if (organization != null){
            //populateEmployeeComboBox(organization);
            // populateRoleComboBox(organization);
        //}
    }//GEN-LAST:event_bedStatusCmbActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
        
        
        String dateString = txtBedDate.getText();
        
        if(dateString == null || dateString.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter date!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean validDate = Validation.validateDate(dateString);
        if(validDate == false)
        {
            JOptionPane.showMessageDialog(null, "Date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String type =(String) bedTypeCmb.getSelectedItem();
        
        
        populateBedTable(dateString,type );

    }//GEN-LAST:event_btnViewActionPerformed

    
    void populateBedTable(String dateString, String bedType) {
        
        //convert string to date
        try{
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=formatter1.parse(dateString);
        
        List<Bed> bedList = bedorg.getList().getBedList();
        DefaultTableModel model = (DefaultTableModel) bedJTable.getModel();
        
        model.setRowCount(0);
        for(Bed bed: bedList)
        {
//            boolean checkBedAvalibility = bedorg.checkIfBedAvailbleOnDate(date1, bed);
        
        
        if(bed.getBedType().getBedType().equals(bedType) && 
                (bed.getStatus().getStatus().equals(Bed.BedStatus.Available.getStatus()))){
        
        //String bedStatus = (String)bedStatusCmb.getSelectedItem();
        
            Object[] row = new Object[2];
            row[0] = bed;//.getBedID();
           // row[1] = bed.getStatus().getStatus();
//            Patient p = bed.getPatient();
//            row[1] = p == null ? "": p;
//            row[2] = "";
            row[1] = bed.getBedType();
            model.addRow(row);
            //row[2] = 
            
        }//if checkBedAvalibility true ends
        }//outer for loop
        
        }//try
        
        catch(Exception e){
            System.out.println("Exception occured in AssignBed :populateBedTableMethod");
        }
    }
    
    
    private void txtBedTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedTypeActionPerformed

    private void txtBedIPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedIPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedIPriceActionPerformed

    private void txtBedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedDateActionPerformed

    private void btnviewBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewBedActionPerformed
        // TODO add your handling code here:
        assignJPanel.setVisible(true);
        populateBedTypeCmb();
        lblBedStatus.setVisible(false);
        bedStatusCmb.setVisible(false);
    }//GEN-LAST:event_btnviewBedActionPerformed

    private void btnAssignBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignBedActionPerformed
        // TODO add your handling code here:
        
        
         int row = bedJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dateString = txtBedDate.getText();
        
        if(dateString == null || dateString.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter date!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean validDate = Validation.validateDate(dateString);
        if(validDate == false)
        {
            JOptionPane.showMessageDialog(null, "Date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        Bed selectedBed= (Bed)  bedJTable.getValueAt(row,0);
        /*if(! selectedBed.getStatus().equals(Bed.BedStatus.Available))
        {
            JOptionPane.showMessageDialog(null, "Cannot assign as bed is not available!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }*/
        //if bed is not availbale cannot assign
        
        
        //String to date convert
        
       
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1;
        try {
            date1 = formatter1.parse(dateString);
            selectedBed.setPatient(patient);
            selectedBed.setAppointment(appointment);
            selectedBed.setStatus(Bed.BedStatus.Occupied);
//            bedorg.assignBedToPatientOnDate(patient,date1, selectedBed);
            //selectedBed.setStatus(Bed.BedStatus.Occupied);
            JOptionPane.showMessageDialog(null, "Bed Assigned Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            Operation opr= appointment.getOperation();
            opr.setBedAssigned(selectedBed);
            opr.setOperationDate(dateString);
            opr.setPerson(nurseUserAccount.getEmployee());
            opr.setPerson(nurseUserAccount.getEmployee());
            opr.setStatus(Operation.OperationStatus.BedAssigned.getValue());
            appointment.setStatus(Appointment.AppointmentStatus.BedAssigned.getValue());
            //appointment.setStatus(Appointment.AppointmentStatus.);
            workrequest.setStatus("Handled- bed assigned sucessfully");
            workrequest.setMessage("Bed is assigned for Date: "+ dateString + ". Surgery date is confirmed!");
        } catch (ParseException ex) {
            Logger.getLogger(AssignBedJPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occured in string to date conversion !!!!!! : method-> btnAssignBedActionPerformed");
        }
        
        
        //if all good then assign bed to this patient appointment
        //change appoitnment status
        txtBedId.setText(selectedBed.toString());
        txtBedType.setText(selectedBed.getBedType().getBedType());
        txtBedIPrice.setText(String.valueOf(selectedBed.getPrice()));
        txtBedAssignDate.setText(txtBedDate.getText() == null ? " " : txtBedDate.getText());
        assignJPanel.setVisible(false);
        btnAssignBed.setEnabled(false);
    }//GEN-LAST:event_btnAssignBedActionPerformed

    void populateBedStatusCmb(){
          bedStatusCmb.removeAllItems();
        
        for (Bed.BedStatus status : Bed.BedStatus.values()){
            bedStatusCmb.addItem(status.getStatus());
        }
    }
    
    
    void populateBedTypeCmb(){
          bedTypeCmb.removeAllItems();
        
        for (Bed.BedType status : Bed.BedType.values()){
            bedTypeCmb.addItem(status.getBedType());
        }
    }
    
    
    private void bedTypeCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedTypeCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bedTypeCmbActionPerformed

    private void txtBedAssignDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedAssignDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedAssignDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assignJPanel;
    private javax.swing.JTable bedJTable;
    private javax.swing.JComboBox bedStatusCmb;
    private javax.swing.JComboBox bedTypeCmb;
    private javax.swing.JButton btnAssignBed;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnviewBed;
    private javax.swing.JButton closebtn;
    private javax.swing.JTextField emailIDTxt;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBedStatus;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JTextArea txtAreaMessage;
    private javax.swing.JTextField txtBedAssignDate;
    private javax.swing.JTextField txtBedDate;
    private javax.swing.JTextField txtBedIPrice;
    private javax.swing.JTextField txtBedId;
    private javax.swing.JTextField txtBedType;
    private javax.swing.JTextField viewAppnmtID;
    private javax.swing.JPanel viewDetailsJPanel;
    private javax.swing.JTextField viewDrTxt;
    private javax.swing.JTextField viewPatientNametxt;
    private javax.swing.JTextField viewRequestDateTxt;
    private javax.swing.JComboBox viewStatusCmb;
    private javax.swing.JTextField viewpatientIdTxt;
    // End of variables declaration//GEN-END:variables
}
