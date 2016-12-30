/*
*  filename: Base10DecimalToBinary.java
*  author: Connor Baker
*  version: 0.2a
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101").
*  references: http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
*/

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Base10DecimalToBinary {
  // Declare the objects used throughout the program
  int count = 0;
  BigDecimal decimal;
  ArrayList<Character> binaryRepresentation = new ArrayList<>();

  // Default, no-arg constructor
  Base10DecimalToBinary() {
    initialization();
    binaryRepresentation.add('0');
    binaryRepresentation.add('.');
    decimalFractionToBinary(decimal);
  }

  // Method to initialize the object
  public void initialization() {
    Scanner grabber = new Scanner(System.in);
    System.out.println("Input the decimal fraction of your choice between 0"
      + " and 1 (exclusive)");
    String input = grabber.nextLine();
    decimal = new BigDecimal(input);
  }


  public void decimalFractionToBinary(BigDecimal decimal) {
    // Check to see if the program needs to stop
    if (count > 16) {
      return;
    }

    // Multiply the decimal by 2 to test for a new addition to the binary
    // representation
    decimal = decimal.multiply(new BigDecimal("2.0"));

    if (decimal.intValue() == 0) {
      System.out.println("Value to be added to binary representation is 0");
      binaryRepresentation.add('0');
    } if (decimal.intValue() == 1) {
      System.out.println("Value to be added to binary representation is 1");
      binaryRepresentation.add('1');
    } else {
      System.out.println("Something weird is happening!");
    }

    // Modify the decimal to pass back into the method, recursively
    decimal = decimal.subtract(decimal.setScale(0, RoundingMode.DOWN));

    // Print out the contents of our binaryRepresentation
    System.out.println(binaryRepresentation);

    // Increment the execution counter
    count++;

    // Pass the decimal back into the method to run again
    decimalFractionToBinary(decimal);
  }

  // Main method
  public static void main(String[] args) {
    Base10DecimalToBinary newConversion = new Base10DecimalToBinary();
  }
}
