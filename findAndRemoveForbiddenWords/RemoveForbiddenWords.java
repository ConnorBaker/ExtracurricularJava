/*
*  Filename: RemoveForbiddenWords.java
*  Author: Connor Baker
*  Version: 0.1c
*  Date created: March 13, 2017
*  Last updated: March 14, 2017
*/



// Declare our package
package findAndRemoveForbiddenWords;



// Declare our imports
import java.math.BigInteger;


public class RemoveForbiddenWords {
  static String[][] allWords = null;
  static int numberOfAllowedWords;
  static int numberOfForbiddenWords;




  public static void fillAllWords() {
    allWords = new String[(int)Math.pow((double) PromptUser.baseToUse, (double) PromptUser.allowedWord.length())][2];
    for (int i = 0; i < allWords.length; i++) {
      // Fill the array with leading zeros so we meet the requirement for
      // number of places to track and so that we can find forbidden words
      allWords[i][0] = String.format("%0"+PromptUser.allowedWord.length()+ 'd', new
      BigInteger(Long.toString((long) i, PromptUser.baseToUse)));
      allWords[i][1] = "Allowed"; // Default to the word being allowed
    }
  }



  public static void flagForbiddenWords() {
    for (int i = 0; i < allWords.length; i++) {
      for (int j = 0; j < FindForbiddenWords.numberOfForbiddenSubwords; j++) {
        if (allWords[i][0].contains(FindForbiddenWords.forbiddenSubwords[j])) {
          allWords[i][1] = "Forbidden"; // Mark the string as having a forbidden word
          numberOfForbiddenWords++;
          break;
        }
      }
    }
    numberOfAllowedWords = allWords.length - numberOfForbiddenWords;
  }
}
