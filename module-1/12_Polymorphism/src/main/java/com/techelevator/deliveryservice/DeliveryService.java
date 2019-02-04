package com.techelevator.deliveryservice;

public interface DeliveryService {
	
    String getName();
    double calculateRate(int weightInOunces, int distanceInMiles);

}
