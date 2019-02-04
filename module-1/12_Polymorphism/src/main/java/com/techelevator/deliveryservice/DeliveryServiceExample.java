package com.techelevator.deliveryservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryServiceExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the weight of the package: ");
        String weightInput = scanner.nextLine();
        int weightValue = Integer.parseInt(weightInput);

        System.out.print("(P)ounds or (O)unces: ");
        String weightType = scanner.nextLine();
        if(weightType == "P") {
            weightValue = weightValue * 16; //get the weight in ounces
        }

        System.out.print("What distance will it be traveling (in miles): ");
        String milesInput = scanner.nextLine();
        int milesValue = Integer.parseInt(milesInput);

        List<DeliveryService> services = new ArrayList<>();
        services.add(new PostalServiceFirstClass());
        services.add(new PostalServiceSecondClass());
        services.add(new PostalServiceThirdClass());
        services.add(new FexEdShipping());
        services.add(new SPUFourDayGround());
        services.add(new SPUTwoDayGround());
        services.add(new SPUNextDayGround());

        System.out.println();
        System.out.println("Delivery Method\t\t\t$ cost");
        System.out.println("--------------------------------------");

        for (DeliveryService service : services) {
            double postage = service.calculateRate(weightValue, milesValue);
            System.out.println(String.format("%-25s",service.getName()) + "\t$" + String.format("%.2f", postage));
        }
	}

}
