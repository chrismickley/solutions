package com.techelevator.deliveryservice;

public class SPUTwoDayGround implements DeliveryService {

    public String getName() {
        return "SPU (next-day)";
    }

    public double calculateRate(int weightInOunces, int distanceInMiles) {
        int weightInLbs = weightInOunces / 16;

        // round up to the nearest lb
        if (weightInOunces % 16 != 0)
        {
            weightInLbs++;
        }

        return (weightInLbs * 0.075) * distanceInMiles;
    }

}
