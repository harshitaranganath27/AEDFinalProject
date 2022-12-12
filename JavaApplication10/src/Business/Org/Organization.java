/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;

import Business.TotalBill.Bill;
import Business.TotalBill.BillDirectory;
import Business.Employee.Employee;
import Business.Employee.PersonDirectory;
import Business.Patient.Patients;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public abstract class Organization {

    private String name;
    private String location;
    private WorkQueue workQueue;
    private PersonDirectory empDirectory;
    private UserAccountDirectory userAccountDirectory;
    private PatientDirectory patientDirectory;
    private BillDirectory billDirectory;
    private int orgID;
    private static int counter = 1;

    public enum Type {
        Admin("Admin"),
        Dental("Dental Department"),
        ENT("ENT Department"),
        CovidCenter("Covid-19 Treatment Department"),
        MedicalStore("Medical Store Department"),
        BedManagement("Bed Management Department"),
        Pathology("Pathology Department"),
        Radiology("Radiology Department"),
        UrgentCare("Urgent Care Department"),
        Cardiology("Cardiology Department"),
        Billing("Billing Department"),
        Lab("Lab"),
        Insurance("Insurance"),
        Other("Other Department");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        empDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        patientDirectory = new PatientDirectory();
        if (patientDirectory.getPatientList() == null) {
            patientDirectory.setPatientList(new ArrayList<Patients>());
        }
        billDirectory = new BillDirectory();
        if (billDirectory.getBillList() == null) {
            billDirectory.setBillList(new ArrayList<Bill>());
        }
        orgID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrgID() {
        return orgID;
    }

    public PersonDirectory getEmpDirectory() {
        return empDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public BillDirectory getBillDirectory() {
        return billDirectory;
    }

    public void setBillDirectory(BillDirectory billDirectory) {
        this.billDirectory = billDirectory;
    }

    @Override
    public String toString() {
        return name;
    }

    public void removeAllUserAccount() {
        for (UserAccount ua : userAccountDirectory.getUserAccountList()) {
            this.userAccountDirectory.removeUserAccount(ua);
        }

    }

    public void removeAllEmployee() {
        for (Employee ua : empDirectory.getEmployeeList()) {
            this.empDirectory.removeEmployee(ua);
        }
    }

}
