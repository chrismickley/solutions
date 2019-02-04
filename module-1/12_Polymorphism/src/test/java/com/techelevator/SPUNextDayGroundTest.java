package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.deliveryservice.SPUNextDayGround;

public class SPUNextDayGroundTest {

	@Test
    public void calculateRateTestSPUNextDayGround() {
		
        SPUNextDayGround spu = new SPUNextDayGround();

        assertEquals(0.075, spu.calculateRate(15, 1), 0.01);
        assertEquals(.150, spu.calculateRate(17, 1), 0.01);

    }

}
