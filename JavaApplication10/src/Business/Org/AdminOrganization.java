/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        return roles;
    }
     
}
