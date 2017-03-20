/*
*  Filename: OrbitOfOneInBase.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 18, 2017
*  Last updated: March 18, 2017
*
*  Description: Calculate the orbit of one in a given base, using the
*               formula y = ((base)*(number))(mod 1). The orbit of a number is
*               the non-terminating fractional representation. An example of
*               the orbit of one in base ten is 0.999999...
*/



// Declare our package
package automaticallyFindForbiddenStrings;



// Declare our imports
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;



class OrbitOfOneInBase {
  // Initialize our variables
  public static BigDecimal base;
  public static BigDecimal floorOfBase;
  public static BigDecimal number = new BigDecimal("1.0");
  public static int maxIterations = 10;
  public static int floorOfBaseInt;
  public static final List<Character> ORBIT_VALUES = new ArrayList<>();



  // Method to calculate the floor of the base to be used for computations
  public static void calculateNeededValues() {
    floorOfBase = base.setScale(0, RoundingMode.DOWN);
    floorOfBaseInt = base.intValue();
  }



  // Method to calculate the orbit of the number in the base
  public static void calculateOrbit() {
    System.out.println("\nCalculating orbit...");
    double percentDone = 0;
    for (int i = 0; i < maxIterations; i++) {
      number = number.multiply(base);

      // We need a for loop that iterates through and uses the counter as the base to check against. This allows us to work with any base in (1,10).
      for (int j = 0; j <= floorOfBaseInt; j++) {
        if (number.intValue() == j) {
          number = number.subtract(new BigDecimal(j));
          ORBIT_VALUES.add((char)('0'+j));
        }
      }

      // Print out progress
      if (maxIterations < 100) {
        // Don't even bother with the percent completed
      } else if ((100 <= maxIterations) && (maxIterations < 1000)) {
        if (i%(maxIterations/100) == 0) {
          try {
            String progress = "\rCalculation Progress: "
                +String.format("%.0f", percentDone)+"%    ";
            System.out.write(progress.getBytes());
            percentDone++;
          } catch(IOException e) {
            // Do nothing
          }
        }
      } else if ((1000 <= maxIterations) && (maxIterations < 100000)) {
        if (i%(maxIterations/1000) == 0) {
          try {
            String progress = "\rCalculation Progress: "
                +String.format("%.1f", percentDone)+"%    ";
            System.out.write(progress.getBytes());
            percentDone += 0.1;
          } catch(IOException e) {
            // Do nothing
          }
        }
      } else if ((100000 <= maxIterations) && (maxIterations < 1000000)) {
        if (i%(maxIterations/100000) == 0) {
          try {
            String progress = "\rCalculation Progress: "
                +String.format("%.2f", percentDone)+"%    ";
            System.out.write(progress.getBytes());
            percentDone += 0.001;
          } catch(IOException e) {
            // Do nothing
          }
        }
      } else {
        if (i%(maxIterations/1000000) == 0) {
          try {
            String progress = "\rCalculation Progress: "
                +String.format("%.3f", percentDone)+"%    ";
            System.out.write(progress.getBytes());
            percentDone += 0.0001;
          } catch(IOException e) {
            // Do nothing
          }
        }
      }
    }

    // Let the user know our calculations are complete
    try {
      String progress ="\rCalculation Progress: 100%    ";
      System.out.write(progress.getBytes());
      System.out.println("\nCalculation Complete.");
    } catch(IOException e) {
      // Do nothing
    }
  }



  public static void run(String baseToUse) throws IOException {
    // Declare the base to use
    base = new BigDecimal(baseToUse);

    // Run the program
    calculateNeededValues();
    calculateOrbit();
  }
}
