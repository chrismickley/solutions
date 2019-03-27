package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public void insertSurvey(Survey survey) {
		String sql = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) VALUES "
				+ "(DEFAULT, ?, ?, ?, ?) RETURNING surveyid";
		survey.setSurveyId(jdbcTemplate.queryForObject(sql, Long.class, 
				survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getAcivityLevel()));	
	}

	@Override
	public List<SurveyResult> getSurveyResults() {
		List<SurveyResult> surveyResults = new ArrayList<SurveyResult>();
		
		String sql = "SELECT count(*) as votes, park.parkcode, park.parkname " + 
				"FROM survey_result " + 
				"JOIN park on park.parkcode = survey_result.parkcode " + 
				"GROUP BY park.parkcode, park.parkname " + 
				"ORDER BY votes DESC, park.parkname ASC";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		while (rows.next()) {
			surveyResults.add(mapRowToSurveyResult(rows));
		}
		return surveyResults;
	}
	
	private SurveyResult mapRowToSurveyResult(SqlRowSet row) {
		return new SurveyResult(row.getString("parkcode"), row.getString("parkname"), row.getInt("votes"));
	}

}
