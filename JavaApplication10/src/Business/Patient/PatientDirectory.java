/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Enterprise.Insurance.Insurance;
import Business.Location.Location;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshita
 */
public class PatientDirectory {
    private List<Patients> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<>();
    }
    
    

    public List<Patients> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patients> patientList) {
        this.patientList = patientList;
    }
    
    

    public Patients createPatient(String patientName, String phoneNumber, String gender, String bloodGroup, UserAccount userAccount, Location locationPoint, String email,
            Insurance insuranceE, String insuranceId, String SSN) {
        Patients patient = new Patients();
        patient.setEmpName(patientName);
        patient.setPhoneNumber(phoneNumber);
        patient.setPatientSex(gender);
        //patient.setAddress(address);
        patient.setBloodGroup(bloodGroup);
        patient.setUserAccount(userAccount);
        patient.setAddress(locationPoint);
        patient.setRole("Patient Role");
        patient.setEmailID(email);
        patientList.add(patient);
        patient.createNewAppointmentDirectory();
        patient.setInsuranceId(insuranceId);
        patient.setInsuranceE(insuranceE);
        patient.setSSN(SSN);
        return patient;
    }

    public void updatePatient(int patientID, String name, String phoneNumber, String gender, String bloodGroup, Location locationPoint, String email) {
        for(Patients patient : patientList){
            if(patient.getId() == patientID){
                patient.setEmpName(name);
                patient.setAddress(locationPoint);
                patient.setPatientSex(gender);
                patient.setPhoneNumber(phoneNumber);
                patient.setBloodGroup(bloodGroup);
                patient.setEmailID(name);
            }
        }
    }
    
    
    public Patients findPatientById(int patientId){
        for(Patients patient : patientList){
            if(patient.getId() == patientId){
                return patient;
            }
        }
        return null;
    }
    
    
    public Patients findPatientBySSN(String ssn){
        for(Patients patient : patientList){
            if(patient.getSSN().equals(ssn)){
                return patient;
            }
        }
        return null;
    }
    
}
