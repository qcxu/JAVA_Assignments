package minttodo;

import java.util.HashSet;

public class MintLineWidthChecker extends MintSingleLineChecker {
  // **** TODO ****
  // Constructor (calls super), defines the default maxWidth and tabSize
	public MintLineWidthChecker(HashSet<Integer> failedLines, String errorMessage) {
		super(failedLines, errorMessage);
		maxWidth = 100;
		tabSize = 3;
	}
	
  // **** TODO ****
  // Constructor with maxWidth parameter.
	public MintLineWidthChecker(HashSet<Integer> failedLines, String errorMessage, int maxWidth) {
		super(failedLines, errorMessage);
		this.maxWidth = maxWidth;
	}

  // **** TODO ****
  // Constructor with both maxWidth and tabSize parameters.
	public MintLineWidthChecker(HashSet<Integer> failedLines, 
			String errorMessage, int maxWidth, int tabSize) {
		super(failedLines, errorMessage);
		this.maxWidth = maxWidth;
		this.tabSize = tabSize;		
	}

  // **** TODO ****
  // Override checkLine() aka implement this method!
	public boolean checkLine(String line) {
		if (line.length() <= maxWidth) {
			return true;
		} else return false;
	}
	
  // A helper method to set the error message.
	private void setErrorMessage() {
		errorMessage = "Line width exceeded " + maxWidth + " characters.";
	}
  
	private int maxWidth;
	private int tabSize;
}
