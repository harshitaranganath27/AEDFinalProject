/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.TotalBill.Bill;
import Business.Patient.Patient;

/**
 *
 * @author harshita
 */
public class InsuranceWorkRequest extends WorkRequest{

    private Patient patient;
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
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
