/*
*  Filename: DetectForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1b
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
  static String[][] allSubwords;
  static Scanner grabber = new Scanner(System.in);
  static int baseToUse;
  static int numberOfAllowedSubwords = 0;
  static int numberOfForbiddenSubwords = 0;

  public static void printDescription() {
    System.out.println("/*"
    +"\n*  Filename: DetectForbiddenWords.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.1b"
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
    allSubwords = new String[allowedWord.length()][2];

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
      } else {
        allSubwords[i][1] = "Forbidden";
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
    System.out.println(temp);
    return new String(temp);
  }

  public static void printAllowedSubwords() {
    System.out.println("All allowed strings are:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Allowed")) {
        System.out.println(allSubwords[i][0]);
      }
    }
  }

  public static void printForbiddenSubwords() {
    System.out.println("All forbidden strings are:");
    for (int i = 0; i < allSubwords.length; i++) {
      if (allSubwords[i][1].equals("Forbidden")) {
        System.out.println(allSubwords[i][0]);
      }
    }
  }

  public static void main(String[] args) {
    printDescription();
    promptUser();
    fillArray();
    removeForbiddenStrings();
    printAllowedSubwords();
    printForbiddenSubwords();
    // System.out.println("Number of total strings: "+(int)Math.pow(baseToUse, placesToTrack));
    // System.out.println("Number of allowed strings: "+numberOfAllowedStrings);
    // System.out.println("Number of forbidden strings: "+numberOfForbiddenStrings);
  }
}
