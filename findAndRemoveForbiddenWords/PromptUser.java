/*
*  Filename: PromptUser.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 12, 2017
*  Last updated: March 13, 2017
*/



// Declare our package
package findAndRemoveForbiddenWords;



// Declare our imports
import java.util.Scanner;


public class PromptUser {
  public static Scanner grabber = new Scanner(System.in);
  public static String allowedWord;
  public static String filename;
  public static boolean printToFile;
  public static int baseToUse;



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
}
