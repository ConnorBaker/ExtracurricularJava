/*
*  Filename: DetectForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 3, 2017
*  Last updated: March 4, 2017
*
*  Description: Take input from a user (forbidden words) and calculate all
*               the strings in that base that are allowed given the inputted
*               forbidden words.
*/

// Declare our imports
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;

public class DetectForbiddenWords {
  static String allowedWord;
  static String[] allSubwords;
  static Scanner grabber = new Scanner(System.in);
  static int baseToUse;
  static int numberOfAllowedSubwords = 0;
  static int numberOfForbiddenSubwords = 0;

  public static void printDescription() {
    System.out.println("/*"
    +"\n*  Filename: DetectForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.1a"
    +"\n*  Date created: March 3, 2017"
    +"\n*  Last updated: March 4, 2017"
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
  }

  public static void fillArray() {
    // INitialize the array of sub words
    allSubwords = new String[allowedWord.length()];

    // Fill in the array of sub words
    for (int i = 0; i < allowedWord.length(); i++) {
      allSubwords[i][0] = allowedWord.substring(0, i+1); // range of substring is exclusive, so add one to get the entirety of the string
    }
  }

  // public static void removeForbiddenStrings() {
  //
  // }

  // public static void printAllowedSubwords() {
  //   System.out.println("All allowed strings are:");
  //   for (int i = 0; i < allSubwords.length; i++) {
  //     if (allSubwords[i][1].equals("Allowed")) {
  //       System.out.println(allSubwords[i][0]);
  //     }
  //   }
  // }
  //
  // public static void printForbiddenSubwords() {
  //   System.out.println("All forbidden strings are:");
  //   for (int i = 0; i < allSubwords.length; i++) {
  //     if (allSubwords[i][1].equals("Forbidden")) {
  //       System.out.println(allSubwords[i][0]);
  //     }
  //   }
  // }

  public static void main(String[] args) {
    printDescription();
    promptUser();
    fillArray();
    // removeForbiddenStrings();
    // printAllowedStrings();
    // printForbiddenStrings();
    // System.out.println("Number of total strings: "+(int)Math.pow(baseToUse, placesToTrack));
    // System.out.println("Number of allowed strings: "+numberOfAllowedStrings);
    // System.out.println("Number of forbidden strings: "+numberOfForbiddenStrings);
  }
}
