/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LoginPatient;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author harshita
 */
public class PatientMainWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReceptionistWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;
    
    public PatientMainWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = business;
        
        jLabel5.setText("Welcome " + userAccount.getEmployee().getEmpName() + "!");
        
    }

   
    
    
     
    
     
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnViewAppointment = new javax.swing.JButton();
        btnBookAppointment = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 145, 157));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome back!");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 420, 37));

        btnViewAppointment.setBackground(new java.awt.Color(255, 155, 54));
        btnViewAppointment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewAppointment.setText("View Appointment");
        btnViewAppointment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnViewAppointment.setMaximumSize(new java.awt.Dimension(167, 40));
        btnViewAppointment.setMinimumSize(new java.awt.Dimension(167, 40));
        btnViewAppointment.setPreferredSize(new java.awt.Dimension(167, 40));
        btnViewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentActionPerformed(evt);
            }
        });
        add(btnViewAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 210, 230, 230));

        btnBookAppointment.setBackground(new java.awt.Color(255, 155, 54));
        btnBookAppointment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBookAppointment.setText("Book Appointment");
        btnBookAppointment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnBookAppointment.setMaximumSize(new java.awt.Dimension(167, 40));
        btnBookAppointment.setMinimumSize(new java.awt.Dimension(167, 40));
        btnBookAppointment.setPreferredSize(new java.awt.Dimension(167, 40));
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });
        add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 230, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
        
            BookSelfAppointmentJPanel appointmentJPanel = new BookSelfAppointmentJPanel(userProcessContainer, userAccount, organization, enterprise, system,(Patient) (userAccount.getEmployee()));
            userProcessContainer.add("BookSelfAppointmentJPanel",appointmentJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void btnViewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppointmentActionPerformed
        // TODO add your handling code here:
       
            userinterface.LoginPatient.ViewSelfAppointmentJPanel viewAppointmentJPanel = new ViewSelfAppointmentJPanel(userProcessContainer, userAccount, organization, enterprise, system,(Patient) userAccount.getEmployee());
            userProcessContainer.add("ViewSelfAppointmentJPanel",viewAppointmentJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnViewAppointmentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnViewAppointment;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    
}
