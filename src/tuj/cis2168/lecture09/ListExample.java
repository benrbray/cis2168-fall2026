package tuj.cis2168.lecture09;

import java.util.Iterator;

public class ListExample {
  public static void main() {
    Cis2168List<String> example = new DoubleLinkedList<>();
    example.add("apricot");
    example.add("banana");
    example.add("cherry");

    System.out.println("Before");
    printList(example);

    example.insert(1, "avocado");

    System.out.println("\n\nAfter");
    printList(example);

    // 0 apricot
    // 1 avocado
    // 2 banana
    // 3 cherry

    example.remove(0);
    System.out.println("\n\nAfter Removal");
    printList(example);
  }

  public static void removeOddNumbers(Cis2168List<Integer> list) {
    // n * O(n) = O(n^2) if the list is a linked list
    for(int i = 0; i < list.size(); i++) { // n times
      if(list.get(i) % 2 == 1) { // O(n)
        list.remove(i); // O(n)
      }
    }
  }

  // n * O(1) = O(n)
  public static void removeOddNumbersDouble(DoubleLinkedList801<Integer> list) {
    Iterator<Integer> it = list.iterator();
    Integer n = null;
    while(it.hasNext()) { // n times
      n = it.next();

      if(n % 2 == 1) {
        it.remove(); // modifies the list in place!!! O(1)
      }
    }
  }

  public static <T> void printList(Cis2168List<T> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("idx=" + i + ":" + list.get(i));
    }
  }
}
