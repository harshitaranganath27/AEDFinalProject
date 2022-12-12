/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.UserAccount.UserAccount;
import userinterface.PharmacyWorker.PharmacyManageAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author harshita
 */
public class PharmacyEmp extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PharmacyManageAreaJPanel( userProcessContainer,account,organization,  enterprise ,business);
        
    }
    
    @Override
    public String roleValue()
    {
        return "Pharmacy Worker Role";
    }
    
}
