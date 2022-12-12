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
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
/**
 *
 * @author harshita
 */
public class ManageBedsFinalJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageBedsFinalJPanel
     */
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    //Appointment appointment;
    //Patient patient;
    //Employee doctor;
    UserAccount nurseUserAccount;
    //WorkRequest workrequest;
    BedManagementDepartment bedorg;
   
    public ManageBedsFinalJPanel(JPanel userProcessContainer, Enterprise enterprise,  UserAccount nurseUserAccount) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.enterprise= enterprise;
        
        this.nurseUserAccount= nurseUserAccount;
        
        this.bedorg= getBedDepartment();
        populateBedTypeCmb();
        populateBedStatusCmb();
    }

      void populateBedTypeCmb(){
          bedTypeCmb.removeAllItems();
        
        for (Bed.BedType status : Bed.BedType.values()){
            bedTypeCmb.addItem(status.getBedType());
        }
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignJPanel = new javax.swing.JPanel();
        lblBedStatus = new javax.swing.JLabel();
        bedStatusCmb = new javax.swing.JComboBox();
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bedJTable = new javax.swing.JTable();
        txtBedDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnAssignBed = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bedTypeCmb = new javax.swing.JComboBox();
        lblBedStatus1 = new javax.swing.JLabel();
        bedStatusCmb1 = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignJPanel.setBackground(new java.awt.Color(255, 204, 204));
        assignJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Bed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        assignJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBedStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBedStatus.setText("Bed Status");
        assignJPanel.add(lblBedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        bedStatusCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 146, -1));

        btnView.setBackground(new java.awt.Color(255, 155, 54));
        btnView.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnView.setText("View");
        btnView.setPreferredSize(new java.awt.Dimension(100, 40));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        assignJPanel.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        bedJTable.setBackground(new java.awt.Color(255, 193, 131));
        bedJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        bedJTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
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

        assignJPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 240, 210));

        txtBedDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedDateActionPerformed(evt);
            }
        });
        assignJPanel.add(txtBedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 145, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Date");
        assignJPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        btnAssignBed.setBackground(new java.awt.Color(255, 155, 54));
        btnAssignBed.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAssignBed.setText("Change Status");
        btnAssignBed.setPreferredSize(new java.awt.Dimension(167, 40));
        btnAssignBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignBedActionPerformed(evt);
            }
        });
        assignJPanel.add(btnAssignBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Bed Type");
        assignJPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        bedTypeCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedTypeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        bedTypeCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedTypeCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedTypeCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 146, -1));

        lblBedStatus1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBedStatus1.setText("New Bed Status");
        assignJPanel.add(lblBedStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        bedStatusCmb1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bedStatusCmb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmb1ActionPerformed(evt);
            }
        });
        assignJPanel.add(bedStatusCmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 146, -1));

        add(assignJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 374, 540));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 58, -1, -1));

        jLabel5.setBackground(new java.awt.Color(68, 145, 157));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 145, 157));
        jLabel5.setText("Bed Management");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 270, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void bedStatusCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmbActionPerformed
       // Organization organization = (Organization) bedStatusCmb.getSelectedItem();
       // if (organization != null){
            //populateEmployeeComboBox(organization);
            // populateRoleComboBox(organization);
       // }
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
        String status =(String) bedStatusCmb.getSelectedItem();
        populateBedTable(dateString,type,status );
    }//GEN-LAST:event_btnViewActionPerformed

    void populateBedStatusCmb()
    {
        bedStatusCmb.removeAllItems();
        bedStatusCmb1.removeAllItems();
        
        for(Bed.BedStatus status: Bed.BedStatus.values())
        {
            bedStatusCmb.addItem(status.getStatus());
            bedStatusCmb1.addItem(status.getStatus());
        }
    }
    
    
     void populateBedTable(String dateString, String bedType, String status) {
        
        //convert string to date
        try{
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=formatter1.parse(dateString);
       //
//        List<Bed> bedList = null;//bedorg.getBedList().getBedList();
        
        List<Bed> bedList = bedorg.getList().getBedList();
        
//        if(status.equals(Bed.BedStatus.AssignedLaundry.getStatus()))
//        {
//        bedList = bedorg.getBedAssignedLaundry();
//        }
//        else if(status.equals(Bed.BedStatus.Available.getStatus()))
//        {
//        bedList = bedorg.getBedAvailableListOnDate(date1);
//        }
//        else if(status.equals(Bed.BedStatus.Occupied.getStatus()))
//        {
//        bedList = bedorg.getBedOccupiedListOnDate(date1);
//        }
        
        
        DefaultTableModel model = (DefaultTableModel) bedJTable.getModel();
        
        
        if(bedList==null || bedList.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No bed for this status", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        
        
        model.setRowCount(0);
        for(Bed bed: bedList)
        {
            if((bed.getBedType().getBedType().equals(bedType)) && 
                    bed.getStatus().getStatus().equals(status))
            {
        
        //String bedStatus = (String)bedStatusCmb.getSelectedItem();
        
            Object[] row = new Object[2];
            row[0] = bed;//.getBedID();
            //row[1] = bed.getStatus().getStatus();
            //Patient p = bed.getPatient();
            //Map<Date, Bed> bedListOccupied=bedorg.getBedOccupiedListOnDate(date1);
            
            
            //row[1] = p == null ? "": p;
            //row[3] = "";
            row[1] = bed.getBedType();
            model.addRow(row);
            //row[2] = 
            }
      
        }//outer for loop
        
        }//try
        
        catch(Exception e){
            System.out.println("Exception occured in ManageBedsFinaljpanel :populateBedTableMethod");
        }
    }
    
    
    private void txtBedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedDateActionPerformed

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
            String newBedStatus =(String) bedStatusCmb1.getSelectedItem();
            String currentBedStatus= (String) bedStatusCmb.getSelectedItem();//selectedBed.getStatus().getStatus();
            if(newBedStatus.equals(currentBedStatus))
            {
                //status is same, no change
                JOptionPane.showMessageDialog(null, "Bed status is same, no change!");
                return;
                        
            }
            
            else if(newBedStatus.equals(Bed.BedStatus.Occupied.getStatus()))
            {
               
                JOptionPane.showMessageDialog(null, "Cannot assign status occupied from this window, please go to assign bed window!");
                return;
                        
            }
            
            else if(newBedStatus.equals(Bed.BedStatus.Available.getStatus()))
            {
                //status changing to available, remove patient if present
                
                if(currentBedStatus.equals(Bed.BedStatus.Occupied.getStatus()))
                {
                    //selectedBed.getPatient().
                    JOptionPane.showMessageDialog(null, "Cannot assign status available, first assign to laundry!");
                    return;
                }
                if(currentBedStatus.equals(Bed.BedStatus.AssignedLaundry.getStatus()))
                {
                    //selectedBed.getPatient().
                    selectedBed.setStatus(Bed.BedStatus.Available);
                    JOptionPane.showMessageDialog(null, "Bed status changed Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
               
                        
            }
            
            
            else if(newBedStatus.equals(Bed.BedStatus.AssignedLaundry.getStatus()))
            {
                  
               if(currentBedStatus.equals(Bed.BedStatus.Available.getStatus()))
                {
                    //selectedBed.getPatient().
                    JOptionPane.showMessageDialog(null, "Cannot assign status assign laundry as bed is available, wasn't occupied!");
                    return;
                }
                
                
               else if(currentBedStatus.equals(Bed.BedStatus.Occupied.getStatus()))
                {
                    //selectedBed.getPatient().
                    //free patient
                    Patient pat= selectedBed.getPatient();
                    Appointment appointment = selectedBed.getAppointment();
                    selectedBed.setStatus(Bed.BedStatus.AssignedLaundry);
                    appointment.getOperation().setStatus(Operation.OperationStatus.Completed.getValue());
                    JOptionPane.showMessageDialog(null, "Bed status changed Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
//                    Patient pat= bedorg.getPatientByBedNDate(selectedBed,date1);
//                    List<Appointment> appnmtList = pat.getAppointmentDirectory().getAppointmentList();
//                    //add appouintmt in patient app dir also when creating
//                    for(Appointment app : appnmtList)
//                    {
//                        Bed appBed = app.getOperation().getBedAssigned() ;
//                        if(appBed !=null && appBed.equals(selectedBed))
//                        {
//                            //app.getOperation().getBedAssigned().setStatus(newBedStatus);
//                            Operation opr= app.getOperation();
//                            //opr.setBedAssigned(null);
////                            BedPatient bp = new BedPatient();
////                            bp.setPatient(pat);
////                            bp.setBed(appBed);
//                            //remove entry from assignedBedtoPatient map
////                            bedorg.getAssignedBedMap().remove(opr.getOperationDate(), bp);
//                            //add bed to assign laundry list
////                            bedorg.getBedAssignedLaundry().add(selectedBed);
//                            //opr.set(dateString);
//                            //opr.setPerson(nurseUserAccount.getEmployee());
//                            //set opeartion status to complete
//                            opr.setStatus(Operation.OperationStatus.Completed.getValue());
//                             JOptionPane.showMessageDialog(null, "Bed status changed Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    }
                    
                    
                    
                    
                   // Bed.BedStatus.values();
                   // selectedBed.setStatus(Bed.BedStatus.valueOf(newBedStatus));
                   // JOptionPane.showMessageDialog(null, "Cannot assign status available, first assign to laundry!");
                   // return;
                }
                        
            }
            
            
            //do here-->>>
         //   bed status change based on value selected in cmbstatus
                    
                    
                    
           

        } catch (ParseException ex) {
            Logger.getLogger(AssignBedJPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occured in string to date conversion !!!!!! : method-> btnAssignBedActionPerformed");
        }

        //if all good then assign bed to this patient appointment
        //change appoitnment status

    }//GEN-LAST:event_btnAssignBedActionPerformed

    private void bedTypeCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedTypeCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bedTypeCmbActionPerformed

    private void bedStatusCmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bedStatusCmb1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        
         userProcessContainer.remove(this);
        //Component[] componentArray =userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //NurseWorkAreaJPanel sysAdminwajp = (NurseWorkAreaJPanel) component;
        //sysAdminwajp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assignJPanel;
    private javax.swing.JButton backJButton;
    private javax.swing.JTable bedJTable;
    private javax.swing.JComboBox bedStatusCmb;
    private javax.swing.JComboBox bedStatusCmb1;
    private javax.swing.JComboBox bedTypeCmb;
    private javax.swing.JButton btnAssignBed;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBedStatus;
    private javax.swing.JLabel lblBedStatus1;
    private javax.swing.JTextField txtBedDate;
    // End of variables declaration//GEN-END:variables
}
