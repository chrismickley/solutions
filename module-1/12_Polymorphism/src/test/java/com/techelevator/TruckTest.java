package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.vehicle.Truck;

public class TruckTest {

	@Test
	public void truckWith8Axles() {
		Truck truck = new Truck(8);
		assertEquals("Truck", truck.getType());
		assertEquals(8, truck.getAxles());
		assertEquals(0.048, truck.calculateToll(1), 0.01);
		assertEquals(0.48, truck.calculateToll(10), 0.01);
		assertEquals(4.80, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWithMoreThan8Axles() {
		Truck truck = new Truck(9);
		assertEquals("Truck", truck.getType());
		assertEquals(9, truck.getAxles());
		assertEquals(0.048, truck.calculateToll(1), 0.01);
		assertEquals(0.48, truck.calculateToll(10), 0.01);
		assertEquals(4.80, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWith6Axles() {
		Truck truck = new Truck(6);
		assertEquals("Truck", truck.getType());
		assertEquals(6, truck.getAxles());
		assertEquals(0.045, truck.calculateToll(1), 0.01);
		assertEquals(0.45, truck.calculateToll(10), 0.01);
		assertEquals(4.50, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWithMoreThan6ButLessThan8Axles() {
		Truck truck = new Truck(7);
		assertEquals("Truck", truck.getType());
		assertEquals(7, truck.getAxles());
		assertEquals(0.045, truck.calculateToll(1), 0.01);
		assertEquals(0.45, truck.calculateToll(10), 0.01);
		assertEquals(4.50, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWith4Axles() {
		Truck truck = new Truck(4);
		assertEquals("Truck", truck.getType());
		assertEquals(4, truck.getAxles());
		assertEquals(0.040, truck.calculateToll(1), 0.01);
		assertEquals(0.40, truck.calculateToll(10), 0.01);
		assertEquals(4.00, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWithMoreThan4ButLessThan6Axles() {
		Truck truck = new Truck(5);
		assertEquals("Truck", truck.getType());
		assertEquals(5, truck.getAxles());
		assertEquals(0.040, truck.calculateToll(1), 0.01);
		assertEquals(0.40, truck.calculateToll(10), 0.01);
		assertEquals(4.00, truck.calculateToll(100), 0.01);
	}

	@Test
	public void truckWithLessThan4Axles() {
		Truck truck = new Truck(3);
		assertEquals("Truck", truck.getType());
		assertEquals(3, truck.getAxles());
		assertEquals(0.040, truck.calculateToll(1), 0.01);
		assertEquals(0.40, truck.calculateToll(10), 0.01);
		assertEquals(4.00, truck.calculateToll(100), 0.01);
	}

}
