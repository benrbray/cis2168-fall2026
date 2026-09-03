package tuj.cis2168.experiments;

public class ArrayConcatExample {
  public static void main() {
    example1();
  }

  //////////////////////////////////////////////////////////

  public static void example1() {
    int[] a = { 1, 2, 3 };
    int[] b = { 4, 5, 6, 7, 8 };

    // specialized function
    for(var num : concatIntArrays(a, b)) {
      System.out.print(num + " ");
    }
    System.out.println();
    
    // generic function, attempt #2
    // ERROR: Type parameters can only refer to a reference type!
    // for(var num : concatArrays(a, b)) {
    //   System.out.print(num + " ");
    // }
    // System.out.println();

    // generic function, attempt #2
    Integer[] c = { 1, 2, 3 };
    Integer[] d = { 4, 5, 6, 7, 8 };

    for(var num : concatArrays(c, d)) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  /// Merges two arrays containing integers.
  public static int[] concatIntArrays(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];

    int k = 0;

    // add all elements from a
    for(int i = 0; i < a.length; i++) {
      result[k] = a[i];
      k += 1;
    }

    // add all elements from b
    for(int j = 0; j < b.length; j++) {
      result[k] = b[j];
      k += 1;
    }

    return result;
  }

  public static<T> T[] concatArrays(T[] a, T[] b) {
    // In Java, we can only use "new" with a class name, and
    // generic type parameters aren't technically class names.
    // So, we cast from Object[] and suppress the scary warning!
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[a.length + b.length];

    int k = 0;

    // add all elements from a
    for(int i = 0; i < a.length; i++) {
      result[k] = a[i];
      k += 1;
    }

    // add all elements from b
    for(int j = 0; j < b.length; j++) {
      result[k] = b[j];
      k += 1;
    }

    return result;
  }
}
