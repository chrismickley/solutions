package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.worker.SalariedWorker;

public class SalariedWorkerTest {

	@Test
    public void calculateWeeklyPaySalaryBased_RegardlessOfTime() {
        //Arrange
        SalariedWorker sw = new SalariedWorker(52000, "John", "Doe");

        //Assert
        assertEquals(1000, sw.calculateWeeklyPay(0), 0.01);
        assertEquals(1000, sw.calculateWeeklyPay(20), 0.01);
        assertEquals(1000, sw.calculateWeeklyPay(40), 0.01);
        assertEquals(1000, sw.calculateWeeklyPay(60), 0.01);

    }

}
