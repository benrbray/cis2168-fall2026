package tuj.cis2168.lecture13_bst.prep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tuj.cis2168.lecture13_bst.Cis2168Set;

/// Uses a sorted ArrayList to implement the Set interface.
public class SortedArraySet<E extends Comparable<E>> implements Cis2168Set<E> {

  // Requirement:  storage is always sorted in ascending
  // order, according to the Comparable<E> implementation
  List<E> storage;

  SortedArraySet() {
    this.storage = new ArrayList<>();
  }

  //////////////////////////////////////////////////////////
  
  /// Linear search and binary search both return an`index` into
  /// the sorted `storage` list, with the following properties:
  ///
  ///   I.   0 <= index <= storage.size()
  ///   II.  for all i < index, storage[i] <= query
  ///   III. for all i >= index, storage[i] >= query

  // O(n) linear runtime
  // Uses a linear search through the sorted array
  // to find the position where the element belongs.
  private int linearSearch(E query) {
    // return index of first element >= query
    for(int k = 0; k < this.storage.size(); k++) {
      if(query.compareTo(this.storage.get(k)) <= 0) {
        return k;
      }
    }

    // if we reach the end without returning, the query
    // is larger than all elements in the set, so it
    // belongs at the end
    return this.storage.size();
  }

  // O(log n) logarithmic runtime
  // Uses a binary search through the sorted array
  // to find the position where the element belongs.
  public int binarySearch(E query) {
    return this.binarySearch(query, 0, this.storage.size());
  }

  public int binarySearch(E query, int lowIdx, int highIdx) {
    // 0. Base Case:  Range is Empty [)
    if(lowIdx == highIdx) {
      return lowIdx;
    }

    // 1. find the middle of the range [lowIdx, highIdx)
    int middleIdx = lowIdx + (highIdx - lowIdx) / 2;
    E middleElement = this.storage.get(middleIdx);

    int compareResult = query.compareTo(middleElement);

    // 2. if the middle element matches the query, return ths middle index
    if(middleElement == query) {
      return middleIdx;
    }

    // 2. decide which half the query number belongs to, and recurse
    if(compareResult < 0) {
      return this.binarySearch(query, lowIdx, middleIdx);
    } else {
      return this.binarySearch(query, middleIdx+1, highIdx);
    }
  }

  //////////////////////////////////////////////////////////

  @Override
  public void add(E element) {
    // 1. calculate insertion index
    int insertIdx = this.linearSearch(element);    // O(n)
    // int insertIdx = this.binarySearch(element); // O(log n)

    // 2. don't insert the element if it already exists
    //    (if it exists, we know it MUST be found at insertIdx)
    if(insertIdx < this.storage.size()) {
      E elementAtInsertIdx = this.storage.get(insertIdx);
      if(element.equals(elementAtInsertIdx)) {
        return;
      }
    }

    // 3. actually insert the element at the desired position
    this.storage.add(insertIdx, element); // O(n)

    // PROBLEM: If we use an array for storage, add() is still O(n)!!!
    // - Solution #1:  What if we use a CircularArrayDeque?
    //      (then, we have a best-case runtime of O(log n) when inserting
    //       an increasing sequence of numbers into the set, but the worst
    //       case is still O(n))
    // - Solution #2:  Binary Tree!
  }

  @Override
  public boolean remove(E element) {
    // TODO: Exercise for Students!
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public Iterator<E> iterator() {
    // TODO: Exercise for Students!
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
  }

  @Override
  public boolean contains(E element) {
    // 1. calculate index where element must live if it exists
    int insertIdx = this.linearSearch(element);    // O(n)
    // int insertIdx = this.binarySearch(element); // O(log n)

    // 2. check the element
    if(insertIdx < this.storage.size()) {
      E elementAtInsertIdx = this.storage.get(insertIdx);
      if(element.equals(elementAtInsertIdx)) {
        return true;
      }
    }

    return false;
  }

  @Override
  public int size() {
    return this.storage.size();
  }

  @Override
  public boolean isEmpty() {
    return this.storage.isEmpty();
  }
  
  public String toString() {
    return this.storage.toString();
  }
}
