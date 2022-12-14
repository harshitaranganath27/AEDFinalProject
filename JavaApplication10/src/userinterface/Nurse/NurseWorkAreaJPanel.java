/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Nurse;

import Business.Appointment.Appointment;
import Business.Enterprise.Enterprise;
import Business.Operation.Operation;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NurseWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harshita
 */
public class NurseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    //private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form NurseWorkAreaJPanel
     */
    public NurseWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount ua) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount = ua;  
        //viewDetailsJPanel.setVisible(false);
        //searchJPanel.setVisible(false);
        enterpriseLabel.setText(enterprise.getName());
        jLabel5.setText("Welcome " + ua.getEmployee().getEmpName());
       // requestTestJButton.setVisible(false);
    }

    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            
            if(request instanceof NurseWorkRequest){
            Object[] row = new Object[11];
            row[0] = request.getSender();
            row[1] = request.getReceiver();
            row[2] = ((NurseWorkRequest)request).getPatient();
            row[3] = request.getStatus();
            Appointment app = ((NurseWorkRequest)request).getAppointment();
            row[4] = app;//request.getMessage() == null ? " " : request.getMessage() ;
            row[5] = request;
            row[6] = request.getMessage();
            row[7] = app.getStatus();
            Operation opr= app.getOperation() == null ? null : app.getOperation() ;
            row[8] = opr.getStatus() == null ? "" : opr.getStatus();
            row[9] = opr.getOprType();
            row[10] = opr.getOperationDate() == null ? "" : opr.getOperationDate();
            model.addRow(row);
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
        workRequestJTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        viewReqBtn = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        viewDetailsBtn = new javax.swing.JButton();
        btnManageBedAssngmt = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setBackground(new java.awt.Color(51, 153, 255));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        workRequestJTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Patient", "Status", "Appointment Date", "Request ID", "Message", "Appointment Status", "Operation Status", "Operation Type", "Operation Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 1088, 450));

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewReqBtn.setBackground(new java.awt.Color(255, 155, 54));
        viewReqBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewReqBtn.setText("View New Request");
        viewReqBtn.setPreferredSize(new java.awt.Dimension(167, 40));
        viewReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReqBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(viewReqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, -1, 89));

        refreshTestJButton.setBackground(new java.awt.Color(255, 155, 54));
        refreshTestJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.setPreferredSize(new java.awt.Dimension(167, 40));
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 150, 90));

        viewDetailsBtn.setBackground(new java.awt.Color(255, 155, 54));
        viewDetailsBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewDetailsBtn.setText("View Details");
        viewDetailsBtn.setPreferredSize(new java.awt.Dimension(167, 40));
        viewDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(viewDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 150, 90));

        btnManageBedAssngmt.setBackground(new java.awt.Color(255, 155, 54));
        btnManageBedAssngmt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnManageBedAssngmt.setText("Manage Bed Assignment");
        btnManageBedAssngmt.setPreferredSize(new java.awt.Dimension(167, 40));
        btnManageBedAssngmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBedAssngmtActionPerformed(evt);
            }
        });
        buttonPanel.add(btnManageBedAssngmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 180, 90));

        btnAssignToMe.setBackground(new java.awt.Color(255, 155, 54));
        btnAssignToMe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.setPreferredSize(new java.awt.Dimension(167, 40));
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        buttonPanel.add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 130, 80));

        add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 99, 1090, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 145, 157));
        jLabel5.setText("Welcome!");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, 37));

        enterpriseLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(68, 145, 157));
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 300, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void viewReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReqBtnActionPerformed
        // TODO add your handling code here:
        //show all new request
        if(enterprise.getWorkQueue().getWorkRequestList().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No request!");
            return;

        }
        
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if((request.getStatus().equals("New")) && (request instanceof NurseWorkRequest) )
                              
            {
                
            //sender, receiver, pateint,status, message
            Object[] row = new Object[11];
            row[0] = request.getSender();
            row[1] = request.getReceiver();
            row[2] = ((NurseWorkRequest)request).getPatient();
            row[3] = request.getStatus();
            
            //String result = ((LabTestWorkRequest) request).getTestResult();
            //row[3] = result == null ? "Waiting" : result;
            Appointment app = ((NurseWorkRequest)request).getAppointment();
            row[4] = app;//request.getMessage() == null ? " " : request.getMessage() ;
            row[5] = request;
            row[6] = request.getMessage();
            row[7] = app.getStatus();
            Operation opr= app.getOperation() == null ? null : app.getOperation() ;
            row[8] = opr.getStatus() == null ? "" : opr.getStatus();
            row[9] = opr.getOprType();
            row[10] = opr.getOperationDate() == null ? "" : opr.getOperationDate();
            model.addRow(row);
            
        }
        }
        
    }//GEN-LAST:event_viewReqBtnActionPerformed

    private void viewDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsBtnActionPerformed
        // TODO add your handling code here:
        //viewDetailsJPanel.setVisible(true);
        
        
        int row = workRequestJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
       
        
        UserAccount doctor =(UserAccount) workRequestJTable.getValueAt(row, 0);
        
        Patient patient = (Patient) workRequestJTable.getValueAt(row, 2);
        
        Appointment appointment =(Appointment) workRequestJTable.getValueAt(row, 4);
        //FlightSchedule fsch= (FlightSchedule)  tblFlightSchedule.getValueAt(row,7);
        UserAccount nurseUserAccount = userAccount;
        WorkRequest workreq= (WorkRequest) workRequestJTable.getValueAt(row, 5);
        
        if(workreq.getReceiver()==null)
        {
             JOptionPane.showMessageDialog(null, "Please assign request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AssignBedJPanel manageOrganizationJPanel = new AssignBedJPanel(userProcessContainer, enterprise, appointment, patient, doctor, nurseUserAccount, workreq);
        userProcessContainer.add("AssignBedJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewDetailsBtnActionPerformed

    private void btnManageBedAssngmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBedAssngmtActionPerformed
        // TODO add your handling code here:
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout(); //JPanel,Enterprise,UserAccount
        userProcessContainer.add("ManageBedsFinalJPanel", new ManageBedsFinalJPanel(userProcessContainer, enterprise,userAccount));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnManageBedAssngmtActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 5);
        
        
        
         if( request.getReceiver()!=null &&request.getReceiver().equals(userAccount) )
        {
              JOptionPane.showMessageDialog(null, "Already handled, cannot assign!");
            return;
            
        }
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateRequestTable();
        
        JOptionPane.showMessageDialog(null, "Assignment successful!");
        
    }//GEN-LAST:event_btnAssignToMeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnManageBedAssngmt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton viewDetailsBtn;
    private javax.swing.JButton viewReqBtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
