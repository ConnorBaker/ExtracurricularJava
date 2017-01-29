/*
*  filename: DecimalFractionToBinaryFraction.java
*  author: Connor Baker
*  version: 0.1a
*  description:
*/

// Declare our package
package decimaltobinary;

// Import the necessary packages
import java.math.BigDecimal;
import java.util.ArrayList;

public class DecimalFractionToBinaryFraction extends Thread {
  // Variables for values used
  long numberOfDecimalPlaces = 0;
  long numberOfFiguresToTrack;
  BigDecimal decimal;

  // Declare array list for holding the binary representation
  ArrayList<String> binaryRepresentation = new ArrayList<>();

  // Default, no-arg constructor
  DecimalFractionToBinaryFraction(String string) {
    queryForAccuracy();
    decimal = new BigDecimal(("0."+string));
    decimalFractionToBinary(decimal);
  }

  // Ask the user how many values they want to track
  public void queryForAccuracy() {
    // if (Main.debugging) {
      numberOfFiguresToTrack = 4096;
    // } else {
    //   System.out.println("Input the number of figures you want to track");
    //   numberOfFiguresToTrack = grabber.nextLong();
    // }
  }

  // Print the binary representation
  public void printBinaryRepresentation() {
    // Print the radix for the binary representation
    System.out.print(".");
    for (int i = 0; i < binaryRepresentation.size(); i++) {
      System.out.print(binaryRepresentation.get(i));
    }
    System.out.println(); // for padding
  }

  public void decimalFractionToBinary(BigDecimal decimal) {
    for (numberOfDecimalPlaces = 0; numberOfDecimalPlaces < numberOfFiguresToTrack; numberOfDecimalPlaces += 4) {
      // Check to see if the program needs to stop
      if (numberOfDecimalPlaces >= numberOfFiguresToTrack) {
        printBinaryRepresentation();
        return;
      }

      // Multiply the decimal by 16 to test for new additions to the binary
      // representation
      decimal = decimal.multiply(Main.VALUES[15]);

      // Create a temporary value for decimal.intValue() since we call it often
      int tempInt = decimal.intValue();

      // Print messages if debugging is enabled
      if (Main.debugging) {
        System.out.println("tempInt is "+tempInt);
        System.out.println(decimal);
        System.out.println(Main.LUT[tempInt]);
      }

      // Use our findings to add to the binary representation
      if (tempInt == 0) {
        binaryRepresentation.add(Main.LUT[0]);
      } else {
        binaryRepresentation.add(Main.LUT[tempInt]);
        decimal = decimal.subtract(Main.VALUES[tempInt-1]);
      }
    }
    printBinaryRepresentation();
    return;
  }
}
