package tuj.cis2168.lab04.optional;

import java.util.Objects;

// PRACTICE PROBLEM
// Modify our SingleLinkedList implementation and all its
// methods to keep track of the tail node in addition to a
// head. Then, use your modified linked list to implement a
// queue that has O(1) constant runtime for both push() and pop().

// SOLUTION
// To keep the solution simple, I created a new SLLQueue class
// that implements the Queue interface using a linked list internally.


public class SLLQueue<T> implements Queue<T> {

  public static void main() {
    Queue<Integer> q = new SLLQueue<>();
    q.enqueue(1);
    q.enqueue(2);
    System.out.println(q.dequeue());
    q.enqueue(3);
    System.out.println(q.dequeue());
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    q.enqueue(7);
    System.out.println(q.dequeue());
  }

  //////////////////////////////////////////////////////////

  private static class Node<T> {
    /// The data stored in this node, or
    /// `null` if this is the tail node.
    T data;

    /// A reference to the next node in the list,
    /// or `null` if this is the tail node.
    Node<T> next;

    Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  //////////////////////////////////////////////////////////

  /// The first node in the linked list.
  /// Represents the "front" of the queue.
  private Node<T> head;

  /// The last node in the linked list.
  /// Represents the "back" of the queue.
  private Node<T> tail;
  
  /// The number of elements in the list.
  /// Equal to the number of `Node<T>`s in the list,
  /// not including the tail node.
  private int count;

  //////////////////////////////////////////////////////////
  
  SLLQueue() {
    this.head = null;
    this.tail = null;
  }
  
  //////////////////////////////////////////////////////////

  @Override
  public void enqueue(T elem) {
    // 0. Ensure the element is not null.
    Objects.requireNonNull(elem);
    // 1. Create a new node for this element.
    Node<T> node = new Node<>(elem, null);
    // 2. Insert into the back of the queue / tail of the list.
    if(this.tail == null) {
      // if the queue was empty, the new node
      // becomes both the head and tail
      this.head = node;
      this.tail = node;
    } else {
      // point the old tail to the new node
      this.tail.next = node;
      // make the new node the tail
      this.tail = node;
    }
    // 3. Increase the size of the list by one.
    this.count += 1;
  }

  @Override
  public T dequeue() {
    // 1. Remove the element at the head of the list (front of the queue).
    T removed = this.head.data;
    this.head = this.head.next;

    // If there was only one element in the queue,
    // now head and tail are both null.
    if(this.head == null) {
      this.tail = null;
    }

    // 3. Decrease the size of the list by one.
    this.count -= 1;
    return removed;
  }

  @Override
  public T peek() {
    return this.head.data;
  }

  @Override
  public boolean isEmpty() {
    return this.count == 0;
  }
}
