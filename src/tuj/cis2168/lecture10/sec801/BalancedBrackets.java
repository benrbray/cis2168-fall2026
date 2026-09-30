package tuj.cis2168.lecture10.sec801;

import tuj.cis2168.lecture10.Stack;

public class BalancedBrackets {
  public static void main() {
    assert isBalanced("([5 + 7]") == false;
    assert isBalanced("([5 + 7])") == true;
    assert isBalanced("[8*4])") == false;
    assert isBalanced("{5 * (4 + 1) * {6 + [7*8]}}") == true;
    System.out.print("Success!");
  }

  static String LEFT_BRACKETS  = "({[";
  static String RIGHT_BRACKETS = ")}]";

  public static boolean isLeftBracket(Character c) {
    return LEFT_BRACKETS.indexOf(c) != -1;
  }

  public static boolean isRightBracket(Character c) {
    return RIGHT_BRACKETS.indexOf(c) != -1;
  }

  public static Character matchingRightBracket(Character left) {
    int idx = LEFT_BRACKETS.indexOf(left);
    if(idx < 0) { throw new IllegalArgumentException("Not a left bracket!"); }

    return RIGHT_BRACKETS.charAt(idx);
  }

  public static boolean isBalanced(String expr) {
    // 1. Create an empty stack of characters.
    Stack<Character> leftBrackets = new SingleLLStack<>();

    // 3. Loop over every character of the input string.
    for(int i = 0; i < expr.length(); i++) {
      // 3a. Get the next character in the expression.
      Character c = expr.charAt(i);
      // 3b. If next character is a left bracket,
      //     push it onto the stack.
      if(isLeftBracket(c)) {
        leftBrackets.push(c);
      }
      // 3c. If next character is a right bracket,
      //     pop the stack and ensure that they match.
      if(isRightBracket(c)) {
        if(leftBrackets.isEmpty()) {
          return false;
        } else {
          Character left = leftBrackets.pop();
          Character right = matchingRightBracket(left);
          if(!c.equals(right)) {
            return false;
          }
        }
      }
    }
    
    // 4. Return true if balanced AND the stack is empty.
    //    (non-empty stack means there are un-closed brackets!)
    return leftBrackets.isEmpty();
  }
}
