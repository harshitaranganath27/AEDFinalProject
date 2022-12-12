/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Org;
import Business.Org.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
public class organizationDir {
    
    private ArrayList<Organization> orgList;

    public organizationDir() {
        orgList = new ArrayList();
    }

    public ArrayList<Organization> getOrgList() {
        return orgList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Dental.getValue())){
            organization = new GeneralOrg(Type.Dental.getValue());
            orgList.add(organization);
        }
        else if (type.getValue().equals(Type.Pathology.getValue())){
            organization = new PathologyOrganization();
            orgList.add(organization);
        }
        else if (type.getValue().equals(Type.Billing.getValue())){
            organization = new BillingDepartment();
            orgList.add(organization);
        }
        else if (type.getValue().equals(Type.BedManagement.getValue())){
            organization = new BedManagementDepartment();
            orgList.add(organization);
        }
        else if (type.getValue().equals(Type.Cardiology.getValue())){
            organization = new GeneralOrg(Type.Cardiology.getValue());
            orgList.add(organization);    
        }    
        else if (type.getValue().equals(Type.ENT.getValue())){
            organization = new GeneralOrg(Type.ENT.getValue());
            orgList.add(organization);   
        }
        else if (type.getValue().equals(Type.CovidCenter.getValue())){
            organization = new GeneralOrg(Type.CovidCenter.getValue());
            orgList.add(organization);   
        }
        else if (type.getValue().equals(Type.UrgentCare.getValue())){
            organization = new GeneralOrg(Type.UrgentCare.getValue());
            orgList.add(organization);   
        }
        else if (type.getValue().equals(Type.Radiology.getValue())){
            organization = new RadiologyOrganization();
            orgList.add(organization);   
        }
        else if (type.getValue().equals(Type.MedicalStore.getValue())){
            organization = new MedicalStoreDept();
            orgList.add(organization);   
        }
        
        else if (type.getValue().equals(Type.Insurance.getValue())){
            organization = new InsuranceOrg();
            orgList.add(organization);
        }

        return organization;
    }
}