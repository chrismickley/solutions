package com.techelevator.vehicle;

public class Truck implements Vehicle {

	private int numberOfAxles;
	
	public Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}
	
	public int getAxles() {
		return numberOfAxles;
	}
	
	public String getType() {
		return "Truck";
	}
	
	public double calculateToll(int distance) {
		if (numberOfAxles >= 8) {
			return distance * 0.048;
		}
		else if (numberOfAxles >= 6) {
			return distance * 0.045;
		}
		else {
			return distance * 0.040;
		}
	}
}
