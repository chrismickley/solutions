package com.techelevator.npgeek.model.survey;

public class SurveyResult {

	private String parkCode;
	private String parkName;
	private int votes;
	
	public SurveyResult() {
		
	}
	
	public SurveyResult(String parkCode, String parkName, int votes) {
		this.parkCode = parkCode;
		this.parkName = parkName;
		this.votes = votes;
	}

	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
}
