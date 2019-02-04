package com.techelevator.deliveryservice;

public class PostalServiceFirstClass implements DeliveryService {

	final int ThreePoundsInOz = 48;
    final int EightPoundsInOz = 128;

    public String getName() {
        return "Postal Service (1st Class)";
    }

    public double calculateRate(int weightInOunces, int distanceInMiles) {
        double rate = 0.0;

        if (weightInOunces <= 2) rate = 0.035;
        else if (weightInOunces <= 8) rate = 0.040;
        else if (weightInOunces <= 15) rate = 0.047;
        else if (weightInOunces <= ThreePoundsInOz) rate = 0.195;
        else if (weightInOunces <= EightPoundsInOz) rate = 0.450;
        else rate = 0.500;

        return rate * distanceInMiles;            
    }

}
