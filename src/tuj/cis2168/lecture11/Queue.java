package tuj.cis2168.lecture11;

/// An ordered collection of elements of type E that
/// emits elements in First In, First Out (FIFO) order.
public interface Queue<T> {
  /// Adds `elem` at the "back" of this queue.
  /// Requires that `elem != null`.
  void enqueue(T elem);

  /// Removes and returns the "front" element of this queue.
  /// Requires `!this.isEmpty()`.
  T dequeue();

  /// Returns the "front" element without removing it.
  /// Requires `!this.isEmpty()`.
  T peek();

  /// Returns `true` if the queue is currently empty,
  /// and `false` otherwise.
  boolean isEmpty();
}
