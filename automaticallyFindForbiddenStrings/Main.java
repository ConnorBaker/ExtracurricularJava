/*
*  Filename: Main.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 24, 2017
*  Last updated: March 24, 2017
*
*  Description:
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.io.IOException;



public class Main {
  public static void main(String[] args) throws IOException {
    // Call our setup program
    ProgramSetup.printDescription();

    // Create our object
    Base newUserBase = new Base();

    // Run the program
    Base.calculateOrbitOfOne();

    ForbiddenWords.findForbiddenWords();


    // Decide where to print to
    if (ProgramSetup.printToFile) {
      ProgramOutput.printToFile();
    } else {
      ProgramOutput.printToConsole();
    }
  }

}
