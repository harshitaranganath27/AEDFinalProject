/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.TotalBill.Bill;
import Business.Patient.Patients;

/**
 *
 * @author harshita
 */
public class InsuranceWorkRequest extends WorkRequest{

    private Patients patient;
    private Appointment appointment;
    public Bill getHospitalBill() {
        return hospitalBill;
    }

    public void setHospitalBill(Bill hospitalBill) {
        this.hospitalBill = hospitalBill;
    }
    private String amount;
    private Bill hospitalBill;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    
    
}
