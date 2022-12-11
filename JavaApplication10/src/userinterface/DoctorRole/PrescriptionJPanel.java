/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Appointment.Appointment;
import Business.Appointment.AppointmentDirectory;
import Business.Appointment.Prescription;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Medicine.Medicine;
import Business.Medicine.MedicineDirectory;
import Business.Network.Network;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sushmitamaity
 */


public class PrescriptionJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrescriptionJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Patient patient;
    private Employee doctor;
    private Appointment appointment;
    private MedicineDirectory medicineList;
    private AppointmentDirectory prescriptionList;
    private Enterprise enterprise;
    private EcoSystem ecosystem;
    

   public PrescriptionJPanel(JPanel userProcessContainer, Patient patient, Appointment appointment, Employee doctor,
            MedicineDirectory medicineList,EcoSystem ecosystem, Enterprise enterprise, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.appointment = appointment;
        this.patient = patient;
        this.doctor = doctor;
        this.ecosystem=ecosystem;
        this.medicineList = medicineList;
        this.enterprise= enterprise;
        this.userAccount = userAccount;
        patientNameTxt.setText(patient.getName());
        doctorNameTxt.setText(doctor.getName());
        //docotr
        //appointment.
        //appointment.setPrescription(prescription);
        populatePharmacy();
        //populateMedicineCmb();
    }

    
    void populatePharmacy(){
        ArrayList<Network> networkList=ecosystem.getNetworkList();
        Network network=null;
        //network
        cmbPharmacy.removeAllItems();
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            
            List<Enterprise> enterpriseList= network.getEnterpriseDirectory().getEnterpriseList();
        if (enterpriseList == null || enterpriseList.isEmpty()) {
            //nothing
        } 
            {
                //boston network
                
                enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
                
               for(Enterprise enterpri: enterpriseList){
                   if(enterpri.getEnterpriseType().equals(Enterprise.EnterpriseType.Pharmacy))
                   {
                       cmbPharmacy.addItem(enterpri);
                   }
               }
            }
            
            
            
        }
        
        
        //
        
        
        
    }
    
    void populateMedicineCmb()
    {
          medicneCmb.removeAllItems();
        
          Pharmacy pharEnterprise =(Pharmacy) cmbPharmacy.getSelectedItem();
          if(pharEnterprise != null)  // added because on page loading null pointer exception is coming
          {
          MedicineDirectory medicineList1 =pharEnterprise.getMedicineList();
          
          
          if(medicineList1 != null){
          for(Medicine med: medicineList1.getMedicineList())
          {
              medicneCmb.addItem(med);
          }
          }

          
          }//end if
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        patientNameTxt = new javax.swing.JTextField();
        doctorNameTxt = new javax.swing.JTextField();
        dosageTxt = new javax.swing.JTextField();
        remarksTxt = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        btnPrescribe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PrescriptionTable = new javax.swing.JTable();
        medicneCmb = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbPharmacy = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(196, 224, 229));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(68, 145, 157));
        jLabel1.setText("Medicine Prescription");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 240, 35));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Patient Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Doctor Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Remark :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 70, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Medicines Prescribed :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        patientNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(patientNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 144, -1));

        doctorNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(doctorNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 144, -1));

        dosageTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(dosageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 144, -1));

        remarksTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(remarksTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 144, 84));

        backJButton.setBackground(new java.awt.Color(102, 147, 255));
        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnPrescribe.setBackground(new java.awt.Color(255, 155, 54));
        btnPrescribe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPrescribe.setText("Prescribe");
        btnPrescribe.setPreferredSize(new java.awt.Dimension(167, 40));
        btnPrescribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeActionPerformed(evt);
            }
        });
        add(btnPrescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        PrescriptionTable.setBackground(new java.awt.Color(255, 193, 131));
        PrescriptionTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        PrescriptionTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PrescriptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicines prescribed", "Dosage", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PrescriptionTable);
        if (PrescriptionTable.getColumnModel().getColumnCount() > 0) {
            PrescriptionTable.getColumnModel().getColumn(0).setResizable(false);
            PrescriptionTable.getColumnModel().getColumn(1).setResizable(false);
            PrescriptionTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 504, 185));

        medicneCmb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        medicneCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        medicneCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicneCmbActionPerformed(evt);
            }
        });
        add(medicneCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 144, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Dosage :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 155, 54));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Add Medicine");
        jButton1.setPreferredSize(new java.awt.Dimension(167, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, -1, -1));

        cmbPharmacy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmbPharmacy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPharmacyActionPerformed(evt);
            }
        });
        add(cmbPharmacy, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 144, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Pharmacy :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Quantity :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, -1, -1));

        quantityTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(quantityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 144, -1));

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

        jPanel14.setBackground(new java.awt.Color(196, 224, 229));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);

        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        DoctorWorkAreaJPanel ms = (DoctorWorkAreaJPanel) c;
        ms.populateRequestTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnPrescribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeActionPerformed
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
          
        //String date=dateTxt.getText();
        //date = dateFormat.format(date);
        String patientName=patientNameTxt.getText();
        String doctorName=doctorNameTxt.getText();
        //String specialization=specializationTxt.getText();
        String medsPrescribed= dosageTxt.getText();
        if(patientName.equals("") || doctorName.equals("") || medsPrescribed.equals(""))
        {
           JOptionPane.showMessageDialog(null, "Fields cannot be empty"); 
        }
        else
        {Prescription prescription = appointment.getPrescription();//prescriptionList.addPrescription();
        //prescription.setDate(date);
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        
        patient.getAppointmentDirectory().getPrescriptionList().add(prescription);
        
        //pharmacy work request created--todo
        PharmacyWorkRequest phWr = new PharmacyWorkRequest();
         phWr.setStatus("New");
                //appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
                phWr.setMessage("Please provide the Prescribed medicines for this Patient");
                phWr.setSender(userAccount);
                phWr.setAppointment(appointment);
                phWr.setDoctor(doctor);
                phWr.setPatient(patient);
                phWr.setMedicineMap(appointment.getPrescription().getMedicinePrescribed());
                //phWr.setReceiver(receptionist);
                //Appointment appointment = (Appointment) 
                Pharmacy pharEnterprise =(Pharmacy) cmbPharmacy.getSelectedItem();
                pharEnterprise.getWorkQueue().getWorkRequestList().add(phWr);
                prescription.setPhmacy(pharEnterprise);
                //UserAccount recepUseracc = null;
                //List<UserAccount> userAccDir=  organization.getUserAccountDirectory().getUserAccountList();
                //List<UserAccount> nurseList = enterprise.getUserAccountDirectory().getUserAccountList();
                //workreq.setReceiver(receptionist.getUserAccountDirectory().getUserAccountList().get(0));
                JOptionPane.showMessageDialog(null, "Medicine prescription request sent to Pharmacy");
                DB4OUtil.getInstance().storeSystem(ecosystem);
        
        
        
        //dateTxt.setText("");
        patientNameTxt.setText("");
        doctorNameTxt.setText("");
        dosageTxt.setText("");
        remarksTxt.setText("");
        quantityTxt.setText("");
        appointment.setPrescription(prescription);
       // JOptionPane.showMessageDialog(null, "Prescription sucessfully added"); 
        populate();
        }
        
    }//GEN-LAST:event_btnPrescribeActionPerformed

    private void cmbPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPharmacyActionPerformed
        // TODO add your handling code here:
        
        populateMedicineCmb();
         DefaultTableModel model = (DefaultTableModel) PrescriptionTable.getModel();
        
        model.setRowCount(0);
        Prescription prescription = appointment.getPrescription();
        
        prescription.getMedicinePrescribed().clear();
    }//GEN-LAST:event_cmbPharmacyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(patientNameTxt.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null, "Please fill all entries");
        
            
            return;
        }
        
        DB4OUtil.getInstance().storeSystem(ecosystem);
        populatePrescribedMedicineTable();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void medicneCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicneCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicneCmbActionPerformed

    
    void populatePrescribedMedicineTable(){
        if(patientNameTxt.getText()!=""){
        Medicine med = (Medicine) medicneCmb.getSelectedItem();
        double dosage = Double.parseDouble(dosageTxt.getText());
        int quantity = Integer.parseInt(quantityTxt.getText());
        
        Prescription prescription = appointment.getPrescription();
        
        if(prescription.getMedicinePrescribed() == null){
           Map<Medicine, Double>  medicinePrescribed = new HashMap<>();
           prescription.setMedicinePrescribed(medicinePrescribed);
        }
        prescription.getMedicinePrescribed().put(med, dosage);
        
        if(prescription.getMedicineListquanity() == null){
           Map<Medicine, Integer>  medicinePrescribed = new HashMap<>();
           prescription.setMedicineListquanity(medicinePrescribed);
        }
        
        
        prescription.getMedicineListquanity().put(med, quantity);
        
        
        
        DefaultTableModel model = (DefaultTableModel) PrescriptionTable.getModel();
        Object[] row = new Object[3];
                   
                    row[0] = med;
                    row[1] = dosage;
                    row[2] = quantity;
                    model.addRow(row);
        }
    }
    
    
     public void populate() {
        DefaultTableModel model = (DefaultTableModel) PrescriptionTable.getModel();

        model.setRowCount(0);
        //for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {s
          /*  for (MapEntry<Medicine,double> med : appointment.getPrescription().getMedicinePrescribed()) {
                    Object[] row = new Object[3];
                    //row[0] = prescription.getDate();
                    row[0] = prescription.getPatient();
                    row[1] = prescription.getDoctor();
                    row[2] = prescription.getMedicineList();
                    model.addRow(row);
                }*/
            }
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PrescriptionTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnPrescribe;
    private javax.swing.JComboBox cmbPharmacy;
    private javax.swing.JTextField doctorNameTxt;
    private javax.swing.JTextField dosageTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox medicneCmb;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField remarksTxt;
    // End of variables declaration//GEN-END:variables
}