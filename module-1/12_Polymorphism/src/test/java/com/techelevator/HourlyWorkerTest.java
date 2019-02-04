package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.worker.HourlyWorker;

public class HourlyWorkerTest {

	@Test
    public void calculateWeekly0Hours0Pay() {
        HourlyWorker hw = new HourlyWorker(1.0, "John", "Doe");

        assertEquals(0, hw.calculateWeeklyPay(0), 0.01);
    }

	@Test
    public void calculateWeeklyRegularTime() {
        HourlyWorker hw = new HourlyWorker(1.0, "John", "Doe");

        assertEquals(1, hw.calculateWeeklyPay(1), 0.01);
        assertEquals(20, hw.calculateWeeklyPay(20), 0.01);
        assertEquals(40, hw.calculateWeeklyPay(40), 0.01);            
    }

	@Test
    public void calculateWeeklyPayOverTime() {
        HourlyWorker hw = new HourlyWorker(1.0, "John", "Doe");

        assertEquals(41.5, hw.calculateWeeklyPay(41), 0.01);
        assertEquals(70, hw.calculateWeeklyPay(60), 0.01);
    }

}
