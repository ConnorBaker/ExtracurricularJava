/*
*  Filename: ProgramIO.java
*  Author: Connor Baker
*  Version: 0.1c
*  Date created: March 13, 2017
*  Last updated: March 14, 2017
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class ProgramIO {
  public static void printDescription() {
    System.out.println("This program takes as input a base (1,10), an allowed word in that base, and calculates forbidden subwords and words in that base."
    +"\nFor larger bases, it is recommended to use the option to export to a file. Please note that it will be placed in the directory above where the source code is compiled and run.");
  }



  public static void printToConsole() {
    // Print allowed subwords to console
    System.out.println("Allowed subwords include:");
    for (int i = 0; i < FindForbiddenWords.allSubwords.length; i++) {
      if ("Allowed".equals(FindForbiddenWords.allSubwords[i][1])) {
        System.out.println(FindForbiddenWords.allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to console
    System.out.println("Forbidden subwords include:");
    for (int i = 0; i < FindForbiddenWords.allSubwords.length; i++) {
      if ("Forbidden".equals(FindForbiddenWords.allSubwords[i][1])) {
        System.out.println(FindForbiddenWords.allSubwords[i][2]);
      }
    }

    // Print info
    System.out.println("Number of total subwords: "+FindForbiddenWords.allowedWord.length());
    System.out.println("Number of allowed subwords: "+FindForbiddenWords.numberOfAllowedSubwords);
    System.out.println("Number of forbidden subwords: "+FindForbiddenWords.numberOfForbiddenSubwords);

    // Print allowed words to console
    System.out.println("All allowed words are:");
    for (int i = 0; i < RemoveForbiddenWords.allWords.length; i++) {
      if ("Allowed".equals(RemoveForbiddenWords.allWords[i][1])) {
        System.out.println(RemoveForbiddenWords.allWords[i][0]);
      }
    }

    // Print forbidden words to console
    System.out.println("All forbidden words are:");
    for (int i = 0; i < RemoveForbiddenWords.allWords.length; i++) {
      if ("Forbidden".equals(RemoveForbiddenWords.allWords[i][1])) {
        System.out.println(RemoveForbiddenWords.allWords[i][0]);
      }
    }

    // Print info
    System.out.println("Number of total words: "+RemoveForbiddenWords.allWords.length);
    System.out.println("Number of allowed words: "+RemoveForbiddenWords.numberOfAllowedWords);
    System.out.println("Number of forbidden words: "+RemoveForbiddenWords.numberOfForbiddenWords);
  }



  public static void printToFile() throws IOException {
    // Initialize our objects used for writing to file
    final FileWriter tempfile = new FileWriter(PromptUser.filename);
    final BufferedWriter tempBW = new BufferedWriter(tempfile);
    final PrintWriter tempPW = new PrintWriter(tempBW);

    // Print Description
    tempPW.println("This program takes as input a whole number base [2,10], an allowed word in that base, and calculates forbidden subwords and words in that base."
    +"\nFor larger bases, it is recommended to use the option to export to a file. Please note that it will be placed in the directory above where the source code is compiled and run.");

    // Copy of use input
    tempPW.println("Input base to use:");
    tempPW.println(FindForbiddenWords.baseToUse);
    tempPW.println("Print output to a file? (Y/N)");
    tempPW.println(PromptUser.printToFile);
    tempPW.println("Filename to write to?");
    tempPW.println(PromptUser.filename);

    // Print allowed subwords to console
    tempPW.println("Allowed subwords include:");
    for (int i = 0; i < FindForbiddenWords.allSubwords.length; i++) {
      if ("Allowed".equals(FindForbiddenWords.allSubwords[i][1])) {
        tempPW.println(FindForbiddenWords.allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to console
    tempPW.println("Forbidden subwords include:");
    for (int i = 0; i < FindForbiddenWords.allSubwords.length; i++) {
      if ("Forbidden".equals(FindForbiddenWords.allSubwords[i][1])) {
        tempPW.println(FindForbiddenWords.allSubwords[i][2]);
      }
    }

    // Print info
    tempPW.println("Number of total subwords: "+FindForbiddenWords.allowedWord.length());
    tempPW.println("Number of allowed subwords: "+FindForbiddenWords.numberOfAllowedSubwords);
    tempPW.println("Number of forbidden subwords: "+FindForbiddenWords.numberOfForbiddenSubwords);

    // Print allowed words to console
    tempPW.println("All allowed words are:");
    for (int i = 0; i < RemoveForbiddenWords.allWords.length; i++) {
      if ("Allowed".equals(RemoveForbiddenWords.allWords[i][1])) {
        tempPW.println(RemoveForbiddenWords.allWords[i][0]);
      }
    }

    // Print forbidden words to console
    tempPW.println("All forbidden words are:");
    for (int i = 0; i < RemoveForbiddenWords.allWords.length; i++) {
      if ("Forbidden".equals(RemoveForbiddenWords.allWords[i][1])) {
        tempPW.println(RemoveForbiddenWords.allWords[i][0]);
      }
    }

    // Print info
    tempPW.println("Number of total words: "+RemoveForbiddenWords.allWords.length);
    tempPW.println("Number of allowed words: "+RemoveForbiddenWords.numberOfAllowedWords);
    tempPW.println("Number of forbidden words: "+RemoveForbiddenWords.numberOfForbiddenWords);

    // Close PrintWriter
    tempPW.flush();
    tempPW.close();
  }
}
