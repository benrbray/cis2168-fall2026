package tuj.cis2168.lecture08;

import java.util.Iterator;
import java.util.Objects;

public class ElasticArray801<T> implements Cis2168List<T>, Iterable<T> {

  private static final int INITIAL_CAPACITY = 4;

  //////////////////////////////////////////////////////////
  
  private static class ArrayIterator<E> implements Iterator<E> {

    private int nextIndex;
    private ElasticArray801<E> list;

    ArrayIterator(ElasticArray801<E> list) {
      this.list = list;
      this.nextIndex = 0;
    }

    // O(1)
    @Override
    public boolean hasNext() {
      return (this.nextIndex < list.size());
    }

    // O(1)
    @Override
    public E next() {
      // return this.list.storage[this.nextIndex];
      return this.list.get(this.nextIndex);
    }
    
  }

  public Iterator<T> iterator() {
    return new ArrayIterator<>(this);
  }

  //////////////////////////////////////////////////////////

  @FunctionalInterface
  public static interface GrowthStrategy {
    /// Returns the next capacity in the sequence.
    public int next(int currentCapacity);
  }

  //////////////////////////////////////////////////////////

  private T[] storage;
  private int count;

  private GrowthStrategy growthStrategy;

  public ElasticArray801(GrowthStrategy growthStrategy) {
    // growth strategy will determine how quickly the
    // storage array grows when the list exceeds capacity
    this.growthStrategy = growthStrategy;

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

  // GROWTH RATE: O(n)
  // if there's already enough capacity, then O(1)
  // if we need to allocate new storage, then O(n)

  /// Accepts the desired size of the list as input.
  /// If there's not enough capacity, grow the storage.
  void ensureCapacity(int requiredCapacity) {
    // 0. if there is already enough capacity, do nothing
    if(this.storage.length >= requiredCapacity) {
      return;
    }

    // 1. determine new storage capacity
    int currentCapacity = this.storage.length;
    int nextCapacity = this.growthStrategy.next(currentCapacity);
    nextCapacity = Math.max(nextCapacity, requiredCapacity);
    assert nextCapacity > currentCapacity;
    
    // 2. allocate larger storage array
    @SuppressWarnings("unchecked")
    T[] nextStorage = (T[]) new Object[nextCapacity];

    // 3. manually copy the old storage into the new
    for(int i = 0; i < this.count; i++) {  // O(n)
      nextStorage[i] = this.storage[i];
    }

    // 4. replace the old storage with the new
    this.storage = nextStorage;
  }

  //////////////////////////////////////////////////////////

  @Override
  public int size() {
    return count;
  }
  

  // if there's already enough storage, O(1)
  // if there's not.... O(n)
  @Override
  public void add(T element) {
    // 1. ensure storage has enough space for the new element
    this.ensureCapacity(this.count + 1);  /// O(1)
    // 2. append the new element to the end of the list
    this.storage[this.count] = element;  // O(1)
    // 3. update the count variable
    this.count += 1;                     // O(1)
  }
  
  @Override
  public void insert(int index, T element) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, count + 1);
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

  // Growth Rate:  O(1) constant
  @Override
  public void set(int index, T element) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, count); // O(1)
    // 1. actually replace the element
    this.storage[index] = element; // O(1)
  }

  // Growth Rate: O(1) constant
  @Override
  public T get(int index) {
    // 0. ensure the index is within bounds
    Objects.checkIndex(index, this.count);  // O(1)
    // 1. return the element
    return this.storage[index]; // O(1)
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
