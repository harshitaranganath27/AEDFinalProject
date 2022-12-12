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
import userinterface.Nurse.NurseWorkAreaJPanel;


/**
 *
 * @author harshita
 */
public class NurseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new NurseWorkAreaJPanel(userProcessContainer, enterprise, account);
    }
    
    @Override
    public String roleValue()
    {
        return "Nurse Role";
    }
}
