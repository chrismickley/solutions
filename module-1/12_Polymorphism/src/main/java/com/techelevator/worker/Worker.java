package com.techelevator.worker;

public interface Worker {

	String getFirstName();
    String getLastName();

    double calculateWeeklyPay(int hoursWorked);

}
