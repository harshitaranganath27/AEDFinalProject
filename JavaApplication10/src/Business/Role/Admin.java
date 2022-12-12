/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Org.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Administrator.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author harshita
 */
public class Admin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise, account, organization, business);
    }

    @Override
    public String roleValue()
    {
        return "Admin Role";
    }

   
    
}
