package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.TemperatureScale;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.ParkWeather;
import com.techelevator.npgeek.model.weather.ParkWeatherDao;

@Controller
@SessionAttributes("temperatureScale")
public class ParkController {
	
	@Autowired
	private ParkDao parkDao;

	@Autowired
	private ParkWeatherDao weatherDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showAllParks(ModelMap map) {
		map.addAttribute("parks", parkDao.getAllParks());
		return "allParks";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String showParkDetail(@RequestParam(required=false) String parkCode, ModelMap map) {
		if (parkCode == null || parkCode.length() < 1) {
			return "redirect:/";
		}
		map.addAttribute("park", parkDao.getParkByParkCode(parkCode));
		map.addAttribute("weather", getParkWeather(parkCode, map));
		
		return "parkDetail";
	}
	
	@RequestMapping(path="/switchScale", method=RequestMethod.GET)
	public String switchScale(@RequestParam String parkCode, @RequestParam boolean isCelsius, ModelMap map) {
		
		((TemperatureScale) map.get("temperatureScale")).setCelsius(isCelsius);
		map.addAttribute("parkCode", parkCode);
		return "redirect:/parkDetail";
	}
	

	
	private ParkWeather getParkWeather(String parkCode, ModelMap map) {
		if (!map.containsKey("temperatureScale")) {
			map.addAttribute("temperatureScale", new TemperatureScale());
		}
		ParkWeather weather = weatherDao.getParkWeatherByParkCode(new ParkWeather(parkCode, (TemperatureScale) map.get("temperatureScale")));
		return weather;
	}
	
}
