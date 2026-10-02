package tuj.cis2168.lecture11.sec801;

import tuj.cis2168.lecture11.DoubleLinkedList;
import tuj.cis2168.lecture11.Queue;

public class DLLQueue<T> implements Queue<T> {

  private DoubleLinkedList<T> storage;

  DLLQueue() {
    this.storage = new DoubleLinkedList<>();
  }

  /// O(1)
  @Override
  public void enqueue(T elem) {
    this.storage.add(elem);
  }

  /// O(1)
  @Override
  public T dequeue() {
    return this.storage.remove(0);
  }

  /// O(1)
  @Override
  public T peek() {
    return this.storage.get(0);
  }

  // O(1)
  @Override
  public boolean isEmpty() {
    return this.storage.size() == 0;
  }
}
