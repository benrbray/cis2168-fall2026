package tuj.cis2168.lecture10.prep;

import java.util.function.Function;

import tuj.cis2168.lecture10.Stack;

interface BinaryOp<T> {
  T apply(T left, T right);
}

public class PostfixEvaluator {
  public static void main() {

  }

  public static boolean isOperator(String s) {
    return (s.length() == 1) && "+-/*".contains(s);
  }

  public static BinaryOp<Integer> getOperation(String s) {
    if(s == "+") { return (x, y) -> x + y; }
    if(s == "-") { return (x, y) -> x - y; }
    if(s == "*") { return (x, y) -> x * y; }
    if(s == "/") { return (x, y) -> x / y; }
    
    throw new IllegalArgumentException("Not an operation!");
  }

  public static void evaluatePostfix(String expr) {
    // 1. Create an empty stack of Integers.
    Stack<Integer> operands = new ElasticArrayStack<>();

    // 2. Split the input string into tokens.
    String[] tokens = expr.split(" ");

    // 3. Get the next token from the expression string
    for(int i = 0; i < tokens.length; i++) {
      String token = tokens[i];

      try {
        // 3a. If the next token is a digit,
        //     push it onto the operand stack.
        Integer operand = Integer.valueOf(token);
        operands.push(operand);
      }
      catch (NumberFormatException e) {
        // 3b. If the next token is an operator,
        //     pop the left and right operands off the stack,
        //     evaluate the expression, and push the result
        //     onto the top of the stack so it can be used
        //     by other operators.
        BinaryOp<Integer> binaryOp = getOperation(token);
        Integer right = operands.pop();
        Integer left = operands.pop();
        Integer result = binaryOp.apply(left, right);

        operands.push(result);
      }

    }
  }
}
