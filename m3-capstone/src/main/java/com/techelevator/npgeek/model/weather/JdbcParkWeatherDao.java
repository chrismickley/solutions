package com.techelevator.npgeek.model.weather;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkWeatherDao implements ParkWeatherDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkWeatherDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ParkWeather getParkWeatherByParkCode(ParkWeather parkWeather) {
		
		String sql = "SELECT fivedayforecastvalue, low, high, forecast FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue ASC";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkWeather.getParkCode());
		while (result.next()) {
			parkWeather.addDailyWeather(new Weather(result.getInt("fivedayforecastvalue"), result.getInt("high"), 
					result.getInt("low"), result.getString("forecast"), parkWeather.getTemperatureScale()));
		}
		return parkWeather;
	}
	

}
