package tuj.cis2168.lecture10.sec802;

import tuj.cis2168.lecture10.Stack;

public class PalindromeExample {
  public static void main() {
    System.out.println(isPalindrome("RACECAR")); // expect true
    System.out.println(isPalindrome("ORANGE")); // expect false
    System.out.println("Success!");
  }

  // O(n) linear
  public static boolean isPalindrome(String input) {
    String reversedInput = reverseString(input); // O(n)
    return input.equals(reversedInput); // O(1)
  }

  // O(n) linear
  public static String reverseString(String original) {
    // 1. add all characters to a stack
    Stack<Character> charStack = new ElasticArrayStack<>();
    // O(n)
    for(int i = 0; i < original.length(); i++) { // exactly n times
      charStack.push(original.charAt(i));       // O(1)
    }

    // 2. build the string by popping the stack
    StringBuilder result = new StringBuilder();
    // O(n)
    while(!charStack.isEmpty()) { // exactly n times
      result.append(charStack.pop()); // amortized O(1)
    }
    // 3. return the string final
    return result.toString(); // O(n)
  }
}
