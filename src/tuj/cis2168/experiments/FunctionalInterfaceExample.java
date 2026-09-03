package tuj.cis2168.experiments;

// Q:  What's the difference between using a Lambda and using an Inner Class?
// A:  The inner class creates a new scope -- so "this" refers to the inner class.
//     In a Lambda, no new scope is created.  So "this" refers to the original scope.

// Reading:
//   https://www.baeldung.com/java-8-lambda-expressions-tips
//   https://www.baeldung.com/java-8-functional-interfaces

public class FunctionalInterfaceExample {
  public static void main() {
    // OK:  we could create an anonymous class, and instantiate it
    DoubleFunction f2 = new DoubleFunction() {
      public double apply(double input) {
        return 2 + input;
      }
    };

    // BEST: or,
    DoubleFunction f1 = (x -> 2 + x);
    
    // Lambda with two arguments
    TwoArgFunction g = ((x, y) -> x + y);

    // usage example
    System.out.println(applyTwice(x -> 2 + x, 10));
  }

  // this function takes another function as input
  // we might call it a "higher-order function"
  static double applyTwice(DoubleFunction func, double x) {
    return func.apply(func.apply(x));
  }
}

@FunctionalInterface
interface DoubleFunction {
  double apply(double input);
}

@FunctionalInterface
interface TwoArgFunction {
  double apply(double x, double y);
}

