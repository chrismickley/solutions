package com.techelevator.npgeek.model.weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.model.TemperatureScale;

public class Weather {

	private int day;
	private int high;
	private int low;
	private String forecast;
	private TemperatureScale temperatureScale;
	
	public Weather(int day, int high, int low, String forcast, TemperatureScale temperatureScale) {
		this.day = day;
		this.high = high;
		this.low = low;
		this.forecast = forcast;
		this.temperatureScale = temperatureScale;
	}
		
	public int getHigh() {
		return getConvertedTemperature(high);
	}

	public int getLow() {
		return getConvertedTemperature(low);
	}
	
	public String getHighWithScale() {
		return getTempString(high);
	}
	
	public String getLowWithScale() {
		return getTempString(low);
	}
	
	public String getForecast() {
		return forecast;
	}

	public String getDayName() {
		if (day == 1) {
			return "Today";
		}
		if (day == 2) {
			return "Tomorrow";
		}
		LocalDate today = LocalDate.now();
		String dayName = today.plusDays(day - 1).getDayOfWeek().toString();
		return dayName.substring(0, 1) + dayName.substring(1).toLowerCase();
	}
	
	public List<String> getWarnings() {
		List<String> warnings = new ArrayList<String>();
		getForecastWarning(warnings);
		getTemperatureWarning(warnings);
		return warnings;
	}
	
	private void getForecastWarning(List<String> warnings) {
		
		
		switch (forecast.toLowerCase()) {
			case "snow":
				warnings.add("Pack snowshoes");
				break;
			case "rain":
				warnings.add("Wear weatherproof gear and shoes");
				break;
			case "thunderstorms":
				warnings.add("Seek shelter and avoid hiking on exposed ridges");
				break;
			case "sun":
				warnings.add("Pack sunblock");
				break;
		}

	}
	
	private void getTemperatureWarning(List<String> warnings) {
		if (high > 75) {
			warnings.add("High temperature: Bring extra water");
		}
		
		if (low < 20) {
			warnings.add("Frigid temperature: Danger from exposure");
		}
		
		if (Math.abs(high - low) > 20) {
			warnings.add("Varied temperature: Wear breathable layers");
		}
	}
	
	
	private boolean isCelius() {
		return temperatureScale.isCelsius();
	}
	
	private int getConvertedTemperature(int temp) {
		if (isCelius()) {
			return convertToCelius(temp);
		}
		return temp;
	}
	
	private int convertToCelius(int temp) {
		return (int) Math.round((temp - 32) * 5d/9d);
	}
	
	private String getTempString(int temp) {
		String temperatureString = String.valueOf(getConvertedTemperature(temp));
		if (isCelius()) {
			temperatureString += "C";
		} else {
			temperatureString += "F";
		}
		return temperatureString;
	}
}
