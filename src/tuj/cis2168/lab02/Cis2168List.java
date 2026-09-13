package tuj.cis2168.lab02;

interface Cis2168List<T> {

  /// Returns the current number of elements in this list.
  int size();

  /// Appends the given `element` to the end of this list.
  void add(T element);

/// Inserts the given `element` at the specified `index`
  /// by shifting all later elements to the right.
  /// Requires `0 <= index < size()`.
  void insert(int index, T element);

  /// Replace the entry at the given `index` with `element`.
  /// Requires `0 <= index < size()`.
  void set(int index, T element);

  /// Return the element at the given `index`.
  T get(int index);

  /// Returns the smallest index where `element` can be found
  /// in this list.  Requires that `contains(element)` is `true`.
  /// If the item is not found, return -1.
  int indexOf(T element);

  /// Returns `true` if `element` belongs to this list.
  boolean contains(T element);
  
  /// Removes the element at the given index, and returns it.
  /// Fill the gap by shifting all later elements to the left.
  T remove(int index);

  /// Removes the first instance of `element` from this list,
  /// and fills the gap by shifting all later elements left.
  void delete(T element);
}