/*
*  filename: DecimalToBinary16.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user into its binary
*  representation. Allows for arbitrary precision given that there is enough
*  memory allowed in the stack.
*/

// Import the necessary packages
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class DecimalToBinary16 {
  // Declare the objects used throughout the program
  final static boolean debugging = false;
  long tempQuotient;
  long tempRemainder;
  long count = 0;
  long numberOfDecimalPlaces = 0;
  BigInteger decimal;
  BigInteger[] temp;
  final static BigInteger VALUEOFSIXTEEN = new BigInteger("16");
  ArrayList<String> binaryRepresentation = new ArrayList<>();
  Scanner grabber = new Scanner(System.in);

  final static String[] LUT = {"0000","0001","0010","0011",
                               "0100","0101","0110","0111",
                               "1000","1001","1010","1011",
                               "1100","1101","1110","1111"};

  // Default, no-arg constructor
  DecimalToBinary16() {
    initialization();
    decimalToBinary(decimal);
    printBinaryRepresentation();
  }

  // Method to initialize the object
  public void initialization() {
    System.out.println("Input the decimal of your choice:");
    decimal = new BigInteger(grabber.nextLine());
  }

  public void decimalToBinary(BigInteger decimal) {
    // Find the quotient and remainder
    temp = decimal.divideAndRemainder(VALUEOFSIXTEEN);

    // Print useful information if debugging is enabled
    if (debugging) {
      System.out.println("Quotient is "+temp[0]);
      System.out.println("Remainder is "+temp[1]);
    }

    // Cast the remainder to int for easy comparison
    tempQuotient = temp[0].intValue();
    tempRemainder = temp[1].intValue();

    // Check whether to halt
    if ((tempQuotient == 0) && (tempRemainder == 0)) {
      return;
    }

    // Use the look up table and add the remainder to the binaryRepresentation
    binaryRepresentation.add(LUT[(int)tempRemainder]);

    // Increment the execution counter by four since we mutiplied by four
    count++;

    // Pass back into method
    decimal = temp[0];
    decimalToBinary(decimal);
  }

  // Print out the binary representation
  public void printBinaryRepresentation() {
    System.out.println("There were "+count+" iterations");
    Collections.reverse(binaryRepresentation);
    for (int i = 0; i < binaryRepresentation.size(); i++) {
      System.out.print(binaryRepresentation.get(i));
    }
    System.out.println();
    return;
  }

  // Main method
  public static void main(String[] args) {
    DecimalToBinary16 newConversion = new DecimalToBinary16();
  }
}
