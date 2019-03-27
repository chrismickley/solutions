package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.model.TemperatureScale;

public class ParkWeather {

	private String parkCode;
	private TemperatureScale temperatureScale;
	private List<Weather> dailyWeather = new ArrayList<Weather>();
	
	public ParkWeather(String parkCode, TemperatureScale temperatureScale) {
		this.parkCode = parkCode;
		this.temperatureScale = temperatureScale;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public boolean isCelius() {
		return temperatureScale.isCelsius();
	}
	
	public TemperatureScale getTemperatureScale() {
		return this.temperatureScale;
	}
	
	public List<Weather> getDailyWeather() {
		return dailyWeather;
	}
	
	public void addDailyWeather(Weather weather) {
		this.dailyWeather.add(weather);
	}
	
}
