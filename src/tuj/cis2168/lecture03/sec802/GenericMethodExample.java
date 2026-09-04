package tuj.cis2168.lecture03.sec802;

class Cis2168Integer {
  private int data;

  Cis2168Integer(int number) {
    this.data = number;
  }
}

public class GenericMethodExample {
  public static void main() {
    // example1();
    example2();
    exampleWeirdIntegers();

    // int x = 10;     // primitive
    // Integer y = 10; // reference type (boxed type)
  }

  public static void exampleWeirdIntegers() {
    Integer x = 2168;
    Integer y = 2168;
    
    // these integers reside in different memory locations
    // and == only checks if their _references_ are equal
    // (this is true of all reference types -- not primitives)
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    System.out.println("x == y? " + (x == y));
    System.out.println("x.equals(y)? " + (x.equals(y)));
  }

  public static void example1() {
    int[] a = new int[10];
    a[0] = 10;
    a[1] = 3;

    int[] b = { 4, 10, -2 };
    int[] c = { 4, 10, -2 };

    System.out.println("sameElementsInt(a,b) = " + sameElementsInt(a,b));
    System.out.println("sameElementsInt(b,c) = " + sameElementsInt(b,c));
  }

  public static void example2() {
    Integer[] a = new Integer[10];
    a[0] = 10;
    a[1] = 3;

    Integer[] b = { 4, 10, -2 };
    Integer[] c = { 4, 10, -2 };

    String[] fruits = { "banana", "cherry" };
    String[] animals = { "cat", "dog" };

    System.out.println("sameElements(a,b) = " + sameElements(a,b));
    System.out.println("sameElements(c,d) = " + sameElements(b, c));
    System.out.println("sameElements(fruits, animals) = " + sameElements(fruits, animals));
  }

  public static boolean sameElementsInt(int[] a, int[] b) {
    // we need to know the length of both arrays
    if(a.length != b.length) {
      return false;
    }

    // compare all of the elements using a for loop
    for(int i = 0; i < a.length; i++) {
      if(a[i] != b[i]) {
        return false;
      }
    }

    // if we reach the end of this functoin without returning
    // we know the arrays are equal!
    return true;
  }

  public static <T> boolean sameElements(T[] a, T[] b) {
    // we need to know the length of both arrays
    if(a.length != b.length) {
      return false;
    }

    // compare all of the elements using a for loop
    for(int i = 0; i < a.length; i++) {
      if(!a[i].equals(b[i])) {
        return false;
      }
    }

    // if we reach the end of this functoin without returning
    // we know the arrays are equal!
    return true;
  }
}
