/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Administrator;

import Business.Bed.Bed;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Org.BedManagementDepartment;
import Business.Org.Organization;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author 
 */
public class TotalBedCountGraph extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    EcoSystem system;
    JFreeChart barChart;
   
    Network selectedNetwork;
//    /**
//     * Creates new form ViewScenesGraph
//     */
    public TotalBedCountGraph(JPanel userProcessContainer, EcoSystem system, Network selectedNetwork) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.selectedNetwork= selectedNetwork;
        jLabel6.setText("Bed Status Across " + selectedNetwork.getName().toUpperCase());
        populateBarGraph();
        
    }
//    
    public void populateBarGraph() {

        Map<String, Integer> workReqMap = new HashMap<>();
        
        for (Enterprise epr : selectedNetwork.getEntDirectory().getEnterpriseList()) 
        {
            for (Organization org : epr.getOrgDirectory().getOrganizationList()) 
            {
                if (org instanceof BedManagementDepartment) 
                {
                    List<Bed> bedList = ((BedManagementDepartment) org).getBedList().getBedList();
                    for (Bed b : bedList) 
                    {
                        if (b.getStatus().getStatus().equals(Bed.BedStatus.Available.getStatus())) 
                        {
                            workReqMap.put("Available", workReqMap.getOrDefault("Available", 0) + 1);

                        } else if (b.getStatus().getStatus().equals(Bed.BedStatus.Occupied.getStatus())) 
                        {
                            workReqMap.put("Occupied", workReqMap.getOrDefault("Occupied", 0) + 1);

                        }
                        if (b.getStatus().getStatus().equals(Bed.BedStatus.AssignedLaundry.getStatus())) 
                        {
                            workReqMap.put("Laundry", workReqMap.getOrDefault("Laundry", 0) + 1);

                        }
                    }
                }
            }
        }
     
        barChart = ChartFactory.createPieChart(
         "Number of beds Available, Occupied, Laundry",                     
         createDataset(workReqMap),          
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );   
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate(); 
    }
    
    private PieDataset createDataset(Map<String, Integer> workReqMap) {
       
        final DefaultPieDataset dataset = new DefaultPieDataset();  

        for(String r : workReqMap.keySet()) {
            dataset.setValue(r, workReqMap.get(r));
        }               

        return dataset; 
   }
    
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 730, 450));

        jButton1.setBackground(new java.awt.Color(255, 155, 54));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 56, 82));
        jButton1.setText("Download Graph");
        jButton1.setPreferredSize(new java.awt.Dimension(167, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(68, 145, 157));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BEDS STATUS ACROSS ALL NETWORKS");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 594, -1));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int width = 640;    /* Width of the image */
            int height = 480;   /* Height of the image */
            File BarChart = new File( "BedsAcross"+selectedNetwork.getName()+".jpeg" );
            ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
            JOptionPane.showMessageDialog(null, "A JPEG image file named BedsAcross"+selectedNetwork.getName()+".jpeg is downloaded in your current directory.");
        } catch (IOException ex) {
            Logger.getLogger(TotalBedCountGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}