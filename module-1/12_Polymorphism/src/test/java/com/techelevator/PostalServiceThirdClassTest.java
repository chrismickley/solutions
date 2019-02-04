package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.PostalServiceThirdClass;

public class PostalServiceThirdClassTest {

	@Test
    public void calculateRateTestPostalServiceThirdClass() {
        PostalServiceThirdClass psfc = new PostalServiceThirdClass();

        assertEquals(0.0020, psfc.calculateRate(1, 1), 0.01);
        assertEquals(0.0022, psfc.calculateRate(5, 1), 0.01);
        assertEquals(0.0024, psfc.calculateRate(14, 1), 0.01);
        assertEquals(0.0150, psfc.calculateRate(36, 1), 0.01);
        assertEquals(0.0160, psfc.calculateRate(62, 1), 0.01);
        assertEquals(0.0170, psfc.calculateRate(144, 1), 0.01);
    }

}
