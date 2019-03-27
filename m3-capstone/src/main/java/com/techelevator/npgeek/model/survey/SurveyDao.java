package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDao {

	void insertSurvey(Survey survey);
	List<SurveyResult> getSurveyResults();
}
