/*
*  filename: DecimalFractionToBinaryFraction2NonRecursive.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101"). Allows for arbitrary
*  precision given that there is enough memory allowed.
*/

// Import packages
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class DecimalFractionToBinaryFraction2NonRecursive {
  // Declare whether debugging is enabled or not
  final static boolean debugging = false;

  // Variables for values used
  long count = 0;
  long numberOfDecimalPlaces = 0;
  long numberOfFiguresToTrack;
  BigDecimal decimal;

  // Declare arrays that we'll use for processing
  final static BigDecimal[] VALUES = {new BigDecimal("1.0"),
                                      new BigDecimal("2.0")};
  final static String[] BINARY = {"0",
                                  "1"};

  // Declare array list for holding the binary representation
  ArrayList<String> binaryRepresentation = new ArrayList<>();

  // Declare scanner we use to grab input
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  DecimalFractionToBinaryFraction2NonRecursive() {
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

  // Method to perform the processing
  public void decimalFractionToBinary(BigDecimal decimal) {
    for (numberOfDecimalPlaces = 0; numberOfDecimalPlaces < numberOfFiguresToTrack; numberOfDecimalPlaces++) {
      // Multiply the decimal by 2 to test for new additions to the binary
      // representation
      decimal = decimal.multiply(VALUES[1]);

      // Create a temporary value for the decimal since we call it twice
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
        binaryRepresentation.add(BINARY[1]);
        decimal = decimal.subtract(VALUES[0]);
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
    DecimalFractionToBinaryFraction2NonRecursive newConversion = new DecimalFractionToBinaryFraction2NonRecursive();
  }
}
