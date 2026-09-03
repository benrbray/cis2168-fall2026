package tuj.cis2168.lecture03;

public class ArrayExample {
  public static void main() {
    // creating arrays
    int[] array1 = new int[10];      // initialized to all zeros
    int[] array2 = { 10, 4, -3, 7 }; // manual initializer list

    // array operations
    int arrayLen = array1.length;

    // accessing elements
    int arrayElement = array1[0];
    array1[4] = 10;

    // element access is only checked at runtime
    // Runtime: ArrayIndexOutOfBoundsException
    array1[100] = 10;

    
  }
}
