package tuj.cis2168.lecture03.sec801;

class Cis2168Integer {
  private int data;

  Cis2168Integer(int number) {
    this.data = number;
  }

  public boolean equals(Cis2168Integer other) {
    return (this.data == other.data);
  }
}

public class GenericsExample {

  public static void main() {
    // example1();
    example2();
    // exampleWeirdIntegers();
  }

  public static void example1() {
    int[] a = new int[10];
    int[] b = { 4, 6, 10 };

    // float[] c = { 1.2f, 2.5f };
    // float[] d = { 2.4f, 10.6f, 11.8f };

    System.out.println("sameElementsInt(a,b) = " + sameElementsInt(a, b));
    System.out.println("sameElementsInt(b,b) = " + sameElementsInt(b, b));

    // int x = 10; // primitive type
    // Integer y = 10; // reference type (boxed integer)
  }

  public static void example2() {
    Integer[] a = new Integer[10];
    Integer[] b = { 4, 6, 10 };

    Float[] c = { 3.14f };
    Float[] d = { 3.14f };

    String[] section801 = { "Sean", "Ren", "Taylie" };
    String[] section802 = { "Alice", "Bob" };

    System.out.println("sameElements(a,b) = " + sameElements(a, b));
    System.out.println("sameElements(b,b) = " + sameElements(b, b));
    System.out.println("sameElements(c,d) = " + sameElements(c, d));

    System.out.println("sameElements(801,802) = " + sameElements(section801, section802));
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

  class Missile {
    public void launch() {
      // launches the missile
    }
  }

  public static void exampleMissiles() {
    Missile[] missiles1 = new Missile[10];
    Missile[] missiles2 = new Missile[10];

    // we have some code to create the missiles

    sameElements(missiles1, missiles2);
  }

  public static <T> boolean sameElements(T[] a, T[] b) {
    // return true if both int arrays have the same elements
    // return false otherwise

    // compare the lengths
    if(a.length != b.length) {
      return false;
    }

    for(int i = 0; i < a.length; i++) {
      if(!a[i].equals(b[i])) {
        return false;
      }
    }
    
    return true;
  }


  public static boolean sameElementsInt(int[] a, int[] b) {
    // return true if both int arrays have the same elements
    // return false otherwise

    // compare the lengths
    if(a.length != b.length) {
      return false;
    }

    for(int i = 0; i < a.length; i++) {
      if(a[i] != b[i]) {
        return false;
      }
    }
    
    return true;
  }

}

