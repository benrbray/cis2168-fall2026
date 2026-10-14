package tuj.cis2168.lecture12;

public class RecursionExample801 {
  public static void main() {
    int[] numbers = { 1,2,3,4,5 };
    System.out.println(contains(4, numbers));

  }

  public static int length(String str) {
    if(str.isEmpty() || str == null) {
      // base case
      return 0;
    } else {
      return 1 + length(str.substring(1));
    }
  }

  public static void printChars(String str) {
    // base case: empty string
    if(str.isEmpty() || str == null) {
      return;
    }
    // recursive case: peel off one character
    printChars(str.substring(1));      // print the rest of the string
    System.out.println(str.charAt(0)); // print the first character
  }

  // Iterative: O(n)
//   public static int fibonacciIterative(int n) {
//     if(n == 1) { return 1; }
//     if(n == 2) { return 1; }

//     i
//     for(int k = 3; knt prev    = 1;
//     int current = 1;
//  <= n; k++) {
//       int next = current + prev;
//       prev = current;
//       current = next;
//     }

//     return current;
//   }

  // number of simple operations in total is fibonacci(n)-1
  // always returns the nth fibonacci number
  public static int fibonacciRecursive(int n) {
    if(n == 1) { return 1; } // O(1)
    if(n == 2) { return 1; } // O(1)

    // recursive case
    return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);  
  }

  // O(n) linear
  public static int fibonacci(int n) {
    return fibonacciHelper(0, 1, n);
  }

  public static int fibonacciHelper(int prev, int current, int n) {
    if(n == 1) {
      return current;
    }else {
      return fibonacciHelper(current, prev + current, n-1);
    }
  }

  public static boolean arrayContains(int query, int[] numbers) {
    // return true if the numbers array contains query
    for(int i = 0; i < numbers.length; i++ ){
      if(numbers[i] == query) {
        return true;
      }
    }

    return false;
  }

  public static boolean contains(int query, int[] numbers) {
    return containsRecursive(query, numbers, 0);
  }

  public static boolean containsRecursive(int query, int[] numbers, int idx) {
    // base case: we reached the end
    if(idx >= numbers.length) {
      return false;
    }
    // recursive case
    if(numbers[idx] == query) {
      return true;
    } else {
      return containsRecursive(query, numbers, idx + 1);
    }
  }
}
