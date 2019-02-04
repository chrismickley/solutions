package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.SPUTwoDayGround;

public class SPUTwoDayGroundTest {

	@Test
    public void calculateRateTestSPUTwoDayGround() {
		
        SPUTwoDayGround spu = new SPUTwoDayGround();

        assertEquals(.050, spu.calculateRate(15, 1), 0.1);
        assertEquals(.100, spu.calculateRate(17, 1), 0.1);
    }

}
