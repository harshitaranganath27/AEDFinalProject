/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Doctor.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author harshita
 */
public class Doctor extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new DoctorWorkAreaJPanel(userProcessContainer,organization, account, enterprise, business);
    //return new DoctorWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
    
    }
    
    @Override
    public String roleValue()
    {
        return "Doctor Role";
    }
    
}
