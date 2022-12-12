/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Org.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LoginPatient.PatientMainWorkAreaJPanel;


/**
 *
 * @author harshita
 */
public class Patient extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PatientMainWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
    }
    
    @Override
    public String roleValue()
    {
        return "Patient Role";
    }
    
    
}
