package tuj.cis2168.lecture11.prep;

import tuj.cis2168.lecture11.DoubleLinkedList;
import tuj.cis2168.lecture11.Queue;

public class DLLQueue<T> implements Queue<T> {

  private DoubleLinkedList<T> storage;

  DLLQueue() {
    this.storage = new DoubleLinkedList<>();
  }

  @Override
  public void enqueue(T elem) {
    this.storage.insert(0, elem);
  }

  @Override
  public T dequeue() {
    return this.storage.remove(this.storage.size() - 1);
  }

  @Override
  public T peek() {
    return this.storage.get(this.storage.size() - 1);
  }

  @Override
  public boolean isEmpty() {
    return this.storage.size() == 0;
  }
  
}
