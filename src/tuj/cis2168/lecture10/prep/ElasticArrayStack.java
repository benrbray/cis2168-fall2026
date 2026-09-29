package tuj.cis2168.lecture10.prep;

import tuj.cis2168.lecture10.ElasticArray;
import tuj.cis2168.lecture10.Stack;

public class ElasticArrayStack<E> implements Stack<E> {

  ElasticArray<E> storage;

  ElasticArrayStack() {
    this.storage = new ElasticArray<>(n -> n * 2);
  }

  /// O(1) constant runtime.
  @Override
  public boolean isEmpty() {
    return this.storage.size() == 0; // O(1)
  }

  /// O(1) constant runtime.
  @Override
  public E peek() {
    return this.storage.get(this.storage.size()-1); // O(1)
  }

  /// O(1) constant runtime.
  @Override
  public E pop() {
    return this.storage.remove(this.storage.size()-1); // O(1) for last element
  }

  /// If we have enough capacity, O(1) constant runtime.
  /// If not, grow the elastic array, O(n) linear runtime.
  @Override
  public void push(E element) {
    this.storage.add(element);
  }
  
}
