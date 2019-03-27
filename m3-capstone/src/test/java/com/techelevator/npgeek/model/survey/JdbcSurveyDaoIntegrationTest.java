package com.techelevator.npgeek.model.survey;

import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;


public class JdbcSurveyDaoIntegrationTest extends DAOIntegrationTest {

	private static final String PARK_CODE = "TEST";
	
	private static final String PARK_CODE_A = "AAA";
	private static final String PARK_CODE_B = "BBB";
	private static final String PARK_CODE_C = "CCC";
	
	private SurveyDao surveyDao;
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		surveyDao = new JdbcSurveyDao(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		truncateSurveyResultTable();
		insertPark(PARK_CODE);
		insertPark(PARK_CODE_A);
		insertPark(PARK_CODE_B);
		insertPark(PARK_CODE_C);
	}
	
	@Test
	public void insert_survey_and_get_all_results() {
		Survey survey = getSurvey(PARK_CODE);
		surveyDao.insertSurvey(survey);
		Assert.assertTrue("Survey Id not Returned from Insert", survey.getSurveyId() > 0);
		
		List<SurveyResult> results = surveyDao.getSurveyResults();
		Assert.assertEquals("Incorrect number of survey results returned after insert", 1, results.size());
	}
	
	@Test 
	public void get_all_surveys() {
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_C));
		
		Assert.assertEquals(3, surveyDao.getSurveyResults().size());
	}
	
	
	@Test
	public void get_survey_count() {
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		
		Assert.assertEquals("Only 1 SurveyResult should be returned", 1, surveyDao.getSurveyResults().size());
		Assert.assertEquals("SurveyResult should have 3 votes", 3, surveyDao.getSurveyResults().get(0).getVotes());
	}
	
	@Test
	public void parks_with_no_votes_should_not_return() {
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_B));
		
		List<SurveyResult> results = surveyDao.getSurveyResults();
		
		Assert.assertEquals("Wrong number of SurveyResults Returned", 3, results.size());
		
		boolean parkC_found = false;	
		for (SurveyResult result : results) {
			if (result.getParkCode().equals(PARK_CODE_C)) {
				parkC_found = true;
			}
		}
		Assert.assertFalse("Park Code C should not be in list" , parkC_found);
	}
	
	
	@Test
	public void survey_results_return_in_vote_order() {
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_B));
		
		List<SurveyResult> results = surveyDao.getSurveyResults();
		Assert.assertEquals("Wrong number of SurveyResults Returned", 3, results.size());
		
		Assert.assertEquals("Park Code TEST should be first in list", PARK_CODE, results.get(0).getParkCode());
		Assert.assertEquals("Park Code TEST should have 3 votes", 3, results.get(0).getVotes());
		
		Assert.assertEquals("Park Code A should be second in list", PARK_CODE_A, results.get(1).getParkCode());
		Assert.assertEquals("Park Code A should have 2 votes", 2, results.get(1).getVotes());
		
		Assert.assertEquals("Park Code B should be third in list", PARK_CODE_B, results.get(2).getParkCode());
		Assert.assertEquals("Park Code B should have 1 vote", 1, results.get(2).getVotes());
	}
	
	@Test 
	public void survey_results_with_equal_votes_should_return_in_alphabetic_order() {
		surveyDao.insertSurvey(getSurvey(PARK_CODE_C));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_B));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		
		List<SurveyResult> results = surveyDao.getSurveyResults();
		Assert.assertEquals("Wrong number of SurveyResults Returned", 3, results.size());
		
		Assert.assertEquals("Park Code A should be first in list", PARK_CODE_A, results.get(0).getParkCode());
		Assert.assertEquals("Park Code B should be second in list", PARK_CODE_B, results.get(1).getParkCode());
		Assert.assertEquals("Park Code C should be third in list", PARK_CODE_C, results.get(2).getParkCode());
	}
	
	@Test
	public void survey_results_with_more_and_equal_votes_return_in_correct_order() {
		
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_C));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_C));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_B));
		surveyDao.insertSurvey(getSurvey(PARK_CODE_A));
		
		List<SurveyResult> results = surveyDao.getSurveyResults();
		Assert.assertEquals("Wrong number of SurveyResults Returned", 4, results.size());
		
		Assert.assertEquals("Park Code TEST should be first in list", PARK_CODE, results.get(0).getParkCode());
		Assert.assertEquals("Park Code C should be second in list", PARK_CODE_C, results.get(1).getParkCode());
		Assert.assertEquals("Park Code A should be third in list", PARK_CODE_A, results.get(2).getParkCode());
		Assert.assertEquals("Park Code B should be fourth in list", PARK_CODE_B, results.get(3).getParkCode());
	}
	
	private Survey getSurvey(String parkCode) {
		Survey survey = new Survey();
		survey.setParkCode(parkCode);
		survey.setAcivityLevel("active");
		survey.setEmailAddress("test@test.com");
		survey.setState("OH");
		return survey;
	}
	
	
	private void truncateSurveyResultTable() {
		String sql = "TRUNCATE TABLE survey_result";
		jdbcTemplate.update(sql);
	}
}
