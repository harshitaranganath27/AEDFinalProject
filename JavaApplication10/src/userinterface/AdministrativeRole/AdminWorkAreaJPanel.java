

package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BedManagementDepartment;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount account;
    Organization organization;
    EcoSystem system;
    /** Creates new form AdminWorkAreaJPanel */
    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise,UserAccount account, Organization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = organization;
        this.system = system;
        lblEnterprise.setText(enterprise.getName());
        jLabel5.setText("Welcome " + account.getEmployee().getName());
        String enterpriseType= enterprise.getEnterpriseType().toString();
        if(enterpriseType.equals("Hospital"))
        {
            manageBedsBtn.setEnabled(true);
            manageBedsBtn.setVisible(true);
        }
        else{
             manageBedsBtn.setEnabled(false);
             manageBedsBtn.setVisible(false);
        }
        
        
        if(enterpriseType.equals("Pharmacy"))
        {            
            manageInventoryBtn.setVisible(true);
            manageInventoryBtn.setEnabled(true);
        }
        else{
            manageInventoryBtn.setVisible(false);
            manageInventoryBtn.setEnabled(false);
        }
        
        if(enterpriseType.equals("Hospital"))
        {        
        lblEnterpriseImage.setIcon(new ImageIcon("src/icon/hospital.png"));
        }
        else if(enterpriseType.equals("Pharmacy"))
        {        
        lblEnterpriseImage.setIcon(new ImageIcon("src/icon/pharm1.png"));
        }
        else if(enterpriseType.equals("Lab"))
        {        
        lblEnterpriseImage.setIcon(new ImageIcon("src/icon/laboratory.jpg"));
        }   
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEnterprise = new javax.swing.JLabel();
        manageBedsBtn = new javax.swing.JButton();
        manageInventoryBtn = new javax.swing.JButton();
        manageDeptBtn = new javax.swing.JButton();
        manageStaffBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnterprise.setBackground(new java.awt.Color(153, 153, 0));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(0, 51, 255));
        lblEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnterprise.setText("Welcome Admin!");
        add(lblEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 280, 30));

        manageBedsBtn.setBackground(new java.awt.Color(0, 51, 255));
        manageBedsBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        manageBedsBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageBedsBtn.setText("Manage Bed");
        manageBedsBtn.setEnabled(false);
        manageBedsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBedsBtnActionPerformed(evt);
            }
        });
        add(manageBedsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 200, 140));

        manageInventoryBtn.setBackground(new java.awt.Color(0, 51, 255));
        manageInventoryBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        manageInventoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageInventoryBtn.setText("Manage Inventory");
        manageInventoryBtn.setEnabled(false);
        manageInventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageInventoryBtnActionPerformed(evt);
            }
        });
        add(manageInventoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 200, 140));

        manageDeptBtn.setBackground(new java.awt.Color(0, 51, 255));
        manageDeptBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        manageDeptBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageDeptBtn.setText("Manage Department");
        manageDeptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDeptBtnActionPerformed(evt);
            }
        });
        add(manageDeptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 200, 140));

        manageStaffBtn.setBackground(new java.awt.Color(0, 51, 255));
        manageStaffBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        manageStaffBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageStaffBtn.setText("Manage Staff");
        manageStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStaffBtnActionPerformed(evt);
            }
        });
        add(manageStaffBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 200, 140));

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void manageInventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageInventoryBtnActionPerformed

        ManageMedicinesJPanel manageEmployeeJPanel = new ManageMedicinesJPanel(userProcessContainer, enterprise.getOrganizationDirectory(), enterprise);
        userProcessContainer.add("ManageMedicinesJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_manageInventoryBtnActionPerformed

    private void manageBedsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBedsBtnActionPerformed
        // TODO add your handling code here:
        //check if bed management department is created or not
        boolean flag=false;
        BedManagementDepartment bedOrg=null;
        OrganizationDirectory orgDir = enterprise.getOrganizationDirectory();
        for(Organization org : orgDir.getOrganizationList() ){
            if(org.getName().equals(Organization.Type.BedManagement.getValue()))
            {
                //if bed management departemtn is present then navigate to bed management screen
                flag = true;
                bedOrg = (BedManagementDepartment)org;
            }
        }
        
        if(flag == true){
        ManageBedJPanel manageOrganizationJPanel = new ManageBedJPanel(userProcessContainer, 
                orgDir, organization, bedOrg, enterprise,system);
        userProcessContainer.add("ManageBedJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "No Bed Management department, please create one!");
            return;

        }
    }//GEN-LAST:event_manageBedsBtnActionPerformed

    private void manageStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStaffBtnActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageStaffBtnActionPerformed

    private void manageDeptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDeptBtnActionPerformed

        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(), enterprise, system);
        userProcessContainer.add("ManageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageDeptBtnActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JButton manageBedsBtn;
    private javax.swing.JButton manageDeptBtn;
    private javax.swing.JButton manageInventoryBtn;
    private javax.swing.JButton manageStaffBtn;
    // End of variables declaration//GEN-END:variables
    
}
