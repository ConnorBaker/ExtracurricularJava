/*
*  filename: DecimalToInteger.java
*  author: Connor Baker
*  version: 0.1b
*  description: Convert a decimal entered by user (between 0 and 1) into its string
*  representation (e.g. 0.123 becomes "0.123").
*/

import java.util.Scanner;
import java.lang.Math;
import java.lang.Character;

public class DecimalToInteger {
  double decimal;
  int length;
  // String stringRepresentation;

  int arrayOfInts[];
  // char arrayOfChars[];

  DecimalToInteger() {
    getDecimal();
    getLength();
    int arrayOfInts[] = new int[length];
    getArrayOfInts();
    // char arrayOfChars[] = new char[length+2]; // +2 because it holds the '0.' part
    // getArrayOfChars();
    // getStringRepresentation();
    // printStringRepresentation();
  }


  public static void main(String args[]) {
    DecimalToInteger decimal1 = new DecimalToInteger();
  }

  public void getDecimal() {
    // Create a scanner to grab user-inputted decimal
    Scanner grab = new Scanner(System.in);

    // Prompt the user for the decimal and grab it
    System.out.println("Input decimal");
    decimal = grab.nextDouble();

    // Close the Scanner
    grab.close();
  }

  public void getLength() {
    // Initialize our counter
    int length = 0;
    double tempDecimal = decimal;

    // Get the length of the decimal
    while ((tempDecimal%1) != 0) {
      tempDecimal *= 10;
      length++;
    }
  }

  // public void getStringRepresentation() {
  //   stringRepresentation = new String(arrayOfChars);
  // }
  //
  // public void printStringRepresentation() {
  //   System.out.println(stringRepresentation);
  // }

  public void getArrayOfInts() {
    int tempInt = 0;
    int count = 0;
    double tempDecimal = decimal;
    System.out.println("Here1");
    System.out.println(decimal);
    while ((tempDecimal % 1) != 0) {
      tempDecimal *= 10;
      System.out.println("Here2");
      System.out.println("decimal is "+tempDecimal);
      System.out.println("array length is "+arrayOfInts.length);
      arrayOfInts[count] = (int)tempDecimal - tempInt;
      System.out.println("Here3");
      System.out.println("arrayOfInts["+count+"] is "+arrayOfInts[count]);
      tempInt = (int)tempDecimal * (int)Math.pow(10, count+1);
      System.out.println("tempInt is "+tempInt);
      count++;
    }
  }

  // public void getArrayOfChars() {
  //   // Fill the first two entires of the array with the "0." part of the decimal
  //   arrayOfChars[0] = '0';
  //   arrayOfChars[1] = '.';
  //
  //   // Fill the array of characters using the array of integers
  //   for (int i = 2; i < length+2; i++) {
  //     arrayOfChars[i] = getCharacterAtIndex(i-2);
  //   }
  // }

  // public char getCharacterAtIndex(int i) {
  //   // Initialize our character
  //   char character = '0';
  //
  //   // Find the character representation of the integer
  //   if (arrayOfInts[i] == 0) {
  //     character = '0';
  //   } else if (arrayOfInts[i] == 1) {
  //     character = '1';
  //   } else if (arrayOfInts[i] == 2) {
  //     character = '2';
  //   } else if (arrayOfInts[i] == 3) {
  //     character = '3';
  //   } else if (arrayOfInts[i] == 4) {
  //     character = '4';
  //   } else if (arrayOfInts[i] == 5) {
  //     character = '5';
  //   } else if (arrayOfInts[i] == 6) {
  //     character = '6';
  //   } else if (arrayOfInts[i] == 7) {
  //     character = '7';
  //   } else if (arrayOfInts[i] == 8) {
  //     character = '8';
  //   } else if (arrayOfInts[i] == 9) {
  //     character = '9';
  //   }
  //
  //   return character;
  // }
}
