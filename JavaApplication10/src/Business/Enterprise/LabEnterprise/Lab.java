/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.LabEnterprise;

import Business.Department.Receptionist;
import Business.Enterprise.Enterprise;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class Lab extends Enterprise {

    int id;
    PatientDirectory patientList;
    Receptionist receptionist;
    LabTechnicianDirectory labTechnicianList;
    
    //String enterpriseType;
    public Lab(String name){
        super(name,Enterprise.EnterpriseType.Lab);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
