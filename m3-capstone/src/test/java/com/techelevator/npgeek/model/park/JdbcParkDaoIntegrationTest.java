package com.techelevator.npgeek.model.park;

import java.util.List;
import org.junit.*;
import com.techelevator.DAOIntegrationTest;


public class JdbcParkDaoIntegrationTest extends DAOIntegrationTest {

	private static final String PARK_CODE = "TEST";
	
	private ParkDao parkDao;
	
	@Before
	public void setup() {
		parkDao = new JdbcParkDao(getDataSource());
	}
	
	@Test 
	public void get_all_parks_gets_all_parks_in_table() {
		int originalCount = parkDao.getAllParks().size();
		Park insertedPark = insertPark(PARK_CODE);
		List<Park> allParks = parkDao.getAllParks();
		Assert.assertEquals("Count of parks returned is incorrect", originalCount + 1, allParks.size());
		Assert.assertTrue(allParks.contains(insertedPark));
	}

	@Test
	public void get_park_by_parkcode_returns_correct_park() {
		Park insertedPark = insertPark(PARK_CODE);
		Park retrievedPark = parkDao.getParkByParkCode(PARK_CODE);
		Assert.assertEquals(insertedPark, retrievedPark);
	}
	
	
}
