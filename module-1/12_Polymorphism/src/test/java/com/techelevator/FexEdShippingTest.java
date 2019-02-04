package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.FexEdShipping;

public class FexEdShippingTest {

	@Test
    public void calculateRateTestFexEdShipping() {
        FexEdShipping fs = new FexEdShipping();

        assertEquals(20, fs.calculateRate(16, 100), 0.01);
        assertEquals(25, fs.calculateRate(16, 501), 0.01);
        assertEquals(23, fs.calculateRate(49, 100), 0.01);
        assertEquals(28, fs.calculateRate(49, 501), 0.01);
    }

}
