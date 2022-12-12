/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Appointment.Appointment;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Lab.Lab;
import Business.Enterprise.Lab.LabTest;
import Business.Enterprise.Lab.LabTestDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTechnicianWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class AssignLabTestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignLabTestJPanel
     */
    private JPanel userProcessContainer;
    private Patient patient;
    private Person person;
    private Appointment appointment;
    private LabTestDirectory labTestList;
    private Lab lab;
    private Network network;
    private UserAccount userAccount;
    private Organization organization;
    private Date createdOn;
    private EcoSystem system;

    public AssignLabTestJPanel(JPanel userProcessContainer, Patient patient, Appointment appointment, Network network, UserAccount userAccount, Organization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.appointment = appointment;
        this.labTestList = appointment.getLabTestList();
        this.network = network;
        this.userAccount = userAccount;
        this.organization = organization;
        this.system= system;
        populateNetworkLabs();
        populateLabTest();
    }

    void populateNetworkLabs() {
        labSelection.removeAllItems();;
        if(system.getNetworkList() == null)
        {
            return;
        }
        for(Network network1: system.getNetworkList())
        {
         

        List<Enterprise> enterprsList = network1.getEnterpriseDirectory().getEnterpriseList();
        if (enterprsList == null || enterprsList.isEmpty()) {
            //nothing
        } else {
            for (Enterprise enterprise : enterprsList) {
                if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())) {
                    {
                        labSelection.addItem(enterprise);
                    }
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

        jScrollPane4 = new javax.swing.JScrollPane();
        assignTestTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        testName = new javax.swing.JTextField();
        labSelection = new javax.swing.JComboBox();
        submitBtn = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignTestTbl.setBackground(new java.awt.Color(204, 204, 204));
        assignTestTbl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        assignTestTbl.setFont(new java.awt.Font("Big Caslon", 1, 18)); // NOI18N
        assignTestTbl.setForeground(new java.awt.Color(255, 153, 0));
        assignTestTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Test Name", "Lab ", "Patient Name", "Test Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(assignTestTbl);
        if (assignTestTbl.getColumnModel().getColumnCount() > 0) {
            assignTestTbl.getColumnModel().getColumn(0).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(1).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(2).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 500, 240));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Assign Lab Test");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Test Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Lab :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        testName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        testName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNameActionPerformed(evt);
            }
        });
        add(testName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 171, 35));

        labSelection.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        labSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labSelectionActionPerformed(evt);
            }
        });
        add(labSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 171, -1));

        submitBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("/Users/sirius/Downloads/blood-test-1200x628-facebook-1200x628.jpg")); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 820));
    }// </editor-fold>//GEN-END:initComponents

    private void testNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testNameActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String testType = testName.getText();
        //String labName = cmbLabs.getActionCommand();

        //String medsPrescribed= medsPrescribedTxt.getText();
        if (testType.equals("")) {
            JOptionPane.showMessageDialog(null, "Test Name cannot be empty");
        }   else
        { LabTechnicianWorkRequest workreq = new LabTechnicianWorkRequest();
                workreq.setStatus("New");
                appointment.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
                workreq.setMessage("New Patient for Lab test, please confirm a Test Date");
                workreq.setStatus("New");
                workreq.setAppointment(appointment);
                workreq.setMessage("Please conduct lab test!");
                workreq.setRequestDate(createdOn == null ? new Date() : createdOn);
                //workreq.setDoctorUserAccount(userAccount);
                workreq.setSender(userAccount);
                workreq.setPatient(patient);
                //workreq.setDoctor(doctor);
                //workreq.setReceiver(userAccount);
                Lab lab = (Lab) labSelection.getSelectedItem();
                lab.getWorkQueue().getWorkRequestList().add(workreq);
                LabTest labTest= new LabTest();
                labTest.setLab(lab);
                labTest.setLabTechnician(null);
                labTest.setPatient(patient);
                labTest.setName(testType);
                labTest.setDoctor(appointment.getDoctor());
                labTest.setStatus("New");
                //labTest.setType(testType);
                workreq.setLabTest(labTest);
                appointment.getLabTestList().addLabTest(labTest);
                appointment.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
                DB4OUtil.getInstance().storeSystem(system);
                //UserAccount recepUseracc = null;
                //List<UserAccount> userAccDir=  organization.getUserAccountDirectory().getUserAccountList();
                //List<UserAccount> nurseList = enterprise.getUserAccountDirectory().getUserAccountList();
                //workreq.setReceiver(lab.getUserAccountDirectory().getUserAccountList().get(0));
   }
        populateLabTest();
        //String medsPrescribed= medsPrescribedTxt.getText();
//        if (testType.equals("") || labName.equals("")) {
//            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
//        } else {
//            LabTest labTest = labTestList.addLabTest();
//            labTest.setPatient(patient);
//            labTest.setType(testType);
//            labTest.setLab(lab);
//            //dateTxt.setText("");
//            testTypeTxt.setText("");
//            cmbLabs.setActionCommand(labName);
//            //medsPrescribedTxt.setText("");
//            //appointment.setLabTestList(labTestList);
//            JOptionPane.showMessageDialog(null, "Lab test assigned sucessfully");

//        }
    }//GEN-LAST:event_submitBtnActionPerformed

    public void populateLabTest() {
        DefaultTableModel model = (DefaultTableModel) assignTestTbl.getModel();
        model.setRowCount(0);
        //for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {s
        if(labTestList==null)
        {
            labTestList= new LabTestDirectory();
            appointment.setLabTestList(labTestList);
        }
        if(labTestList.getLabTestList() != null && !labTestList.getLabTestList().isEmpty()){
        for (LabTest labTest : labTestList.getLabTestList()) {
            Object[] row = new Object[5];
            row[0] = new Date();
            row[1] = labTest.getName();
            row[2] = labTest.getLab();
            row[3] = labTest.getPatient();
            row[4] = (labTest.getStatus().equals("") ) ? "New" :labTest.getStatus() ;
            model.addRow(row);
            
        }
        }
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
          Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        DoctorWorkAreaJPanel ms = (DoctorWorkAreaJPanel) c;
        ms.populateRequestTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void labSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labSelectionActionPerformed
        String str = String.valueOf(labSelection.getSelectedItem());
    }//GEN-LAST:event_labSelectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignTestTbl;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox labSelection;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField testName;
    // End of variables declaration//GEN-END:variables
}
