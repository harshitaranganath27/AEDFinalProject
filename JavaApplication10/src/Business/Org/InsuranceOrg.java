/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

//import Business.Role.InsuranceDealerRole;

import Business.Role.InsuranceDealerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class InsuranceOrg extends Organization
{
     

    public InsuranceOrg() {
       // super(Organization.Type.Dental.getValue());
       super(Organization.Type.Insurance.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsuranceDealerRole());
        return roles;
}
    
}
