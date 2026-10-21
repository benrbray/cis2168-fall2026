package tuj.cis2168.lecture14_bst;

// A collection that contains no duplicate elements.
public interface Cis2168Set<E> extends Iterable<E> {
  
  /// Returns `true` if `element` is a member of this set.
  boolean contains(E element);

  /// Add a new element to the set.  Has no effect if the
  /// element already belongs to the set.
  /// Requirement:  `element != null`
  void add(E element);

  /// If the element belongs to the set, removes it and
  /// returns `true`.  Otherwise, returns `false`.
  boolean remove(E element);
  
  // The number of elements in the set.
  int size();
  
  // Returns `true` if the set has no elements.
  boolean isEmpty();
}
