/*
*  filename: DecimalToBinary2.java
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

public class DecimalToBinary2 {
  // Declare the objects used throughout the program
  final static boolean debugging = false;
  long tempQuotient;
  long tempRemainder;
  long count = 0;
  long numberOfDecimalPlaces = 0;
  BigInteger decimal;
  BigInteger[] temp;
  final static BigInteger VALUEOFTWO = new BigInteger("2");
  ArrayList<Character> binaryRepresentation = new ArrayList<>();
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  DecimalToBinary2() {
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
    temp = decimal.divideAndRemainder(VALUEOFTWO);

    // Print useful information if debugging is enabled
    if (debugging) {
      System.out.println("Quotient is "+temp[0]);
      System.out.println("Remainder is "+temp[1]);
    }

    // Cast the remainder to long for easy comparison
    tempQuotient = temp[0].longValue();
    tempRemainder = temp[1].longValue();

    // Check whether to halt
    if ((tempQuotient == 0) && (tempRemainder == 0)) {
      return;
    }

    // First case where the decimal is even
    if (tempRemainder == 0) {
      if (debugging) {
        System.out.println("tempRemainder == 0");
      }
      binaryRepresentation.add('0');
      if (debugging) {
        System.out.println(decimal);
      }
    }

    // Second case where the decimal is odd
    else if (tempRemainder == 1) {
      if (debugging) {
        System.out.println("tempRemainder == 1");
      }
      binaryRepresentation.add('1');
      if (debugging) {
        System.out.println(decimal);
      }
    }

    // Third case where something stupid and werid happens
    else {
      if (debugging) {
        System.out.println("Something weird is happening!");
      }
      return;
    }

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
    DecimalToBinary2 newConversion = new DecimalToBinary2();
  }
}
