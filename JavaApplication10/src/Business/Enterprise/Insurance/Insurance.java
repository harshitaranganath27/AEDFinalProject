/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Insurance;

import Business.Enterprise.Enterprise;
import Business.Patient.PatientDirectory;
import Business.Department.Receptionist;
import Business.Person.EmpDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class Insurance extends Enterprise {
    int id;
    EmpDirectory doctorList;
    //NurseDirectory nurseList;
    PatientDirectory patientList;
    Receptionist receptionist;
    InsuranceDirectory indir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmpDirectory getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(EmpDirectory doctorList) {
        this.doctorList = doctorList;
    }

    public PatientDirectory getPatientList() {
        return patientList;
    }

    public void setPatientList(PatientDirectory patientList) {
        this.patientList = patientList;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public InsuranceDirectory getIndir() {
        return indir;
    }

    public void setIndir(InsuranceDirectory indir) {
        this.indir = indir;
    }
    
    //String enterpriseType;
    public Insurance(String name){
        super(name,enterprseType.Insurance);
        
        indir= new InsuranceDirectory();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
