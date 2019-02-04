package com.techelevator.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleExample {

	public static void main(String[] args) {
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Car(false));
		vehicles.add(new Car(true));
		vehicles.add(new Tank());
		vehicles.add(new Truck(8));
		vehicles.add(new Truck(6));
		vehicles.add(new Truck(4));
		
		int totalMilesTraveled = 0;
		double totalTollRevenue = 0;
		System.out.println("Vehicle\t\tDistance Traveled\t\tToll$");
		System.out.println("-----------------------------------------------------");
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		for(Vehicle vehicle : vehicles) {
			int distance = rnd.nextInt(230) + 10;
			double toll = vehicle.calculateToll(distance);
			System.out.println(vehicle.getType() + "\t\t" + distance + "\t\t\t\t$" +  String.format("%.2f",toll));
			totalMilesTraveled += distance;
			totalTollRevenue += toll;
		}
		System.out.println();
		System.out.println("Total Miles Traveled: " + totalMilesTraveled);
		System.out.println("Total Tollbooth Revenue: " + "$" + String.format("%.2f",totalTollRevenue));		
		System.out.println();
	}

}
