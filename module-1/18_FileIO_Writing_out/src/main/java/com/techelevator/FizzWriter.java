package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		File destinationFile = new File("FizzBuzz.txt");

		// Write FizzBuzz 1 - 300
		try (PrintWriter destinationWriter = new PrintWriter(destinationFile.getAbsoluteFile())) {
			for (int i = 1; i <= 300; i++) {
				boolean isDivisibleBy5 = i % 5 == 0;
				boolean isDivisibleBy3 = i % 3 == 0;
				if (isDivisibleBy5 && isDivisibleBy3) {
					destinationWriter.println("FizzBuzz");
				} else if (isDivisibleBy3 || Integer.toString(i).contains("3")) {
					destinationWriter.println("Fizz");
				} else if (isDivisibleBy5 || Integer.toString(i).contains("5")) {
					destinationWriter.println("Buzz");
				} else {
					destinationWriter.println(Integer.toString(i));
				}
			}

			System.out.println("FizzBuzz.txt has been created.");

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.print(fileNotFoundException.getStackTrace());
		}
	}

}
