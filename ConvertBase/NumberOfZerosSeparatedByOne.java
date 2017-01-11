/*
*  filename: NumberOfZerosSeparatedByOne.java
*  author: Connor Baker
*  version: 0.1a
*  description: Finds the number of zeros separated by one
*/

// Import packages (more than we need, we can cut down later)
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class NumberOfZerosSeparatedByOne {
static int[] array = new int[2000];
static int j = 0;
static int numberOfZeros = 0;

  public static void main(String[] args) throws IOException {
    readFromFile("file.txt");
    // System.out.println(Arrays.toString(array));

    for (int k = 0; k < array.length; k++) {
      System.out.println(array[k]);
    }
  }

  // Read from file and fill array (which we will treat as coordinate points)
  public static void readFromFile(String filename) throws IOException {
    // Initialize input stream
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

    // Read the line in
    char[] arrayOfChars = (br.readLine()).toCharArray();

    // Print out the input
    System.out.println(arrayOfChars);

    // While loop
    for (int i = 0; i < arrayOfChars.length; i++) {
      // Check whether to add a zero or a one
      if (arrayOfChars[i] == '0') {
        numberOfZeros++;
        // System.out.println("Adding zero "+arrayOfChars[i]);
      }
      else {
        array[j] = numberOfZeros;
        numberOfZeros = 0;
        // System.out.println("Adding one "+arrayOfChars[i]);
        j++;
      }
    }

    // Close buffered reader
    br.close();
  }
}
