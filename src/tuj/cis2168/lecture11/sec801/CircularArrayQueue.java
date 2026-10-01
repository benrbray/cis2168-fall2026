package tuj.cis2168.lecture11.sec801;

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
    // 1. compare the current capacity to the current size
    // 2. decide the new capacity

    // 3. allocate a larger array and copy everything over

    // 4. place all existing elements in correct order
    //    starting from index 0 of the larger array
    // arraycopy(E[] src, int srcPos, E[] dest, int destPos, int length)

    // 5. update front and storage
    // TODO
  }

  //////////////////////////////////////////////////////////

  @Override
  public void enqueue(E elem) {
    // 0. ensure element is not null
    Objects.requireNonNull(elem);
    // 1. ensure we have enough capacity for the new element
    // 2. add the new element into the next empty space
    //    (remember to wrap around!)
    // 3. increase the count
    // TODO
  }

  @Override
  public E dequeue() {
    // 0. throw NoSuchElementException if the queue is currently empty!
    if(this.isEmpty()) {
      throw new NoSuchElementException();
    }

    // 1. remove the front of the queue, keeping a reference
    // 2. increment front index (remember to wrap it!)
    // 3. decrease the count
    // 4. return the removed element
  }

  @Override
  public E peek() {
    // 0. throw NoSuchElementException if the queue is currently empty!
    if(this.isEmpty()) {
      throw new NoSuchElementException();
    }

    // 1. return the element at the front index
    // TODO
  }

  @Override
  public boolean isEmpty() {
    // TODO
  }

}
