package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * FindAndReplace
 * 
 * Write a program that can be used to replace all occurrences of one word with another word.
 * 
 * The program should prompt the user for the following values:
 * - The search term
 * - The term to replace the search term with
 * - The source file. This must be an existing file. If the user enters an invalid source file path, 
 *   the program will indicate this and exit.
 * - The destination file. The program will create a copy of the source file with the requested 
 *   replacements at this location. If a file or directory already exists at this location, the program will 
 *   print an error and exit.
 */

public class FindAndReplace {

	public static void main(String[] args) {

		try (Scanner userInput = new Scanner(System.in)) {

			// Get the search word
			System.out.println("What is the search word?");
			String searchWord = userInput.nextLine();
			if ((searchWord == null) || (searchWord.isEmpty())) {
				System.out.println("The word to replace is empty");
				System.exit(1);
			}

			// Get the replacement word
			System.out.println("What is the replacement word?");
			String replacementWord = userInput.nextLine();
			if ((replacementWord == null) || (replacementWord.isEmpty())) {
				System.out.println("The replacement word is empty");
				System.exit(1);
			}
			
			// Get the location of the source file
			File sourceFile;
			System.out.println("What is the source file?");
			String path = userInput.nextLine();
			// Validate the input file
			sourceFile = new File(path);
			if(sourceFile.exists() == false) {
				System.out.println(path+" does not exist");
				System.exit(1);
			} else if(sourceFile.isFile() == false) {
				System.out.println(path+" is not a file");
				System.exit(1);
			}
			
			// Get the location of the destination file
			File destinationFile;
			System.out.println("What is the destination file?");
			path = userInput.nextLine();
			// Validate the input file
			destinationFile = new File(path);
			if(destinationFile.exists() == false) {
				System.out.println(path+" does not exist");
				System.exit(1);
			} else if(destinationFile.isFile() == false) {
				System.out.println(path+" is not a file");
				System.exit(1);
			}
			
			// Replace word
			try (Scanner sourceScanner = new Scanner(sourceFile.getAbsoluteFile());
					PrintWriter destinationWriter = new PrintWriter(destinationFile.getAbsoluteFile())){
				while (sourceScanner.hasNextLine()) {
					String line = sourceScanner.nextLine();
					destinationWriter.println(line.replaceAll(searchWord, replacementWord));
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
