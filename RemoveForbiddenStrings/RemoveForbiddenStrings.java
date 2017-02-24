/*
*  Filename: RemoveForbiddenStrings.java
*  Author: Connor Baker
*  Version: 0.1b
*  Date created: February 23, 2017
*  Last updated: February 23, 2017
*
*  Description: Take input from a user (forbidden words) and calculate all
*               the strings in that base that are allowed given the inputted
*               forbidden words.
*/

// Declare our imports
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;

public class RemoveForbiddenStrings {
  static String[][] arrayOfNumbers;
  static String[] forbiddenWords;
  static Scanner grabber = new Scanner(System.in);
  static int baseToUse;
  static int placesToTrack;
  static int numberOfAllowedStrings = 0;
  static int numberOfForbiddenStrings = 0;

  public static void printDescription() {
    System.out.println("/*\n"
    +"*  Filename: RemoveForbiddenStrings.java\n"
    +"*  Author: Connor Baker\n"
    +"*  Version: 0.1a\n"
    +"*  Date created: February 23, 2017\n"
    +"*  Last updated: February 23, 2017\n"
    +"*\n"
    +"*  Description: Take input from a user (forbidden words) and calculate all\n"
    +"*               the strings in that base that are allowed given the inputted\n"
    +"*               forbidden words.\n"
    +"*/\n");
  }

  public static void promptUser() {
    System.out.println("Input whole number base to use:");
    baseToUse = grabber.nextInt();
    System.out.println("Input number of places to track:");
    placesToTrack = grabber.nextInt();
    grabber.nextLine();
    System.out.println("Input forbidden words seperated by commas");
    forbiddenWords = (grabber.nextLine()).split(",");
    System.out.println("Forbidden words are:");
    System.out.println(Arrays.deepToString(forbiddenWords));
  }

  public static void fillArray() {
    arrayOfNumbers = new String[(int)Math.pow(baseToUse, placesToTrack)][2];
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      // Fill the array with leading zeros so we meet the requirement for
      // number of places to track and so that we can find forbidden words
      arrayOfNumbers[i][0] = String.format("%0"+placesToTrack+"d", new
                             BigInteger(Integer.toString(i, baseToUse)));
    }
  }

  public static void removeForbiddenStrings() {
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      for (int j = 0; j < forbiddenWords.length; j++) {
        if (arrayOfNumbers[i][0].contains(forbiddenWords[j])) {
          arrayOfNumbers[i][1] = "T"; // Mark the string as having a forbidden word
          break;
        } else {
          arrayOfNumbers[i][1] = "F"; // Mark the string as not having a forbidden word
        }
      }
    }
  }

  public static void printAllowedStrings() {
    System.out.println("All allowed strings are:");
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      if (arrayOfNumbers[i][1].equals("T")) {
        numberOfAllowedStrings++;
      } else {
        System.out.println(arrayOfNumbers[i][0]);
      }
    }
  }

  public static void printForbiddenStrings() {
    System.out.println("All forbidden strings are:");
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      if (arrayOfNumbers[i][1].equals("F")) {
        numberOfForbiddenStrings++;
      } else {
        System.out.println(arrayOfNumbers[i][0]);
      }
    }
  }

  public static void main(String[] args) {
    printDescription();
    promptUser();
    fillArray();
    removeForbiddenStrings();
    printAllowedStrings();
    printForbiddenStrings();
    System.out.println("Number of total strings: "+(int)Math.pow(baseToUse, placesToTrack));
    System.out.println("Number of allowed strings: "+numberOfAllowedStrings);
    System.out.println("Number of forbidden strings: "+numberOfForbiddenStrings);
  }
}
