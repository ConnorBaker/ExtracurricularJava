/*
*  filename: DecimalToBinary.java
*  author: Connor Baker
*  version: 0.1a
*  description:
*/

// Declare our package
package decimaltobinary;

// Import the necessary packages
import java.math.BigInteger;
import java.util.Collections;
import java.util.ArrayList;

public class DecimalToBinary extends Thread {
  // Variables for values used
  long tempQuotient; // can possibly overflow
  long tempRemainder; // use an int because x(mod(16)) is [0,15]
  long numberOfDecimalPlaces = 0;
  BigInteger[] temp;
  BigInteger decimal;
  final static BigInteger VALUEOFSIXTEEN = new BigInteger("16");
  ArrayList<String> binaryRepresentation = new ArrayList<>();

  // Default argumented constructor
  DecimalToBinary(String string) {
    decimal = new BigInteger(string);
    decimalToBinary(decimal);
    printBinaryRepresentation();
  }

  public void decimalToBinary(BigInteger decimal) {
    // Find the quotient and remainder
    temp = decimal.divideAndRemainder(new BigInteger("16"));

    // Cast the remainder to int for easy comparison
    tempQuotient = temp[0].intValue();
    tempRemainder = temp[1].intValue();

    // Check whether to halt
    if ((tempQuotient == 0) && (tempRemainder == 0)) {
      return;
    }

    // Use the look up table and add the remainder to the binaryRepresentation
    binaryRepresentation.add(Main.LUT[(int)tempRemainder]);

    // Pass back into method
    decimal = temp[0];
    decimalToBinary(decimal);
  }

  // Print out the binary representation
  public void printBinaryRepresentation() {
    Collections.reverse(binaryRepresentation);
    for (int i = 0; i < binaryRepresentation.size(); i++) {
      System.out.print(binaryRepresentation.get(i));
    }
    return;
  }
}
