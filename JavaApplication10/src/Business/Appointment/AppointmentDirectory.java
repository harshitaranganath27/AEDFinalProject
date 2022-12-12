/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Employee.Employee;
import Business.Patient.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Harshita
 */
public class AppointmentDirectory {
    private int count = 11;
    List<Appointment> apptmentList;
    List<Prescription> prescrptionList;
    List<PatientHistoryDetails> patHistoryList;

    public AppointmentDirectory(){
        apptmentList = new ArrayList<>();
        prescrptionList = new ArrayList<>();
        patHistoryList = new ArrayList<>();
        
    }
    
    
    public List<Appointment> getApptmentList() {
        return apptmentList;
    }

    public void setApptmentList(List<Appointment> apptmentList) {
        this.apptmentList = apptmentList;
    }

    public List<Prescription> getPrescrptionList() {
        return prescrptionList;
    }

    public void setPrescrptionList(List<Prescription> prescrptionList) {
        this.prescrptionList = prescrptionList;
    }

    public List<PatientHistoryDetails> getPatHistoryList() {
        return patHistoryList;
    }

    public void setPatHistoryList(List<PatientHistoryDetails> patHistoryList) {
        this.patHistoryList = patHistoryList;
    }
    
    
    //update appointment
    
    void updateAppointment(Appointment app){
        
    }
    
    
    //cancel appointment
    void cancelAppointment(Appointment app){
        apptmentList.remove(app);
    }
    
    //search Appointment by patient and date
    Appointment searchAppointment(Patient patient, Date date){
        Appointment app= null;
        
        
        
        
        return app;
    }
    
    
    //Return List of Appointments by patient
    List<Appointment> searchAppointment(Patient patient){
        List<Appointment> app= null;
        
        
        
        
        return app;
    }

    public Appointment createAppointment(Patient patient, Employee doctor, Date appointmetDate, String appointmentType) { 
        Appointment appointment = new Appointment(count++);
        appointment.setDate(appointmetDate);
        appointment.setDoc(doctor);
        appointment.setType(appointmentType);
        appointment.setPatient(patient);
        appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
        patient.getAppointmentDirectory().getApptmentList().add(appointment);
       return appointment;
    }
    
    public Appointment createLabAppointment(Patient patient, Employee doctor, Date appointmetDate, String appointmentType) { 
        Appointment appointment = new Appointment(count++);
        appointment.setDate(appointmetDate);
        appointment.setDoc(doctor);
        appointment.setType(appointmentType);
        appointment.setPatient(patient);
        appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
        patient.getLabAppointmentDirectory().getApptmentList().add(appointment);
       return appointment;
    }
    
    public Prescription addPrescription(){
        Prescription prescription = new Prescription();
        prescrptionList.add(prescription);
        return prescription;
    }
    
    public AppointmentDirectory createNewAPPDir()
    {
            AppointmentDirectory appointmentDirectory = new AppointmentDirectory();
            //List<Appointment> apptmentList = new ArrayList<Appointment>();
            //appointmentDirectory.setAppointmentList(apptmentList);
            return appointmentDirectory;
    }
}
