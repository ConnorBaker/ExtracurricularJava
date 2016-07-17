/*
*  Author: Connor Baker
*  Version: 0.5a
*  Created: July 16, 2016
*  Last Updated: July 16, 2016
*
*  Description: Compute highly composite numbers.
*
*  Note: I suspect that all arbitrarily large n that we are searching for end
*  in a zero. As such, we could iterate by 10 each time.
*
*  TODO: Copy each thread's output to an array list for sanitization. As the
*  algorithm works currently, each thread is isolated from the others. As such
*  they may output a value that (based on the numbers the thread has processed
*  previously) does in fact have the smallest n for largest number of divisors
*  -- however, it may not be true with respect to the other threads. The simple
*  solution for this is to put all the values into an array list, and then
*  double check for duplicate values of number of divisors, tossing the one
*  with the larger n.
*
*  TODO: Find a way to reuse code. I hate copy-pasting code.
*
*  TODO: Find a way to mutate the first thread to significantly cut down on the
*  amount of code in this program.
*/

/* Import necessary packages */
import java.math.BigInteger;

public class ThreadedHighlyCompositeNumbers {
  public static void main(String[] args) {
    Thread thread0 = new Thread(new Compute0());
    thread0.start();
    Thread thread1 = new Thread(new Compute1());
    thread1.start();
    Thread thread2 = new Thread(new Compute2());
    thread2.start();
    Thread thread3 = new Thread(new Compute3());
    thread3.start();
  }
}

class Compute0 extends Thread {
  public void run() {
    BigInteger n0 = BigInteger.valueOf(4);
    BigInteger divisor0 = BigInteger.valueOf(2);
    BigInteger number_of_divisors0 = BigInteger.valueOf(0);
    BigInteger temp_number_of_divisors0 = BigInteger.valueOf(0);

    while (true) {
      if (divisor0.compareTo(n0.divide(BigInteger.valueOf(2))) == 1) {
        if ((temp_number_of_divisors0.compareTo(number_of_divisors0)) == 1) {
          number_of_divisors0 = temp_number_of_divisors0;
          System.out.println(n0+ " has " +number_of_divisors0+ " divisors.");
        }
        temp_number_of_divisors0 = BigInteger.valueOf(0);
        divisor0 = BigInteger.valueOf(2);
        n0 = n0.add(BigInteger.valueOf(8));
      } else {
        if (n0.mod(divisor0) == BigInteger.valueOf(0)) {
          temp_number_of_divisors0 = temp_number_of_divisors0.add(BigInteger.valueOf(1));
          divisor0 = divisor0.add(BigInteger.valueOf(1));
        } else {
          divisor0 = divisor0.add(BigInteger.valueOf(1));
        }
      }
    }
  }
}

class Compute1 extends Thread {
  public void run() {
    BigInteger n1 = BigInteger.valueOf(5);
    BigInteger divisor1 = BigInteger.valueOf(2);
    BigInteger number_of_divisors1 = BigInteger.valueOf(0);
    BigInteger temp_number_of_divisors1 = BigInteger.valueOf(0);

    while (true) {
      if (divisor1.compareTo(n1.divide(BigInteger.valueOf(2))) == 1) {
        if ((temp_number_of_divisors1.compareTo(number_of_divisors1)) == 1) {
          number_of_divisors1 = temp_number_of_divisors1;
          System.out.println(n1+ " has " +number_of_divisors1+ " divisors.");
        }
        temp_number_of_divisors1 = BigInteger.valueOf(0);
        divisor1 = BigInteger.valueOf(2);
        n1 = n1.add(BigInteger.valueOf(8));
      } else {
        if (n1.mod(divisor1) == BigInteger.valueOf(0)) {
          temp_number_of_divisors1 = temp_number_of_divisors1.add(BigInteger.valueOf(1));
          divisor1 = divisor1.add(BigInteger.valueOf(1));
        } else {
          divisor1 = divisor1.add(BigInteger.valueOf(1));
        }
      }
    }
  }
}

class Compute2 extends Thread {
  public void run() {
    BigInteger n2 = BigInteger.valueOf(6);
    BigInteger divisor2 = BigInteger.valueOf(2);
    BigInteger number_of_divisors2 = BigInteger.valueOf(0);
    BigInteger temp_number_of_divisors2 = BigInteger.valueOf(0);

    while (true) {
      if (divisor2.compareTo(n2.divide(BigInteger.valueOf(2))) == 1) {
        if ((temp_number_of_divisors2.compareTo(number_of_divisors2)) == 1) {
          number_of_divisors2 = temp_number_of_divisors2;
          System.out.println(n2+ " has " +number_of_divisors2+ " divisors.");
        }
        temp_number_of_divisors2 = BigInteger.valueOf(0);
        divisor2 = BigInteger.valueOf(2);
        n2 = n2.add(BigInteger.valueOf(8));
      } else {
        if (n2.mod(divisor2) == BigInteger.valueOf(0)) {
          temp_number_of_divisors2 = temp_number_of_divisors2.add(BigInteger.valueOf(1));
          divisor2 = divisor2.add(BigInteger.valueOf(1));
        } else {
          divisor2 = divisor2.add(BigInteger.valueOf(1));
        }
      }
    }
  }
}

class Compute3 extends Thread {
  public void run() {
    BigInteger n3 = BigInteger.valueOf(7);
    BigInteger divisor3 = BigInteger.valueOf(2);
    BigInteger number_of_divisors3 = BigInteger.valueOf(0);
    BigInteger temp_number_of_divisors3 = BigInteger.valueOf(0);

    while (true) {
      if (divisor3.compareTo(n3.divide(BigInteger.valueOf(2))) == 1) {
        if ((temp_number_of_divisors3.compareTo(number_of_divisors3)) == 1) {
          number_of_divisors3 = temp_number_of_divisors3;
          System.out.println(n3+ " has " +number_of_divisors3+ " divisors.");
        }
        temp_number_of_divisors3 = BigInteger.valueOf(0);
        divisor3 = BigInteger.valueOf(2);
        n3 = n3.add(BigInteger.valueOf(8));
      } else {
        if (n3.mod(divisor3) == BigInteger.valueOf(0)) {
          temp_number_of_divisors3 = temp_number_of_divisors3.add(BigInteger.valueOf(1));
          divisor3 = divisor3.add(BigInteger.valueOf(1));
        } else {
          divisor3 = divisor3.add(BigInteger.valueOf(1));
        }
      }
    }
  }
}
