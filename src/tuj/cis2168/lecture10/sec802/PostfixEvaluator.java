package tuj.cis2168.lecture10.sec802;

import tuj.cis2168.lecture10.Stack;

public class PostfixEvaluator {
  public static void main() {
    System.out.println("Result: " + evaluatePostfix("5 3 + 4 *"));
  }

  public static Integer evaluatePostfix(String expr) {
    // 1. Create an empty stack of Integers.
    Stack<Integer> numbers = new SingleLLStack<>();

    // 2. Split the input string into tokens.
    String[] tokens = expr.split(" ");

    // 3. Get the next token from the expression string
    for(int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      System.out.println(i + ": " + token);

      try {
        // 3a. If the next token is a digit,
        //     push it onto the operand stack.
        Integer n = Integer.valueOf(token);
        numbers.push(n);
      } catch (NumberFormatException e) {
        // 3b. If the next token is an operator,
        //     pop the left and right operands off the stack,
        //     evaluate the expression, and push the result
        //     onto the top of the stack so it can be used
        //     by other operators.
        Integer right = numbers.pop();
        Integer left = numbers.pop();

        if(token.equals("+")) {
          numbers.push(left + right);
        } else if(token.equals("-")) {
          numbers.push(left - right);
        } else if(token.equals("*")) {
          numbers.push(left * right);
        } else if(token.equals("/")) {
          numbers.push(left / right);
        } else {
          throw new IllegalArgumentException();
        }
      }
    }

    // 4. pop the stack and return the result
    return numbers.pop();
  }
}
