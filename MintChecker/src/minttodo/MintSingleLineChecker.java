package minttodo;

import java.util.HashSet;
import java.util.HashMap;

// The abstract parent class for all the single line checkers.
public abstract class MintSingleLineChecker implements MintChecker{
  // Checks if a line satisfies the checker's rule:
  public abstract boolean checkLine(String line);
  
  // Records a failed line.
  public void failedAtLine(int line_num) {
    failedLines.add(line_num);
  }
  
  // Returns error messages for all the failed lines found by the checker.
  public HashMap<Integer, String> getErrors(String filename) {
    HashMap<Integer, String> errors = new HashMap<Integer, String>();
    for(Integer i : failedLines) {
      String err = filename + ":" + i + ": error: " + errorMessage;
      errors.put(i, err);
    }
    return errors;
  }
  
  // **** TODO ****
  // Create a constructor that is protected, that creates a new HashSet --> failedLines

  protected HashSet<Integer> failedLines;
  protected String errorMessage;
  protected MintSingleLineChecker(HashSet<Integer> failedLines, String errorMessage) {
	  this.failedLines = failedLines;
	  this.errorMessage = errorMessage;
  }
  
  
}
