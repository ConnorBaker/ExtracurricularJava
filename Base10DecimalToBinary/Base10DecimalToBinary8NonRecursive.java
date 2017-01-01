/*
*  filename: Base10DecimalToBinary8NonRecursive.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101"). Allows for arbitrary
*  precision given that there is enough memory allowed in the stack. The stack
*  size can be changed by executing the program using "java -Xss8g
*  Base10DecimalToBinary" where 8g allocated eight gigabytes of memory to the
*  stack.
*  Uses some neat math tricks.
*
*  algorithm (roughly): Take in a decimal in base 10 on (0,1). Mutliply by 8.
*  if in (0,1) add '000' to binaryRepresentation, subtract (0x2^0)
*  if in (1,2) add '001' to binaryRepresentation, subtract (1x2^0)
*  if in (2,3) add '010' to binaryRepresentation, subtract (1x2^1)
*  if in (3,4) add '011' to binaryRepresentation, subtract (1x2^0 + 1x2^1)
*  if in (4,5) add '100' to binaryRepresentation, subtract (1x2^2)
*  if in (5,6) add '101' to binaryRepresentation, subtract (1x2^0 + 1x2^2)
*  if in (6,7) add '110' to binaryRepresentation, subtract (1x2^1 + 1x2^2)
*  if in (7,8) add '111' to binaryRepresentation, subtract (1x2^0 + 1x2^1 +
*  1x2^2)
*
*  references: http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
*/

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Base10DecimalToBinary8NonRecursive {
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
  final static BigDecimal VALUEOFFIVE = new BigDecimal("5.0");
  final static BigDecimal VALUEOFSIX = new BigDecimal("6.0");
  final static BigDecimal VALUEOFSEVEN = new BigDecimal("7.0");
  final static BigDecimal VALUEOFEIGHT = new BigDecimal("8.0");
  ArrayList<Character> binaryRepresentation = new ArrayList<>();
  Scanner grabber = new Scanner(System.in);

  // Default, no-arg constructor
  Base10DecimalToBinary8NonRecursive() {
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
    for (numberOfDecimalPlaces = 0; numberOfDecimalPlaces < numberOfFiguresToTrack; numberOfDecimalPlaces += 3) {
      // Multiply the decimal by 4 to test for new additions to the binary
      // representation
      decimal = decimal.multiply(VALUEOFEIGHT);

      // First case where the decimal is less than one
      // I use intValue here because I beleive it's faster than compareTo (it
      // truncates the decimal portion for us)
      if (decimal.intValue() == 0) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 0");
        }
        binaryRepresentation.add('0');
        binaryRepresentation.add('0');
        binaryRepresentation.add('0');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("0, 0, 0");
        }
      }

      // Second case where the decimal is greater than one, but less than two
      else if (decimal.intValue() == 1) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 1");
        }
        decimal = decimal.subtract(VALUEOFONE);
        binaryRepresentation.add('0');
        binaryRepresentation.add('0');
        binaryRepresentation.add('1');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("0, 0, 1");
        }
      }

      // Third case where the decimal is greater than two, but less than three
      else if (decimal.intValue() == 2) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 2");
        }
        decimal = decimal.subtract(VALUEOFTWO);
        binaryRepresentation.add('0');
        binaryRepresentation.add('1');
        binaryRepresentation.add('0');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("0, 1, 0");
        }
      }

      // Fourth case where the decimal is greater than three, but less than four
      else if (decimal.intValue() == 3) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 3");
        }
        decimal = decimal.subtract(VALUEOFTHREE);
        binaryRepresentation.add('0');
        binaryRepresentation.add('1');
        binaryRepresentation.add('1');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("0, 1, 1");
        }
      }

      // Fifth case where the decimal is greater than four, but less than five
      else if (decimal.intValue() == 4) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 4");
        }
        decimal = decimal.subtract(VALUEOFFOUR);
        binaryRepresentation.add('1');
        binaryRepresentation.add('0');
        binaryRepresentation.add('0');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("1, 0, 0");
        }
      }

      // Sixth case where the decimal is greater than five, but less than six
      else if (decimal.intValue() == 5) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 5");
        }
        decimal = decimal.subtract(VALUEOFFIVE);
        binaryRepresentation.add('1');
        binaryRepresentation.add('0');
        binaryRepresentation.add('1');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("1, 0, 1");
        }
      }

      // Seventh case where the decimal is greater than six, but less than seven
      else if (decimal.intValue() == 6) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 6");
        }
        decimal = decimal.subtract(VALUEOFSIX);
        binaryRepresentation.add('1');
        binaryRepresentation.add('1');
        binaryRepresentation.add('0');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("1, 1, 0");
        }
      }

      // Eigth case where the decimal is greater than seven, but less than eight
      else if (decimal.intValue() == 7) {
        if (debugging == true) {
          System.out.println("decimal.intValue() == 7");
        }
        decimal = decimal.subtract(VALUEOFSEVEN);
        binaryRepresentation.add('1');
        binaryRepresentation.add('1');
        binaryRepresentation.add('1');
        if (debugging == true) {
          System.out.println(decimal);
          System.out.println("1, 1, 1");
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
    }
    System.out.println("There were "+count+" iterations");
    System.out.println(binaryRepresentation);
    return;
  }

  // Main method
  public static void main(String[] args) {
    Base10DecimalToBinary8NonRecursive newConversion = new Base10DecimalToBinary8NonRecursive();
  }
}
