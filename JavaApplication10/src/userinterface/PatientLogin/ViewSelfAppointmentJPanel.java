/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientLogin;

import Business.Appointment.Appointment;
import Business.Appointment.Appointment.AppointmentStatus;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author avina
 */
public class ViewSelfAppointmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookAppointmentJPanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;
    Patient patient;
    Appointment appointment;
    public ViewSelfAppointmentJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem system, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.system = system;
        this.patient = patient;
        //populate doctor
        setAppointmentStatus();
        disableFields();
        populatePatientVisits();
       // btnGenerateBill.setVisible(false);
        
    }
    
    public void setAppointmentStatus(){
        cmbAppointmentStatus.removeAllItems();
        cmbAppointmentStatus.addItem("--Select--");
        
        for(AppointmentStatus status : AppointmentStatus.values()){
            if(status.getValue().equals(AppointmentStatus.New.getValue()) ||
                    status.getValue().equals(AppointmentStatus.Cancel.getValue()) ||
                    status.getValue().equals(AppointmentStatus.Markforbilling.getValue()) ||
                    status.getValue().equals(AppointmentStatus.MarkForInsurance.getValue()) ||
                    status.getValue().equals(AppointmentStatus.Close.getValue()) ||
                    status.getValue().equals(AppointmentStatus.ApprovedInsurance.getValue()) ||
                    status.getValue().equals(AppointmentStatus.DisapprovedInsurance.getValue())||
                    status.getValue().equals(AppointmentStatus.MarkforTest.getValue())){
                cmbAppointmentStatus.addItem(status.getValue());
            }
        }
    }
    
    private void disableFields(){
        txtPatientName.setEditable(false);
        txtDoctor.setEditable(false);
        txtAppointmetDate.setEditable(false);
        txtAppointmentType.setEnabled(false);
        txtAppointmentStatus.setEditable(false);
        txtPatientId.setEditable(false);
        txtInsuranceE.setEditable(false);
        txtInsuranceId.setEditable(false);
        txtInsuranceStatus.setEditable(false);
    }

    private void populatePatientVisits(String status) {
        DefaultTableModel model = (DefaultTableModel) viewAppointmentJTable.getModel();
        model.setRowCount(0);
        List<Appointment> appointments = null;
            appointments = patient.getAppointmentDirectory().getAppointmentList();
      
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        for(Appointment appointment : appointments){
            if(appointment.getStatus().equals(status)){
                Object[] row = new Object[7];
                row[0] = patient.getId();
                row[1] = patient.getName();
                row[2] = appointment.getAppointmentId();
                if(appointment.getDoctor().getSpecialization() != null){
                    row[3] = appointment.getDoctor().getName() + "-" + appointment.getDoctor().getSpecialization().getValue();
                }else{
                    row[3] = appointment.getDoctor().getName();
                }
                row[4] = appointment;//formatter1.format(appointment.getDate());
                row[5] = appointment.getType();
                row[6] = appointment.getStatus();
                model.addRow(row); 
            }
            
        }
    }
    
    private void populatePatientVisits() {
        DefaultTableModel model = (DefaultTableModel) viewAppointmentJTable.getModel();
        model.setRowCount(0);
        List<Appointment> appointments = null;
            appointments = patient.getAppointmentDirectory().getAppointmentList();
      
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        for(Appointment appointment : appointments){
                Object[] row = new Object[7];
                row[0] = patient.getId();
                row[1] = patient.getName();
                row[2] = appointment.getAppointmentId();
                if(appointment.getDoctor().getSpecialization() != null){
                    row[3] = appointment.getDoctor().getName() + "-" + appointment.getDoctor().getSpecialization().getValue();
                }else{
                    row[3] = appointment.getDoctor().getName();
                }
                row[4] = appointment;//formatter1.format(appointment.getDate());
                row[5] = appointment.getType();
                row[6] = appointment.getStatus();
                model.addRow(row); 
            
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAppointmetDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAppointmentType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewAppointmentJTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtDoctor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbAppointmentStatus = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAppointmentStatus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPatientId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtInsuranceStatus = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtInsuranceId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtInsuranceE = new javax.swing.JTextField();
        btnViewBill = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 13, 188, -1));

        jButton1.setBackground(new java.awt.Color(102, 147, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setLabel("Back");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Patient Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 134, -1));

        txtPatientName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 162, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Doctor:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 134, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Appointment Date:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 160, -1));

        txtAppointmetDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAppointmetDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmetDateActionPerformed(evt);
            }
        });
        add(txtAppointmetDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 162, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Appointment Type:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 160, -1));

        txtAppointmentType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAppointmentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "In-Person", "Online" }));
        add(txtAppointmentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 162, -1));

        viewAppointmentJTable.setBackground(new java.awt.Color(255, 193, 131));
        viewAppointmentJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        viewAppointmentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient Name", "Appointment Id", "Doctor", "Appointment Date", "Appointment Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewAppointmentJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(viewAppointmentJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 671, 162));

        jButton2.setBackground(new java.awt.Color(255, 155, 54));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("View Appointment");
        jButton2.setPreferredSize(new java.awt.Dimension(167, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 165, -1));

        jButton3.setBackground(new java.awt.Color(255, 155, 54));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Cancel Appointment");
        jButton3.setPreferredSize(new java.awt.Dimension(167, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 179, -1));

        txtDoctor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 162, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Appointment Status : ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        cmbAppointmentStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmbAppointmentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbAppointmentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 187, -1));

        btnSubmit.setBackground(new java.awt.Color(102, 147, 255));
        btnSubmit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSubmit.setText("Search");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 116, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/viewAppont.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 348, 244, 165));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Appointment Status:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        txtAppointmentStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAppointmentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmentStatusActionPerformed(evt);
            }
        });
        add(txtAppointmentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 162, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("PatientId:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 134, -1));

        txtPatientId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtPatientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 162, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Insurance Status:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 143, -1));

        txtInsuranceStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtInsuranceStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 161, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Insurance ID:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 166, -1));

        txtInsuranceId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtInsuranceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 160, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Insurance Company:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, 166, -1));

        txtInsuranceE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtInsuranceE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, 160, -1));

        btnViewBill.setBackground(new java.awt.Color(255, 155, 54));
        btnViewBill.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewBill.setText("View Bill");
        btnViewBill.setPreferredSize(new java.awt.Dimension(167, 40));
        btnViewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBillActionPerformed(evt);
            }
        });
        add(btnViewBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 162, -1));

        jPanel14.setBackground(new java.awt.Color(196, 224, 229));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 200));

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

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(68, 145, 157));
        jLabel13.setText("View Appointment");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 270, 37));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/receptionist.jpg"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 290, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAppointmetDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmetDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmetDateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        //Component[] componentArray =userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //ReceptionistWorkAreaJPanel sysAdminwajp = (ReceptionistWorkAreaJPanel) component;
        //sysAdminwajp.populatePatients();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // btnGenerateBill.setVisible(true);
        int selectedRow = viewAppointmentJTable.getSelectedRow();
        if(selectedRow >= 0){
            
           appointment =(Appointment) viewAppointmentJTable.getValueAt(selectedRow, 4);
            
            this.appointment = appointment;
            txtPatientId.setText(String.valueOf(appointment.getPatient().getId()));
            txtPatientName.setText(appointment.getPatient().getName());
            if(appointment.getDoctor().getSpecialization() != null){
                txtDoctor.setText(appointment.getDoctor().getName() + " - " + appointment.getDoctor().getSpecialization().getValue());
            }else{
                txtDoctor.setText(appointment.getDoctor().getName());
            }
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
            txtAppointmetDate.setText(formatter1.format(appointment.getDate()));
            txtAppointmentType.setSelectedItem(appointment.getType());
            txtAppointmentStatus.setText(appointment.getStatus());
            txtInsuranceE.setText(patient.getInsuranceE().getName());
            txtInsuranceId.setText(patient.getInsuranceId());
            
            String insuranceStatus="Pending";
            if(appointment.getHospitalbill() == null)
            {
                insuranceStatus = "Not claimed";
                
            }
            else if(appointment.getStatus().equals(Appointment.AppointmentStatus.ApprovedInsurance.getValue()))
            {
                insuranceStatus = "Approved";
            }
            else if(appointment.getStatus().equals(Appointment.AppointmentStatus.MarkForInsurance.getValue()))
            {
                insuranceStatus = "Pending";
            }
            
            txtInsuranceStatus.setText(insuranceStatus);
            
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if(cmbAppointmentStatus.getSelectedIndex() != 0){
//            AppointmentStatus status = (AppointmentStatus)txtAppointmentStatus.getSelectedItem();
            populatePatientVisits(cmbAppointmentStatus.getSelectedItem().toString());
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtAppointmentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmentStatusActionPerformed

    private void btnViewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBillActionPerformed
        // TODO add your handling code here:
        
        
        if(appointment == null )
        {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(appointment != null && appointment.getHospitalbill() == null)
        {
            JOptionPane.showMessageDialog(null, "Bill not yet generated.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        
        if(appointment != null){
            //Patient patient = enterprise.getPatientDirectory().findPatientById(Integer.parseInt(txtPatientId.getText()));
            
            ViewSelfPatientBillJPanel generatePatientBillJPanel = new ViewSelfPatientBillJPanel(userProcessContainer, organization, enterprise, system, patient, appointment, userAccount);
            userProcessContainer.add("ViewSelfPatientBillJPanel",generatePatientBillJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            
        }
    }//GEN-LAST:event_btnViewBillActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = viewAppointmentJTable.getSelectedRow();
        if(selectedRow >= 0){
            Appointment appointment = (Appointment) viewAppointmentJTable.getValueAt(selectedRow, 4);
            if(appointment.getStatus().equals(AppointmentStatus.New.getValue())){
                appointment.setStatus(AppointmentStatus.Cancel.getValue());
                
                ArrayList<Integer> arrlistime=appointment.getDoctor().getSchedule().get(appointment.getDate());
                arrlistime.remove(appointment.getTime());
                
                
                JOptionPane.showMessageDialog(null, "Appointment Cancelled", "Info", JOptionPane.WARNING_MESSAGE);
                populatePatientVisits(AppointmentStatus.Cancel.getValue());
                DB4OUtil.getInstance().storeSystem(system);
            }else{
                JOptionPane.showMessageDialog(null, "Appointment can not be cancelled", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            return;
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewBill;
    private javax.swing.JComboBox<String> cmbAppointmentStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField txtAppointmentStatus;
    private javax.swing.JComboBox txtAppointmentType;
    private javax.swing.JTextField txtAppointmetDate;
    private javax.swing.JTextField txtDoctor;
    private javax.swing.JTextField txtInsuranceE;
    private javax.swing.JTextField txtInsuranceId;
    private javax.swing.JTextField txtInsuranceStatus;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTable viewAppointmentJTable;
    // End of variables declaration//GEN-END:variables

    
}
