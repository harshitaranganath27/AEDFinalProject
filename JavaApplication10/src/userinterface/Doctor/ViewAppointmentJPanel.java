/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctor;

import Business.Appointment.Appointment;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class ViewAppointmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAppointmentJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private EcoSystem ecosystem;
    private Enterprise enterprise;
    private Patient patient;
    private Appointment appointment;
    private Employee doctor;
    
    public ViewAppointmentJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem ecosystem,Appointment appointment) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.ecosystem = ecosystem;
        this.appointment = appointment;
        this.patient= appointment.getPatient();
        this.doctor= (Employee) appointment.getDoc();
        appointmentIDTxt.setText(String.valueOf(appointment.getAppntmentID()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        DateTxt.setText(formatter.format(appointment.getDate()) + " " + appointment.getTime() + ":00");
        appointmentTypeTxt.setText(appointment.getType());
        //locationTxt.setText(appointment.setLocation());
        patientNameTxt.setText(patient.getEmpName());
        doctorNameTxt.setText(doctor.getEmpName());
        //appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
        appointmentIDTxt.setEditable(false);
        DateTxt.setEditable(false);
        appointmentTypeTxt.setEditable(false);
        //locationTxt.setEditable(false);
        patientNameTxt.setEditable(false);
        doctorNameTxt.setEditable(false);
        appointmentStatusTxt.setEditable(false);
        appointmentStatusTxt.setText(appointment.getStatus());
        apptHistoryTxt.setText(this.appointment.getAppoitmentHistory());
        apptHistoryTxt.setEditable(false);
        //populateAppointmentDetails();
    }
    
//    public void populateAppointmentDetails(){
//       DefaultTableModel model = (DefaultTableModel)appointmentDetailsTbl.getModel();
//        model.setRowCount(0);
//        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        
////            Object row[]=new Object[8];
////            row[0]=request.getPeople().getId();
////            row[1]=request.getPeople().getName();
////            row[2]=request.getPeople().getAge();
////            row[3]=request.getPeople().getGender();
////            row[4]=request.getAssignedDoctor()==null?"pending":request.getAssignedDoctor().getEmployee().getName();
////            row[5]=request.getStatus();
////            row[6]=formatter.format(request.getDate());
////            String result=((LabTest_documentDoctor)request).getMessage();
////            row[7]=result;
////            model.addRow(row);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        appointmentIDTxt = new javax.swing.JTextField();
        appointmentTypeTxt = new javax.swing.JTextField();
        patientNameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        appointmentStatusTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        DateTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        doctorNameTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        apptHistoryTxt = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Appointment Details");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 230, -1));

        backJButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton1.setText("Back");
        backJButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        appointmentIDTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appointmentIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentIDTxtActionPerformed(evt);
            }
        });
        jPanel1.add(appointmentIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 109, 160, -1));

        appointmentTypeTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appointmentTypeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentTypeTxtActionPerformed(evt);
            }
        });
        jPanel1.add(appointmentTypeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 138, 160, -1));

        patientNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        patientNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(patientNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 160, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Appointment ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Appointment Type :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 160, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Patient Name :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Status :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 240, 66, -1));

        appointmentStatusTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appointmentStatusTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentStatusTxtActionPerformed(evt);
            }
        });
        jPanel1.add(appointmentStatusTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 237, 160, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Date :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 83, 55, -1));

        DateTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTxtActionPerformed(evt);
            }
        });
        jPanel1.add(DateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 80, 160, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Doctor Name :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        doctorNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doctorNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(doctorNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 208, 160, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 520, 270));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("Appointment History:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 160, -1));

        apptHistoryTxt.setBackground(new java.awt.Color(204, 204, 204));
        apptHistoryTxt.setColumns(20);
        apptHistoryTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        apptHistoryTxt.setRows(5);
        jScrollPane1.setViewportView(apptHistoryTxt);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 310, 121));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        
         userProcessContainer.remove(this);
        //Component[] componentArray =userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //NurseWorkAreaJPanel sysAdminwajp = (NurseWorkAreaJPanel) component;
        //sysAdminwajp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void appointmentIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentIDTxtActionPerformed

    private void appointmentTypeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentTypeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentTypeTxtActionPerformed

    private void patientNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameTxtActionPerformed

    private void appointmentStatusTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentStatusTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentStatusTxtActionPerformed

    private void DateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateTxtActionPerformed

    private void doctorNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorNameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateTxt;
    private javax.swing.JTextField appointmentIDTxt;
    private javax.swing.JTextField appointmentStatusTxt;
    private javax.swing.JTextField appointmentTypeTxt;
    private javax.swing.JTextArea apptHistoryTxt;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTextField doctorNameTxt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField patientNameTxt;
    // End of variables declaration//GEN-END:variables
}
