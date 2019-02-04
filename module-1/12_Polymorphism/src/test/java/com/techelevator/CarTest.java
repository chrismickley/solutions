package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.vehicle.Car;

public class CarTest {

	@Test
	public void carWithoutTrailerTest() {
		Car car = new Car(false);
		assertEquals("Car", car.getType());
		assertEquals(false, car.hasTrailer());
		assertEquals(0.020, car.calculateToll(1), 0.01);
		assertEquals(0.20, car.calculateToll(10), 0.01);
		assertEquals(2.0, car.calculateToll(100), 0.01);
	}

	@Test
	public void carWithTrailerTest() {
		Car car = new Car(true);
		assertEquals("Car", car.getType());
		assertEquals(true, car.hasTrailer());
		assertEquals(1.020, car.calculateToll(1), 0.01);
		assertEquals(1.20, car.calculateToll(10), 0.01);
		assertEquals(3.0, car.calculateToll(100), 0.01);
	}

}
