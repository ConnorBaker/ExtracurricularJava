/*
*  Filename: Main.java
*  Author: Connor Baker
*  Version: 0.1b
*  Date created: March 13, 2017
*  Last updated: March 14, 2017
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.io.IOException;
import java.util.Arrays;



public class Main {
  public static void main(String[] args) throws IOException {
    ProgramIO.printDescription();
    PromptUser.promptUser();
    OrbitOfOneInBase.run(PromptUser.baseToUse);
    FindForbiddenWords.initializeRequiredVariables();
    FindForbiddenWords.fillSubwords();
    System.out.println(Arrays.deepToString(FindForbiddenWords.allSubwords));
    FindForbiddenWords.flagForbiddenSubwords();
    FindForbiddenWords.fillForbiddenSubwords();
    RemoveForbiddenWords.fillAllWords();
    RemoveForbiddenWords.flagForbiddenWords();
    if (PromptUser.printToFile) {
      ProgramIO.printToFile();
    } else {
      ProgramIO.printToConsole();
    }
  }
}
