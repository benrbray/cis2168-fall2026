package tuj.cis2168.lecture03;

// below are similar interfaces in the
// Java Collections Framework
// import java.util.List;
// import java.util.Collection;
// import java.util.SequencedCollection;

public class StringListExample {
  
}

////////////////////////////////////////////////////////////

interface StringList {
  /// Appends the given `element` to the end of this list.
  void add(String element);
  
  /// Inserts the given `element` at the specified `index`
  /// by shifting all later elements to the right.
  /// Requires `0 <= index < size()`.
  void insert(int index, String element);
  
  /// Returns the current number of elements in this list.
  int size();
  
  /// Return the element at the given `index`.
  String get(int index);

  /// Replace the entry at the given `index` with `element`.
  /// Requires `0 <= index < size()`.
  void set(int index, String element);

  /// Returns `true` if `element` belongs to this list.
  boolean contains(String element);

  /// Returns the smallest index where `element` can be found
  /// in this list.  Requires that `contains(element)` is `true`.
  int indexOf(String element);
  
  /// Removes the element at the given index, and returns it.
  /// Fill the gap by shifting all later elements to the left.
  String remove(int index);

  /// Removes the first instance of `element` from this list,
  /// and fills the gap by shifting all later elements left.
  /// Requires that `contains(element)` is `true`.
  void delete(String element);
}