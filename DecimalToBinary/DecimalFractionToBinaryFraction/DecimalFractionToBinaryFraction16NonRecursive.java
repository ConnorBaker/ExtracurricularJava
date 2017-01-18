/*
*  filename: DecimalFractionToBinaryFraction16NonRecursive.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101"). Allows for arbitrary
*  precision given that there is enough memory allowed.
*  Uses some neat math tricks.
*
*  algorithm (roughly): Take in a decimal in base 10 on (0,1). Mutliply by 16.
*  if in (0,1) add '000' to binaryRepresentation, subtract (0x2^0)
*  if in (1,2) add '001' to binaryRepresentation, subtract (1x2^0)
*  if in (2,3) add '010' to binaryRepresentation, subtract (1x2^1)
*  if in (3,4) add '011' to binaryRepresentation, subtract (1x2^0 + 1x2^1)
*  if in (4,5) add '100' to binaryRepresentation, subtract (1x2^2)
*  if in (5,6) add '101' to binaryRepresentation, subtract (1x2^0 + 1x2^2)
*  if in (6,7) add '110' to binaryRepresentation, subtract (1x2^1 + 1x2^2)
*  if in (7,8) add '111' to binaryRepresentation, subtract (1x2^0 + 1x2^1 +
*  1x2^2)
*  if in (8,9) add '1000' to binaryRepresentation, subtract (1x2^3)
*  if in (9,10) add '1001' to binaryRepresentation, subtract (1x2^0 + 1x2^3)
*  if in (10,11) add '1010' to binaryRepresentation, subtract (1x2^1 + 1x2^3)
*  if in (11,12) add '1011' to binaryRepresentation, subtract (1x2^0 + 1x2^1 +
*  1x2^3)
*  if in (12,13) add '1100' to binaryRepresentation, subtract (1x2^2 + 1x2^3)
*  if in (13,14) add '1101' to binaryRepresentation, subtract (1x2^0 + 1x2^2 +
*  1x2^3)
*  if in (14,15) add '1110' to binaryRepresentation, subtract (1x2^1 + 1x2^2 +
*  1x2^3)
*  if in (15,16) add '1111' to binaryRepresentation, subtract (1x2^0 + 1x2^1 +
*  1x2^2 + 1x2^3)
*/

// Import packages
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class DecimalFractionToBinaryFraction16NonRecursive {
  // Declare whether debugging is enabled or not
  final static boolean debugging = false;

  // Variables for values used
  long count = 0;
  long numberOfDecimalPlaces = 0;
  long numberOfFiguresToTrack;
  BigDecimal decimal;

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
  final static String[] BINARY = {"0000","0001","0010","0011",
                                  "0100","0101","0110","0111",
                                  "1000","1001","1010","1011",
                                  "1100","1101","1110","1111"};

  // Declare array list for holding the binary representation
  ArrayList<String> binaryRepresentation = new ArrayList<>();

  // Declare scanner we use to grab input
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  DecimalFractionToBinaryFraction16NonRecursive() {
    initialization();
    queryForAccuracy();
    binaryRepresentation.add("0.");
    decimalFractionToBinary(decimal);
  }

  // Method to initialize the object
  public void initialization() {
    if (debugging) {
      decimal = new BigDecimal("0.13423");
    } else {
      System.out.println("Input the decimal fraction of your choice between 0"
      + " and 1 (exclusive)");
      decimal = new BigDecimal(grabber.nextLine());
    }
  }

  // Ask the user how many values they want to track
  public void queryForAccuracy() {
    if (debugging) {
      numberOfFiguresToTrack = 36000;
    } else {
      System.out.println("Input the number of figures you want to track");
      numberOfFiguresToTrack = grabber.nextLong();
    }
  }

  // Print the binary representation
  public void printBinaryRepresentation() {
    for (int i = 0; i < binaryRepresentation.size(); i++) {
      System.out.print(binaryRepresentation.get(i));
    }
    System.out.println(); // for padding
  }

  public void decimalFractionToBinary(BigDecimal decimal) {
    for (numberOfDecimalPlaces = 0; numberOfDecimalPlaces < numberOfFiguresToTrack; numberOfDecimalPlaces += 4) {
      // Check to see if the program needs to stop
      if (numberOfDecimalPlaces >= numberOfFiguresToTrack) {
        System.out.println("There were "+count+" iterations");
        printBinaryRepresentation();
        return;
      }

      // Multiply the decimal by 16 to test for new additions to the binary
      // representation
      decimal = decimal.multiply(VALUES[15]);

      // Create a temporary value for decimal.intValue() since we call it often
      int tempInt = decimal.intValue();

      // Print messages if debugging is enabled
      if (debugging) {
        System.out.println("tempInt is "+tempInt);
        System.out.println(decimal);
        System.out.println(BINARY[tempInt]);
      }

      // Use our findings to add to the binary representation
      if (tempInt == 0) {
        binaryRepresentation.add(BINARY[0]);
      } else {
        binaryRepresentation.add(BINARY[tempInt]);
        decimal = decimal.subtract(VALUES[tempInt-1]);
      }

      // Increment the execution counter and number of decimal places
      count++;
    }
    System.out.println("There were "+count+" iterations");
    printBinaryRepresentation();
    return;
  }

  // Main method
  public static void main(String[] args) {
    DecimalFractionToBinaryFraction16NonRecursive newConversion = new DecimalFractionToBinaryFraction16NonRecursive();
  }
}
