package com.techelevator.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerExample {

	public static void main(String[] args) {
        // Create a list of various workers
        List<Worker> payrollEmployees = new ArrayList<>();
        payrollEmployees.add(new SalariedWorker(120000, "Mickey", "Mouse"));
        payrollEmployees.add(new VolunteerWorker("George", "Geef"));
        payrollEmployees.add(new HourlyWorker(15, "Donald", "Duck"));
        payrollEmployees.add(new HourlyWorker(19.5, "Daisy", "Duck"));
        payrollEmployees.add(new SalariedWorker(170000, "Minnie", "Mouse"));

        // Print out the first row
        System.out.println(String.format("%-30s", "Employee") + String.format("%-25s","Hours Worked") + String.format("%-10s","Pay"));

        // Variables to hold Count
        double totalHours = 0;
        double totalPay = 0.0;
        Random randomHourGenerator = new Random();
        randomHourGenerator.setSeed(System.currentTimeMillis());
        for (Worker worker : payrollEmployees) {
            int hoursWorked = randomHourGenerator.nextInt(60) + 10;
            double pay = worker.calculateWeeklyPay(hoursWorked);

            // Print the employee line out
            System.out.print(String.format("%-30s", (worker.getLastName() + ", " + worker.getFirstName())));
            System.out.print(String.format("%-25s", Integer.toString(hoursWorked)));
            System.out.print(String.format("%-10s", "$" + String.format("%.2f",pay)));
            System.out.print("\r\n");

            totalHours += hoursWorked;
            totalPay += pay;
        }

        // Print the last line out
        System.out.println();
        System.out.println("Total Hours: \t" + totalHours);
        System.out.println("Total Pay: \t" + "$" + String.format("%.2f", totalPay));
        System.out.println();

	}

}
