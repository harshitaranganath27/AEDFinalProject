package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospEnterprise.Hospital;
import Business.Enterprise.Insurance.Insurance;
import Business.Enterprise.Lab.Lab;
import Business.Enterprise.Pharmacy.Pharmacy;
import Business.Location.Location;
import Business.Org.BedManagementDepartment;
import Business.Org.Organization;
import Business.Patient.Patients;
import Business.Role.Admin;
import Business.Role.Doctor;
import Business.Role.InsurancePersonnel;
import Business.Role.LabTechRole;
import Business.Role.Nurse;
import Business.Role.PatientRole;
import Business.Role.PharmacyEmp;
import Business.Role.Receptionist;
import Business.Role.SysAdmin;
import Business.UserAccount.UserAccount;
import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author harshita
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = new Employee();//system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SysAdmin());
        
        String [] bgs = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        String bg;
        String[] genders = {"Male","Female","Other"};
        String gender;
        
        // Boston Network
        System.err.println("Boston Network");
        system.createAndAddNetwork().setName("Boston");
        
            // Boston Insurance - Enterprise
            System.err.println("Boston Blue Cross Insurance");
            Enterprise Ie = new Insurance("Boston Blue Cross Insurance");
            
                Organization o;
                Employee e1 = new Employee();
                UserAccount u = new UserAccount();
                String ssn;
                String insId;
                
                Faker admFaker = new Faker(Locale.US, new Random(0));
                String firstName = admFaker.name().firstName().replaceAll("'", "");
                String lastName = admFaker.name().lastName().replaceAll("'", "");
                String name = firstName + " " + lastName;
                String username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = Ie.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = Ie.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
            
                System.out.println("Insurance Organization");
                o = Ie.getOrgDirectory().createOrganization(Organization.Type.Insurance);
                    
                    for(int i = 41; i<=45; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        System.out.println("Insurance Dealer: "  + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new InsurancePersonnel()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new InsurancePersonnel());

                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
            System.out.println();
            system.getNetworkList().get(0).getEntDirectory().getEnterpriseList().add(Ie) ;

        
            // Boston Hospital - Enterprise
            System.err.println("Boston BIDMC Hospital");
            Enterprise e = new Hospital("Boston BIDMC Hospital");
                
                // ENT Organization
                admFaker = new Faker(Locale.US, new Random(40));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();

                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
                
                System.out.println("ENT Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.ENT);
                
                for(int i = 1; i<=21; i++) 
                {
                    Faker faker = new Faker(Locale.US, new Random(i));
  
                    //int id = faker.number().numberBetween(1000, 10000);
                    firstName = faker.name().firstName().replaceAll("'", "");
                    lastName = faker.name().lastName().replaceAll("'", "");
                    name = firstName + " " + lastName;
                    username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                    String email = "avinash.raikesh@gmail.com";
                    String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                    //int officeNo = faker.number().numberBetween(1, 999);
                    if(i <=5)
                    {
                        System.out.println("Doctor: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Doctor()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Doctor());
                    }
                    else if(i <= 10)
                    {
                        System.out.println("Nurse: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Nurse()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Nurse());
                    }
                    else if(i == 11)
                    {
                        System.out.println("Receptionist: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Receptionist()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                    }
                    else
                    {
                        
                        bg = bgs[faker.number().numberBetween(0, 8)];
                        gender = genders[faker.number().numberBetween(0, 3)];
                        ssn = String.valueOf(faker.number().numberBetween(123456789l, 999999999l));
                        insId = "BST" + String.valueOf(faker.number().numberBetween(12345678l, 99999999l));
                        System.out.println("Patient: " + username);
                        Location locationPoint = new Location();
                        locationPoint.setStreet(faker.address().streetAddress());
                        locationPoint.setState(faker.address().state());
                        locationPoint.setCity(faker.address().cityName());
                        u = system.getUserAccountDirectory().createUserAccount(username, "Sam123!!", null, new Patients());
                        e1= system.getPatientDirectory().createPatient(name, "8574246269", gender, bg, u, locationPoint, "email",(Insurance)Ie,insId , ssn);
                        e.getPatientDirectory().getPatientList().add((Patients)e1);
                        Ie.getPatientDirectory().getPatientList().add((Patients)e1);
                    }
                    
                    u.setEmployee(e1);
                    e1.setEmailID(email);
                    e1.setPhoneNumber("8574246269");
                    e1.setCarrier("@tmomail.net");
                
                }
                System.out.println();
                
                System.out.println("Cardiology Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.Cardiology);
                
                for(int i = 100; i<=121; i++) 
                {
                    Faker faker = new Faker(Locale.US, new Random(i));
  
                    //int id = faker.number().numberBetween(1000, 10000);
                    firstName = faker.name().firstName().replaceAll("'", "");
                    lastName = faker.name().lastName().replaceAll("'", "");
                    name = firstName + " " + lastName;
                    username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                    String email = "avinash.raikesh@gmail.com";
                    String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                    //int officeNo = faker.number().numberBetween(1, 999);
                    if(i <=105)
                    {
                        System.out.println("Doctor: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Doctor()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Doctor());
                    }
                    else if(i <= 110)
                    {
                        System.out.println("Nurse: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Nurse()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Nurse());
                    }
                    else if(i == 111)
                    {
                        System.out.println("Receptionist: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Receptionist()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                    }
                    else
                    {
                        bg = bgs[faker.number().numberBetween(0, 8)];
                        gender = genders[faker.number().numberBetween(0, 3)];
                        ssn = String.valueOf(faker.number().numberBetween(123456789l, 999999999l));
                        insId = "BST" + String.valueOf(faker.number().numberBetween(12345678l, 99999999l));
                        
                        System.out.println("Patient: " + username);
                        Location locationPoint = new Location();
                        locationPoint.setStreet(faker.address().streetAddress());
                        locationPoint.setState(faker.address().state());
                        locationPoint.setCity(faker.address().cityName());
                        u = system.getUserAccountDirectory().createUserAccount(username, "Sam123!!", null, new Patients());
                        e1= system.getPatientDirectory().createPatient(name, "8574246269", gender, bg, u, locationPoint, email,(Insurance)Ie,insId,ssn);
                        e.getPatientDirectory().getPatientList().add((Patients)e1);
                        Ie.getPatientDirectory().getPatientList().add((Patients)e1);
                    }
                    
                    u.setEmployee(e1);
                    e1.setEmailID(email);
                    e1.setPhoneNumber("8574246269");
                    e1.setCarrier("@tmomail.net");
                }
                
                System.out.println();
                
                System.out.println("BedManagement Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.BedManagement);
                BedManagementDepartment bo = ((BedManagementDepartment)o);
                bo.createBedList(23);
                
                
                System.out.println("Billing Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.Billing);
                //((BillingDepartment)o).generateInvoice(date, patient);
                
         
            system.getNetworkList().get(0).getEntDirectory().getEnterpriseList().add(e) ;
        
        
            // Boston Lab - Enterprise
            System.err.println("Boston EastPac Lab");
            e = new Lab("Boston EastPac Lab");
            
                admFaker = new Faker(Locale.US, new Random(1000));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
                
                    System.out.println("Pathology Organization");
                    o = e.getOrgDirectory().createOrganization(Organization.Type.Pathology);
                    
                    for(int i = 22; i<=26; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        if(i<26)
                        {
                            System.out.println("Lab Technician: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new LabTechRole()).roleValue());
                            e1.setSpecialization(Employee.SpecializationType.Physician);
                            e1.setVisitingCharge(20);
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new LabTechRole());
                        }
                        else
                        {
                            System.out.println("Receptionist: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new Receptionist()).roleValue());
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                        }
                    
                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                        
                        
                    }
                    System.out.println();
                    
                    
                        
                
                    System.out.println("Radiology Organization");
                    o = e.getOrgDirectory().createOrganization(Organization.Type.Radiology);
                    
                    for(int i = 27; i<=32; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        if(i<32)
                        {
                            System.out.println("Lab Technician: "  + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new LabTechRole()).roleValue());
                            e1.setSpecialization(Employee.SpecializationType.Physician);
                            e1.setVisitingCharge(20);
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new LabTechRole());
                        }
                        else
                        {
                            System.out.println("Receptionist: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new Receptionist()).roleValue());
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                        }
                        
                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
                    
                    System.out.println();
        
            system.getNetworkList().get(0).getEntDirectory().getEnterpriseList().add(e) ;
        
            // Boston Pharmacy - Enterprise
            System.err.println("Boston CVS Pharmacy");
            e = new Pharmacy("Boston CVS Pharmacy");
            
                admFaker = new Faker(Locale.US, new Random(33));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
            
                System.out.println("Medical Store Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.MedicalStore);
                    
                    for(int i = 34; i<=39; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        System.out.println("Pharmacy Worker: "  + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new PharmacyEmp()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new PharmacyEmp());

                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
                    
                    System.out.println();
        
            system.getNetworkList().get(0).getEntDirectory().getEnterpriseList().add(e) ;
             
            
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // Seattle Network
        System.err.println("Seattle Network");
        system.createAndAddNetwork().setName("Seattle");
        
            // Seattle Insurance - Enterprise
            System.err.println("Seattle Aetna Insurance");
            Ie = new Insurance("Seattle Aetna Insurance");
            
                admFaker = new Faker(Locale.US, new Random(86));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = Ie.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = Ie.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
            
                System.out.println("Insurance Organization");
                o = Ie.getOrgDirectory().createOrganization(Organization.Type.Insurance);
                    
                    for(int i = 87; i<=92; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        System.out.println("Insurance Dealer: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new InsurancePersonnel()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new InsurancePersonnel());
                    
                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
        
            System.out.println();
            system.getNetworkList().get(1).getEntDirectory().getEnterpriseList().add(Ie) ;
        
            // Boston Hospital - Enterprise
            System.err.println("Seattle Grey-Sloan Hospital");
            e = new Hospital("Seattle Grey-Sloan Hospital");
                
                // Denyal Organization
                
                admFaker = new Faker(Locale.US, new Random(46));
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
                
                System.out.println("Dental Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.Dental);
                
                for(int i = 47; i<=68; i++) 
                {
                    Faker faker = new Faker(Locale.US, new Random(i));
  
                    //int id = faker.number().numberBetween(1000, 10000);
                    firstName = faker.name().firstName().replaceAll("'", "");
                    lastName = faker.name().lastName().replaceAll("'", "");
                    name = firstName + " " + lastName;
                    username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                    String email = "avinash.raikesh@gmail.com";
                    String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                    //int officeNo = faker.number().numberBetween(1, 999);
                    if(i <=52)
                    {
                        System.out.println("Doctor: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Doctor()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Doctor());
                    }
                    else if(i <= 57)
                    {
                        System.out.println("Nurse: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Nurse()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Nurse());
                    }
                    else if(i == 58)
                    {
                        System.out.println("Receptionist: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Receptionist()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                    }
                    else
                    {
                        
                        bg = bgs[faker.number().numberBetween(0, 8)];
                        gender = genders[faker.number().numberBetween(0, 3)];
                        ssn = String.valueOf(faker.number().numberBetween(123456789l, 999999999l));
                        insId = "SEA" + String.valueOf(faker.number().numberBetween(12345678l, 99999999l));
                        
                        System.out.println("Patient: " + username);
                        Location locationPoint = new Location();
                        locationPoint.setStreet(faker.address().streetAddress());
                        locationPoint.setState(faker.address().state());
                        locationPoint.setCity(faker.address().cityName());
                        u = system.getUserAccountDirectory().createUserAccount(username, "Sam123!!", null, new Patients());
                        e1= system.getPatientDirectory().createPatient(name, "8574246269", gender, bg, u, locationPoint, email,(Insurance)Ie, insId , ssn);
                        e.getPatientDirectory().getPatientList().add((Patients)e1);
                        Ie.getPatientDirectory().getPatientList().add((Patients)e1);
                    }
                    
                    u.setEmployee(e1);
                    e1.setEmailID(email);
                    e1.setPhoneNumber("8574246269");
                    e1.setCarrier("@tmomail.net");
                
                }
                
                System.out.println("CovidCenter Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.CovidCenter);
                
                for(int i = 200; i<=221; i++) 
                {
                    Faker faker = new Faker(Locale.US, new Random(i));
  
                    //int id = faker.number().numberBetween(1000, 10000);
                    firstName = faker.name().firstName().replaceAll("'", "");
                    lastName = faker.name().lastName().replaceAll("'", "");
                    name = firstName + " " + lastName;
                    username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                    String email = "avinash.raikesh@gmail.com";
                    String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                    //int officeNo = faker.number().numberBetween(1, 999);
                    if(i <=205)
                    {
                        System.out.println("Doctor: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Doctor()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Doctor());
                    }
                    else if(i <= 210)
                    {
                        System.out.println("Nurse: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Nurse()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Nurse());
                    }
                    else if(i == 211)
                    {
                        System.out.println("Receptionist: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new Receptionist()).roleValue());
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                    }
                    else
                    {
                        bg = bgs[faker.number().numberBetween(0, 8)];
                        gender = genders[faker.number().numberBetween(0, 3)];
                        ssn = String.valueOf(faker.number().numberBetween(123456789l, 999999999l));
                        insId = "SEA" + String.valueOf(faker.number().numberBetween(12345678l, 99999999l));
                        
                        System.out.println("Patient: " + username);
                        Location locationPoint = new Location();
                        locationPoint.setStreet(faker.address().streetAddress());
                        locationPoint.setState(faker.address().state());
                        locationPoint.setCity(faker.address().cityName());
                        u = system.getUserAccountDirectory().createUserAccount(username, "Sam123!!", null, new Patients());
                        e1= system.getPatientDirectory().createPatient(name, "8574246269", gender, bg, u, locationPoint, email,(Insurance)Ie,insId , ssn);
                        e.getPatientDirectory().getPatientList().add((Patients)e1);
                        Ie.getPatientDirectory().getPatientList().add((Patients)e1);
                    }
                    
                    u.setEmployee(e1);
                    e1.setEmailID(email);
                    e1.setPhoneNumber("8574246269");
                    e1.setCarrier("@tmomail.net");
                }
                System.out.println();
                
                System.out.println("BedManagement Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.BedManagement);
                bo = ((BedManagementDepartment)o);
                bo.createBedList(43);
                
                System.out.println();
                System.out.println("Billing Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.Billing);
                
            
            system.getNetworkList().get(1).getEntDirectory().getEnterpriseList().add(e) ;
        
        
            // Seattle Lab - Enterprise
            System.err.println("Seattle WestPac Lab");
            e = new Lab("Seattle WestPac Lab");
            
                admFaker = new Faker(Locale.US, new Random(69));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
                
                    System.out.println("Pathology Organization");
                    o = e.getOrgDirectory().createOrganization(Organization.Type.Pathology);
                    
                    for(int i = 70; i<=74; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                        
                        if(i<74)
                        {
                            System.out.println("Lab Technician: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new LabTechRole()).roleValue());
                            e1.setSpecialization(Employee.SpecializationType.Physician);
                            e1.setVisitingCharge(20);
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new LabTechRole());
                        }
                        else
                        {
                            System.out.println("Receptionist: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new Receptionist()).roleValue());
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                        }

                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
                    System.out.println();
                    
                
                    System.out.println("Radiology Organization");
                    o = e.getOrgDirectory().createOrganization(Organization.Type.Radiology);
                    
                    for(int i = 75; i<=79; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        if(i<79)
                        {
                            System.out.println("Lab Technician: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new LabTechRole()).roleValue());
                            e1.setSpecialization(Employee.SpecializationType.Physician);
                            e1.setVisitingCharge(20);
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new LabTechRole());
                        }
                        else
                        {
                            System.out.println("Receptionist: " + username);
                            e1 =  o.getEmpDirectory().createEmployee(name);
                            e1.setRole((new Receptionist()).roleValue());
                            u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Receptionist());
                        }
                    
                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
            System.out.println();
        
            system.getNetworkList().get(1).getEntDirectory().getEnterpriseList().add(e) ;
        
            // Seattle Pharmacy - Enterprise
            System.err.println("Seattle Walgreens Pharmacy");
            e = new Pharmacy("Seattle Walgreens Pharmacy");
            
                admFaker = new Faker(Locale.US, new Random(80));
                
                firstName = admFaker.name().firstName().replaceAll("'", "");
                lastName = admFaker.name().lastName().replaceAll("'", "");
                name = firstName + " " + lastName;
                username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                
                e1 = e.getEmpDirectory().createEmployee(name);
                e1.setRole("Head Role");
                u = e.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new Admin());
                u.setEmployee(e1);
                System.out.println("Head: " + username);
            
                System.out.println("Medical Store Organization");
                o = e.getOrgDirectory().createOrganization(Organization.Type.MedicalStore);
                    
                    for(int i = 81; i<=85; i++) 
                    {
                        Faker faker = new Faker(Locale.US, new Random(i));
  
                        //int id = faker.number().numberBetween(1000, 10000);
                        firstName = faker.name().firstName().replaceAll("'", "");
                        lastName = faker.name().lastName().replaceAll("'", "");
                        name = firstName + " " + lastName;
                        username = firstName.toLowerCase() + "." + lastName.toLowerCase();
                        String email = "avinash.raikesh@gmail.com";
                        String phone = faker.phoneNumber().phoneNumber().replaceAll("\\(","").replaceAll("\\)","")
                    .   replaceAll(" ","").replaceAll("-","").replaceAll("\\.","").replaceAll("x", "").substring(0, 10);
                        //int officeNo = faker.number().numberBetween(1, 999);
                    
                        System.out.println("Pharmacy Worker: " + username);
                        e1 =  o.getEmpDirectory().createEmployee(name);
                        e1.setRole((new PharmacyEmp()).roleValue());
                        e1.setSpecialization(Employee.SpecializationType.Physician);
                        e1.setVisitingCharge(20);
                        u = o.getUserAccountDirectory().createUserAccount(username, "Sam123!!", employee, new PharmacyEmp());
                        
                        u.setEmployee(e1);
                        e1.setEmailID(email);
                        e1.setPhoneNumber("8574246269");
                        e1.setCarrier("@tmomail.net");
                        
                    }
            System.out.println();
            system.getNetworkList().get(1).getEntDirectory().getEnterpriseList().add(e) ;

        return system;
    }
    
}
