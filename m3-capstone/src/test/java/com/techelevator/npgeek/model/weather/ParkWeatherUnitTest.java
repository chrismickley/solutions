package com.techelevator.npgeek.model.weather;

import java.time.LocalDate;

import org.junit.*;

import com.techelevator.npgeek.model.TemperatureScale;


public class ParkWeatherUnitTest {

	private ParkWeather parkWeather;
	private TemperatureScale temperatureScale;
	
	@Before
	public void setup() {
		temperatureScale = new TemperatureScale();
		parkWeather = new ParkWeather("TEST", temperatureScale);
		
		for (int i = 1; i <= 5 ; i++) {
			Weather weather = new Weather(i, 70, 32, "cloudy" ,temperatureScale);
			parkWeather.addDailyWeather(weather);
		}
	}
	
	@Test
	public void returns_farenheit_when_set_to_farenheit() {
		Assert.assertFalse(parkWeather.isCelius());
	}
	
	@Test
	public void returns_celius_when_set_to_celius() {
		temperatureScale.setCelsius(true);
		Assert.assertTrue(parkWeather.isCelius());
	}
	
	@Test
	public void can_switch_between_farenheit_and_celius() {
		Assert.assertFalse("Did not default to F", parkWeather.isCelius());
		temperatureScale.setCelsius(true);
		Assert.assertTrue("Did not change to C", parkWeather.isCelius());
		temperatureScale.setCelsius(false);
		Assert.assertFalse("Did not return to F", parkWeather.isCelius());
	}
	
	@Test
	public void weather_high_is_farenheit() {
		for (Weather weather : parkWeather.getDailyWeather()) {
			Assert.assertEquals(70, weather.getHigh());
		}
	}
	
	@Test
	public void weather_low_is_farenheit() {
		for (Weather weather : parkWeather.getDailyWeather()) {
			Assert.assertEquals(32, weather.getLow());
		}
	}
	
	@Test
	public void weather_high_is_celius() {
		temperatureScale.setCelsius(true);
		for (Weather weather : parkWeather.getDailyWeather()) {
			Assert.assertEquals(21, weather.getHigh());
		}
	}
	
	@Test
	public void weather_low_is_celius() {
		temperatureScale.setCelsius(true);
		for (Weather weather : parkWeather.getDailyWeather()) {
			Assert.assertEquals(0, weather.getLow());
		}
	}
	

}
