/*
*  filename: Base10DecimalToBinary.java
*  author: Connor Baker
*  version: 0.1a
*  description: Convert a decimal entered by user (between 0 and 1) into its
*  binary representation (e.g. 0.625 becomes "0.101").
*  references: http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
*/

import java.math.BigDecimal;


public class Base10DecimalToBinary {
  public static void main(String[] args) {
    BigDecimal decimal = new BigDecimal("0.625");
    BigDecimal binaryRepresentation = new BigDecimal("0.0");
    int count = 1;
    System.out.println("The decimal is "+decimal);

    while (decimal.scale() != 0 && count < 16) {
      decimal = decimal.multiply(new BigDecimal("2.0"));
      System.out.println("count is "+count);

      // Handle the scenario that the floor is zero, in which case taking a negative exponent would yeild infinity
      if ((decimal.divideToIntegralValue(new BigDecimal("1.0"))).compareTo(new BigDecimal("0.0")) == 0) {
        System.out.println("Value to be added to binary representation is 0");
        count++;
      } if ((decimal.divideToIntegralValue(new BigDecimal("1.0"))).compareTo(new BigDecimal("1.0")) == 0) {
        System.out.println("Value to be added to binary representation is "+Math.pow(1.0/10.0, count));
        // binaryRepresentation += Math.pow(1.0/10.0, count);
      } else {
        System.out.println("Something weird is happening: floor returns "+decimal.divideToIntegralValue(new BigDecimal("1.0")));
      }

      decimal = decimal.subtract(decimal.divideToIntegralValue(new BigDecimal(1.0)));

      // System.out.println("The binaryRepresentation is "+binaryRepresentation);
      count++;
    }
  }
}
