package tuj.cis2168.lecture18_hashset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ChainedHashSet<E> implements Cis2168Set<E> {

  static final float MAX_LOAD_FACTOR = 1.5f;
  static final int INITIAL_CAPACITY = 10;

  private List<E>[] storage;
  private int count;

  //////////////////////////////////////////////////////////
  
  public ChainedHashSet() {
    this(INITIAL_CAPACITY);
  }

  public ChainedHashSet(int initialCapcity) {
    // allocate storage array, initially filled with `null`
    @SuppressWarnings("unchecked")
    List<E>[] storage = (List<E>[]) new List[initialCapcity];
    this.storage = storage;
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  /// data ---> integer ---> index
  private static <E> int computeIndex(int capacity, E element) {
    return Math.floorMod(element.hashCode(), capacity);
  }

  private static <E> boolean addToStorage(List<E>[] storage, E element) {
    // 0. refuse to add null elements
    Objects.requireNonNull(element);
    // 1. compute the index where the element belongs
    int hashIdx = computeIndex(storage.length, element);
    // 2. retrieve the linked list at that index from the hash table
    List<E> list = storage[hashIdx];
    
    if(list == null) {
      // 3a. the set contains no elements that reduce to this index
      list = new LinkedList<E>();
      list.add(element);
      storage[hashIdx] = list;
    } else {
      // 3b. only add the new element if it does not already exist
      if(list.contains(element)) { return false; }

      list.add(element);
    }

    return true;
  }

  //////////////////////////////////////////////////////////
  
  private void grow() {
    // 1. calculate new capacity
    int capacity = this.storage.length;
    int newCapacity = capacity * 2;

    // 2. allocate and fill new hashtable
    @SuppressWarnings("unchecked")
    List<E>[] newStorage = (List<E>[]) new List[newCapacity];
    
    for(E element : this) {
      ChainedHashSet.addToStorage(newStorage, element);
    }

    // 3. replace existing storage
    this.storage = newStorage;
  }

  //////////////////////////////////////////////////////////
  
  private static class Iter<E> implements Iterator<E> {
    
    private ChainedHashSet<E> set;

    private int arrayIdx;
    private int listIdx;

    Iter(ChainedHashSet<E> set) {
      this.set = set;
      this.arrayIdx = 0;
      this.listIdx = 0;
    }

    private void advanceIndices() {
      // 1. ensure arrayIdx points to non-null entry,
      //    and listIdx is a valid index
      while(
        this.arrayIdx < this.set.storage.length && (
          this.set.storage[this.arrayIdx] == null ||
          this.listIdx >= this.set.storage[this.arrayIdx].size()
        )
      ) {
        this.arrayIdx++;
        this.listIdx = 0;
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
      return this.set.storage[this.arrayIdx].get(this.listIdx++);
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
    // 1. compute the index where the element belongs
    int hashIdx = computeIndex(this.storage.length, element);
    // 2. retrieve the linked list at that index from the hash table
    List<E> list = this.storage[hashIdx];
    if(list == null) { return false; }
    // 3. search the linked list for the element
    return list.contains(element);
  }

  @Override
  public void add(E element) {
    // 1. grow if the load factor exceeds the maximum
    int capacity = this.storage.length;
    float loadFactor = (this.count + 1) / (float)capacity;
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
    // TODO: Exercise for students!
    // HINT: Remember to `null` out empty linked lists!
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
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
