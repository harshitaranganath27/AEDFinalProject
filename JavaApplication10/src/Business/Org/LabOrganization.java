/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

//import Business.Role.LabTechnicianRole;
//import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class LabOrganization extends Organization
{
    
    public LabOrganization() {
        super(Organization.Type.Lab.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        //roles.add(new LabTechnicianRole());
        //roles.add(new ReceptionistRole());
        return roles;
    }
     
   
    
    
}
