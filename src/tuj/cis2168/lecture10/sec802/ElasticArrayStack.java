package tuj.cis2168.lecture10.sec802;

import tuj.cis2168.lecture10.ElasticArray;
import tuj.cis2168.lecture10.Stack;

public class ElasticArrayStack<E> implements Stack<E> {

  ElasticArray<E> storage;

  ElasticArrayStack() {
    this.storage = new ElasticArray<>(n -> n * 2);
  }

  /// O(1) constant
  @Override
  public boolean isEmpty() {
    return this.storage.size() == 0;
  }

  /// O(1) constant
  @Override
  public E peek() {
    return this.storage.get(this.storage.size() - 1); // O(1)
  }

  /// O(1) constant
  @Override
  public E pop() {
    return this.storage.remove(this.storage.size() - 1); // O(1)
  }

  // amortized O(1)
  @Override
  public void push(E element) {
    this.storage.add(element); // amortized O(1)
  }
  // TODO: Implement me!
}
