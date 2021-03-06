/*
*  Filename: OrbitOfNumber.java
*  Author: Connor Baker
*  Version: 0.2b
*  Date created: March 14, 2017
*  Last updated: March 19, 2017
*
*  Description: Calculate the orbit of a number in a given base, using the
*               formula y = ((base)*(number))(mod 1). The orbit of a number is
*               the non-terminating fractional representation. An example of
*               the orbit of one in base ten is 0.999999...
*/



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


class OrbitOfNumber {
  // Initialize our variables
  private static BigDecimal base;
  private static BigDecimal floorOfBase;
  private static BigDecimal number;
  private static int maxIterations;
  private static int floorOfBaseInt;
  private static String filename;
  private static boolean printToFile;
  private static final List<Character> ORBIT_VALUES = new ArrayList<>();



  private static void printDescription() {
    System.out.println("/*"
    +"\n*  Filename: OrbitOfNumber.java"
    +"\n*  Author: Connor Baker"
    +"\n*  Version: 0.2a"
    +"\n*  Date created: March 14, 2017"
    +"\n*  Last updated: March 18, 2017"
    +"\n*"
    +"\n*  Description: Calculate the orbit of a number in a given base, using the"
    +"\n*               formula y = ((base)*(number))(mod 1). The orbit of a number is"
    +"\n*               the non-terminating fractional representation. An example of"
    +"\n*               the orbit of one in base ten is 0.999999..."
    +"\n*\\");
  }




  // Method to grab user input
  private static void getUserInput() {
    // Create our scanner
    final Scanner grabber = new Scanner(System.in);

    // Prompt for base
    System.out.println("Input the non-integer base to use in (1,10):");
    base = new BigDecimal(grabber.nextLine());

    // Prompt for number
    System.out.println("Input the number to calculate the orbit of:");
    number = new BigDecimal(grabber.nextLine());

    // Prompt for max number of iterations
    System.out.println("Input the maximum number of iterations you will "
        +"allow (enter 0 for the largest possible, the size of an int):");
    maxIterations = grabber.nextInt();

    // Take care of the case that maxIterations is zero
    if (maxIterations == 0) {
      maxIterations = Integer.MAX_VALUE;
    }

    // Clear the Scanner since we didn't leave off with a nextLine()
    grabber.nextLine();

    // Prompt to write to file
    System.out.println("Print output to a file? (Y/N)");
    printToFile = "y".equals((grabber.nextLine()).toLowerCase());
    if (printToFile) {
      System.out.println("Filename to write to?");
      filename = grabber.nextLine();
    }

    // Close the scanner
    grabber.close();
  }



  // Method to calculate the floor of the base to be used for computations
  private static void calculateNeededValues() {
    floorOfBase = base.setScale(0, RoundingMode.DOWN);
    floorOfBaseInt = base.intValue();
  }



  // Method to calculate the orbit of the number in the base
  private static void calculateOrbit() {
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



  // Method to print to console the orbit
  private static void printOrbitToConsole() {
    // Print to console
    for (Character orbitValue : ORBIT_VALUES) {
      System.out.println(orbitValue);
    }
  }



  // Method to print to file the orbit
  private static void printOrbitToFile() throws IOException {
    // Initialize our objects used for writing to file
    final FileWriter tempfile = new FileWriter(filename);
    final BufferedWriter tempBW = new BufferedWriter(tempfile);
    final PrintWriter tempPW = new PrintWriter(tempBW);

    // Print to file
    for (Character orbitValue : ORBIT_VALUES) {
      tempPW.println(orbitValue);
    }

    // Close PrintWriter
    tempPW.flush();
    tempPW.close();
  }



  // Method to calculate the error of our orbit vs the actual number
  private static void calculateError() {
    // Initialize variables to be used in computing the error
    BigDecimal calculatedValue = new BigDecimal("0.0");
    BigDecimal error = new BigDecimal("0.0");
    System.out.println("\nCalculating Accuracy...");

    // Compute the total of our orbit
    for (int i = 0; i < maxIterations; i++) {
      if (ORBIT_VALUES.get(i) != '0') {
        calculatedValue = calculatedValue.add(new BigDecimal("1.0")).divide(base.pow(i+1), maxIterations, RoundingMode.HALF_UP); // round to the accuracy provided by the user
      }
    }

      // Compute the actual error
      error = (((calculatedValue).abs()).divide(number, maxIterations, RoundingMode.HALF_UP)).multiply(new BigDecimal("100.0"));

      // Print the error
      System.out.println("Computed Error: "+error.setScale(maxIterations, RoundingMode.HALF_UP)+"%    ");
      System.out.println("Calculation Complete.");
  }



  public static void main(String[] args) throws IOException {
    printDescription();
    getUserInput();
    calculateNeededValues();
    calculateOrbit();
    if (printToFile) {
      printOrbitToFile();
    } else {
    printOrbitToConsole();
    }
    calculateError();
  }
}
