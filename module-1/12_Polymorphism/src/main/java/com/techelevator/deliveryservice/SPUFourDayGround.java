package com.techelevator.deliveryservice;

public class SPUFourDayGround implements DeliveryService {
	
    public String getName() {
        return "SPU (4-day ground)";
    }

    public double calculateRate(int weightInOunces, int distanceInMiles) {
        int weightInLbs = weightInOunces / 16;

        // round up to the nearest lb
        if (weightInOunces % 16 != 0)
        {
            weightInLbs++;
        }

        return (weightInLbs * 0.0050) * distanceInMiles;
    }

}
