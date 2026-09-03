package tuj.cis2168.lecture03;

public class GenericsExample {
  public static void main() {
    example1();
    // example2();
    // example3();
    // exampleWeirdIntegers();
  }

  //////////////////////////////////////////////////////////
  
  public static void example1() {
    int[] a = { 1, 2, 3 };
    int[] b = { 1, 2, 99 };

    System.out.println("sameElementsInt(a,b) = " + sameElementsInt(a, b));
  }

  public static boolean sameElementsInt(int[] a, int[] b) {
    if(a.length != b.length) {
      return false;
    }

    for(int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  ///// GENERIC VERSION ////////////////////////////////////
  
  // public static void example2() {
  //   int[] a = { 1, 2, 3 };
  //   int[] b = { 1, 2, 99 };

  //   // ERROR: The method sameElements(T[], T[]) in the type
  //   // GenericsExample is not applicable for the arguments (int[], int[])
  //   System.out.println("sameElements<int>(a,b) = " + sameElements(a, b));
  // }

  public static void example3() {
    Integer[] a = { 1, 2, 3 };
    Integer[] b = { 1, 2, 99 };

    // Type parameters can only refer to a reference type,
    // so we need to use boxed Integers instead.
    System.out.println("sameElements<int>(a,b) = " + sameElements(a, b));

    // Verbose ugly way to be explicit with the generic arguments!
    // System.out.println("sameElements<int>(a,b) = " + GenericsExample.<Integer>sameElements(a, b));
  }
  
  public static<T> boolean sameElements(T[] a, T[] b) {
    if(a.length != b.length) {
      return false;
    }

    for(int i = 0; i < a.length; i++) {
      if (!a[i].equals(b[i])) {
        return false;
      }
    }

    return true;
  }

  //// BOXED INTEGERS //////////////////////////////////////

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
}
