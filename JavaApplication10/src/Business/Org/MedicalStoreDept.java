/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;


import Business.Medicine.MedicineDirectory;
import Business.Appointment.Prescription;
import Business.Role.PharmacyWorkerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class MedicalStoreDept extends Organization {
    MedicineDirectory medicineList;
    String pharmacistName;
    Prescription prescription;

    public MedicalStoreDept() {
        super(Organization.Type.MedicalStore.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PharmacyWorkerRole());
        return roles;
}  
    public void generateBill(Prescription prescription){
       //generates medicine bill
    }
}
