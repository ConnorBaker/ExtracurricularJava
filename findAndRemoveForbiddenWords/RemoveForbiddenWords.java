/*
*  Filename: RemoveForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 13, 2017
*  Last updated: March 13, 2017
*/



// Declare our package
package findAndRemoveForbiddenWords;



// Declare our imports
import java.math.BigInteger;
import java.util.Arrays;



public class RemoveForbiddenWords {
  static String[][] allWords;
  static int numberOfAllowedWords = 0;
  static int numberOfForbiddenWords = 0;




  public static void fillAllWords() {
    allWords = new String[(int)Math.pow(PromptUser.baseToUse, PromptUser.allowedWord.length())][2];
    for (int i = 0; i < allWords.length; i++) {
      // Fill the array with leading zeros so we meet the requirement for
      // number of places to track and so that we can find forbidden words
      allWords[i][0] = String.format("%0"+PromptUser.allowedWord.length()+"d", new
      BigInteger(Long.toString(i, PromptUser.baseToUse)));
    }
  }



  public static void flagForbiddenWords() {
    for (int i = 0; i < allWords.length; i++) {
      for (int j = 0; j < FindForbiddenWords.numberOfForbiddenSubwords; j++) {
        if (allWords[i][0].contains(FindForbiddenWords.forbiddenSubwords[j])) {
          allWords[i][1] = "Forbidden"; // Mark the string as having a forbidden word
          numberOfForbiddenWords++;
        } else {
          allWords[i][1] = "Allowed"; // Mark the string as not having a forbidden word
          numberOfAllowedWords++;
        }
      }
    }
  }
}
