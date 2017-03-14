/*
*  Filename: Main.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 12, 2017
*  Last updated: March 13, 2017
*/



// Declare our package
package findAndRemoveForbiddenWords;



// Declare our imports
import java.io.IOException;


public class Main {
  public static void main(String[] args) throws IOException {
    ProgramIO.printDescription();
    PromptUser.promptUser();
    FindForbiddenWords.fillSubwords();
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
