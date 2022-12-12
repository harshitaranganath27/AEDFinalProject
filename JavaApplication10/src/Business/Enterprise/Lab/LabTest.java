/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Lab;

import Business.Employee.Employee;
import Business.Patient.Patients;
import java.util.Date;

/**
 *
 * @author harshita
 */
public class LabTest {
    int id;
    String name;
    String type;
    double charge;
    Date createdOn;
    String status;
    Employee doctor;
    Employee labTech;
    private Patients patient;
    private Lab lab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Employee getLabTech() {
        return labTech;
    }

    public void setLabTech(Employee labTech) {
        this.labTech = labTech;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
    
    
    @Override
    public String toString(){
        return this.getName();
    }
    
    
}
