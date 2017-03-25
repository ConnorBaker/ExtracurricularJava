/*
*  Filename: ProgressOfComputation.java
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
import java.io.IOException;



class ProgressOfComputation {
  // Initialize our variables
  public static double percentDone = 0.0;


  // Method to calculate the orbit of the number in the base
  public static void printProgress(int i, int maxIterations) throws IOException {
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

  public static void printCompleted() throws IOException {
    // Let the user know our calculations are complete
    try {
      String progress ="\rCalculation Progress: 100%    ";
      System.out.write(progress.getBytes());
      System.out.println("\nCalculation Complete.");
    } catch(IOException e) {
      // Do nothing
    }
  }
}
