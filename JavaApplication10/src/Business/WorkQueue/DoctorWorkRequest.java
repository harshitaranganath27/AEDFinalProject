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
public class DoctorWorkRequest extends WorkRequest{

     private Appointment appointment;

    private Patients patient;

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    public DoctorWorkRequest(){
       
    }
    
    
}
