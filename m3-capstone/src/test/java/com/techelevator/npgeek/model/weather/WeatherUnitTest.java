package com.techelevator.npgeek.model.weather;

import java.time.LocalDate;
import java.util.List;

import org.junit.*;

import com.techelevator.npgeek.model.TemperatureScale;


public class WeatherUnitTest {

	@Test
	public void returns_temp_in_F() {
		Weather weather = getWeather(1, 70, 32, "snow");
		Assert.assertEquals("High incorrect for F", 70, weather.getHigh());
		Assert.assertEquals("Low incorrect for F", 32, weather.getLow());
	}
	
	@Test
	public void returns_temp_in_C() {
		TemperatureScale scale = new TemperatureScale();
		scale.setCelsius(true);
		Weather weather = new Weather(1, 70, 32, "snow", scale);
		Assert.assertEquals("High incorrect for C", 21, weather.getHigh());
		Assert.assertEquals("Low incorrect for C", 0, weather.getLow());
	}
	
	@Test
	public void returns_temp_in_F_with_scale() {
		Weather weather = getWeather(1, 70, 32, "snow");
		Assert.assertEquals("High and scale incorrect for F", "70F", weather.getHighWithScale());
		Assert.assertEquals("Low and scale incorrect for F", "32F", weather.getLowWithScale());
	}
	
	@Test
	public void returns_temp_in_C_with_scale() {
		TemperatureScale scale = new TemperatureScale();
		scale.setCelsius(true);
		Weather weather = new Weather(1, 70, 32, "snow", scale);
		Assert.assertEquals("High incorrect for C", "21C", weather.getHighWithScale());
		Assert.assertEquals("Low incorrect for C", "0C", weather.getLowWithScale());
	}
	
	@Test 
	public void snow_returns_correct_warning() {
		Weather weather = getWeather(1, 60, 60, "snow");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Pack snowshoes", warnings.get(0));
	}
	
	@Test 
	public void rain_returns_correct_warning() {
		Weather weather = getWeather(1, 60, 60, "rain");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Wear weatherproof gear and shoes", warnings.get(0));
	}
	
	@Test 
	public void thunderstorms_returns_correct_warning() {
		Weather weather = getWeather(1, 60, 60, "thunderstorms");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Seek shelter and avoid hiking on exposed ridges", warnings.get(0));
	}
	
	@Test 
	public void sun_returns_correct_warning() {
		Weather weather = getWeather(1, 60, 60, "sun");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Pack sunblock", warnings.get(0));
	}
	
	public void high_temp_returns_correct_warning() {
		Weather weather = getWeather(1, 76, 60, "other");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("High temperature: Bring extra water", warnings.get(0));
	}
	
	public void low_temp_returns_correct_warning() {
		Weather weather = getWeather(1, 30, 19, "other");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Frigid temperature: Danger from exposure", warnings.get(0));
	}
	
	public void midtemp_spread_20_returns_correct_warning() {
		Weather weather = getWeather(1, 70, 40, "other");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(1, warnings.size());
		Assert.assertEquals("Varied temperature: Wear breathable layers", warnings.get(0));
	}
	
	public void all_temperature_warnings_return_together() {
		Weather weather = getWeather(1, 80, 10, "other");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals("Wear weatherproof gear and shoes", warnings.get(0));
		Assert.assertEquals("High temperature: Bring extra water", warnings.get(0));
		Assert.assertEquals("Frigid temperature: Danger from exposure", warnings.get(1));
		Assert.assertEquals("Varied temperature: Wear breathable layers", warnings.get(2));
	}
	
	
	public void temperature_and_weather_warnings_return_together() {
		Weather weather = getWeather(1, 80, 60, "snow");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(3, warnings.size());
		Assert.assertEquals("Pack snowshoes", warnings.get(0));
		Assert.assertEquals("High temperature: Bring extra water", warnings.get(1));
	}
	
	public void max_possible_warnings_return_together() {
		Weather weather = getWeather(1, 80, 10, "rain");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(4, warnings.size());
		Assert.assertEquals("High temperature: Bring extra water", warnings.get(1));
		Assert.assertEquals("High temperature: Bring extra water", warnings.get(1));
		Assert.assertEquals("Frigid temperature: Danger from exposure", warnings.get(2));
		Assert.assertEquals("Varied temperature: Wear breathable layers", warnings.get(3));
	}
	
	@Test 
	public void partly_cloudy_returns_no_warning() {
		Weather weather = getWeather(1, 60, 60, "partly cloudy");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(0, warnings.size());
	}
	
	@Test 
	public void other_returns_no_warning() {
		Weather weather = getWeather(1, 60, 60, "other");
		List<String> warnings = weather.getWarnings();
		Assert.assertEquals(0, warnings.size());
	}
	
	@Test 
	public void day_one_returns_today() {
		Weather weather = getWeather(1, 0, 0, "");
		Assert.assertEquals("Today", weather.getDayName());
	}
	
	@Test 
	public void day_two_returns_tomorrow() {
		Weather weather = getWeather(2, 0, 0, "");
		Assert.assertEquals("Tomorrow", weather.getDayName());
	}
	
	@Test 
	public void day_three_returns_correct_day() {
		Weather weather = getWeather(3, 0, 0, "");
		Assert.assertEquals(getFutureDayName(2), weather.getDayName());
	}
	
	@Test 
	public void day_four_returns_correct_day() {
		Weather weather = getWeather(4, 0, 0, "");
		Assert.assertEquals(getFutureDayName(3), weather.getDayName());
	}
	
	@Test 
	public void day_five_returns_correct_day() {
		
		Weather weather = getWeather(5, 0, 0, "");
		Assert.assertEquals(getFutureDayName(4), weather.getDayName());
	}
	
	private String getFutureDayName(int daysToAdd) {
		LocalDate today = LocalDate.now();
		String dayName = today.plusDays(daysToAdd).getDayOfWeek().toString();
		return dayName.substring(0, 1) + dayName.substring(1).toLowerCase();
	}
	
	private Weather getWeather(int day, int high, int low, String forecast) {
		TemperatureScale temperatureScale = new TemperatureScale();
		return new Weather(day, high, low, forecast, temperatureScale);
	}
}
