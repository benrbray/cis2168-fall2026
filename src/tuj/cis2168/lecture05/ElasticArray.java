package tuj.cis2168.lecture05;

import java.util.Objects;

public class ElasticArray<T> implements Cis2168List<T> {

  private static final int INITIAL_CAPACITY = 4;

  private T[] storage;
  private int count;

  ElasticArray() {
    // allocate storage for this instance
    // In Java, `new` only works with a concrete class, not
    // with type parameters, so as a hack, create Object[],
    // and cast to T[], then suppress the resulting warning.
    @SuppressWarnings("unchecked")
    T[] storage = (T[]) new Object[INITIAL_CAPACITY];
    this.storage = storage;

    // initially, the list is empty
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  /// Grow the array!
  void grow() {
    // 1. allocate a new larger array
    int nextCapacity = this.storage.length * 2;
    @SuppressWarnings("unchecked")
    T[] nextStorage = (T[]) new Object[nextCapacity];

    // 2. manually copy the old storage into the new
    for(int i = 0; i < this.count; i++) {
      nextStorage[i] = this.storage[i];
    }

    // 3. replace the old storage with the new
    this.storage = nextStorage;
  }

  /// Accepts the desired size of the list as input.
  /// If there's not enough capacity, grow the storage.
  void ensureCapacity(int newCount) {
    while(this.storage.length < newCount) {
      this.grow();
      System.out.println("Grow! New Size: " + this.storage.length);
    }
  }

  //////////////////////////////////////////////////////////

  @Override
  public int size() {
    return count;
  }
  
  @Override
  public void add(T element) {
    // 1. ensure storage has enough space for the new element
    this.ensureCapacity(this.count + 1);
    // 2. append the new element to the end of the list
    this.storage[this.count] = element;
    // 3. update the count variable
    this.count += 1;
  }
  
  @Override
  public void insert(int index, T element) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, count);
    // 1. ensure storage has enough space for the new element
    this.ensureCapacity(this.count + 1);
    // 2. shift all elements after index to the right
    //    (starting from the end!)
    for(int i = this.count - 1; i >= index; i--) {
      this.storage[i + 1] = this.storage[i];
    }
    // 3. actually insert the new element
    this.storage[index] = element;
    // 4. update the count variable
    this.count += 1;
  }

  @Override
  public void set(int index, T element) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, count);
    // 1. actually replace the element
    this.storage[index] = element;
  }

  @Override
  public T get(int index) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, this.count);
    // 1. return the element
    return this.storage[index];
  }

  @Override
  public int indexOf(T element) {
    for(int idx = 0; idx < this.count; idx++) {
      // Q:  Why not use .equals() here?
      // A:  If the list contains nulls, we'd get an error.
      //     Using Objects.equals() handles nulls correctly.
      if(Objects.equals(this.storage[idx], element)) {
        return idx;
      }
    }

    return -1;
  }

  @Override
  public boolean contains(T element) {
    return this.indexOf(element) >= 0;
  }

  @Override
  public T remove(int index) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, this.count);
    // 1. save the removed element for later
    T removed = this.storage[index];
    // 2. manually shift everything after index to the left,
    //    overwriting whatever was previously at that index
    for(int k = index; k < this.count-1; k++) {
      this.storage[k] = this.storage[k+1];
    }
    // 3. the last element is now repeated twice!
    //    set it to null to avoid dangling reference
    this.storage[this.count-1] = null;
    // 4. decrease the count variable
    this.count -= 1;
    // 5. return the removed element
    return removed;
  }

  @Override
  public void delete(T element) {
    int idx = this.indexOf(element);
    if(idx >= 0) {
      this.remove(idx);
    }
  }

}
