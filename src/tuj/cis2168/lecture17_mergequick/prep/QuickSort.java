package tuj.cis2168.lecture17_mergequick.prep;

import java.util.Arrays;

public class QuickSort {

  public static void main() {
    check(new int[]{ });
    check(new int[]{ 1 });
    check(new int[]{ 1,1 });
    check(new int[]{ 2,1 });
    check(new int[]{ 2,8,4,1,7,2,3,6,9,0 });
    check(new int[]{ 5,5,5,5,5,5,5,1,5,5 });
    check(new int[]{ 1,1,1,2,2,2,1,1,1,2,2 });
  }
  
  public static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  /// Uses a pivoting strategy to choose the next pivot.
  /// Returns the index of the chosen pivot.
  public static int selectPivot(int[] array, int start, int end) {
    return start;
    // return start + (end - start) / 2;
    // return median of start,middle,end
    // return random index
  }

  /// O(n) linear
  /// After partitioning,
  ///    all smaller elements move to the left of pivot
  ///    all larger elements move to the right of pivot
  /// Returns new index of pivot, after partitioning.
  /// REQUIRES:
  ///   length >= 2
  ///   0 <= start <= pivot < end <= length
  public static int partition(int[] array, int start, int end, int pivot) {
    // 0. swap the pivot with the first element
    swap(array, pivot, start);
    // 1. search for elements which can be swapped
    //    starting from the left, find elements larger than pivot
    //    starting from the right, find elements smaller than pivot
    int l = start+1;
    int r = end-1;

    // Invariant:
    //   start <= i < l   ==>  array[i] <= pivot value
    //       r <  i < end ==>  array[i] >= pivot value

    while(l <= r) {
      if      (array[l] <= array[pivot]) { l++; }
      else if (array[r] >= array[pivot]) { r--; }
      else {
        // both l and r are on the wrong side of pivot, so swap them
        swap(array, l, r);
      }
    }

    // 2. after the loop, r = l-1
    //    the partition boundary is between l and r
    //    move the pivot into its final, sorted location (l-1)
    int newPivot = l-1;
    swap(array, start, newPivot);
    return newPivot;
  }

  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length);
  }
  
  public static void quickSort(int[] array, int start, int end) {
    // 0. base case
    if(end - start < 2) { return; }
    // 1. choose a pivot
    int pivot = selectPivot(array, start, end);
    // 2. use the pivot to partition the array
    pivot = partition(array, start, end, pivot);
    // 3. recursively quickSort the two sides of the partition
    quickSort(array, start, pivot);
    quickSort(array, pivot+1, end);
  }

  public static void check(int[] original) {
    // use our sort to sort a copy of the original array
    int[] sorted1 = Arrays.copyOf(original, original.length);
    quickSort(sorted1);

    // sort the original array using Java's sort
    int[] sorted2 = Arrays.copyOf(original, original.length);
    Arrays.sort(sorted2);

    // make sure they are equal
    boolean pass = Arrays.equals(sorted1, sorted2);
    System.out.println(Arrays.toString(original) + " --> " + Arrays.toString(sorted1));
    System.out.println(pass ? "Pass!" : "Fail!");
  }
}
