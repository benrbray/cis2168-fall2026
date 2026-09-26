package tuj.cis2168.lab03;

import java.util.Iterator;
import java.util.LinkedList;

public class Problem1 {
  public static void main() {
    // TODO: Add your own test!
  }
}

////////////////////////////////////////////////////////////

/// A list which stores elements in _ascending_ order,
/// smallest to largest, using the Comparable interface.
class OrderedList<E extends Comparable<E>> {
  private LinkedList<E> list;

  OrderedList() {
    // TODO:  Implement me!
  }

  /// Inserts a new element into the list, preserving order.
  /// Time Complexity:  O(n)
  public void add(E element) {
    // TODO:  Implement me!
  }

  /// Returns an `Iterator` for this OrderedList.
  /// Time Complexity:  O(1)
  public Iterator<E> iterator() {
    // TODO:  Implement me!
  }

  /// Returns the element at `index`, in sorted order.
  /// Time Complexity:  O(n)
  public E get(int index) {
    // TODO:  Implement me!
  }

  /// Returns the number of elements in the `OrderedList`.
  /// Time Complexity:  O(1)
  public int size() {
    // TODO:  Implement me!
  }

  /// Removes the first occurrence of `element` from the `OrderedList`.
  /// Time Complexity:  O(n)
  public E remove(E element) {
    // TODO:  Implement me!
  }
}