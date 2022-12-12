/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;


import Business.Employee.Employee;
import Business.Enterprise.Lab.LabTestDirectory;
import Business.Enterprise.Pharmacy.Pharmacy;
import Business.Medicine.Medicine;
import Business.Patient.Patient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Harshita
 */
public class Prescription {
    LabTestDirectory labTestList;
    Map<Medicine, Double> medsPrescribed;
    Map<Medicine, Integer> medsList;
    private Pharmacy pharmacy;
    private String status;
    private double amt;

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    private Date createdOn;
    Employee doctor;
    Patient patient;
    private String history;

    public Prescription() {
        this.createdOn = new Date();
        medsPrescribed = new HashMap<>();
        medsList = new HashMap<>();
    }

    
    public LabTestDirectory getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(LabTestDirectory labTestList) {
        this.labTestList = labTestList;
    }

    public Map<Medicine, Double> getMedsPrescribed() {
        return medsPrescribed;
    }

    public void setMedsPrescribed(Map<Medicine, Double> medsPrescribed) {
        this.medsPrescribed = medsPrescribed;
    }

    public Map<Medicine, Integer> getMedsList() {
        return medsList;
    }

    public void setMedsList(Map<Medicine, Integer> medsList) {
        this.medsList = medsList;
    }

    

    public Date getCreatedOn() {
        return createdOn;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    
    
    
    
}
