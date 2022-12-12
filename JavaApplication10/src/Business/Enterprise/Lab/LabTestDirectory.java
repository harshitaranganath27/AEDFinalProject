/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Lab;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshita
 */
public class LabTestDirectory {
    private List <LabTest> testList;

    public LabTestDirectory() {
        testList= new ArrayList<>();      
    }

    public List<LabTest> getTestList() {
        return testList;
    }

    public void setTestList(List<LabTest> testList) {
        this.testList = testList;
    }
    
    public LabTest addLabTest(LabTest labTest){
        testList.add(labTest);
        return labTest;
    }
}
