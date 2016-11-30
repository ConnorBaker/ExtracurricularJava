/*
*  filename: DecimalToString.java
*  author: Connor Baker, IllegalArgument
*  version: 0.2a
*  description: Convert a decimal entered by user (between 0 and 1) into its string
*               representation (e.g. 0.123 becomes "0.123").
*  references: The ever knowledgeable IllegalArgument of chatroom legends (plural)
*/

import java.util.Scanner;

public class DecimalToString {
// Initialize all of our variables
int length; // the length of the decimal (excluding the leading zero)
int i; // an iteration counter
long l; // the value of
long[] a; // holds the values of the different places of the decimal
double decimal; // the value of the user-inputted decimal
char[] c; // holds the character representation of the decimal
String stringRepresentation; // the string representation of the decimal

  // Decimal constructor
  DecimalToString() {
    getDecimal();
    getLength();
    getLong();
    a = new long[length];
    c = new char[length+2]; // Contains "0." in addition to all of a[]
    i = 0;
    computeDigits(l, a, i);
    getArrayOfChars();
    getStringRepresentation();
    printStringRepresentation();
  }

  // Method to compute the long representation of the user-inputted decimal
  public void computeDigits(long l, long[] a, int i) {
    // Calculate the ones place of the long representation by dividing by 10 cast to long
    a[i] = l % 10L;
    // System.out.println("a["+i+"] = "+l+" % "+10L+" = "+a[i]);

    // If the long representation is larger than 10, call this method recursively
    if (l > 10L) {
      computeDigits(l / 10L, a, i + 1);
    }
  }

  // Method to prompt user for decimal and grab the input
  public void getDecimal() {
    // Create a scanner to grab user-inputted decimal
    Scanner grab = new Scanner(System.in);

    // Prompt the user for the decimal and grab it
    System.out.println("Input decimal");
    decimal = grab.nextDouble();

    // Close the Scanner
    grab.close();
  }

  // Method to get the length of the user-inputted decmal (excluding the leading zero)
  public void getLength() {
    // Initialize the value of the length to zero
    length = 0;

    // Create a copy of decimal so we don't change the actual value
    double tempDecimal = decimal;

    // Calculate the length of the decimal
    /*
    *  Java allows us to do modular arithmatic on floating point values. We encounter a
    *  problem with certain decimal inputs because they have no finite represenation as a
    *  "decimal" in base 2. When this occurs, we get a length of 17.
    */
    while ((tempDecimal%1) != 0) {
      tempDecimal *= 10;
      length++;
    }
  }

  // Method to get the long representation of the user-inputted decimal
  public void getLong() {
    // Initialize the variable that will hold the content of the decimal
    l = 0;
    double tempDecimal = decimal;

    // Get the representation of the decimal
    while ((tempDecimal%1) != 0) {
      tempDecimal *= 10;
    }
    l = (long)tempDecimal;
  }

  // Method to get the string representation of the user-inputted decimal
  // We create a string using our character array. Strings in Java are just immutable
  // arrays of characters.
  public void getStringRepresentation() {
    stringRepresentation = new String(c);
  }

  // Method to print the string representation of the user-inputted decimal
  public void printStringRepresentation() {
    System.out.println("The string representation of the entered decimal is "
        +stringRepresentation+".");
    System.out.println("Due to java storing all doubles in base 2, the accuracy of what"
        +" you've inputted is lost for some numbers.");
    System.out.println("For example, 0.1 has no finite representation (as base 2's"
        +" equivalent of a decimal) in base 2.");
  }

  // Method to create an array of characters representing the user-inputted decimal
  public void getArrayOfChars() {
    // Fill the first two entires of the array with the "0." part of the decimal
    c[0] = '0';
    c[1] = '.';
    // System.out.println("c[0] = "+c[0])+"\nc[1] = "+c[1]);

    // Fill the array of characters using the array of integers
    for (int i = 2; i < (length+2); i++) {
      /*
      *  By using (2-i)+(length-1) we create a mapping from the first value of a[] to the
      *  last value of c[]. We must do this because we read in the values of
      *  the decimal effectively in reverse (starting at the least significant bit).
      */
      c[i] = getCharacterAtIndex((2-i)+(length-1));
      // System.out.println("c["+i+"] = "+c[i]);
    }
  }

  // Method to find the character representation of the integer at a given index of a[]
  public char getCharacterAtIndex(int i) {
    // Initialize our character
    char character = '0';

    // Find the character representation of the integer
    if (a[i] == 0) {
      character = '0';
    } else if (a[i] == 1) {
      character = '1';
    } else if (a[i] == 2) {
      character = '2';
    } else if (a[i] == 3) {
      character = '3';
    } else if (a[i] == 4) {
      character = '4';
    } else if (a[i] == 5) {
      character = '5';
    } else if (a[i] == 6) {
      character = '6';
    } else if (a[i] == 7) {
      character = '7';
    } else if (a[i] == 8) {
      character = '8';
    } else if (a[i] == 9) {
      character = '9';
    }

    // Return the character to the method caller
    return character;
  }

  // main method
  public static void main(String args[]) {
    // Create our new object
    DecimalToString newString = new DecimalToString();
  }
}
