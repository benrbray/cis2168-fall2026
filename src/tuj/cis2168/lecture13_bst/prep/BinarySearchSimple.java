package tuj.cis2168.lecture13_bst.prep;

import java.util.Arrays;

public class BinarySearchSimple {
  public static void main() {
    checker("Empty Array", new int[]{ }, 4);

    checker("Single Element, Insert Lower",  new int[]{ 5 }, 4);
    checker("Single Element, Insert Higher", new int[]{ 5 }, 6);
    checker("Single Element, Insert Same",   new int[]{ 5 }, 5);
    
    checker("Two Elements,   Insert Lower",  new int[]{ 2, 4 }, 1);
    checker("Two Elements,   Insert First",  new int[]{ 2, 4 }, 2);
    checker("Two Elements,   Insert Middle", new int[]{ 2, 4 }, 3);
    checker("Two Elements,   Insert Second", new int[]{ 2, 4 }, 4);
    checker("Two Elements,   Insert Higher", new int[]{ 2, 4 }, 5);

    checker("Random", randomSortedArray(10), (int)(Math.floor(Math.random()*60)));
  }

  // Overload
  public static int binarySearch(int[] sorted, int query) {
    return binarySearch(sorted, query, 0, sorted.length);
  }

  /// Returns an `index` into the `sorted` list with the following properties:
  ///   I.   0 <= index <= sorted.length
  ///   II.  for all i < index, sorted[i] <= query
  ///   III. for all i >= index, sorted[i] >= query
  /// Requirement:  `sorted` is sorted in ascending order.
  public static int binarySearch(int[] sorted, int query, int lowIdx, int highIdx) {
    // 0. Base Case:  Range is Empty [)
    if(lowIdx == highIdx) {
      return lowIdx;
    }

    // 1. find the middle of the range [lowIdx, highIdx)
    int middleIdx = lowIdx + (highIdx - lowIdx) / 2;
    int middleElement = sorted[middleIdx];

    // 2. if the middle element matches the query, return ths middle index
    if(middleElement == query) {
      return middleIdx;
    }

    // 2. decide which half the query number belongs to, and recurse
    if(query < middleElement) {
      return binarySearch(sorted, query, lowIdx, middleIdx);
    } else {
      return binarySearch(sorted, query, middleIdx+1, highIdx);
    }
  }

  //// HELPER METHODS //////////////////////////////////////

  /// Generates a random sorted array of numbers that
  /// we can use for testing our binary search.
  public static int[] randomSortedArray(int length) {
    int[] numbers = new int[length];

    int x = 0;
    for(int k = 0; k < length; k++) {
      x += 1 + Math.floor(Math.random() * 10);
      numbers[k] = x;
    }

    return numbers;
  }

  public static void checker(String title, int[] numbers, int query) {
    int queryIdx = binarySearch(numbers, query);
    String sep = " | ";
    String result = "\n";

    result += "--- " + title + " " + "-".repeat(75 - title.length()) + "\n";
    result += "Query:    " + query + "\n";
    result += "QueryIdx: " + queryIdx + "\n";

    // 1. print all the numbers
    for(int k = 0; k < numbers.length; k++) {
      result += String.format("% 5d", numbers[k])  + sep;
    }
    result += "\n";

    // 2. highlight numbers that violate postcondition
    for(int k = 0; k < numbers.length; k++) {
      // calculate whether or not the poscondition is satisfied
      boolean satisfies;
      if(k < queryIdx) {
        satisfies = numbers[k] <= query;
      } else {
        satisfies = numbers[k] >= query;
      }
      
      // print a ! whenever a number violates the condition
      if(satisfies) {
        result += "    +";
      } else {
        result += "!".repeat(5);
      }
      result += sep;
    }
    result += "\n";
      
      // 3. print the indexes
      for(int k = 0; k < numbers.length + 1; k++) {
        if(k == queryIdx) {
          result += " ^^^^";
        } else {
          result += String.format("% 5d", k);
        }
        result += sep;
      }

    System.out.println(result);
  }
}
