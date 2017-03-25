/*
*  Filename: Base.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 24, 2017
*  Last updated: March 24, 2017
*
*  Description:
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;



public class ProgramSetup {
  public static final Scanner grabber = new Scanner(System.in);
  public static String filename = null;
  public static boolean printToFile = false;


  public static BigDecimal getBase() {
    System.out.println("Input number base to use:");
    return new BigDecimal(grabber.nextLine());
  }

  public static BigDecimal getFloorOfBase(BigDecimal base) {
    return base.setScale(0, RoundingMode.DOWN);
  }

  public static void printDescription() {
    System.out.println("This program takes as input a base (1,10) and calculates forbidden subwords and words in that base."
    +"\nFor larger bases, it is recommended to use the option to export to a file.");
  }

  public static void promptForPrintToFile() {
    System.out.println("Print output to a file? (Y/N)");
    printToFile = "y".equals((grabber.nextLine()).toLowerCase());
    if (printToFile) {
      System.out.println("Filename to write to?");
      filename = grabber.nextLine();
    }
  }
}
