package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.PostalServiceSecondClass;

public class PostalServiceSecondClassTest {

	@Test
    public void calculateRateTestPostalServiceSecondClass() {
        PostalServiceSecondClass psfc = new PostalServiceSecondClass();

        assertEquals(0.0035, psfc.calculateRate(1, 1), 0.01);
        assertEquals(0.0040, psfc.calculateRate(5, 1), 0.01);
        assertEquals(0.0047, psfc.calculateRate(14, 1), 0.01);
        assertEquals(0.0195, psfc.calculateRate(36, 1), 0.01);
        assertEquals(0.0450, psfc.calculateRate(62, 1), 0.01);
        assertEquals(0.0500, psfc.calculateRate(144, 1), 0.01);
    }

}
