/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.Role.Doctor;
import Business.Role.Nurse;
import Business.Role.Receptionist;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class GeneralOrg extends Organization {

    public GeneralOrg(String type) {
        super(type);
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Doctor());
        roles.add(new Nurse());
        roles.add(new Receptionist());
        return roles;
    }

}
