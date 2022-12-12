/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.Role.Nurse;
import Business.Role.Role;
import java.util.ArrayList;
import Business.Bed.BedDirectory;

/**
 *
 * @author harshita
 */
public class BedManagementDepartment extends Organization {

    private BedDirectory list;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BedDirectory getList() {
        return list;
    }

    public void setList(BedDirectory list) {

        this.list = list;
    }

    public BedDirectory createBedList(int count) {
        this.list = new BedDirectory(count);
        this.count = count * 2;
        return list;
    }

    public void addBedInBedList(int count) {
        this.list.addBeds(count);
    }

    public BedManagementDepartment() {
        super(Organization.Type.BedManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Nurse());
        return roles;
    }

}
