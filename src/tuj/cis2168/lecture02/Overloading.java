package tuj.cis2168.lecture02;

public class Overloading {
  public static void main() {
    myFunction(2);
    myFunction(2, 5);
    myFunction(1.25);
  }

  static int myFunction(int x) {
    return 2 * x;
  }

  static int myFunction(double x) {
    return 2;
  }

  static int myFunction(int x, int y) {
    return x + y;
  }
}
