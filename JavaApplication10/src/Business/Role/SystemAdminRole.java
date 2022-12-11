/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.SysAdminWorkArea.SysAdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author harshita
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,
            Enterprise enterprise, EcoSystem system) {
        return new SysAdminWorkArea(userProcessContainer, system);
    }
    
    @Override
    public String roleValue()
    {
        return "Sys Admin Role";
    }
}
