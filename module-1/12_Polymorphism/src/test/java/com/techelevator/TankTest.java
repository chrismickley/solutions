package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.vehicle.Tank;

public class TankTest {

	@Test
	public void basicTest() {
		Tank tank = new Tank();
		assertEquals("Tank", tank.getType());
		assertEquals(0.0, tank.calculateToll(0), 0.01);
		assertEquals(0.0, tank.calculateToll(100), 0.01);
		assertEquals(0.0, tank.calculateToll(1000), 0.01);
	}

}
