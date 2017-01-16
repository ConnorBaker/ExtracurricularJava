/*
*  filename: Base10DecimalToBinary2.java
*  author: Connor Baker
*  version: 0.1d
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101"). Allows for arbitrary
*  precision given that there is enough memory allowed in the stack. The stack
*  size can be changed by executing the program using "java -Xss8g
*  Base10DecimalToBinary" where 8g allocated eight gigabytes of memory to the
*  stack.
*  references: http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
*/

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Base10DecimalToBinary2 {
  // Declare the objects used throughout the program
  final static boolean debugging = false;
  long count = 0;
  long numberOfDecimalPlaces=0;
  long numberOfFiguresToTrack;
  BigDecimal decimal;
  final static BigDecimal VALUEOFONE = new BigDecimal("1.0");
  final static BigDecimal VALUEOFTWO = new BigDecimal("2.0");
  ArrayList<Character> binaryRepresentation = new ArrayList<>();
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  Base10DecimalToBinary2() {
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
    decimal = decimal.multiply(VALUEOFTWO);

    // Create a temporary value for decimal.intValue() since we call it often
    int tempInt = decimal.intValue();

    // First case where the decimal is less than one
    if (tempInt == 0) {
      if (debugging == true) {
        System.out.println("tempInt == 0");
      }
      binaryRepresentation.add('0');
      numberOfDecimalPlaces++;
      if (debugging == true) {
        System.out.println(decimal);
      }
    }

    // Second case where the decimal is greater than one, but less than two
    else if (tempInt == 1) {
      if (debugging == true) {
        System.out.println("tempInt == 1");
      }
      decimal = decimal.subtract(VALUEOFONE);
      binaryRepresentation.add('1');
      numberOfDecimalPlaces++;
      if (debugging == true) {
        System.out.println(decimal);
      }
    }

    // Third case where something stupid and werid happens
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
    Base10DecimalToBinary2 newConversion = new Base10DecimalToBinary2();
  }
}
