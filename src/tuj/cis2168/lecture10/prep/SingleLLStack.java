package tuj.cis2168.lecture10.prep;

import tuj.cis2168.lecture10.SinglyLinkedList;
import tuj.cis2168.lecture10.Stack;

public class SingleLLStack<E> implements Stack<E> {

  SinglyLinkedList<E> storage;

  SingleLLStack() {
    this.storage = new SinglyLinkedList<>();
  }

  /// O(1) constant runtime.
  @Override
  public boolean isEmpty() {
    return this.storage.size() == 0;
  }

  /// O(1) constant runtime.
  @Override
  public E peek() {
    return this.storage.get(0);
  }

  /// O(1) constant runtime.
  @Override
  public E pop() {
    return this.storage.remove(0); // O(1) to remove head
  }

  /// O(1) constant runtime.
  @Override
  public void push(E element) {
    this.storage.insert(0, element); // O(1) to insert head
  }
  
}
