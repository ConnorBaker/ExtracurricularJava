/*
*  Filename: DetectForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.2b
*  Date created: March 3, 2017
*  Last updated: March 6, 2017
*
*  Description: Take input from a user (forbidden words) and calculate all
*               the strings in that base that are allowed given the inputted
*               forbidden words.
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



public class DetectForbiddenWords {
  static String allowedWord;
  static boolean printToFile;
  static String filename;
  static String[][] allSubwords;
  static Scanner grabber = new Scanner(System.in);
  static int baseToUse;
  static int numberOfAllowedSubwords = 0;
  static int numberOfForbiddenSubwords = 0;

  public static void printDescription() {
    System.out.println("/*"
    +"\n*  Filename: DetectForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.2b"
    +"\n*  Date created: March 3, 2017"
    +"\n*  Last updated: March 6, 2017"
    +"\n*"
    +"\n*  Description: Take input from a user (forbidden words) and calculate all"
    +"\n*               the strings in that base that are allowed given the inputted"
    +"\n*               forbidden words."
    +"\n*/");
  }

  public static void promptUser() {
    System.out.println("Input whole number base to use:");
    baseToUse = grabber.nextInt();
    grabber.nextLine(); // Ready for input again
    System.out.println("Input allowed string");
    allowedWord = grabber.nextLine();
    System.out.println("Print output to a file? (Y/N)");
    printToFile = ((grabber.nextLine()).toLowerCase()).equals("y");
    if (printToFile) {
      System.out.println("Filename to write to?");
      filename = grabber.nextLine();
    }
  }

  public static void fillArray() {
    // INitialize the array of sub words
    allSubwords = new String[allowedWord.length()][3];

    // Fill in the array of sub words
    for (int i = 0; i < allowedWord.length(); i++) {
      allSubwords[i][0] = allowedWord.substring(0, i+1); // range of substring is exclusive, so add one to get the entirety of the string
    }
  }


  /*
  *  Check notes to make sure that I'm actually calculating the forbidden words.
  *  In the current implementation, I'm just marking forbidden words, but I need
  *  to calculate forbidden words as well.
  */
  public static void removeForbiddenStrings() {
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
    // Print allowed subwords to file
    System.out.println("Allowed strings include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Allowed")) {
        System.out.println(allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to file
    System.out.println("Forbidden strings include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        System.out.println(allSubwords[i][2]);
      }
    }

    // Print info
    System.out.println("Number of total strings: "+allowedWord.length());
    System.out.println("Number of allowed strings: "+numberOfAllowedSubwords);
    System.out.println("Number of forbidden strings: "+numberOfForbiddenSubwords);
  }

  public static void printToFile() throws IOException {
    // Initialize our objects used for writing to file
    FileWriter tempfile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tempfile);
    PrintWriter tempPW = new PrintWriter(tempBW);

    // Print Description
    tempPW.println("/*"
    +"\n*  Filename: DetectForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.2b"
    +"\n*  Date created: March 3, 2017"
    +"\n*  Last updated: March 6, 2017"
    +"\n*"
    +"\n*  Description: Take input from a user (forbidden words) and calculate all"
    +"\n*               the strings in that base that are allowed given the inputted"
    +"\n*               forbidden words."
    +"\n*/");

    // Copy of use input
    tempPW.println("Input whole number base to use:");
    tempPW.println(baseToUse);
    tempPW.println("Input allowed string");
    tempPW.println(allowedWord);
    tempPW.println("Print output to a file? (Y/N)");
    tempPW.println(printToFile);
    tempPW.println("Filename to write to?");
    tempPW.println(filename);

    // Print allowed subwords to file
    tempPW.println("Allowed strings include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Allowed")) {
        tempPW.println(allSubwords[i][2]);
      }
    }

    // Print forbidden subwords to file
    tempPW.println("Forbidden strings include:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        tempPW.println(allSubwords[i][2]);
      }
    }

    // Print info
    tempPW.println("Number of total strings: "+allowedWord.length());
    tempPW.println("Number of allowed strings: "+numberOfAllowedSubwords);
    tempPW.println("Number of forbidden strings: "+numberOfForbiddenSubwords);

    // Close PrintWriter
    tempPW.flush();
    tempPW.close();
  }

  public static void main(String[] args) throws IOException {
    printDescription();
    promptUser();
    fillArray();
    removeForbiddenStrings();
    if (printToFile) {
      printToFile();
    } else {
      printToConsole();
    }
  }
}
