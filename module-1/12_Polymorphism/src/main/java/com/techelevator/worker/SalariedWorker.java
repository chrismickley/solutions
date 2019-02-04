package com.techelevator.worker;

public class SalariedWorker implements Worker {
	
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

    public SalariedWorker(double annualSalary, String firstname, String lastname)
    {
        this.annualSalary = annualSalary;
        this.firstName = firstname;
        this.lastName = lastname;
    }

    /*
    * Weekly pay for salary worker is annual pay over 52 weeks
    */
    @Override
    public double calculateWeeklyPay(int hoursWorked) {
        return this.annualSalary / 52;
    }

}
