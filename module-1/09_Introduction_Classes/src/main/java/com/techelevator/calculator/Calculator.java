package com.techelevator.calculator;

public class Calculator {
	
	private int currentValue = 0;
	
	public int getCurrentValue() {
		return currentValue;
	}
	
	public int add(int addend) {
		currentValue += addend;
		return currentValue;
	}

	public int subtract(int subtrahend) {
		currentValue -= subtrahend;
		return currentValue;
	}

	public int multiply(int multiplier) {
		currentValue *= multiplier;
		return currentValue;
	}

	public int power(int exponent) {
		currentValue = (int)Math.pow(currentValue, (double)exponent);
		return currentValue;
	}

	public void reset() {
		currentValue = 0;
	}

}
