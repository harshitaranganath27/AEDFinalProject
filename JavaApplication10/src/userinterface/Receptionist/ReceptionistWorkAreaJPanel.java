/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Receptionist;

import Business.Appointment.Appointment;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReceptionistWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Patient.BookAppointmentJPanel;
import userinterface.Patient.CreateNewPatientJPanel;
import userinterface.Patient.ViewPatientJPanel;

/**
 *
 * @author harshita
 */
public class ReceptionistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReceptionistWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;
    
    public ReceptionistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = business;
        
        jLabel5.setText("Welcome " + account.getEmployee().getEmpName());
        
        if(enterprise.getEnterpriseType().getValue().equals("Hospital"))
        {
           populatePatients();
        }
        
        
        if(enterprise.getEnterpriseType().getValue().equals("Lab"))
        {
            populateTest();
        }
        
        
        if(enterprise.getEnterpriseType().getValue().equals("Pharmacy"))
        {
           // populatepharmacyReceptionist();
        }
        
        
        if(enterprise.getEnterpriseType().getValue().equals("Insurance"))
        {
          //  populateTest();
        }
        
        
    }

    public void populatePatients() {
        DefaultTableModel model = (DefaultTableModel) PatientDataJTable.getModel();
        model.setRowCount(0);
        if(enterprise.getPatientDirectory()!= null && enterprise.getPatientDirectory().getPatientList() != null){
            for (Patient patient : enterprise.getPatientDirectory().getPatientList()) {
                    Object[] row = new Object[4];
                    row[0] = patient.getId();
                    row[1] = patient;//.getName();
                    row[2] = patient.getPhoneNumber();
                    row[3] = patient.getBloodGroup();
                    model.addRow(row); 
            }
        }
    }
    
    
    
     public void populateTest() {
        DefaultTableModel model = (DefaultTableModel) PatientDataJTable.getModel();
        model.setRowCount(0);
        if(enterprise.getWorkQueue() != null ){
            List<WorkRequest> wrList = enterprise.getWorkQueue().getWorkRequestList();
            for (WorkRequest wr : wrList) {
                if(wr instanceof ReceptionistWorkRequest)
                {
                    Appointment app = ((ReceptionistWorkRequest) wr).getApp();
                Patient patient = ((ReceptionistWorkRequest)wr).getPatient();
                if(patient == null && app !=null){
                    patient= ((ReceptionistWorkRequest) wr).getApp().getPatient();
                            
                }
                
                
                if(patient!=null)
                {
                
                    Object[] row = new Object[4];
                    row[0] = patient.getId();
                    row[1] = patient;//getName();
                    row[2] = patient.getPhoneNumber();
                    row[3] = patient.getBloodGroup();
                    model.addRow(row); 
                }
                }
            }
        }
    }
    
     
     public void populatepharmacyReceptionist() {
        DefaultTableModel model = (DefaultTableModel) PatientDataJTable.getModel();
        model.setRowCount(0);
        if(enterprise.getWorkQueue() != null ){
            List<WorkRequest> wrList = enterprise.getWorkQueue().getWorkRequestList();
            for (WorkRequest wr : wrList) {
                if(wr instanceof ReceptionistWorkRequest)
                {
                
                Patient patient = ((ReceptionistWorkRequest)wr).getPatient();
                if(patient!=null)
                {
                
                    Object[] row = new Object[4];
                    row[0] = patient.getId();
                    row[1] = patient;
                    row[2] = patient.getPhoneNumber();
                    row[3] = patient.getBloodGroup();
                    model.addRow(row); 
                }
                }
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
        PatientDataJTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnManagePatient = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();
        btnViewAppointment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));

        PatientDataJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        PatientDataJTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PatientDataJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient Name", "Phone Number", "Blood Group"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PatientDataJTable.setBounds(new java.awt.Rectangle(15, 0, 0, 0));
        PatientDataJTable.setGridColor(new java.awt.Color(0, 153, 153));
        PatientDataJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(PatientDataJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 876, 362));

        jPanel1.setBackground(new java.awt.Color(164, 208, 215));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManagePatient.setBackground(new java.awt.Color(0, 153, 153));
        btnManagePatient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnManagePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnManagePatient.setText("Create a Patient");
        btnManagePatient.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnManagePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePatientActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 153, 30));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View a Patient");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 153, 30));

        btnBookAppointment.setBackground(new java.awt.Color(0, 153, 153));
        btnBookAppointment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBookAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setText("Book an Appointment");
        btnBookAppointment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });
        jPanel1.add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 70, 170, 38));

        btnViewAppointment.setBackground(new java.awt.Color(0, 153, 153));
        btnViewAppointment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAppointment.setText("View Appointments");
        btnViewAppointment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnViewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 70, 170, 38));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 550, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/receptionist.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 230));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 145, 157));
        jLabel5.setText("What would you like to do?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 350, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManagePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePatientActionPerformed

        CreateNewPatientJPanel createNewPatientJPanel = new CreateNewPatientJPanel(userProcessContainer, userAccount, organization, enterprise, system);
        userProcessContainer.add("createNewPatientJPanel",createNewPatientJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManagePatientActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = PatientDataJTable.getSelectedRow();
        if(selectedRow >= 0){
            Patient patient = (Patient)PatientDataJTable.getValueAt(selectedRow,1);
//            Order order = (Order)OrderJTable.getValueAt(selectedRow, 0);
            ViewPatientJPanel viewPatientJPanel = new ViewPatientJPanel(userProcessContainer, userAccount, organization, enterprise, system, patient);
            userProcessContainer.add("viewPatientJPanel",viewPatientJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
        int selectedRow = PatientDataJTable.getSelectedRow();
        if(selectedRow >= 0){
            //int patientId = (int) PatientDataJTable.getValueAt(selectedRow, 0);
            Patient temp = (Patient)  PatientDataJTable.getValueAt(selectedRow, 1);
            BookAppointmentJPanel appointmentJPanel = new BookAppointmentJPanel(userProcessContainer, userAccount, organization, enterprise, system, temp);
            userProcessContainer.add("appointmentJPanel",appointmentJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnViewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppointmentActionPerformed
        // TODO add your handling code here:
       int selectedRow = PatientDataJTable.getSelectedRow();
        if(selectedRow >= 0){
             
            Patient temp = (Patient) PatientDataJTable.getValueAt(selectedRow, 1);
           
            userinterface.Patient.ViewAppointmentJPanel viewAppointmentJPanel = new userinterface.Patient.ViewAppointmentJPanel(userProcessContainer, userAccount, organization, enterprise, system, temp);
            userProcessContainer.add("viewAppointmentJPanel",viewAppointmentJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_btnViewAppointmentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientDataJTable;
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnManagePatient;
    private javax.swing.JButton btnViewAppointment;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
