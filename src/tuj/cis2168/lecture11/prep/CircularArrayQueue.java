package tuj.cis2168.lecture11.prep;

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
    this.front = 0;
    this.count = 0;

    // allocate initial storage array
    @SuppressWarnings("unchecked")
    E[] storage = (E[]) new Object[INITIAL_CAPACITY];
    this.storage = storage;
  }

  //////////////////////////////////////////////////////////
  
  public String toString() {
    String result = "";

    for(int i = 0; i < this.storage.length; i++) {
      if(this.storage[i] == null) {
        result += ".";
      } else {
        result += this.storage[i].toString().charAt(0);
      }
    }

    result += "\n";

    for(int i = 0; i < this.storage.length; i++){
      if(i == this.front) {
        result += "^";
      } else {
        result += " ";
      }
    }
    
    return result;
  }
  
  private void ensureCapacity(int numElements) {
    // 1. compare the current capacity to the current size
    int currentCapacity = this.storage.length;
    if(currentCapacity >= numElements) {
      return;
    }

    // 2. decide the new capacity
    int newCapacity = Math.max(currentCapacity*2, numElements);

    // 3. allocate a larger array and copy everything over
    @SuppressWarnings("unchecked")
    E[] larger = (E[]) new Object[newCapacity];

    // 4. place all existing elements in correct order
    //    starting from index 0 of the larger array
    // arraycopy(E[] src, int srcPos, E[] dest, int destPos, int length)
    int firstHalf = currentCapacity - this.front;
    System.arraycopy(this.storage, this.front, larger, 0, firstHalf);
    System.arraycopy(this.storage, 0, larger, firstHalf, front);

    // 5. update front and storage
    this.front = 0;
    this.storage = larger;
  }

  //////////////////////////////////////////////////////////

  @Override
  public void enqueue(E elem) {
    // 0. ensure element is not null
    Objects.requireNonNull(elem);
    // 1. ensure we have enough capacity for the new element
    this.ensureCapacity(this.count + 1);
    // 2. add the new element into the next empty space
    int capacity = this.storage.length;
    int nextIdx = (front + count) % capacity;
    this.storage[nextIdx] = elem;
    // 3. increase the count
    this.count++;
  }

  @Override
  public E dequeue() {
    // 0. throw NoSuchElementException if the queue is currently empty!
    if(this.isEmpty()) {
      throw new NoSuchElementException();
    }

    // 1. remove the front of the queue, keeping a reference
    E removed = this.storage[this.front];
    this.storage[this.front] = null;

    // 2. increment front index (remember to wrap it!)
    int capacity = this.storage.length;
    this.front = (this.front + 1) % capacity;

    // 3. decrease the count
    this.count--;

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
    return (this.count == 0);
  }

}
