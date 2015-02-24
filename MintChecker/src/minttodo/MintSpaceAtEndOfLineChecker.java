package minttodo;

import java.lang.Character;
import java.util.HashSet;

public class MintSpaceAtEndOfLineChecker extends MintSingleLineChecker {
  // Constructor.
  public MintSpaceAtEndOfLineChecker(HashSet<Integer> failedLines, String errorMessage) {
    // Call the parent class's constructor
    super(failedLines, errorMessage);
    errorMessage = "Extra space at the end of a line.";
  }

  @Override
  public boolean checkLine(String line) {
    int len = line.length();
    return !(len > 0 && Character.isWhitespace(line.charAt(len-1)));
  }
}
