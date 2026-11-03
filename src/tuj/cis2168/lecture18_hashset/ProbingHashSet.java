package tuj.cis2168.lecture18_hashset;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProbingHashSet<E> implements Cis2168Set<E> {

  static final float MAX_LOAD_FACTOR = 0.5f; // grow when half full
  static final int INITIAL_CAPACITY = 10;
  
  // WEIRD:  The set doesn't ever need to return an E, so use
  // an Object array!  Every Object has a hashCode() and equals()!
  // This is necessary, because to delete, we will fill with
  // a dummy value.
  private Object[] storage;  // Object-oriented programming :)
  private int count;
  private int deletedCount;

  //////////////////////////////////////////////////////////
  
  // deleted entries will be replaced with a dummy,
  // to avoid breaking the probe parade!
  private final static Object DUMMY = new Object();

  //////////////////////////////////////////////////////////
  
  public ProbingHashSet() {
    this(INITIAL_CAPACITY);
  }
  
  public ProbingHashSet(int initialCapacity) {
    // allocate storage array, initially filled with `null`
    this.storage = new Object[initialCapacity];
    this.count = 0;
    this.deletedCount = 0;
  }

  //////////////////////////////////////////////////////////
  
  /// data ---> integer ---> index
  private static int computeIndex(int capacity, Object element) {
    return Math.floorMod(element.hashCode(), capacity);
  }

  /// REQUIRES:
  ///    storage has at least one `null` element
  /// POSTCONDITION:
  ///    storage[probeIdx] == null || storage[probeIdx].equals(element)
  private static int probe(Object[] storage, Object element) {
    // 1. compute the index where the element belongs
    int hashIdx = computeIndex(storage.length, element);

    // 2. keep probing until we find the element, or null
    int probeIdx = hashIdx;

    while(true) {
      // 2a. retrieve element at probeIdx
      Object probe = storage[probeIdx];
      // 2b. if null, return probe location
      if(probe == null) {
        return probeIdx;
      }
      // 2c. if equal to element, return probe location
      if(probe.equals(element)) {
        return probeIdx;
      }
      // 2d. otherwise, continue with linear probe
      probeIdx = (probeIdx + 1) % storage.length;
    }
  }

  private static boolean addToStorage(Object[] storage, Object element) {
    // 0. refuse to add null elements
    Objects.requireNonNull(element);
    // 1. use linear probing to find location where element belongs
    int probeIdx = ProbingHashSet.probe(storage, element);
    // 2. if returned probe is null, insert (otherwise, it's already there!)
    if(storage[probeIdx] == null) {
      storage[probeIdx] = element;
      return true;
    } else {
      return false;
    }
  } 

  //////////////////////////////////////////////////////////
  
  private void grow() {
    // 1. calculate new capacity
    int capacity = this.storage.length;
    int newCapacity = capacity * 2;

    // 2. allocate and fill new hashtable
    Object[] newStorage = new Object[newCapacity];
    
    for(E element : this) {
      ProbingHashSet.addToStorage(newStorage, element);
    }

    // 3. replace existing storage
    this.storage = newStorage;
    this.deletedCount = 0;
  }

  //////////////////////////////////////////////////////////

  private static class Iter<E> implements Iterator<E> {
    
    private ProbingHashSet<E> set;

    private int arrayIdx;

    Iter(ProbingHashSet<E> set) {
      this.set = set;
      this.arrayIdx = 0;
    }

    private void advanceIndices() {
      // 1. ensure arrayIdx points to non-null and non-DUMMY entry
      while(
        this.arrayIdx < this.set.storage.length && (
          this.set.storage[this.arrayIdx] == null ||
          this.set.storage[this.arrayIdx] == DUMMY   // NOTE: exact reference check, not .equals()!
        )
      ) {
        this.arrayIdx++;
      }
    }

    @Override
    public boolean hasNext() {
      this.advanceIndices();

      // 2. handle case where we have finished visiting all hash table entries
      if(this.arrayIdx >= set.storage.length) { return false; }

      return true;
    }

    @Override
    public E next() {
      this.advanceIndices();
      
      @SuppressWarnings("unchecked")
      E next = (E) this.set.storage[this.arrayIdx++];
      return next;
    }

  }
  
  @Override
  public Iterator<E> iterator() {
    return new Iter<>(this);
  }

  @Override
  public String toString() {
    String result = "";
    for(E elem : this) {
      result += elem.toString();
    }
    return result;
  }

  //////////////////////////////////////////////////////////

  @Override
  public boolean contains(E element) {
    int probeIdx = ProbingHashSet.probe(this.storage, element);
    return (this.storage[probeIdx] != null);
  }

  @Override
  public void add(E element) {
    // 1. compute load factor
    int capacity = this.storage.length;
    float loadFactor = (this.count + this.deletedCount + 1) / (float)capacity;
    
    // 2. grow if the load factor exceeds the maximum
    if(loadFactor > MAX_LOAD_FACTOR) {
      this.grow();
    }

    // 2. add the new element, ignoring duplicates
    if(addToStorage(this.storage, element)) {
      this.count++;
    }
  }

  @Override
  public boolean remove(E element) {
    // 0. refuse null elements
    Objects.requireNonNull(element);
    // 1. use linear probing to find location where element belongs
    int probeIdx = ProbingHashSet.probe(this.storage, element);
    // 2. if returned probe is non-null, replace with dummy element
    if(this.storage[probeIdx] != null) {
      this.storage[probeIdx] = ProbingHashSet.DUMMY;
      this.count--;
      this.deletedCount++;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }
  
}
