package minttodo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import minttodo.MintChecker;

public class MintManager {

	// Checkers
	private ArrayList<MintChecker> singleLineCheckers;
	private MintSpaceAtEndOfLineChecker spaceAtEndOfLineChecker;
	private MintLineWidthChecker lineWidthChecker;

	private ArrayList<String> originalLines;
	// Use a TreeMap to keep the keys (line numbers) sorted.
	private TreeMap<Integer, ArrayList<String>> errors;
	private String pathToFile;
	private int numErrors;

	// Constructor
	public MintManager(String pathToFile) throws IOException {
		// **** TODO ****
		// Initialize singleLineCheckers. Initialize two checkers and add
		// them to singleLineCheckers

		errors = new TreeMap<Integer, ArrayList<String>>();
		originalLines = new ArrayList<String>();
		// Add a dummy line so originalLines[1] stores the first line.
		originalLines.add("");
		this.pathToFile = pathToFile;
		numErrors = 0;
		// Read all the lines in the input file.
		readLinesFromFile();
	}

	// Returns path to the file to check.
	public String getPathToFile() {
		return pathToFile;
	}

	// Returns the total number of errors.
	public int getNumErrors() {
		return numErrors;
	}

	// Check each line
	public void check() {
		checkLines();
		collectErrors();
	}

	// Return errors as a string. The lines will be in order since we use
	// TreeMap which keeps its key sorted.
	public String getErrors() {
		StringBuilder b = new StringBuilder();
		for (Map.Entry<Integer, ArrayList<String>> error : errors.entrySet()) {
			for (String msg : error.getValue()) {
				b.append(msg + System.lineSeparator());
			}
		}
		return b.toString();
	}

	// Read all the lines from the input file.
	private void readLinesFromFile() throws IOException {
		// Try to open the given file and create a scanner to read in each line.
		try (Scanner scanner = new Scanner(new File(pathToFile))) {
			while (scanner.hasNextLine()) {
				originalLines.add(scanner.nextLine());
			}
		}
	}

	// Check lines with checkers
	private void checkLines() {
		for (int i = 1; i < originalLines.size(); ++i) {
			String line = originalLines.get(i);
			for (MintChecker c : singleLineCheckers) {
				if (!c.checkLine(line)) {
					c.failedAtLine(i);
				}
			}
		}
	}

	// Collect error lines
	private void collectErrors() {
		numErrors = 0;
		// Accumulate errors found by each checker
		for (MintChecker c : singleLineCheckers) {
			// Put all errors from checker c into a set so we can go through
			// them.
			Set<Map.Entry<Integer, String>> error_set = c.getErrors(pathToFile)
					.entrySet();
			for (Map.Entry<Integer, String> e : error_set) {
				Integer error_line_num = e.getKey();
				// If the error line exists in the TreeMap named errors, append
				// the
				// message to its message list; otherwise create a new arraylist
				// to hold
				// messages for this line and add the message to the new
				// arraylist.
				if (errors.containsKey(error_line_num)) {
					errors.get(error_line_num).add(e.getValue());
				} else {
					errors.put(error_line_num, new ArrayList<String>());
					errors.get(error_line_num).add(e.getValue());
				}
			}
			numErrors += error_set.size();
		}
	}

}
