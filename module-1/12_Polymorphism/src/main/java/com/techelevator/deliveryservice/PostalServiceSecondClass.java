package com.techelevator.deliveryservice;

public class PostalServiceSecondClass implements DeliveryService {
    
	final int ThreePoundsInOz = 48;
    final int EightPoundsInOz = 128;

    public String getName() {
        return "Postal Service (2nd Class)";
    }

    public double calculateRate(int weightInOunces, int distanceInMiles) {
        double rate = 0.0;

        if (weightInOunces <= 2) rate = 0.0035;
        else if (weightInOunces <= 8) rate = 0.0040;
        else if (weightInOunces <= 15) rate = 0.0047;
        else if (weightInOunces <= ThreePoundsInOz) rate = 0.0195;
        else if (weightInOunces <= EightPoundsInOz) rate = 0.0450;
        else rate = 0.0500;

        return rate * distanceInMiles;
    }
}
