package tuj.cis2168.lab04.optional;

import tuj.cis2168.lecture11.ElasticArrayStack;
import tuj.cis2168.lecture11.Stack;

public class Reverse {
  public static String reverse(String message) {
    String[] words = message.split(" ");
    Stack<String> stack = new ElasticArrayStack<>();

    for(var w : words) {
      stack.push(w);
    }

    StringBuilder result = new StringBuilder();
    while(!stack.isEmpty()) {
      result.append(stack.pop() + " ");
    }

    return result.toString();
  }

  public static void main() {
    System.out.println(reverse("Hello my name is Ben"));
  }
}
