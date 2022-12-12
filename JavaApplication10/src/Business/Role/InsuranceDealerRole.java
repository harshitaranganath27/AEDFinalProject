/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Insurance.InsuranceDMainAreaJPanel;

/**
 *
 * @author harshita
 */
public class InsuranceDealerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new InsuranceDMainAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    //return new DoctorWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
    
    }
    
    @Override
    public String roleValue()
    {
        return "Insurance Dealer Role";
    }
    
}
