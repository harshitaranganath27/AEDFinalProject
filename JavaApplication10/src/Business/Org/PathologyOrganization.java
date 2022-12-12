/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.Role.LabTechRole;
import Business.Role.Receptionist;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class PathologyOrganization extends Organization {

    public PathologyOrganization() {
        super(Organization.Type.Pathology.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabTechRole());
        roles.add(new Receptionist());
        return roles;
    }

}
