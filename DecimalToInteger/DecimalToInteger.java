/*
*  filename: DecimalToInteger.java
*  author: Connor Baker
*  version: 0.1f
*  description: Convert a decimal entered by user (between 0 and 1) into its string
*  representation (e.g. 0.123 becomes "0.123").
*/

import java.util.Scanner;
import java.lang.Math;
import java.lang.Character;

public class DecimalToInteger {
  // double decimal;
  // int length;
  // long longRepresenation;
  // String stringRepresentation;

  // long[] arrayOfLongs;
  // char arrayOfChars[];

  DecimalToInteger() {
    long l = 54325;
    long[] a = new long[5];
    int i = 0;
    computeDigits(l, a, i);
  //   getDecimal();
  //   getLength();
  //   getLong();
  //   System.out.println(decimal);
  //   System.out.println(length);
  //   System.out.println(longRepresenation);
    // arrayOfLongs = new long[length];
    // getArrayOfLongs();
    // char arrayOfChars[] = new char[length+2]; // +2 because it holds the '0.' part
    // getArrayOfChars();
    // getStringRepresentation();
    // printStringRepresentation();
  }


  public static void main(String args[]) {
    DecimalToInteger newDecimal = new DecimalToInteger();
  }

  public void computeDigits(long l, long[] a, int i) {
    a[i] = l % 10L;
    System.out.println("a["+i+"] = "+l+" % "+10L+" = "+a[i]);
    if (l > 10L) {
      computeDigits(l / 10L, a, i + 1);
    }
  }

  // public void getDecimal() {
  //   // Create a scanner to grab user-inputted decimal
  //   Scanner grab = new Scanner(System.in);
  //
  //   // Prompt the user for the decimal and grab it
  //   System.out.println("Input decimal");
  //   decimal = grab.nextDouble();
  //
  //   // Close the Scanner
  //   grab.close();
  // }
  //
  // public void getLength() {
  //   // Initialize our counter
  //   length = 0;
  //   double tempDecimal = decimal;
  //
  //   // Get the length of the decimal
  //   while ((tempDecimal%1) != 0) {
  //     tempDecimal *= 10;
  //     System.out.println("tempDecimal is "+tempDecimal);
  //     length++;
  //   }
  // }
  //
  // public void getLong() {
  //   // Initialize the variable that will hold the content of the decimal
  //   longRepresenation = 0;
  //   double tempDecimal = decimal;
  //
  //   // Get the representation of the decimal
  //   while ((tempDecimal%1) != 0) {
  //     tempDecimal *= 10;
  //   }
  //   longRepresenation = (long)tempDecimal;
  // }

  // public void getStringRepresentation() {
  //   stringRepresentation = new String(arrayOfChars);
  // }
  //
  // public void printStringRepresentation() {
  //   System.out.println(stringRepresentation);
  // }

  public void getArrayOfChars() {
    // Fill the first two entires of the array with the "0." part of the decimal
    arrayOfChars[0] = '0';
    arrayOfChars[1] = '.';

    // Fill the array of characters using the array of integers
    for (int i = 2; i < length+2; i++) {
      arrayOfChars[i] = getCharacterAtIndex(i-2);
    }
  }

  public char getCharacterAtIndex(int i) {
    // Initialize our character
    char character = '0';

    // Find the character representation of the integer
    if (arrayOfLongs[i] == 0) {
      character = '0';
    } else if (arrayOfLongs[i] == 1) {
      character = '1';
    } else if (arrayOfLongs[i] == 2) {
      character = '2';
    } else if (arrayOfLongs[i] == 3) {
      character = '3';
    } else if (arrayOfLongs[i] == 4) {
      character = '4';
    } else if (arrayOfLongs[i] == 5) {
      character = '5';
    } else if (arrayOfLongs[i] == 6) {
      character = '6';
    } else if (arrayOfLongs[i] == 7) {
      character = '7';
    } else if (arrayOfLongs[i] == 8) {
      character = '8';
    } else if (arrayOfLongs[i] == 9) {
      character = '9';
    }

    return character;
  }
}
