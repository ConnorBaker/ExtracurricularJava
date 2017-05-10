/*
*  filename: Decomp.java
*  author: Connor Baker
*  version: 0.1a
*  description: Take a number that is not a power of two and find the upper and
*  lower bounds of a sum on the natural numbers that is equal to that number,
*  compsoded of at least three terms (since any odd number can be decomposed
*  into two terms adjacent to the half of the number, like with 9 into 4 and 5).
*  Example: input of 15 would return 1 and 5 (1+2+3+4+5=15) and 4 and 6
*  (4+5+6=15).
*/

public class Decomp {

  public static int sum(int lower_bound, int upper_bound) {
    int sum = lower_bound;
    for (int i = lower_bound+1; i <= upper_bound; i++) {
      sum += i;
    }
    return sum;
  }

  public static void main(String[] args) {
      int input = Integer.parseInt(args[0]);

      for (int i = 1; i <= input; i++) { // No sense in going over half the value for the sum
        for (int j = i; j <= input; ++j) { // No sense in going over half the value for the sum
          if (sum(i,j) == input) { // Pass the values to our method to calculate possible bounds
            System.out.println("Lower bound: "+i+"\t Upper bound: "+j); // Print successful attempts
          }
        }
      }
    }
  }
