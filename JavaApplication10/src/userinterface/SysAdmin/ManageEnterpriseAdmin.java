package userinterface.SysAdmin;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;
import static Business.Utility.EmailClass.sendEmailMessage;
import static Business.Utility.EmailClass.sendTextMessage;
import Business.Utility.Validation;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harshita
 */
public class ManageEnterpriseAdmin extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates a new form ManageEnterprise
     */
    public ManageEnterpriseAdmin(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTable();
        populateNetworkComboBox();
        populateCarrierComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEntDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    if(userAccount.getRole().roleValue().equals("Admin Role")){
                        Object[] row = new Object[3];
                        row[0] = enterprise.getName();
                        row[1] = network.getName();
                        row[2] = userAccount.getUsername();

                        model.addRow(row);
                    }
                }
            }
        }
    }

    private void populateNetworkComboBox(){
        networkComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkComboBox.addItem(network);
        }
    }
    
    private void populateEntrprsComboBox(Network network){
        enterpriseComboBox.removeAllItems();
        for (Enterprise enterprise : network.getEntDirectory().getEnterpriseList()){
            enterpriseComboBox.addItem(enterprise);
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
        enterpriseJTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        networkComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        contactCarrier = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        enterpriseComboBox = new javax.swing.JComboBox();
        phoneNumberTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uEmailTxt = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        passwordJPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(68, 145, 157)));
        enterpriseJTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enterpriseJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 400, 210));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(68, 145, 157)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        submitJButton.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        networkComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        networkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(25, 56, 82));
        jLabel11.setText("Carrier");

        usernameJTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        usernameJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        usernameJTextField.setSelectionColor(new java.awt.Color(204, 204, 204));

        contactCarrier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        contactCarrier.setForeground(new java.awt.Color(25, 56, 82));
        contactCarrier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        contactCarrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactCarrierActionPerformed(evt);
            }
        });
        contactCarrier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactCarrierKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel3.setText("Enterprise");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(25, 56, 82));
        jLabel9.setText("Phone Number");

        enterpriseComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        enterpriseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        phoneNumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phoneNumberTxt.setForeground(new java.awt.Color(25, 56, 82));
        phoneNumberTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        phoneNumberTxt.setSelectionColor(new java.awt.Color(68, 145, 157));
        phoneNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTxtActionPerformed(evt);
            }
        });
        phoneNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 56, 82));
        jLabel7.setText("Email Id");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel4.setText("Password");

        uEmailTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        uEmailTxt.setForeground(new java.awt.Color(25, 56, 82));
        uEmailTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uEmailTxt.setSelectionColor(new java.awt.Color(68, 145, 157));
        uEmailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uEmailTxtActionPerformed(evt);
            }
        });
        uEmailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uEmailTxtKeyTyped(evt);
            }
        });

        nameJTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nameJTextField.setSelectionColor(new java.awt.Color(68, 145, 157));

        passwordJPasswordField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        passwordJPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordJPasswordField.setSelectionColor(new java.awt.Color(68, 145, 157));
        passwordJPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJPasswordFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel1.setText("Network");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Add Enterprise Head");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGap(52, 52, 52)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(networkComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contactCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(uEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 420, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 3, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Manage Enterprise Head");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 450, 40));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 51, 255));
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/sirius/Downloads/1939.jpg_860.jpg")); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed

        Network network = (Network) networkComboBox.getSelectedItem();
        if (network != null){
            populateEntrprsComboBox(network);
        }
        
        
    }//GEN-LAST:event_networkComboBoxActionPerformed

    
    
    public void populateCarrierComboBox() {
        contactCarrier.removeAllItems();
        contactCarrier.addItem("ATT");
        contactCarrier.addItem("Sprint");
        contactCarrier.addItem("TMobile");
        contactCarrier.addItem("Verizon");
    }
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SysAdminMainPanel sysAdminwjp = (SysAdminMainPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void contactCarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactCarrierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierActionPerformed

    private void contactCarrierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactCarrierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierKeyTyped

    private void phoneNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtActionPerformed

    private void phoneNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtKeyPressed

    private void phoneNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtKeyReleased

    private void phoneNumberTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtKeyTyped

    private void uEmailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uEmailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uEmailTxtActionPerformed

    private void uEmailTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uEmailTxtKeyTyped
      
    }//GEN-LAST:event_uEmailTxtKeyTyped

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        Enterprise enterprise = (Enterprise) enterpriseComboBox.getSelectedItem();

        String username = usernameJTextField.getText();
        String password = String.valueOf(passwordJPasswordField.getPassword());
        String name = nameJTextField.getText();
        String uEmail = uEmailTxt.getText();//"aditijain2025@gmail.com";

        //check if username is unique
        boolean isUserNameUnique = Validation.checkIfUserNameIsUniqueAcrossNetworks(system,username);

        System.out.println("isUserNameUnique:" + isUserNameUnique);
        if (isUserNameUnique == false) {

            JOptionPane.showMessageDialog(null, "Username already exists, try another name!");
            return;
        }

        boolean isUserNameCorrect = Validation.userNameValidator(username);
        if(isUserNameCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter username properly: only alphabets and numbers allowed!");
            return;
        }
        boolean isValid=Validation.emailValidator(uEmail);
        if(isValid == false){
            JOptionPane.showMessageDialog(null, "Enter email correctly");
            return;
        }
        boolean isPasswordCorrect = Validation.passwordValidator(password);
        if(isPasswordCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter password properly!");
            return;
        }
        boolean isNameCorrect = Validation.validateString(name);
        if(isNameCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter name properly!");
            return;
        }

        if(!phoneNumberValidity(phoneNumberTxt.getText())){
            JOptionPane.showMessageDialog(null, "Phone number is incorrect, only 10 digits no prefix");
            return;
        }

        Employee employee = enterprise.getEmpDirectory().createEmployee(name);
        employee.setRole("Head Role");
        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
        populateTable();
        //send email and sms

        String contact = "";

        if (contactCarrier.getSelectedItem().equals("ATT")) {
            contact = phoneNumberTxt.getText() + "@txt.att.net";
        } else if (contactCarrier.getSelectedItem().equals("Verizon")) {
            contact = phoneNumberTxt.getText() + "@vmobl.com";
        } else if (contactCarrier.getSelectedItem().equals("Sprint")) {
            contact = phoneNumberTxt.getText() + "@messaging.sprintpcs.com";
        } else if (contactCarrier.getSelectedItem().equals("TMobile")) {
            contact = phoneNumberTxt.getText() + "@tmomail.net";
        }
        sendEmailMessage(uEmail, account);
        sendTextMessage(contact);

        JOptionPane.showMessageDialog(null, "User added successfully");
        DB4OUtil.getInstance().storeSystem(system);
        
        nameJTextField.setText("");
        passwordJPasswordField.setText("");
        uEmailTxt.setText("");
        usernameJTextField.setText("");
        phoneNumberTxt.setText("");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void passwordJPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJPasswordFieldActionPerformed
public Boolean phoneNumberValidity(String customerContact) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(customerContact);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox contactCarrier;
    private javax.swing.JComboBox enterpriseComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField uEmailTxt;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
