package minttodo;

import java.util.HashMap;

//TODO: See MintSingleLineChecker
public interface MintChecker {
  // **** TODO ****
  // Check one line of code. For SingleLineChecker, return whether the line
  // satisfies the checkers rule (returns boolean).
	boolean checkLine(String line);
	
  // **** TODO ****
  // Record a failed line.
	void failedAtLine(int line_num);
	
  // **** TODO ****
  // Get error messages associated to previously recorded failed
  // lines.  The input filename will appear in the error message. You might
  // want to look at one of the checker's implementation to get the signature
  // for getErrors.
	HashMap<Integer, String> getErrors(String filename);
}
