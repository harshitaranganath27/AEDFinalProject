/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Harshita
 */
public class Employee {

    private String empName;
    private int id;
    private static int count = 1;
    private double visitingCharge;
    private String phoneNumber;
    private String emailID;
    private String role;
    private String carrier;

    public Map<Date, ArrayList<Integer>> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Date, ArrayList<Integer>> schedule) {
        this.schedule = schedule;
    }
    private Map<Date, ArrayList<Integer>> schedule;

    private SpecializationType specialization;

    public SpecializationType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationType specialization) {
        this.specialization = specialization;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public double getVisitingCharge() {
        return visitingCharge;
    }

    public void setVisitingCharge(double visitingCharge) {
        this.visitingCharge = visitingCharge;
    }

    public Employee() {
        id = count;
        count++;
        schedule = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return empName;
    }

    public enum SpecializationType {
        MBBS("MBBS"),
        Surgeon("Surgeon"),
        MD("MD"),
        Physician("Physician");

        private String value;

        private SpecializationType(String value) {
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

    public void addSchedule(Date date, Integer time) {
        Map<Date, ArrayList<Integer>> schedules = this.getSchedule();

        for (Map.Entry<Date, ArrayList<Integer>> sch : schedules.entrySet()) {

            if (sch.getKey().equals(date)) {
                sch.getValue().add(time);
                return;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(time);
        schedules.put(date, arr);

    }

    public boolean checkScheduleAvailability(Date date, Integer time) {
        Map<Date, ArrayList<Integer>> schedules = this.getSchedule();

        for (Map.Entry<Date, ArrayList<Integer>> sch : schedules.entrySet()) {

            if (sch.getKey().equals(date)) {
                ArrayList<Integer> arr = sch.getValue();

                if (arr.contains(time)) {
                    return false;
                }

            }
        }

        return true;
    }

}
