package com.techelevator.npgeek.model.weather;

import java.util.List;

import org.junit.*;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.npgeek.model.TemperatureScale;


public class JdbcParkWeatherDaoIntegrationTest extends DAOIntegrationTest {

	private final static String PARK_CODE = "TEST";
	
	private ParkWeatherDao weatherDao;
	
	@Before
	public void setup() {
		weatherDao = new JdbcParkWeatherDao(getDataSource());
		insertPark(PARK_CODE);
		
		insertWeatherForPark(PARK_CODE, 1, 1, 32, "one");
		insertWeatherForPark(PARK_CODE, 2, 2, 32, "two");
		insertWeatherForPark(PARK_CODE, 3, 3, 32, "three");
		insertWeatherForPark(PARK_CODE, 4, 4, 32, "four");
		insertWeatherForPark(PARK_CODE, 5, 5, 32, "five");
		
	}
	
	@Test
	public void insert_park() {	
		ParkWeather returnedWeather = weatherDao.getParkWeatherByParkCode(new ParkWeather(PARK_CODE, new TemperatureScale()));
		Assert.assertEquals(PARK_CODE, returnedWeather.getParkCode());
		assertDailyWeather(returnedWeather.getDailyWeather());
	}
	
	private void assertDailyWeather(List<Weather> dailyWeather) {
		Assert.assertEquals("Wrong number of days returned", 5, dailyWeather.size());
		int day = 1;
		for (Weather weather : dailyWeather) {
			Assert.assertEquals(day++, weather.getHigh());
		}
		
	}
	

	
	
	
}
