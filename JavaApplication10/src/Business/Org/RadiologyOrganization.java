/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.Role.LabTechRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class RadiologyOrganization extends Organization {

    public RadiologyOrganization() {
        super(Organization.Type.Radiology.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabTechRole());
        roles.add(new ReceptionistRole());
        return roles;
    }

}
