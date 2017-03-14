/*
*  Filename: FindForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 13, 2017
*  Last updated: March 13, 2017
*/



// Declare our package
package findAndRemoveForbiddenWords;



// Declare our imports
import java.util.Arrays;



public class FindForbiddenWords {
  static String[][] allSubwords;
  static String[] forbiddenSubwords;
  static int numberOfAllowedSubwords = 0;
  static int numberOfForbiddenSubwords = 0;



  public static void fillSubwords() {
    // Initialize the array of sub words
    allSubwords = new String[PromptUser.allowedWord.length()][3];

    // Fill in the array of sub words
    for (int i = 0; i < PromptUser.allowedWord.length(); i++) {
      allSubwords[i][0] = PromptUser.allowedWord.substring(0, i+1); // range of substring is exclusive, so add one to get the entirety of the string
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
      temp[i] = (char)(PromptUser.baseToUse+47);
    }
    return new String(temp);
  }


  public static void flagForbiddenSubwords() {
    for (int i = 0; i < PromptUser.allowedWord.length(); i++) {
      if (allSubwords[i][0].equals(maxValueStringOfBase(i))) { // String is equal to string of maximum allowed number in base
        allSubwords[i][1] = "Allowed";
        // Store the allowed or forbidden string in the second element
        allSubwords[i][2] =  new String(Long.toString(1 + Long.parseLong(allSubwords[i][0], PromptUser.baseToUse), PromptUser.baseToUse));
        numberOfAllowedSubwords++;
      } else {
        allSubwords[i][1] = "Forbidden";
        // Store the allowed or forbidden string in the second element
        allSubwords[i][2] =  new String(Long.toString(1 + Long.parseLong(allSubwords[i][0], PromptUser.baseToUse), PromptUser.baseToUse));
        numberOfForbiddenSubwords++;
      }
    }
  }



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
}
