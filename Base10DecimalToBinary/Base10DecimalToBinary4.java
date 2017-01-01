/*
*  filename: Base10DecimalToBinary4.java
*  author: Connor Baker
*  version: 0.1f
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101"). Allows for arbitrary
*  precision given that there is enough memory allowed in the stack. The stack
*  size can be changed by executing the program using "java -Xss8g
*  Base10DecimalToBinary" where 8g allocated eight gigabytes of memory to the
*  stack.
*  Uses some neat math tricks.
*
*  algorithm (roughly): Take in a decimal in base 10 on (0,1).
*  Multiply by four. If result is < 1, add two zeroes to binary representation.
*  If > 1 but < 2, subtract 1x2^0 and add one zero and one one to binary
*  representation. If > 2 but < 3, subtract 1x2^1, add one one and one zero to
*  binary representation. If > 3 (no need to check for ceiling of < 4 because
*  the decimal itself must be between 0 and 1 originally and the only way for
*  that ceiling to be violated would be if it was >= 1), subtract 1x2^0 +
*  1x2^1, add two ones to binary representation.
*
*  references: http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
*/

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Base10DecimalToBinary4 {
  // Declare the objects used throughout the program
  final static boolean debugging = false;
  long count = 0;
  long numberOfDecimalPlaces=0;
  long numberOfFiguresToTrack;
  BigDecimal decimal;
  final static BigDecimal VALUEOFONE = new BigDecimal("1.0");
  final static BigDecimal VALUEOFTWO = new BigDecimal("2.0");
  final static BigDecimal VALUEOFTHREE = new BigDecimal("3.0");
  final static BigDecimal VALUEOFFOUR = new BigDecimal("4.0");
  ArrayList<Character> binaryRepresentation = new ArrayList<>();
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  Base10DecimalToBinary4() {
    initialization();
    queryForAccuracy();
    binaryRepresentation.add('0');
    binaryRepresentation.add('.');
    decimalFractionToBinary(decimal);
  }

  // Method to initialize the object
  public void initialization() {
    System.out.println("Input the decimal fraction of your choice between 0"
    + " and 1 (exclusive)");
    decimal = new BigDecimal(grabber.nextLine());
    // decimal = new BigDecimal("0.13423");
  }

  public void queryForAccuracy() {
    System.out.println("Input the number of figures you want to track");
    numberOfFiguresToTrack = grabber.nextLong();
    // numberOfFiguresToTrack = 36000;
  }

  public void decimalFractionToBinary(BigDecimal decimal) {
    // Check to see if the program needs to stop
    if (numberOfDecimalPlaces >= numberOfFiguresToTrack) {
      System.out.println("There were "+count+" iterations");
      System.out.println(binaryRepresentation);
      return;
    }

    // Multiply the decimal by 4 to test for new additions to the binary
    // representation
    decimal = decimal.multiply(VALUEOFFOUR);

    // First case where the decimal is less than one
    // I use intValue here because I beleive it's faster than compareTo (it
    // truncates the decimal portion for us)
    if (decimal.intValue() == 0) {
      if (debugging == true) {
        System.out.println("decimal.intValue() == 0");
      }
      binaryRepresentation.add('0');
      binaryRepresentation.add('0');
      numberOfDecimalPlaces += 2;
      if (debugging == true) {
        System.out.println(decimal);
        System.out.println("0, 0");
      }
    }

    // Second case where the decimal is greater than one, but less than two
    else if (decimal.intValue() == 1) {
      if (debugging == true) {
        System.out.println("decimal.intValue() == 1");
      }
      decimal = decimal.subtract(VALUEOFONE);
      binaryRepresentation.add('0');
      binaryRepresentation.add('1');
      numberOfDecimalPlaces += 2;
      if (debugging == true) {
        System.out.println(decimal);
        System.out.println("0, 1");
      }
    }

    // Third case where the decimal is greater than two, but less than three
    else if (decimal.intValue() == 2) {
      if (debugging == true) {
        System.out.println("decimal.intValue() == 2");
      }
      decimal = decimal.subtract(VALUEOFTWO);
      binaryRepresentation.add('1');
      binaryRepresentation.add('0');
      numberOfDecimalPlaces += 2;
      if (debugging == true) {
        System.out.println(decimal);
        System.out.println("1, 0");
      }
    }

    // Fourth case where the decimal is greater than three, but less than four
    else if (decimal.intValue() == 3) {
      if (debugging == true) {
        System.out.println("decimal.intValue() == 3");
      }
      decimal = decimal.subtract(VALUEOFTHREE);
      binaryRepresentation.add('1');
      binaryRepresentation.add('1');
      numberOfDecimalPlaces += 2;
      if (debugging == true) {
        System.out.println(decimal);
        System.out.println("1, 1");
      }
    }

    // Sixth case where something stupid and werid happens
    else {
      if (debugging == true) {
        System.out.println("Something weird is happening!");
      }
      return;
    }

    // Increment the execution counter by four since we mutiplied by four
    count++;

    // Pass the decimal back into the method to run again
    decimalFractionToBinary(decimal);
  }

  // Main method
  public static void main(String[] args) {
    Base10DecimalToBinary4 newConversion = new Base10DecimalToBinary4();
  }
}
