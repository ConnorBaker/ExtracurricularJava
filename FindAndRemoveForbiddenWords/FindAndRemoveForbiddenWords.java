/*
*  Filename: FindAndRemoveForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 12, 2017
*  Last updated: March 13, 2017
*
*  Description: Take input from a user (forbidden words) and calculate all
*               the strings in that base that are allowed given the inputted
*               forbidden words. Then, print all strings that are allowed in
*               that base.
*
*  Todo: Fix the fact that if we use a string that does not contain the maximum
*        allowed digit in the base that we miss out on a whole bunch of
*        forbidden strings. As the program currently works, it takes a
*        concatenation of the base and compares it to several subwords of the
*        allowed word and looks for a match. We need to change it so that it...
*        I'm too tired I can't remember. But there is a problem here.
*
*        Also fix the issue with flagForbiddenWords() not spotting forbidden
*        subwords in words. Example: base 2, 1101 as allowed word. Forbidden
*        subwords are 111, 1110, yet both of them show up in allowed words.
*
*        Also fix the issue with number of allowed and forbidden words being
*        printed. For an example, use the same input as in the paragraph above.
*/



// Declare our imports
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Arrays;



public class FindAndRemoveForbiddenWords {
  static String allowedWord;
  static boolean printToFile;
  static String filename;
  static String[][] allWords;
  static String[][] allSubwords;
  static String[] forbiddenSubwords;
  static Scanner grabber = new Scanner(System.in);
  static int baseToUse;
  static int numberOfAllowedSubwords = 0;
  static int numberOfForbiddenSubwords = 0;
  static int numberOfAllowedWords = 0;
  static int numberOfForbiddenWords = 0;



  public static void printDescription() {
    System.out.println("/*"
    +"\n*  Filename: FindAndRemoveForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.1a"
    +"\n*  Date created: March 12, 2017"
    +"\n*  Last updated: March 13, 2017"
    +"\n*"
    +"\n*  Description: Take input from a user (forbidden words) and calculate all"
    +"\n*               the strings in that base that are allowed given the inputted"
    +"\n*               forbidden words. Then, print all strings that are allowed in"
    +"\n*               that base."
    +"\n*/");
  }



  public static void promptUser() {
    System.out.println("Input whole number base to use:");
    baseToUse = grabber.nextInt();
    grabber.nextLine(); // Ready for input again
    System.out.println("Input allowed word");
    allowedWord = grabber.nextLine();
    System.out.println("Print output to a file? (Y/N)");
    printToFile = ((grabber.nextLine()).toLowerCase()).equals("y");
    if (printToFile) {
      System.out.println("Filename to write to?");
      filename = grabber.nextLine();
    }
  }



  public static void fillAllWords() {
    allWords = new String[(int)Math.pow(baseToUse, allowedWord.length())][2];
    for (int i = 0; i < allWords.length; i++) {
      // Fill the array with leading zeros so we meet the requirement for
      // number of places to track and so that we can find forbidden words
      allWords[i][0] = String.format("%0"+allowedWord.length()+"d", new
      BigInteger(Integer.toString(i, baseToUse)));
    }
  }



  public static void fillSubwords() {
    // Initialize the array of sub words
    allSubwords = new String[allowedWord.length()][3];

    // Fill in the array of sub words
    for (int i = 0; i < allowedWord.length(); i++) {
      allSubwords[i][0] = allowedWord.substring(0, i+1); // range of substring is exclusive, so add one to get the entirety of the string
    }
  }



  // Must call flagForbiddenSubwords before this method
  public static void fillForbiddenSubwords() {
    // Initialize the array of sub words
    forbiddenSubwords = new String[numberOfForbiddenSubwords];
    // Fill in the array of sub words
    int index = 0;
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        forbiddenSubwords[index] = allSubwords[i][2]; // copies the forbidden subword
        index++;
      }
    }
  }



  public static void flagForbiddenSubwords() {
    for (int i = 0; i < allowedWord.length(); i++) {
      if (allSubwords[i][0].equals(maxValueStringOfBase(i))) { // String is equal to string of maximum allowed number in base
        allSubwords[i][1] = "Allowed";
        // Store the allowed or forbidden string in the second element
        allSubwords[i][2] =  new String(Integer.toString(1 + Integer.parseInt(allSubwords[i][0], baseToUse), baseToUse));
        numberOfAllowedSubwords++;
      } else {
        allSubwords[i][1] = "Forbidden";
        // Store the allowed or forbidden string in the second element
        allSubwords[i][2] =  new String(Integer.toString(1 + Integer.parseInt(allSubwords[i][0], baseToUse), baseToUse));
        numberOfForbiddenSubwords++;
      }
    }
  }



  public static void flagForbiddenWords() {
    for (int i = 0; i < allWords.length; i++) {
      for (int j = 0; j < numberOfForbiddenSubwords; j++) {
        if (allWords[i][0].contains(forbiddenSubwords[j])) {
          allWords[i][1] = "Forbidden"; // Mark the string as having a forbidden word
          numberOfForbiddenWords++;
        } else {
          allWords[i][1] = "Allowed"; // Mark the string as not having a forbidden word
          numberOfAllowedWords++;
        }
      }
    }
  }



  public static String maxValueStringOfBase(int length) {
    // The array has to have a size that is indexed at one rather than zero so that is prints out maxvalue strings of adequate length
    char[] temp = new char[length+1];
    for (int i = 0; i <= length; i++) {
      /*
      *  Add the ASCII value less one and use that as a char (this takes care
      *  of the plus 48 to use the base as a number, and the minus one takes
      *  care of the fact that the largest allowed numeral in a base is the
      *  radix less one)
      */
      temp[i] = (char)(baseToUse+47);
    }
    return new String(temp);
  }



  public static void printToConsole() {
    // Print allowed subwords to console
    System.out.println("Allowed subwords include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Allowed")) {
        System.out.println(allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to console
    System.out.println("Forbidden subwords include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        System.out.println(allSubwords[i][2]);
      }
    }

    // Print info
    System.out.println("Number of total subwords: "+allowedWord.length());
    System.out.println("Number of allowed subwords: "+numberOfAllowedSubwords);
    System.out.println("Number of forbidden subwords: "+numberOfForbiddenSubwords);

    // Print allowed words to console
    System.out.println("All allowed words are:");
    for (int i = 0; i < allWords.length; i++) {
      if (allWords[i][1].equals("Allowed")) {
        System.out.println(allWords[i][0]);
      }
    }

    // Print forbidden words to console
    System.out.println("All forbidden words are:");
    for (int i = 0; i < allWords.length; i++) {
      if (allWords[i][1].equals("Forbidden")) {
        System.out.println(allWords[i][0]);
      }
    }

    // Print info
    System.out.println("Number of total words: "+allWords.length);
    System.out.println("Number of allowed words: "+numberOfAllowedWords);
    System.out.println("Number of forbidden words: "+numberOfForbiddenWords);
  }



  public static void printToFile() throws IOException {
    // Initialize our objects used for writing to file
    FileWriter tempfile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tempfile);
    PrintWriter tempPW = new PrintWriter(tempBW);

    // Print Description
    tempPW.println("/*"
    +"\n*  Filename: FindAndRemoveForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.1a"
    +"\n*  Date created: March 12, 2017"
    +"\n*  Last updated: March 13, 2017"
    +"\n*"
    +"\n*  Description: Take input from a user (forbidden words) and calculate all"
    +"\n*               the strings in that base that are allowed given the inputted"
    +"\n*               forbidden words. Then, print all strings that are allowed in"
    +"\n*               that base."
    +"\n*/");

    // Copy of use input
    tempPW.println("Input whole number base to use:");
    tempPW.println(baseToUse);
    tempPW.println("Input allowed word");
    tempPW.println(allowedWord);
    tempPW.println("Print output to a file? (Y/N)");
    tempPW.println(printToFile);
    tempPW.println("Filename to write to?");
    tempPW.println(filename);

    // Print allowed subwords to file
    tempPW.println("Allowed subwords include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Allowed")) {
        tempPW.println(allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to file
    tempPW.println("Forbidden subwords include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        tempPW.println(allSubwords[i][2]);
      }
    }

    // Print info
    tempPW.println("Number of total subwords: "+allowedWord.length());
    tempPW.println("Number of allowed subwords: "+numberOfAllowedSubwords);
    tempPW.println("Number of forbidden subwords: "+numberOfForbiddenSubwords);


    // Print allowed words to console
    tempPW.println("All allowed words are:");
    for (int i = 0; i < allWords.length; i++) {
      if (allWords[i][1].equals("Allowed")) {
        tempPW.println(allWords[i][0]);
      }
    }

    // Print forbidden words to console
    tempPW.println("All forbidden words are:");
    for (int i = 0; i < allWords.length; i++) {
      if (allWords[i][1].equals("Forbidden")) {
        tempPW.println(allWords[i][0]);
      }
    }

    // Print info
    tempPW.println("Number of total words: "+allWords.length);
    tempPW.println("Number of allowed words: "+numberOfAllowedWords);
    tempPW.println("Number of forbidden words: "+numberOfForbiddenWords);

    // Close PrintWriter
    tempPW.flush();
    tempPW.close();
  }



  public static void main(String[] args) throws IOException {
    printDescription();
    promptUser();
    fillSubwords();
    fillAllWords();
    flagForbiddenSubwords();
    fillForbiddenSubwords();
    flagForbiddenWords();
    if (printToFile) {
      printToFile();
    } else {
      printToConsole();
    }
  }
}
