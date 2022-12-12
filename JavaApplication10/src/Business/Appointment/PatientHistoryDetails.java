/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Patient.Patients;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author 
 */
public class PatientHistoryDetails {
    private String allergies;
    private Patients patientObj;
    private String prevDiagnosis;
    private Person personObj;
    private Date createdOn;
    private String surgeryHistory;
    private String familyHistory;
    private String allergy;
    private int id;
    private static int count=10;
    
    public int getId() {
        return id;
    }

    
    public PatientHistoryDetails()
    {
        this.id = id + ++count;
    }
    
    @Override 
    public String toString(){
        return String.valueOf(this.id);
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getSurgeryHistory() {
        return surgeryHistory;
    }

    public void setSurgeryHistory(String surgeryHistory) {
        this.surgeryHistory = surgeryHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Patients getPatientObj() {
        return patientObj;
    }

    public void setPatientObj(Patients patientObj) {
        this.patientObj = patientObj;
    }

    public String getPrevDiagnosis() {
        return prevDiagnosis;
    }

    public void setPrevDiagnosis(String prevDiagnosis) {
        this.prevDiagnosis = prevDiagnosis;
    }

    public Person getPersonObj() {
        return personObj;
    }

    public void setPersonObj(Person personObj) {
        this.personObj = personObj;
    }
}
