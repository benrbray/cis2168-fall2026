package tuj.cis2168.lecture10.sec801;

import tuj.cis2168.lecture10.Stack;

public class PalindromeExample {
  public static void main() {
    System.out.println(isPalindrome("RACECAR"));
    System.out.println(isPalindrome("MANGO"));
  }

  // O(n) linear
  // Palindrome:  RACECAR, AABBAA
  public static boolean isPalindrome(String input) {
    String reversed = reverseString(input); // O(n)
    return reversed.equals(input);
  }

  // O(n) linear
  public static String reverseString(String original) {
    // 1. add all characters to a stack
    Stack<Character> charStack = new ElasticArrayStack<>(); // O(1)
    for(int i = 0; i < original.length(); i++) { // n times
      charStack.push(original.charAt(i));        // O(1)
    }

    // 2. build the string by popping the stack
    StringBuilder result = new StringBuilder();
    while(!charStack.isEmpty()) { // exactly n times
      result.append(charStack.pop()); // O(1)
    }

    // 3. return the string final
    return result.toString(); // O(n)
  }
}
