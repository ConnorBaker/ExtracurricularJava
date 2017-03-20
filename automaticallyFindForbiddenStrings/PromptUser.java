/*
*  Filename: PromptUser.java
*  Author: Connor Baker
*  Version: 0.1b
*  Date created: March 13, 2017
*  Last updated: March 14, 2017
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.util.Scanner;



public class PromptUser {
  public static final Scanner grabber = new Scanner(System.in);
  public static String filename = null;
  public static boolean printToFile = false;
  public static String baseToUse = null;



  public static void promptUser() {
    System.out.println("Input number base to use:");
    baseToUse = grabber.nextLine();
    System.out.println("Print output to a file? (Y/N)");
    printToFile = "y".equals((grabber.nextLine()).toLowerCase());
    if (printToFile) {
      System.out.println("Filename to write to?");
      filename = grabber.nextLine();
    }
  }
}
