/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Patient.Patients;

/**
 *
 * @author harshita
 */
public class NurseWorkRequest extends WorkRequest{
    /* 
    inherited->
    private String message;
    private UserAccount sender;--> from doctor
    private UserAccount receiver; -->> to nurse
    private String status;  -> new, schduled, on-going, success
    private Date requestDate;
    private Date resolveDate;
    */
    private Appointment appointment;    
    //private Operation operation;
    private Patients patient;

        
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    
    
    
}
