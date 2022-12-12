/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.Appointment.Appointment;
import Business.TotalBill.Bill;
import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author harshita
 */
public class BillingDepartment extends Organization{
    String billingId;
    String billIssuer;
    Patient patient;
    Employee doctor;
    Appointment apptment;
    Bill bill;
    String paymntStatus;
    String paymntMode;

    public BillingDepartment() {
      super(Organization.Type.Billing.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ReceptionistRole());
        return roles;
    }
   Bill processBilling(Date date){
      
       return bill;
   }
   
   public void generateInvoice(Date date, Patient patient){
       //generate invoice
   }
    
   public void selectPaymentMode(){
    //choose a payment mode
   }
}
