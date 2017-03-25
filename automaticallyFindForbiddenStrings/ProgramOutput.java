/*
*  Filename: ProgramOutput.java
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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;



public class ProgramOutput {
  public static void printToConsole() {
    // Print forbidden subwords to console
    System.out.println("Forbidden subwords include:");
    for (int i = 0; i < ForbiddenWords.forbiddenSubwords.length; i++) {
      System.out.println(ForbiddenWords.forbiddenSubwords[i]);
    }
  }



  public static void printToFile() throws IOException {
    // Initialize our objects used for writing to file
    final FileWriter tempfile = new FileWriter(ProgramSetup.filename);
    final BufferedWriter tempBW = new BufferedWriter(tempfile);
    final PrintWriter tempPW = new PrintWriter(tempBW);

    // Print Description


    // Copy of use input
    tempPW.println("Input base to use:");
    tempPW.println(Base.base);
    tempPW.println("Print output to a file? (Y/N)");
    tempPW.println(ProgramSetup.printToFile);
    tempPW.println("Filename to write to?");
    tempPW.println(ProgramSetup.filename);


    // Print forbidden subwords to console
    tempPW.println("Forbidden subwords include:");
    for (int i = 0; i < ForbiddenWords.forbiddenSubwords.length; i++) {
      tempPW.println(ForbiddenWords.forbiddenSubwords[i]);
    }


    // Close PrintWriter
    tempPW.flush();
    tempPW.close();
  }
}
