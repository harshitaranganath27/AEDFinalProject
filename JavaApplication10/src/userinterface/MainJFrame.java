/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import userinterface.PatientLogin.CreateNewPatientSelfJPanel;

/**
 *
 * @author 
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    static boolean maximized = true;
    static ImageIcon ii;

    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1300, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPasswordField = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        close = new javax.swing.JLabel();
        maximizer = new javax.swing.JLabel();
        SideSubHeading = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        kGradientPanel1 = new userinterface.KGradientPanel();
        lblHero = new javax.swing.JLabel();
        lblHeroHeading = new javax.swing.JLabel();
        lblHeroSubHeading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setDividerLocation(200);

        jPanel1.setBackground(new java.awt.Color(137, 207, 225));
        jPanel1.setToolTipText("");
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(153, 51, 0));
        btnLogin.setFont(new java.awt.Font("Cochin", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 140, 35));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(255, 255, 255)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 160, 30));

        txtPasswordField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 160, 30));

        lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("User Name:");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));
        jPanel1.add(loginJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 210, -1, -1));

        btnLogout.setFont(new java.awt.Font("Cochin", 1, 12)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 140, 35));

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 29, 28));

        maximizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximize.png"))); // NOI18N
        maximizer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizerMouseClicked(evt);
            }
        });
        jPanel1.add(maximizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 13, 29, 28));

        SideSubHeading.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SideSubHeading.setForeground(new java.awt.Color(255, 255, 255));
        SideSubHeading.setText("Please Login!");
        jPanel1.add(SideSubHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 40));

        btnRegister.setFont(new java.awt.Font("Cochin", 1, 12)); // NOI18N
        btnRegister.setText("REGISTER");
        btnRegister.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 35));

        jSplitPane1.setLeftComponent(jPanel1);

        container.setBackground(new java.awt.Color(161, 237, 246));
        container.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                containerMouseDragged(evt);
            }
        });
        container.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                containerMousePressed(evt);
            }
        });
        container.setLayout(new java.awt.CardLayout());

        lblHero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/herobg.jpeg"))); // NOI18N

        lblHeroHeading.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblHeroHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeroHeading.setText("Effective Health Care");

        lblHeroSubHeading.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblHeroSubHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeroSubHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeroSubHeading.setText("Exceptional Care Close to You.");
        lblHeroSubHeading.setToolTipText("");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(lblHero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHeroSubHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeroHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblHeroHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHeroSubHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(lblHero, javax.swing.GroupLayout.PREFERRED_SIZE, 523, Short.MAX_VALUE)
                .addGap(67, 67, 67))
        );

        container.add(kGradientPanel1, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Get user name
        String userName = txtUsername.getText();
        // Get Password
        char[] passwordCharArray = txtPasswordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);

        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network assignedNetwork = null;
        if (userAccount == null) {
            //Step 2: Go inside each network and check each enterprise
            for (Network network : system.getNetworkList()) {
                //Step 2.a: check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {
                        //Step 3:check against each organization for each enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                assignedNetwork = network;
                                break;
                            }
                        }

                    } else {
                        inEnterprise = enterprise;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system));
            //System.out.println("In network-> "+ assignedNetwork.getName());
            layout.next(container);
        }

        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        txtUsername.setEnabled(false);
        txtPasswordField.setEnabled(false);
        btnRegister.setEnabled(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        btnLogout.setEnabled(false);
        txtUsername.setEnabled(true);
        txtPasswordField.setEnabled(true);
        btnLogin.setEnabled(true);

        btnRegister.setEnabled(true);
        txtUsername.setText("");
        txtPasswordField.setText("");

        container.removeAll();
        //JPanel blankJP = new JPanel();
        //KGradientPanel blankJP = new KGradientPanel();
        container.add("blank", kGradientPanel1);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
//        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void maximizerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizerMouseClicked
        // TODO add your handling code here:

//        if (maximized) {
//            //handle fullscreen - taskbar
//            MainJFrame.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            MainJFrame.this.setMaximizedBounds(env.getMaximumWindowBounds());
//            ii = new ImageIcon(getClass().getResource("minimize.png"));
//            maximizer.setIcon(ii);
//            maximized = false;
//        } else {
//
//            setExtendedState(JFrame.NORMAL);
//            ii = new ImageIcon(getClass().getResource("maximize.png"));
//            maximizer.setIcon(ii);
//            maximized = true;
//        }
    }//GEN-LAST:event_maximizerMouseClicked
    int xy;
    int xx;
    //private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {                                     
    // TODO add your handling code here:

    //}  
    private void containerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_containerMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_containerMousePressed

    private void containerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_containerMouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_containerMouseDragged
    int xy1;
    int xx1;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

        xx1 = evt.getX();
        xy1 = evt.getY();


    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx1, y - xy1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        btnRegister.setEnabled(true);
        btnLogin.setEnabled(true);
        btnLogout.setEnabled(false);
        txtUsername.setEnabled(true);
        txtPasswordField.setEnabled(true);
        // registerBtn.setEnabled(false);
        CardLayout layout = (CardLayout) container.getLayout();
        container.add(new CreateNewPatientSelfJPanel(container, dB4OUtil, system));
        // container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system));
        //System.out.println("In network-> "+ assignedNetwork.getName());
        layout.next(container);


    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SideSubHeading;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel close;
    private javax.swing.JPanel container;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private userinterface.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblHero;
    private javax.swing.JLabel lblHeroHeading;
    private javax.swing.JLabel lblHeroSubHeading;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JLabel maximizer;
    private javax.swing.JPasswordField txtPasswordField;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
