/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Operation;

import Business.Employee.Employee;
import Business.Patient.Patient;
import java.util.List;

/**
 *
 * @author harshita
 */
public class OpsDirectory {

    List<Operation> opsList;

    public List<Operation> getOpsList() {
        return opsList;
    }

    public void setOpsList(List<Operation> opsList) {
        this.opsList = opsList;
    }

    public Operation addOperation() {
        Operation operation = new Operation();
        opsList.add(operation);
        return operation;

    }

    public Operation searchOperationbyDate(String date) {
        for (Operation operation : opsList) {
            if (operation.getOperationDate() == date) {
                return operation;
            }
        }
        return null;
    }

    public void updateOperation(int operationNumber, String operationDate, String operationDescription, double operationCharge, String status, Patient patient, Employee doctor) {
        for (Operation operation : opsList) {
            if (operation.getOperationNumber() == (operationNumber)) {
                operation.setOperationDate(operationDate);
                operation.setOperationDescription(operationDescription);
                operation.setOperationCharge(operationCharge);
                operation.setStatus(status);
                operation.setPatient(patient);
                operation.setDoctor(doctor);

            }
        }
    }

    public void cancelOperation(Operation operation) {
        opsList.remove(operation);
    }

}
