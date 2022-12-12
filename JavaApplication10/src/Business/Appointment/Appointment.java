/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.TotalBill.Bill;
import Business.Employee.Employee;
import Business.Enterprise.Lab.LabTestDirectory;
import Business.Enterprise.Pharmacy.Pharmacy;
import Business.Operation.Operation;
import Business.Patient.Patients;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Harshita
 */
public class Appointment {
    int appntmentID;
    String type;
    Date date;
    Employee doc;
    Patients patient;
    String status;
    String location;
    private Operation operation;
    LabTestDirectory labTestList;
    Prescription prescrption;
    Integer time;
    Bill billObj;

    public Bill getBillObj() {
        return billObj;
    }

    public void setBillObj(Bill bill) {
        this.billObj = bill;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
    String appoitmentHistory;

    public String getAppoitmentHistory() {
        return appoitmentHistory;
    }

    public void setAppoitmentHistory(String appoitmentHistory) {
        this.appoitmentHistory = appoitmentHistory;
    }

    Pharmacy pharmacy;


    public Prescription getPrescrption() {
        return prescrption;
    }

    public LabTestDirectory getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(LabTestDirectory labTestList) {
        this.labTestList = labTestList;
    }

    public void setPrescrption(Prescription prescrption) {
        this.prescrption = prescrption;
    }
    
    public Appointment(int count){
        this.appntmentID = count;
        prescrption= new Prescription();
        labTestList = new LabTestDirectory();
        appoitmentHistory="";
    }

    public int getAppntmentID() {
        return appntmentID;
    }

    public void setAppntmentID(int appntmentID) {
        this.appntmentID = appntmentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getDoc() {
        return doc;
    }

    public void setDoc(Employee doc) {
        this.doc = doc;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status =  status; //this.status + ", " +
        this.appoitmentHistory += " "+ this.status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    

   
    
    
    @Override
    public String toString()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(this.date); 
        //new SimpleDateFormat("yyyy-MM-dd").format(this.date);
        return strDate;
    }
    
    
   // Appointment-> New, markforbilling, markforsurgery, markforTest, close
    
    public enum AppointmentStatus{
        New("New"),
        Markforbilling("Mark for billing"),
        Markforsurgery("Mark for Surgery"),
        MarkforTest("Mark for Test"),
        Close("Close"),
        AnalyseReport("Analyse Report"),
        Cancel("Cancel"),
        GeneratedReport("Generated Report"),
        MarkForInsurance("Mark For Insurance"),
        BedAssigned("Bed Assigned"),
        ApprovedInsurance("ApprovedInsurance"),
        DisapprovedInsurance("DisapprovedInsurance");
        private String value;
        private AppointmentStatus(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
