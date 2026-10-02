package tuj.cis2168.lecture11.sec802;

import java.util.NoSuchElementException;
import java.util.Objects;

import tuj.cis2168.lecture11.Queue;

public class CircularArrayQueue<E> implements Queue<E> {

  private static final int INITIAL_CAPACITY = 4;
  
  /// Index of the "front" element of the queue.
  private int front;

  /// The number of elements currently in the queue.
  private int count;

  private E[] storage;

  public CircularArrayQueue() {
    // 1. initialize the front and count to zero
    this.front = 0;
    this.count = 0;

    // 3. allocate initial storage array
    @SuppressWarnings("unchecked")
    E[] storage = (E[]) new Object[INITIAL_CAPACITY];
    this.storage = storage;
  }

  //////////////////////////////////////////////////////////
  
  private void ensureCapacity(int numElements) {
    // 1. compare the current capacity to the requested size
    int currentCapacity = this.storage.length;
    if(numElements <= currentCapacity) {
      return;
    }

    // 2. decide the new capacity
    int newCapacity = Math.max(numElements, currentCapacity * 2);

    // 3. allocate a larger array and copy everything over
    @SuppressWarnings("unchecked")
    E[] larger = (E[]) new Object[newCapacity];

    // 4. place all existing elements in correct order
    //    starting from index 0 of the larger array
    // arraycopy(E[] src, int srcPos, E[] dest, int destPos, int length)
    int firstHalf = currentCapacity - front;
    System.arraycopy(this.storage, front, larger, 0, firstHalf);
    System.arraycopy(this.storage, 0, larger, firstHalf, front);

    // 5. update front and storage
    this.storage = larger;
    this.front = 0;
  }

  //////////////////////////////////////////////////////////

  // O(1) constant amortized
  @Override
  public void enqueue(E elem) {
    // 0. ensure element is not null
    Objects.requireNonNull(elem);
    // 1. ensure we have enough capacity for the new element
    this.ensureCapacity(this.count + 1);
    // 2. add the new element into the next empty space
    //    (remember to wrap around!)
    int capacity = this.storage.length;
    int nextIdx = (front + this.count) % capacity;
    this.storage[nextIdx] = elem;
    // 3. increase the count
    this.count++;
  }

  // O(1) constant
  @Override
  public E dequeue() {
    // 0. throw NoSuchElementException if the queue is currently empty!
    if(this.isEmpty()) {
      throw new NoSuchElementException();
    }

    // 1. remove the front of the queue, keeping a reference
    E removed = this.storage[this.front]; // O(1)
    this.storage[this.front] = null;      // O(1)

    // 2. increment front index (remember to wrap it!)
    int capacity = this.storage.length;   // O(1)
    this.front = (this.front + 1) % capacity; // O(1)

    // 3. decrease the count
    this.count--; // O(1)

    // 4. return the removed element
    return removed;
  }

  @Override
  public E peek() {
    // 0. throw NoSuchElementException if the queue is currently empty!
    if(this.isEmpty()) {
      throw new NoSuchElementException();
    }

    // 1. return the element at the front index
    return this.storage[this.front];
  }

  @Override
  public boolean isEmpty() {
    return this.count == 0;
  }

}
