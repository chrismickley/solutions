package com.techelevator.deliveryservice;

public class FexEdShipping implements DeliveryService {
	
    public String getName() {
        return "FexEd";
    }

    public double calculateRate(int weightInOunces, int distanceInMiles) {
        double flatRate = 20.00;

        if (distanceInMiles > 500) {
            flatRate = flatRate + 5.00;
        }
        if (weightInOunces > 48) {
            flatRate = flatRate + 3.00;
        }

        return flatRate;
    }

}
