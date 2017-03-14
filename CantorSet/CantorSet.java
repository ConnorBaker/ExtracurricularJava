/*
*  Filename: CantorSet.java
*  Author: Connor Baker
*  Version: 0.1a
*  Date created: March 13, 2017
*  Last updated: March 13, 2017
*
*  Description: Take an iteration from the user and calculate the intervals in
*               the Cantor Set for that iteration.
*
*  Todo: Fix everything. This is not a simple problem, and requires a great
*        deal of though. Most likely, if I can't find an explicit formula for
*        this, the best way to attack it would be a self-referrential method to
*        continually edit and split the ArrayList.
*/

// Declare our imports
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;



public class CantorSet {
  public static ArrayList<CantorSet> cantorSet = new ArrayList<CantorSet>(); // Holds numerator and denominator
  public static int iterationMax;
  public static int iterationCurrent = 0;
  public static long numeratorLowerBound;
  public static long numeratorUpperBound;
  public static long denominator;



  CantorSet() {
    new CantorSet(0, 1); // Interval for the first iteration
  }



  CantorSet(long numeratorLowerBound, long numeratorUpperBound) {
    this.numeratorLowerBound = numeratorLowerBound;
    this.numeratorUpperBound = numeratorUpperBound;
  }



  public static void grabInput() {
    Scanner grabber = new Scanner(System.in);
    System.out.println("Input the iteration of the cantor set you want intervals for:");
    iterationMax = grabber.nextInt();
    grabber.close();
  }



  public static void calculateTheDenominator() {
    denominator = (long)Math.pow(3, iterationCurrent);
  }



  public static String getMathRepresentation(CantorSet inputtedSet) {
    return "["+inputtedSet.numeratorLowerBound+"/"+denominator+","+inputtedSet.numeratorUpperBound+"/"+denominator+"]";
  }



  public static void fillCantorSet() {
    // Create the defaul cantor set. We iterate from this set to get the desired one.
    cantorSet.add(new CantorSet(0, 1));
    iterationCurrent = 1;
    while (iterationCurrent < iterationMax) {
      calculateTheDenominator();
      cantorSet.set(iterationCurrent-1, new CantorSet(0, cantorSet.get(iterationCurrent-1).numeratorLowerBound+1));

      // cantorSet.add(new CantorSet(denominator*cantorSet.get(iterationCurrent-1).numeratorUpperBound-1, denominator));
      iterationCurrent++;
    }
  }



  public static void printCantorSet() {
    for (int i = 0; i < cantorSet.size()-1; i++) {
      System.out.print(getMathRepresentation(cantorSet.get(i))+"∪");
    }
    System.out.print(getMathRepresentation(cantorSet.get(cantorSet.size()-1))+"\n");
  }


  public static void main(String[] args) {
    grabInput();
    calculateTheDenominator();
    fillCantorSet();
    printCantorSet();
  }
}
