package tuj.cis2168.lecture16_sort.prep;

import java.util.Arrays;

// VISUALIZATION:
// https://www.youtube.com/watch?v=kPRA0W1kECg

public class QuadraticSorts {

  public static void main() {
    check(new int[]{5,3,1,4,2,0});
  }

  public static void check(int[] original) {
    // use our sort to sort a copy of the original array
    int[] sorted1 = Arrays.copyOf(original, original.length);
    selectionSort(sorted1);

    // sort the original array using Java's sort
    int[] sorted2 = Arrays.copyOf(original, original.length);
    Arrays.sort(sorted2);

    // make sure they are equal
    boolean pass = Arrays.equals(sorted1, sorted2);
    System.out.println(Arrays.toString(original) + " --> " + Arrays.toString(sorted1));
    System.out.println(pass ? "Pass!" : "Fail!");
  }

  //////////////////////////////////////////////////////////
  
  public static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  //////////////////////////////////////////////////////////
  
  /// Uses selection sort to sort the array
  /// in-place, from smallest to largest.
  public static void selectionSort(int[] array) {
    /// index `k` represents the boundary between the
    /// sorted and unsorted sections of the array.
    
    /// Every iteration of the loop moves the one element from
    /// the unsorted section to the sorted section, and
    /// advances `k` by one.
    
    for(int k = 0; k < array.length; k++) {
      // 1. identify the smallest element
      //    in unsorted section (k <= i < length)
      int smallestIdx = k;
      for(int i = k + 1; i < array.length; i++) {
        if(array[i] < array[smallestIdx]) {
          smallestIdx = i;
        }
      }
      // 2. swap the first element of the unsorted section
      //    with the smallest, and advance k by one
      swap(array, k, smallestIdx);
    }
  }

  //////////////////////////////////////////////////////////
  
  public static void insertionSort(int[] array) {
    for(int k = 0; k < array.length; k++) {
      // 1. bubble down array[k] to the correct position in sorted section
      for(int i = k; i > 0 && array[i-1] > array[i]; i--) {
        swap(array, i, i-1);
      }
    }
  }

  //////////////////////////////////////////////////////////
  
  public static int[] mergeSimple(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];

    int i = 0;
    int j = 0;

    while(i < a.length && j < b.length) {
      
    }

    return result;
  }

}
