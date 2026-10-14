package tuj.cis2168.lecture12;

public class RecursionExample802 {
  public static void main() {
    int[] numbers = {1,2,3,4};
    System.out.println(containsRecursive(99, numbers));
  }

  public static boolean contains(int query, int[] numbers) {
    // if numbers contains the query number, return true
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] == query) {
        return true;
      }
    }

    return false;
  }

  public static boolean containsRecursive(int query, int[] numbers) {
    return containsHelper(query, numbers, 0);
  }

  public static boolean containsHelper(int query, int[] numbers, int idx) {
    // base case: we reached the end of the list
    if(idx >= numbers.length) {
      return false;
    }
    // recursive case
    if(numbers[idx] == query) {
      return true;
    } else {
      return containsHelper(query, numbers, idx + 1);
    }
  }

  // O(n) linear runtime
  public static int fib(int n) {
    return fibHelper(0, 1, n);
  }

  public static int fibHelper(int prev, int current, int n) {
    if(n == 1) {
      return current;
    } else {
      return fibHelper(current, prev + current, n-1);
    }
  }

  // O(n) linear runtime
  public static int fibIter(int n) {
    if(n == 1) { return 1; }
    if(n == 2) { return 1; }

    int prev = 1;
    int current = 1;

    for(int i = 3; i <= n; i++) {
      int next = prev + current;
      prev = current;
      current = next;
    }

    return current;
  }

  public static int stringLength(String str) {
    if(str.isEmpty() || str == null) {
      return 0;
    } else {
      String rest = str.substring(1);
      return 1 + stringLength(rest);
    }
  }

  public static void printChars(String str) {
    if(str.isEmpty() || str == null) {
      return;
    } else {
      printChars(str.substring(1));
      System.out.println(str.charAt(0)); // print first character
    }
  }

  public static int factorialIter(int n) {
    int result = 1;

    for(int i = 1; i <= n; i++) {
      result *= i;
    }

    return result;
  }

}
