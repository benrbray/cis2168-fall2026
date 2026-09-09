package tuj.cis2168.lecture05;

import java.util.Objects;

public class ElasticArray802<T> implements Cis2168List<T> {

  private static final int INITIAL_CAPACITY = 4;

  private T[] storage;
  private int count;

  ElasticArray802() {
    // TODO
  }

  //////////////////////////////////////////////////////////
  
  /// Grow the array!
  void grow() {
    // 1. allocate a new larger array
    // 2. manually copy the old storage into the new
    // 3. replace the old storage with the new
  }

  /// Accepts the desired size of the list as input.
  /// If there's not enough capacity, grow the storage.
  void ensureCapacity(int newCount) {

  }

  //////////////////////////////////////////////////////////

  @Override
  public int size() {
    // TODO
  }
  
  @Override
  public void add(T element) {
    // 1. ensure storage has enough space for the new element
    // 2. append the new element to the end of the list
    // 3. update the count variable
  }
  
  @Override
  public void insert(int index, T element) {
    // 0. ensure the index is within bounds
    // 1. ensure storage has enough space for the new element
    // 2. shift all elements after index to the right
    // 3. actually insert the new element
    // 4. update the count variable
  }

  @Override
  public void set(int index, T element) {
    // 0. ensure the index is within bounds
    // 1. actually replace the element
  }

  @Override
  public T get(int index) {
    // 0. ensure the index is within bounds
    // 1. return the element
  }

  @Override
  public int indexOf(T element) {
    // TODO
  }

  @Override
  public boolean contains(T element) {
    //
  }

  @Override
  public T remove(int index) {
    // 0. ensure the index is within bounds
    // 1. save the removed element for later
    // 2. manually shift everything after index to the left,
    //    overwriting whatever was previously at that index
    // 3. the last element is now repeated twice!
    //    set it to null to avoid dangling reference
    // 4. decrease the count variable
    // 5. return the removed element
  }

  @Override
  public void delete(T element) {
    
  }

}
