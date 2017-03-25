/*
*  Filename: Base.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 24, 2017
*  Last updated: March 24, 2017
*
*  Description:
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;



public class Base {
  // Initialize our variables
  public static final List<Character> ORBIT_VALUES = new ArrayList<>();
  public static BigDecimal base;
  public static BigDecimal floorOfBase;
  public static int maxIterations = 10;



  Base() {
    // Initialize our variables
    base = ProgramSetup.getBase();
    floorOfBase = ProgramSetup.getFloorOfBase(base);
  }



  // Method to calculate the orbit of the number in the base
  public static void calculateOrbitOfOne() throws IOException {
    System.out.println("\nCalculating orbit...");
    BigDecimal number = new BigDecimal("1.0");
    for (int i = 0; i < maxIterations; i++) {
      number = number.multiply(base);

      // We need a for loop that iterates through and uses the counter as the base to check against. This allows us to work with any base in (1,10).
      for (int j = 0; j <= floorOfBase.intValue(); j++) {
        if (number.intValue() == j) {
          number = number.subtract(new BigDecimal(j));
          ORBIT_VALUES.add((char)('0'+j));
        }
      }

      // Get the current progress
      ProgressOfComputation.printProgress(i, maxIterations);
    }

    // Let the user know our calculations are complete
    ProgressOfComputation.printCompleted();
  }
}
