package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {

			// Get the location of the source file
			File sourceFile;
			System.out.print("Where is the input file (please include the file path to the file)? ");
			String path = userInput.nextLine();
			// Validate the input file
			sourceFile = new File(path);
			if (sourceFile.exists() == false) {
				System.out.println(path + " does not exist");
				System.exit(1);
			} else if (sourceFile.isFile() == false) {
				System.out.println(path + " is not a file");
				System.exit(1);
			}

			// Get the maximum number of lines per file
			System.out.print("What is the maximum number of lines in each output file? ");
			int maxLineCount = userInput.nextInt();

			// Setup the initial destination file
			String destinationPath = sourceFile.getAbsoluteFile().getParent();
			String destinationFilename = sourceFile.getAbsoluteFile().getName();
			String destinationExtension = "";
			if (destinationFilename.contains(".")) {
				// Separate filename and extension
				int lastPeriod = destinationFilename.lastIndexOf(".");
				// Period before extension is preserved in the string
				destinationExtension = destinationFilename.substring(lastPeriod);
				// Period before extension is removed from the string
				destinationFilename = destinationFilename.substring(0, lastPeriod);
			}

			Queue<String> linesInFile = new LinkedList<String>();
			try (Scanner sourceScanner = new Scanner(sourceFile.getAbsoluteFile())) {
				while (sourceScanner.hasNextLine()) {
					String line = sourceScanner.nextLine();
					linesInFile.offer(line);
				}
			}

			int numberOfLinesInFile = linesInFile.size();
			int numberOfFilesToCreate = (int) Math.ceil((double) numberOfLinesInFile / maxLineCount);

			System.out.println(String.format("The input file has %d lines of text." + System.lineSeparator(),
					numberOfLinesInFile));
			System.out.println("Each file that is created should have a sequential number assigned to it."
					+ System.lineSeparator());
			System.out.println(String.format(
					"For a %d line input file \"%s%s\" this will produce %d output files." + System.lineSeparator(),
					numberOfLinesInFile, destinationFilename, destinationExtension, numberOfFilesToCreate));

			System.out.println("**GENERATING OUTPUT**" + System.lineSeparator());

			for (int currentFileNumber = 1; currentFileNumber <= numberOfFilesToCreate; currentFileNumber++) {
				String currentFileName = destinationFilename + "-" + currentFileNumber + destinationExtension;
				System.out.println(currentFileName);

				File destinationFile = new File(destinationPath + File.separatorChar + currentFileName);

				try (PrintWriter destinationWriter = new PrintWriter(destinationFile)) {
					for (int lineNumber = 0; !linesInFile.isEmpty() && lineNumber < maxLineCount; lineNumber++) {
						destinationWriter.println(linesInFile.poll());
					}
				}
			}
			System.out.println();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
