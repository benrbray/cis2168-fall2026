package tuj.cis2168.lecture17_mergequick.prep;

import java.util.Arrays;

public class MergeSort {
  
  public static void main() {
    check(new int[]{ 0, 8, 2, 3, 7, 1, 4, 6, 5, 9 });
  }

  //////////////////////////////////////////////////////////

  // O(n) linear runtime
  // REQUIREMENT:  `a` and `b` are sorted in increasing order
  public static int[] merge(int[] a, int[] b) {
    int[] merged = new int[a.length + b.length];

    int i = 0; // index into a
    int j = 0; // index into b
    int k = 0; // index into merged
    
    // when both arrays have elements remaining
    while(i < a.length && j < b.length) {
      if(a[i] < b[j]) {
        merged[k] = a[i];
        i++;
      } else {
        merged[k] = b[j];
        j++;
      }
      
      k++;
    }

    // fill in the rest of a
    while(i < a.length) { merged[k++] = a[i++]; }
    // fill in the rest of b
    while(j < b.length) { merged[k++] = b[j++]; }

    return merged;
  }


  // Merge sort for the range [start, end) not including end.
  public static void mergeSort(int[] array) {
    // 0. arrays of length zero or one are already sorted
    if(array.length < 2) { return; }
    // 1. make copies of left and right halves of array
    int middle = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, middle);
    int[] right = Arrays.copyOfRange(array, middle, array.length);
    // 2. sort both halves separately
    mergeSort(left);
    mergeSort(right);
    // 3. merge the sorted halves
    int[] merged = merge(left, right);
    // 4. overwrite the input array with the sorted version
    System.arraycopy(merged, 0, array, 0, array.length);
  }
  
  //////////////////////////////////////////////////////////

  public static void check(int[] original) {
    // use our sort to sort a copy of the original array
    int[] sorted1 = Arrays.copyOf(original, original.length);
    mergeSort(sorted1);

    // sort the original array using Java's sort
    int[] sorted2 = Arrays.copyOf(original, original.length);
    Arrays.sort(sorted2);

    // make sure they are equal
    boolean pass = Arrays.equals(sorted1, sorted2);
    System.out.println(Arrays.toString(original) + " --> " + Arrays.toString(sorted1));
    System.out.println(pass ? "Pass!" : "Fail!");
  }

}
