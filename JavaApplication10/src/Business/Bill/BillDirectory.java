/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bill;

import java.util.List;

/**
 *
 * @author 
 */
public class BillDirectory {
    List<Bill> billList;
    //static int count=1;

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
    
    
}
