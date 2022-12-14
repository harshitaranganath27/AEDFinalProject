/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Administrator;

import Business.Bed.Bed;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.BedManagementDepartment;
import Business.Org.Organization;
import Business.Org.organizationDir;
import Business.Patient.Patient;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class ManageBedJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    organizationDir organizationDirectory;
    Organization organization;
    BedManagementDepartment bedorg;
    Enterprise ent;
    EcoSystem system;
    /**
     * Creates new form ManageBedJPanel
     */
    public ManageBedJPanel(JPanel userProcessContainer, organizationDir organizationDirectory, Organization organization, BedManagementDepartment bedorg, Enterprise ent, EcoSystem system) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.organizationDirectory= organizationDirectory;
        this.organization=organization;
        this.bedorg = bedorg;
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        bedCountTxt.setEditable(false);
        currentBedCountTxt.setText(String.valueOf(this.bedorg.getCount()));
        currentBedCountTxt.setEditable(false);
        this.system= system;
        this.ent = ent;
        populateBedTable();
        
    }

    
    void populateBedTable(){
        DefaultTableModel model = (DefaultTableModel) bedJTable.getModel();
        
        model.setRowCount(0);
        String bedStatus = (String)bedStatusCmb.getSelectedItem();
        for (Bed bed : bedorg.getList().getBedList()){
            if(bed.getStatus().getStatus().equals(bedStatus)){
            Object[] row = new Object[3];
            row[0] = bed.getBedID();
            row[1] = bed.getStatus().getStatus();
            Patient p = bed.getPatient();
            row[2] = p == null ? "": p;
            model.addRow(row);
            //row[2] = 
            }//end if
            
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

        jLabel3 = new javax.swing.JLabel();
        bedCountTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bedJTable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bedStatusCmb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        currentBedCountTxt = new javax.swing.JTextField();
        btnViewGraph = new javax.swing.JButton();
        btnViewApptntStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(100, 100));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("New Bed Count");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

        bedCountTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(bedCountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 146, -1));

        bedJTable.setBackground(new java.awt.Color(255, 193, 131));
        bedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Bed ID", "Status", "Patient"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bedJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(bedJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 480, 149));

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Bed Status");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        bedStatusCmb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bedStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmbActionPerformed(evt);
            }
        });
        add(bedStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 146, -1));

        jLabel6.setBackground(new java.awt.Color(68, 145, 157));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Manage Beds");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        btnView.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnView.setText("View");
        btnView.setPreferredSize(new java.awt.Dimension(100, 40));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, -1));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setLabel("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Current Bed Count");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        currentBedCountTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(currentBedCountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 146, -1));

        btnViewGraph.setBackground(new java.awt.Color(255, 155, 54));
        btnViewGraph.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewGraph.setText("View Bed Graph");
        btnViewGraph.setPreferredSize(new java.awt.Dimension(167, 40));
        btnViewGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewGraphActionPerformed(evt);
            }
        });
        add(btnViewGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 180, -1));

        btnViewApptntStatus.setBackground(new java.awt.Color(255, 155, 54));
        btnViewApptntStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewApptntStatus.setText("View Appointment Status");
        btnViewApptntStatus.setPreferredSize(new java.awt.Dimension(180, 40));
        btnViewApptntStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewApptntStatusActionPerformed(evt);
            }
        });
        add(btnViewApptntStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 240, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
       // organization.g
        String count = bedCountTxt.getText();
        if(count.equals("") || count == null){
             JOptionPane.showMessageDialog(null, "Please enter value!");
            return;
        }
        int newCountBed = Integer.parseInt(bedCountTxt.getText());
        int currentCount = bedorg.getCount();
        
        if(currentCount > newCountBed){
            JOptionPane.showMessageDialog(null, "Cannot decrease bed Count!");
            return;

        }
        
        if(currentCount == newCountBed){
            JOptionPane.showMessageDialog(null, "No change in bed Count!");
            return;

        }
        
        newCountBed = newCountBed - currentCount;
        
        bedorg.addBedInBedList(newCountBed);
        JOptionPane.showMessageDialog(null, "Beds added successfully!");
        DB4OUtil.getInstance().storeSystem(system);
            //return;

        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        bedCountTxt.setEditable(false);
        currentBedCountTxt.setText(String.valueOf(bedorg.getCount()));
        bedCountTxt.setText("");
        populateBedTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        bedCountTxt.setEditable(true);
        DB4OUtil.getInstance().storeSystem(system);
        
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void bedStatusCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmbActionPerformed
       // Organization organization = (Organization) bedStatusCmb.getSelectedItem();
        //if (organization != null){
            //populateEmployeeComboBox(organization);
           // populateRoleComboBox(organization);
        //}
    }//GEN-LAST:event_bedStatusCmbActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        populateBedTable();
        
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnViewGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewGraphActionPerformed
        // TODO add your handling code here:

        BedCountGraph manageOrganizationJPanel = new BedCountGraph(userProcessContainer, system ,ent);
        userProcessContainer.add("BedCountGraph", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewGraphActionPerformed

    private void btnViewApptntStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewApptntStatusActionPerformed
        // TODO add your handling code here:
        
        AppointmentStatusGraphInEnterprise manageOrganizationJPanel = new AppointmentStatusGraphInEnterprise(userProcessContainer, system, ent );
        userProcessContainer.add("AppointmentStatusGraphInEnterprise", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewApptntStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bedCountTxt;
    private javax.swing.JTable bedJTable;
    private javax.swing.JComboBox bedStatusCmb;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnViewApptntStatus;
    private javax.swing.JButton btnViewGraph;
    private javax.swing.JTextField currentBedCountTxt;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
