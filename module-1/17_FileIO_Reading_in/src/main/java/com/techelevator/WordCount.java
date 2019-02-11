package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Word Count (Part 1)
 * 
 * Write a program that, given a  path for a text file, reads the contents of the file, 
 * and displays both the number of words and the number of sentences in the file.
 * 
 * Hint 1: words are delimited by space characters
 * Hint 2: sentences are terminated by either a period, an exclamation mark, or a question mark.
 * 
 * alices_adventures_in_wonderland.txt
 * -----------------------------------
 * Expected Word Count: 30355
 * Expected Sentence Count: 1116 - 1839
 */
public class WordCount {
	
	public static void main(String[] args) throws FileNotFoundException {

		try (Scanner userInput = new Scanner(System.in)) {
			// Get the path of the input file
			File inputFile;
			while(true) {
				System.out.println("What is the file that should be searched?");
				String path = userInput.nextLine();
				// Validate the input file
				inputFile = new File(path);
				if(inputFile.exists() == false) {
					System.out.println(path+" does not exist");
					continue;
				} else if(inputFile.isFile() == false) {
					System.out.println(path+" is not a file");
					continue;
				}
				break;
			}
			// Count the words and sentences
			int wordCount = 0;
			int sentenceCount = 0;
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())){
				while (inputScanner.hasNextLine()) {
					String line = inputScanner.nextLine();
					if (!line.isEmpty()) { 								// Blank lines should be skipped
						String[] words = line.trim().split("\\s+");   	// Split the line into individual words.
						wordCount += words.length;						// The length of the array of words is the number of words. Doh!
						for(String word : words) {						// Loop through words, add one each 'sentence terminated' word found
							if (word.endsWith(".") || word.endsWith("?") || word.endsWith("!")) {
								sentenceCount += 1;
							}
						}
					}
				}
			}
			// Display the word and sentence counts
			System.out.println("Word count: " + wordCount);
			System.out.println("Sentence count: " + sentenceCount);
		}
		
	}
}
