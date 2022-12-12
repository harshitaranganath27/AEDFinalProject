/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Administrator;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.BedManagementDepartment;
import Business.Org.Organization;
import Business.Org.Organization.Type;
import Business.Org.organizationDir;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private organizationDir directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, organizationDir directory, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterprise;
        this.system = system;
        populateTable();
        addDeptJPanel.setVisible(false);

    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();

        if (enterprise.getType().getValue().equals(Enterprise.enterprseType.Pharmacy.getValue())) {
            for (Type type : Organization.Type.values()) {
                if (type.getValue().equals(Type.MedicalStore.getValue())
                        || type.getValue().equals(Type.Billing.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }
        } else if (enterprise.getType().getValue().equals(Enterprise.enterprseType.Lab.getValue())) {
            for (Type type : Organization.Type.values()) {
                if (type.getValue().equals(Type.Billing.getValue())
                        || type.getValue().equals(Type.Pathology.getValue())
                        || type.getValue().equals(Type.Radiology.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }

        } else if (enterprise.getType().getValue().equals(Enterprise.enterprseType.Insurance.getValue())) {
            for (Type type : Organization.Type.values()) {
                if (type.getValue().equals(Type.Insurance.getValue())
                        || type.getValue().equals(Type.Billing.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }

        } else {
            for (Type type : Organization.Type.values()) {
                if (!type.getValue().equals(Type.Admin.getValue())
                        && !type.getValue().equals(Type.Lab.getValue())
                        && !type.getValue().equals(Type.Pathology.getValue())
                        && !type.getValue().equals(Type.Radiology.getValue())
                        && !type.getValue().equals(Type.MedicalStore.getValue())
                        && !type.getValue().equals(Type.Insurance.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization;//.getName();

            model.addRow(row);
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
        organizationJTable = new javax.swing.JTable();
        addDeptJPanel = new javax.swing.JPanel();
        closebtn = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblNumofBeds = new javax.swing.JLabel();
        cmbBedNUmber = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        addDeptShowJpanelBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        deletBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setBackground(new java.awt.Color(153, 204, 255));
        organizationJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        organizationJTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        organizationJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, 148));

        addDeptJPanel.setBackground(new java.awt.Color(255, 255, 255));
        addDeptJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add Department", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(68, 145, 157))); // NOI18N
        addDeptJPanel.setToolTipText("");
        addDeptJPanel.setAutoscrolls(true);
        addDeptJPanel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        closebtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        addJButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addJButton.setText("Add Department");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Department Type ");

        lblNumofBeds.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNumofBeds.setText("Number of Beds");

        cmbBedNUmber.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbBedNUmber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "15", "20", "30", "40", "50", "100", "150", "200", "250", "300" }));

        javax.swing.GroupLayout addDeptJPanelLayout = new javax.swing.GroupLayout(addDeptJPanel);
        addDeptJPanel.setLayout(addDeptJPanelLayout);
        addDeptJPanelLayout.setHorizontalGroup(
            addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDeptJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumofBeds)
                    .addComponent(closebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(organizationJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBedNUmber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDeptJPanelLayout.createSequentialGroup()
                        .addComponent(addJButton)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        addDeptJPanelLayout.setVerticalGroup(
            addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDeptJPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumofBeds)
                    .addComponent(cmbBedNUmber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(addDeptJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closebtn)
                    .addComponent(addJButton))
                .addGap(114, 114, 114))
        );

        add(addDeptJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 350, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addDeptShowJpanelBtn.setBackground(new java.awt.Color(0, 51, 255));
        addDeptShowJpanelBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addDeptShowJpanelBtn.setForeground(new java.awt.Color(255, 255, 255));
        addDeptShowJpanelBtn.setText("Create Department");
        addDeptShowJpanelBtn.setPreferredSize(new java.awt.Dimension(167, 40));
        addDeptShowJpanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeptShowJpanelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addDeptShowJpanelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 200, 150));

        viewBtn.setBackground(new java.awt.Color(0, 51, 255));
        viewBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("View Department");
        viewBtn.setPreferredSize(new java.awt.Dimension(167, 40));
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 200, 150));

        deletBtn.setBackground(new java.awt.Color(0, 51, 255));
        deletBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        deletBtn.setForeground(new java.awt.Color(255, 255, 255));
        deletBtn.setText("Delete Department");
        deletBtn.setPreferredSize(new java.awt.Dimension(167, 40));
        deletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deletBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 200, 150));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Department");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 230, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 820, 80));

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 51, 255));
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 142, 55));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Type type = (Type) organizationJComboBox.getSelectedItem();
        for (Organization org : directory.getOrganizationList()) {
            if (org.getName().equals(type.getValue())) {
                JOptionPane.showMessageDialog(null, "Department already exists, cannot create new!");
                return;

            }
        }

        Organization dept = directory.createOrganization(type);
        if (type.getValue().equals("Bed Management Department")) {
            int selectedBedCount = Integer.parseInt((String) cmbBedNUmber.getSelectedItem());
            BedManagementDepartment bedMngDept = (BedManagementDepartment) dept;
            bedMngDept.createBedList(selectedBedCount);
        }

        JOptionPane.showMessageDialog(null, "Added Successfully");
        DB4OUtil.getInstance().storeSystem(system);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
        Type type = (Type) organizationJComboBox.getSelectedItem();
        if (type != null) {
            if (type.getValue().equals(Type.BedManagement.getValue())) {
                lblNumofBeds.setVisible(true);
                cmbBedNUmber.setVisible(true);
            } else {
                lblNumofBeds.setVisible(false);
                cmbBedNUmber.setVisible(false);
            }
        }

    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewBtnActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        addDeptJPanel.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

    private void addDeptShowJpanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeptShowJpanelBtnActionPerformed
        // TODO add your handling code here:
        addDeptJPanel.setVisible(true);
        lblNumofBeds.setVisible(false);
        cmbBedNUmber.setVisible(false);
        populateCombo();
    }//GEN-LAST:event_addDeptShowJpanelBtnActionPerformed

    private void deletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletBtnActionPerformed
        // TODO add your handling code here:

        int row = organizationJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the department details?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Organization org = (Organization) organizationJTable.getValueAt(row, 1);
            ArrayList<Organization> orgList = enterprise.getOrgDirectory().getOrganizationList();
            org.removeAllUserAccount();
            org.removeAllEmployee();
            orgList.remove(org);
            populateTable();
            JOptionPane.showMessageDialog(null, "Deleted successfully!!");
        }

    }//GEN-LAST:event_deletBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDeptJPanel;
    private javax.swing.JButton addDeptShowJpanelBtn;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton closebtn;
    private javax.swing.JComboBox cmbBedNUmber;
    private javax.swing.JButton deletBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumofBeds;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
