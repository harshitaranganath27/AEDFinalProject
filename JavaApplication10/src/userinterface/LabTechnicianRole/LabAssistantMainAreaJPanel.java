/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabTechnicianRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Lab.LabTest;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTechnicianWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author harshita
 */
public class LabAssistantMainAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    //private LabOrganization organization;
    
    private Enterprise enterprise;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public LabAssistantMainAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        //this.labOrganization = (LabOrganization)organization;
        this.enterprise = enterprise;
        //this.business = business;
        this.organization = organization;
        jLabel5.setText("Welcome " + account.getEmployee().getName());
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        //enterprise.getWorkQueue().getWorkRequestList();//.add(request);
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
           // List<LabTest> labTestList = ((LabTechnicianWorkRequest)request).getAppointment().getLabTestList().getLabTestList();
            if(request instanceof  LabTechnicianWorkRequest &&(request.getReceiver()==null ||  request.getReceiver() ==  userAccount )){
           //for(LabTest labTest : labTestList)
           // {
            
            Object[] row = new Object[8];
            row[0] = request.getSender();
            //row[1] = request.getSender().getEmployee().getName();
            row[1] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[2] = ((LabTechnicianWorkRequest)request).getPatient();
            
            row[3] = request.getStatus();
            LabTest lt= ((LabTechnicianWorkRequest)request).getLabTest();
            row[4] = lt== null ? " Test " : lt;//.getName();
            row[5] =( lt ==null || lt.getStatus()==null)  ? "New" : lt.getStatus();
            row[6] = request.getMessage();
            row[7] = request;
            model.addRow(row);
       // }//inner for
        }//if
        }//outer for
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
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setBackground(new java.awt.Color(255, 193, 131));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        workRequestJTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Patient", "Request Status", "Lab Test", "Test Status", "Message", "Request ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 860, 170));

        assignJButton.setBackground(new java.awt.Color(255, 155, 54));
        assignJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.setPreferredSize(new java.awt.Dimension(167, 40));
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        processJButton.setBackground(new java.awt.Color(255, 155, 54));
        processJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        processJButton.setText("Process");
        processJButton.setPreferredSize(new java.awt.Dimension(167, 40));
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 120, -1));

        refreshJButton.setBackground(new java.awt.Color(255, 155, 54));
        refreshJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.setPreferredSize(new java.awt.Dimension(167, 40));
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diagnosis.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 860, 370));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(68, 145, 157));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lab Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 270, 40));

        jPanel14.setBackground(new java.awt.Color(196, 224, 229));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 170));

        jPanel13.setBackground(new java.awt.Color(68, 145, 157));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 145, 157));
        jLabel5.setText("Welcome back!");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 480, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 7);
        
        if(request.getReceiver() != null)
        {
            JOptionPane.showMessageDialog(null, "Already assigned to technician!");
            return;
        }
        LabTest lt = (LabTest) workRequestJTable.getValueAt(selectedRow, 4);
        lt.setLabTechnician(userAccount.getEmployee());
        lt.setStatus("In Process");
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        JOptionPane.showMessageDialog(null, "Assigned successfully!");
        DB4OUtil.getInstance().storeSystem(business);
        populateTable();
        
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 7);
        if(request.getReceiver()==null)
        {
            JOptionPane.showMessageDialog(null, "Please assign request before processing!");
            return;
        }
        
        //if(request.getStatus().equals("Close") || request.getStatus().equals("Close"))
       // {
       //    JOptionPane.showMessageDialog(null, "Request is already processed");
       //    return;
      // }
        
        //request.setStatus("Processing");
        LabTest labtest = (LabTest) workRequestJTable.getValueAt(selectedRow, 4);
        LabTechnicianWorkAreaJPanel processWorkRequestJPanel = 
                new LabTechnicianWorkAreaJPanel(userProcessContainer, userAccount,  organization,  business,request, labtest, enterprise);
        userProcessContainer.add("LabTechnicianWorkAreaJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        DB4OUtil.getInstance().storeSystem(business);
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
