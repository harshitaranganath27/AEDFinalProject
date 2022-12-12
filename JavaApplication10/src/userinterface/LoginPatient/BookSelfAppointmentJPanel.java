/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LoginPatient;


import Business.Appointment.Appointment;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospEnterprise.Hospital;
import Business.Enterprise.Lab.Lab;
import Business.Enterprise.Lab.LabTest;
import Business.Network.Network;
import Business.Org.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import static Business.Utility.EmailClass.sendEmailMessageAppointment;
import static Business.Utility.EmailClass.sendTextMessageAppointment;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.LabTechnicianWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author harshita
 */
public class BookSelfAppointmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookAppointmentJPanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;
    Patient patient;
    Integer time;
    public BookSelfAppointmentJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem system, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.system = system;
        this.patient = patient;
        populateNetworkComboBox();
        jLabel2.setText("Appointment Booking for " + patient.getName());
        time=0;
        //populate doctor
        
        
        //-- todo now
        
    }
    
    
    private void populateNetworkComboBox(){
        networkJComboBox1.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox1.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterpriseJComboBox1.removeAllItems();
        //enterpeirse-> bostonHospital!
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprise instanceof Hospital)
            {
                enterpriseJComboBox1.addItem(enterprise);
            }
            
        }
        
    }

    void populateDoctor(Enterprise enterprise){
       List<Employee> empList= new ArrayList<>();//enterprise.getEmployeeDirectory().getDoctorList();
       
       
       if(enterprise !=null && enterprise.getOrganizationDirectory() != null && enterprise.getOrganizationDirectory().getOrganizationList() !=null){
       ArrayList<Organization> deptList = enterprise.getOrganizationDirectory().getOrganizationList();
       if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())){
           for(Organization dept : deptList)
                {
                    if(dept instanceof Business.Org.GeneralOrganization){
                    for(Employee emp : dept.getEmployeeDirectory().getEmployeeList()){
                        if(emp.getRole()!= null && (emp.getRole().equals("Doctor Role")))
                        {
                            empList.add(emp);
                        }
                    }
                    }
                }
       }
       }
       
       
       
        cmbDoctor.removeAllItems();
        //Employee emp = new Employee();
        cmbDoctor.addItem("Select");
        for (Employee doc : empList){
            cmbDoctor.addItem(doc);
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

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbDoctor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtAppointmetDate = new javax.swing.JTextField();
        txtBookAppointment = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtAppointmentType = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jpnael10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpnael1014 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jpnael15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jpnael11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jpnael12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jpnael16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        networkJComboBox1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        enterpriseJComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 147, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 58, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Doctor:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 109, -1));

        cmbDoctor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmbDoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDoctorActionPerformed(evt);
            }
        });
        add(cmbDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 150, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Appointment Date:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 140, -1));

        txtAppointmetDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAppointmetDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAppointmetDateFocusLost(evt);
            }
        });
        txtAppointmetDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAppointmetDateMouseExited(evt);
            }
        });
        txtAppointmetDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmetDateActionPerformed(evt);
            }
        });
        txtAppointmetDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAppointmetDateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAppointmetDateKeyTyped(evt);
            }
        });
        add(txtAppointmetDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 148, -1));

        txtBookAppointment.setBackground(new java.awt.Color(255, 155, 54));
        txtBookAppointment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtBookAppointment.setText("Book Appointment");
        txtBookAppointment.setPreferredSize(new java.awt.Dimension(167, 40));
        txtBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookAppointmentActionPerformed(evt);
            }
        });
        add(txtBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Appointment Type:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        txtAppointmentType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAppointmentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "In-Person", "Online" }));
        add(txtAppointmentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 148, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bookAppomnt.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, 145));

        jpnael10.setBackground(new java.awt.Color(164, 208, 215));
        jpnael10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael10MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" 10 AM");

        javax.swing.GroupLayout jpnael10Layout = new javax.swing.GroupLayout(jpnael10);
        jpnael10.setLayout(jpnael10Layout);
        jpnael10Layout.setHorizontalGroup(
            jpnael10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jpnael10Layout.setVerticalGroup(
            jpnael10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jpnael10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 236, 60, 40));

        jpnael1014.setBackground(new java.awt.Color(164, 208, 215));
        jpnael1014.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael1014MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("14 PM");

        javax.swing.GroupLayout jpnael1014Layout = new javax.swing.GroupLayout(jpnael1014);
        jpnael1014.setLayout(jpnael1014Layout);
        jpnael1014Layout.setHorizontalGroup(
            jpnael1014Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael1014Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpnael1014Layout.setVerticalGroup(
            jpnael1014Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnael1014Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(24, 24, 24))
        );

        add(jpnael1014, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 60, 40));

        jpnael15.setBackground(new java.awt.Color(164, 208, 215));
        jpnael15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael15MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("15 PM");

        javax.swing.GroupLayout jpnael15Layout = new javax.swing.GroupLayout(jpnael15);
        jpnael15.setLayout(jpnael15Layout);
        jpnael15Layout.setHorizontalGroup(
            jpnael15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpnael15Layout.setVerticalGroup(
            jpnael15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnael15Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        add(jpnael15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 60, 40));

        jpnael11.setBackground(new java.awt.Color(164, 208, 215));
        jpnael11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael11MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("11 AM");

        javax.swing.GroupLayout jpnael11Layout = new javax.swing.GroupLayout(jpnael11);
        jpnael11.setLayout(jpnael11Layout);
        jpnael11Layout.setHorizontalGroup(
            jpnael11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jpnael11Layout.setVerticalGroup(
            jpnael11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jpnael11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 236, 60, 40));

        jpnael12.setBackground(new java.awt.Color(164, 208, 215));
        jpnael12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael12MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("12 PM");

        javax.swing.GroupLayout jpnael12Layout = new javax.swing.GroupLayout(jpnael12);
        jpnael12.setLayout(jpnael12Layout);
        jpnael12Layout.setHorizontalGroup(
            jpnael12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpnael12Layout.setVerticalGroup(
            jpnael12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnael12Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        add(jpnael12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 60, 40));

        jpnael16.setBackground(new java.awt.Color(164, 208, 215));
        jpnael16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnael16MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("16 PM");

        javax.swing.GroupLayout jpnael16Layout = new javax.swing.GroupLayout(jpnael16);
        jpnael16.setLayout(jpnael16Layout);
        jpnael16Layout.setHorizontalGroup(
            jpnael16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnael16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpnael16Layout.setVerticalGroup(
            jpnael16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnael16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(24, 24, 24))
        );

        add(jpnael16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 60, 40));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Network:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        networkJComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        networkJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBox1ActionPerformed(evt);
            }
        });
        add(networkJComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 150, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Enterprise:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        enterpriseJComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        enterpriseJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBox1ActionPerformed(evt);
            }
        });
        add(enterpriseJComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 150, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(68, 145, 157));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Book an appointment");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 550, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAppointmetDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmetDateActionPerformed
        // TODO add your handling code here:
      //  setPanelTime();
        
        
        
    }//GEN-LAST:event_txtAppointmetDateActionPerformed

    private void txtBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookAppointmentActionPerformed
        if(txtAppointmetDate.getText().isEmpty() || txtAppointmentType.getSelectedIndex() == 0
                || cmbDoctor.getSelectedIndex() == 0 )
        {
            JOptionPane.showMessageDialog(null, "All fields are mandatory", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        //|| cmbDoctor.getSelectedIndex() == 0
        if(time==0)
        {
            JOptionPane.showMessageDialog(null, "Please select a time!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sDate = txtAppointmetDate.getText();
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= new Date();  
        try {
            date1 = formatter1.parse(sDate);
        } catch (ParseException ex) {
            Logger.getLogger(BookSelfAppointmentJPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("expection in Book appointmentJPanel");
        }
        Employee doctor = (Employee)cmbDoctor.getSelectedItem();
        if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())){
            for(Appointment appointment : patient.getAppointmentDirectory().getApptmentList()){
                if((appointment.getDate().compareTo(date1) == 0) && (appointment.getDoc().getId() == doctor.getId())&& !appointment.getStatus().equalsIgnoreCase(Appointment.AppointmentStatus.Cancel.getValue())){
                    JOptionPane.showMessageDialog(null, "Patient has already booked appointment!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }else if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())){
            for(Appointment appointment : patient.getLabAppointmentDirectory().getApptmentList()){
                if((appointment.getDate().compareTo(date1) == 0) && (appointment.getDoc().getId() == doctor.getId()) &&  !appointment.getStatus().equalsIgnoreCase(Appointment.AppointmentStatus.Cancel.getValue())){
                    JOptionPane.showMessageDialog(null, "Patient has already booked appointment!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        
        
       
        boolean check = doctor.checkScheduleIsAvaible(date1, time);
        if(check ==false)
        {
                JOptionPane.showMessageDialog(null, "Doctor has other appointment already, please select other time!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
        
        Appointment appoint = null;
        if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())){
            appoint = patient.getAppointmentDirectory().createAppointment(patient, doctor, date1 , (String)txtAppointmentType.getSelectedItem());
            appoint.setTime(time);
        }else if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())){
            appoint = patient.getLabAppointmentDirectory().createLabAppointment(patient, doctor, date1 , (String)txtAppointmentType.getSelectedItem());
            appoint.setTime(time);
        }
        Patient pt=null;
        List<Patient> patList=enterprise.getPatientDirectory().getPatientList();
        for(Patient p: patList)
        {
            //if()
            if(p.getSSN()!=null && p.getInsuranceId() !=null &&p.getSSN().equals(patient.getSSN()) && p.getInsuranceId().equalsIgnoreCase(patient.getInsuranceId()) && p.getId() == patient.getId()){
                pt=p;
                
                break;
            }
        }
        
        if(pt==null)
        {enterprise.getPatientDirectory().getPatientList().add(patient);
            
        }
        
        //get user accout of dcotor selected
        
       
       List<Employee> empList= new ArrayList<>();//enterprise.getEmployeeDirectory().getDoctorList();
       UserAccount drUserAcc =null;
       ArrayList<Organization> deptList = enterprise.getOrganizationDirectory().getOrganizationList();
       for(Organization dept : deptList)
       {
           if(dept instanceof Business.Org.GeneralOrganization){
                drUserAcc = dept.getUserAccountDirectory().getUserAccByEMployee(doctor);
              if(drUserAcc!=null ) {break;}
           }else if(dept instanceof Business.Org.PathologyOrganization){
               drUserAcc = dept.getUserAccountDirectory().getUserAccByEMployee(doctor);
              if(drUserAcc!=null ) {break;}
           }else if(dept instanceof Business.Org.RadiologyOrganization){
               drUserAcc = dept.getUserAccountDirectory().getUserAccByEMployee(doctor);
             if(drUserAcc!=null ) {break;}
           }
       }
       //Integer [] arr = null;
       
       
       
        doctor.addSchedule(date1, time);
        //txtPatientName.setText("");
        cmbDoctor.setSelectedIndex(0);
        txtAppointmetDate.setText("");
        txtAppointmentType.setSelectedIndex(0);
        
        //add in work queue for assigned doctor
        if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())){
            LabTechnicianWorkRequest workreq = new LabTechnicianWorkRequest();
                workreq.setStatus("New");
                appoint.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
                workreq.setMessage("New Patient for Lab test, please confirm a Test Date");
                workreq.setStatus("New");
                workreq.setAppointment(appoint);
                workreq.setMessage("Please conduct lab test!");
                workreq.setRequestDate(date1 == null ? new Date() : date1);
                //workreq.setDoctorUserAccount(userAccount);
                workreq.setSender(userAccount);
                workreq.setPatient(patient);
                //workreq.setDoctor(doctor);
                //workreq.setReceiver(userAccount);
                Lab lab = (Lab) enterprise;
                lab.getWorkQueue().getWorkRequestList().add(workreq);
                LabTest labTest= new LabTest();
                labTest.setLab(lab);
                labTest.setLabTechnician(null);
                labTest.setPatient(patient);
                labTest.setName("none");
                labTest.setDoctor(appoint.getDoc());
                labTest.setStatus("New");
                //labTest.setType(testType);
                workreq.setLabTest(labTest);
                appoint.getLabTestList().addLabTest(labTest);
                appoint.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
        }else if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())){
            DoctorWorkRequest drWorkReq = new DoctorWorkRequest();
            drWorkReq.setMessage("New Appointment");
            drWorkReq.setReceiver(drUserAcc);
            drWorkReq.setSender(userAccount);
            drWorkReq.setStatus("New");
            drWorkReq.setPatient(patient);
            drWorkReq.setAppointment(appoint);
            drWorkReq.setRequestDate(new Date());
            drWorkReq.setResolveDate(new Date());
            drUserAcc.getWorkQueue().getWorkRequestList().add(drWorkReq);
        }
        
        JOptionPane.showMessageDialog(null, "Appointment booked successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
        
        
        //send sms and email to patient for appointment book status
        
        //send Sms
                
          //send email and sms

        String statusString = "Hello! Your appointment is booked! Date: "+ date1 + "Doctor: "+ doctor.getName();
        

        String uEmail= patient.getEmailID();
        UserAccount account = patient.getUserAccount();
        String phonecontact = patient.getPhoneNum()+patient.getCarrier();
        //registrationRequest.setContactCarrierName(contact);
        sendEmailMessageAppointment(uEmail, account, statusString);//.getText());
        sendTextMessageAppointment(phonecontact, account, statusString);      
        setPanelTime();
        DB4OUtil.getInstance().storeSystem(system);
        
        //return;
    }//GEN-LAST:event_txtBookAppointmentActionPerformed

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

    private void cmbDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDoctorActionPerformed
        // TODO add your handling code here:
        setPanelTime();
        
    }//GEN-LAST:event_cmbDoctorActionPerformed

    void setPanelTime()
    {
        if(cmbDoctor.getSelectedIndex() ==0)
        {
        resetLblColor(jpnael11);
        resetLblColor(jpnael12);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael15);
        resetLblColor(jpnael16);
        resetLblColor(jpnael10);
        return;
        }
        
        
        Employee doctor = (Employee)cmbDoctor.getSelectedItem();
        if(doctor !=null)
        {
        Date date1= new Date();
        try {
        String sDate = txtAppointmetDate.getText().equals("") ? "2020-12-20" :txtAppointmetDate.getText() ;
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
            date1 = formatter1.parse(sDate);
        } catch (ParseException ex) {
            Logger.getLogger(BookSelfAppointmentJPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("expection in Book appointmentJPanel");
        }
        if(doctor.getSchedule() == null)
        {
            Map<Date,ArrayList<Integer>> schedule = new HashMap<>();
            doctor.setSchedule(schedule);
            //schedule.put()
        }
        
        for(Map.Entry<Date,ArrayList<Integer>> sch : doctor.getSchedule().entrySet()){
            if(sch.getKey().equals(date1) )
            {
                ArrayList<Integer> arr = sch.getValue();
                //for(int i=0;1<arr.length;i++){
                if( arr.contains(10))
                {
                    jpnael10.setEnabled(false);
                    setLblColor(jpnael10);
                    //continue;
                }
                if(arr.contains(11))
                {
                    jpnael11.setEnabled(false);
                    setLblColor(jpnael11);
                    //continue;
                }
                if(arr.contains(12))
                {
                    jpnael12.setEnabled(false);
                    setLblColor(jpnael12);
                    //continue;
                }
               if(arr.contains(14))
                {
                    jpnael1014.setEnabled(false);
                    setLblColor(jpnael1014);
                    //continue;
                }
                if(arr.contains(15))
                {
                    jpnael15.setEnabled(false);
                    setLblColor(jpnael15);
                    //continue;
                }
                if(arr.contains(16))
                {
                    jpnael16.setEnabled(false);
                    setLblColor(jpnael16);
                    //continue;
                }
               // }
            }
        }
        
        }
    }
    
    boolean b10,b11,b12,b14,b15,b16;
    private void jpnael10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael10MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael10);
        resetLblColor(jpnael11);
        resetLblColor(jpnael12);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael15);
        resetLblColor(jpnael16);
        time=10;
        
    }//GEN-LAST:event_jpnael10MouseClicked

    private void jpnael11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael11MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael11);
        resetLblColor(jpnael10);
        resetLblColor(jpnael12);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael15);
        resetLblColor(jpnael16);
        time=11;
    }//GEN-LAST:event_jpnael11MouseClicked

    private void jpnael12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael12MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael12);
        resetLblColor(jpnael11);
        resetLblColor(jpnael10);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael15);
        resetLblColor(jpnael16);
        time=12;
    }//GEN-LAST:event_jpnael12MouseClicked

    private void jpnael1014MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael1014MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael1014);
        resetLblColor(jpnael11);
        resetLblColor(jpnael12);
        resetLblColor(jpnael10);
        resetLblColor(jpnael15);
        resetLblColor(jpnael16);
        time=14;
    }//GEN-LAST:event_jpnael1014MouseClicked

    private void jpnael15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael15MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael15);
        resetLblColor(jpnael11);
        resetLblColor(jpnael12);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael10);
        resetLblColor(jpnael16);
        time=15;
    }//GEN-LAST:event_jpnael15MouseClicked

    private void jpnael16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnael16MouseClicked
        // TODO add your handling code here:
        setLblColor(jpnael16);
        resetLblColor(jpnael11);
        resetLblColor(jpnael12);
        resetLblColor(jpnael1014);
        resetLblColor(jpnael15);
        resetLblColor(jpnael10);
        time=16;
    }//GEN-LAST:event_jpnael16MouseClicked

    private void txtAppointmetDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmetDateKeyReleased
        // TODO add your handling code here:
        //setPanelTime();
    }//GEN-LAST:event_txtAppointmetDateKeyReleased

    private void txtAppointmetDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmetDateKeyTyped
        // TODO add your handling code here:
        
      //  setPanelTime();
    }//GEN-LAST:event_txtAppointmetDateKeyTyped

    private void txtAppointmetDateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAppointmetDateMouseExited
        // TODO add your handling code here:
        
       // setPanelTime();
    }//GEN-LAST:event_txtAppointmetDateMouseExited

    private void txtAppointmetDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAppointmetDateFocusLost
        // TODO add your handling code here:
        
        setPanelTime();
    }//GEN-LAST:event_txtAppointmetDateFocusLost

    private void networkJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBox1ActionPerformed

        Network network = (Network) networkJComboBox1.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }

    }//GEN-LAST:event_networkJComboBox1ActionPerformed

    private void enterpriseJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBox1ActionPerformed
        // TODO add your handling code here:
        enterprise = (Enterprise) enterpriseJComboBox1.getSelectedItem();
         populateDoctor(enterprise);
    }//GEN-LAST:event_enterpriseJComboBox1ActionPerformed

    public void setLblColor(JPanel lbl)
    {
        lbl.setBackground(new Color(22, 42, 57));
    }
    
      public void resetLblColor(JPanel lbl)
    {
        lbl.setBackground(new Color(153,204,255));
    }
    
    
    private void onClick(JPanel panel)
    {
        panel.setBackground(new Color(205, 136, 205));
    }
    
     private void onLeaveClick(JPanel panel)
    {
        panel.setBackground(Color.white);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDoctor;
    private javax.swing.JComboBox enterpriseJComboBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpnael10;
    private javax.swing.JPanel jpnael1014;
    private javax.swing.JPanel jpnael11;
    private javax.swing.JPanel jpnael12;
    private javax.swing.JPanel jpnael15;
    private javax.swing.JPanel jpnael16;
    private javax.swing.JComboBox networkJComboBox1;
    private javax.swing.JComboBox txtAppointmentType;
    private javax.swing.JTextField txtAppointmetDate;
    private javax.swing.JButton txtBookAppointment;
    // End of variables declaration//GEN-END:variables
}
