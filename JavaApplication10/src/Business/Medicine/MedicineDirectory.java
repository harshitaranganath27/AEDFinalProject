/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshita
 */
public class MedicineDirectory {
    
    
    List<Medicine> list;

    public List<Medicine> getList() {
        return list;
    }

    public void setList(List<Medicine> list) {
        this.list = list;
    }
    
    
    public MedicineDirectory(){
        list= new ArrayList<>();
    }
    
    
    
}
