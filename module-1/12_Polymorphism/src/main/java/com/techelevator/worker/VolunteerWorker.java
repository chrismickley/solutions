package com.techelevator.worker;

public class VolunteerWorker implements Worker {

    private double annualSalary;
    private String firstName;
    private String lastName;

    public double getAnnualSalary() {
        return annualSalary;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public VolunteerWorker(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public double calculateWeeklyPay(int hoursWorked) {
        return 0;
    }

}
