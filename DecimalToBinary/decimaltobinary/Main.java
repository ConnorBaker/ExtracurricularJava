/*
*  filename: Main.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user into its binary
*  representation. Allows for arbitrary precision given that there is enough
*  memory allowed in the stack.
*/

// Declare our package
package decimaltobinary;

// Import the necessary packages
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
  // String to hold our split input
  static String input[] = new String[2];

  // Boolean to check for debugging
  final static boolean debugging = false;

  // Declare arrays that we'll use for processing
  final static BigDecimal[] VALUES = {new BigDecimal("1.0"),
                                      new BigDecimal("2.0"),
                                      new BigDecimal("3.0"),
                                      new BigDecimal("4.0"),
                                      new BigDecimal("5.0"),
                                      new BigDecimal("6.0"),
                                      new BigDecimal("7.0"),
                                      new BigDecimal("8.0"),
                                      new BigDecimal("9.0"),
                                      new BigDecimal("10.0"),
                                      new BigDecimal("11.0"),
                                      new BigDecimal("12.0"),
                                      new BigDecimal("13.0"),
                                      new BigDecimal("14.0"),
                                      new BigDecimal("15.0"),
                                      new BigDecimal("16.0")};

  // Look up table that both classes use
  final static String[] LUT = {"0000","0001","0010","0011",
                               "0100","0101","0110","0111",
                               "1000","1001","1010","1011",
                               "1100","1101","1110","1111"};

  // Method to initialize the object
  public static void initialization() {
    System.out.println("Input a decimal in base 10:");
    // Declare scanner we use to grab input
    Scanner grabber = new Scanner(System.in);
    input = (grabber.nextLine()).split("\\.");
  }


  // Main method
  public static void main(String[] args) {
    // initialize things
    initialization();

    // Start the thread that calculates the whole number portion
    Thread thread0 = new Thread(new DecimalToBinary(input[0]));
    thread0.start();

    try {
      // Start the thread that calculates the fraction portion
      Thread thread1 = new Thread(new DecimalFractionToBinaryFraction(input[1]));
      thread1.start();
    } catch (ArrayIndexOutOfBoundsException e) {
      // input[1] wasn't created because it doesn't have a fractional part
    }
  }
}
