package tuj.cis2168.lab04.optional;

// An ordered collection of elements of type E that
// emits elements in Last In, First Out (LIFO) order.
public interface Stack<E> {
  /// Returns `true` if the stack is currently empty, otherwise `false`.
  boolean isEmpty();
  
  /// Returns the element at the top of the stack, without removing it.
  /// Requires `!isEmpty()`.
  E peek();
  
  /// Removes and returns the element at the top of the stack.
  /// Requires `!isEmpty()`.
  E pop();
  
  /// Adds `element` to the top of the stack.
  /// Requiremes that `element != null`.
  void push(E element);
}
