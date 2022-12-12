/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Pharmacy;

import Business.Enterprise.Enterprise;
import Business.Medicine.Medicine;
import Business.Medicine.MedicineDirectory;
import Business.Role.Role;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author harshita
 */
public class Pharmacy extends Enterprise {

    Map<Medicine, Integer> medicineListInventory;
    MedicineDirectory medicineList;

    public MedicineDirectory getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(MedicineDirectory medicineList) {
        this.medicineList = medicineList;
    }

    public Map<Medicine, Integer> getMedicineListquanity() {
        return medicineListInventory;
    }

    public void setMedicineListquanity(Map<Medicine, Integer> medicineListquanity) {
        this.medicineListInventory = medicineListquanity;
    }

    public Pharmacy(String name) {
        super(name, enterprseType.Pharmacy);
        medicineList = new MedicineDirectory();
        populateMedicineListForNewPharmacy();

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    void populateMedicineListForNewPharmacy() {
        try {
            if (medicineList.getList().isEmpty()) {
                Medicine med = new Medicine();
                medicineList.getList().add(med);
                String sDate = "2022-12-30";
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = formatter1.parse(sDate);
                med.setValues("Benadryl", date1, "2", 300.00, 250, "Liquid");
                med = new Medicine();
                medicineList.getList().add(med);
                med.setValues("Multi Vitamin", date1, "2", 300.00, 250, "Tablet");
                med = new Medicine();
                medicineList.getList().add(med);
                med.setValues("Flu Injection", date1, "2", 300.00, 250, "Injection");
                med = new Medicine();
                medicineList.getList().add(med);
                med.setValues("ABC Gel", date1, "2", 320.00, 20, "Gel");

            }

        } catch (Exception ex) {
            System.out.println("Exception occured in medicine creation in pharmacy");
        }
    }

}
