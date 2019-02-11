package com.techelevator;

public class QuizQuestion {

	private String question;
	private String[] answers;
	private String correctAnswer;
	
	/**
	 * Parses the bar-delimited line into its constituent parts: question, answers, and correctAnswer
	 * 
	 * @param line
	 */
	public QuizQuestion(String line) {
		if ((line != null) && (!line.isEmpty())) {	// Skip null or empty lines
			String[] parts = line.split("\\|");
			this.question = parts[0];
			answers = new String[parts.length-1];
			for(int i = 1; i < parts.length; i++) {
				String answer = parts[i].trim();
				if (answer.endsWith("*")) {
					answer = answer.substring(0, answer.length()-1);	// Pull-off trailing "*" character
					this.correctAnswer = Integer.toString(i);
				}
				answers[i-1] = answer;									// Add the answer to the array of answers
			}
		}
	}
	
	/**
	 * Returns the question.
	 * 
	 * @return
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * Returns a copy of the original answers, so caller never gains access to the private array.
	 * 
	 * @return
	 */
	public String[] getAnswers() {
		return this.answers.clone(); // Return a copy, preserving the original
	}
	
	/**
	 * Determines if the answer selected by the user is correct.
	 * 
	 * @param selectedAnswer
	 * @return true if selectedAnswer is the correctAnswerIndex
	 */
	public boolean isCorrectAnswer(String selectedAnswer) {
		return this.correctAnswer.equals(selectedAnswer);
	}
	
}
