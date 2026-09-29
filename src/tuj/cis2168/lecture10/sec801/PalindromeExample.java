package tuj.cis2168.lecture10.sec801;

import tuj.cis2168.lecture10.Stack;

public class PalindromeExample {
  public static void main() {

  }

  public static boolean isPalindrome(String input) {
    String reversedInput = reverseString(input);
    return input.equals(reversedInput);
  }

  public static String reverseString(String original) {
    // 1. add all characters to a stack
    Stack<Character> charStack = null; // TODO
    for(int i = 0; i < original.length(); i++) {
      charStack.push(original.charAt(i));
    }

    // 2. build the string by popping the stack
    StringBuilder result = new StringBuilder();
    // TODO

    // 3. return the string final
    return result.toString(); // O(N)
  }
}
