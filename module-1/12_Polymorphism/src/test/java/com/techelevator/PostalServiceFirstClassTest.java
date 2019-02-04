package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.PostalServiceFirstClass;

public class PostalServiceFirstClassTest {

	@Test
    public void calculateRateTestPostalServiceFirstClass() {
        PostalServiceFirstClass psfc = new PostalServiceFirstClass();

        assertEquals(0.035, psfc.calculateRate(1, 1), 0.01);
        assertEquals(0.040, psfc.calculateRate(5, 1), 0.0);
        assertEquals(0.047, psfc.calculateRate(14, 1), 0.0);
        assertEquals(0.195, psfc.calculateRate(36, 1), 0.0);
        assertEquals(0.450, psfc.calculateRate(62, 1), 0.0);
        assertEquals(0.500, psfc.calculateRate(144, 1), 0.0);
    }

}
