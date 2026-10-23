package tuj.cis2168.lecture15_heap.prep;

import java.util.Arrays;
import java.util.List;

public class HeapCheck {

  public static void main() {
    // testInsert();
    testHeapify();
  }
  
  public static void testInsert() {
    MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>();

    int[] numbers = {
      20, 13, 14, 12,  8,  3,  9,  6, 17,  2,
      10,  5, 19,  1, 11, 18,  4,  7, 15, 16 };

    // insert first 10
    for(int i = 0; i < 10; i++) {
      heap.insert(numbers[i]);
    }

    // pop 5 largest
    for(int k = 0; k < 5; k++) {
      System.out.println("Pop: " + heap.popMax());
    }

    System.out.println("-----");

    // insert remaining 10
    for(int i = 10; i < 20; i++) {
      heap.insert(numbers[i]);
    }

    // pop all
    while(!heap.isEmpty()) {
      System.out.println("Pop: " + heap.popMax());
    }
  }

  public static void testHeapify() {
    List<Integer> numbers = List.of(
      20, 13, 14, 12,  8,  3,  9,  6, 17,  2,
      10,  5, 19,  1, 11, 18,  4,  7, 15, 16
    );
    
    MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>(numbers);

    // pop all (our first sorting algorithm!!!!)
    while(!heap.isEmpty()) {
      System.out.println("Pop: " + heap.popMax());
    }
  }
}

