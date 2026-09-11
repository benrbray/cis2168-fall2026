package tuj.cis2168.lecture06;

import java.util.Objects;

public class SinglyLinkedList802<T> implements Cis2168List<T> {

  /// In Java, it's considered good style to write only one
  /// class per file.  So, if a data structure needs a
  /// private helper class such as Node<T>, it's customary
  /// to make it an "nested class" using `private static`.
  /// 
  /// In other languages, namespaces are based on filenames,
  /// rather than classes, avoiding the need for this way
  /// of organizing your classes.

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
  private Node<T> head;
  
  /// The number of elements in the list.
  /// Equal to the number of `Node<T>`s in the list,
  /// not including the tail node.
  private int count;

  //////////////////////////////////////////////////////////
  
  public SinglyLinkedList802() {
    this.head = new Node<>(null, null);
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  /// Creates a new node for `element`, and inserts it after
  /// the specified `node` in the linked list.
  /// Requires that `element != null`.
  private void addAfter(Node<T> node, T element) {
    // 0. ensure the new element is not null
    Objects.requireNonNull(element);
    // 1. insert a new node in between node and node.next
    // 2. increase the size of the list
  }

  /// Creates a new node for `element`, and uses
  /// it as the new `head` of this linked list.
  /// Requires that `element != null`.
  private void addFirst(T element) {
    // 0. ensure the new element is not null
    Objects.requireNonNull(element);
    // 1. replace the current head with a
    //    new node, linked to the old head
    // 2. increase the size of this list
  }

  private Node<T> nodeAtIndex(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);
    // 1. starting from the head, follow links
    //    until reaching the desired `index`
  }

  //////////////////////////////////////////////////////////

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public void add(T element) {
    // re-use the insert() method
  }

  @Override
  public void insert(int index, T element) {
    // 0. ensure the element is not null
    Objects.requireNonNull(element);
    // 1. ensure 0 <= index <= this.count
    Objects.checkIndex(index, this.count+1);
    
    if(index == 0) {
      // 2. special case:  replacing the head
    } else {
      // 3. general case:  index > 0
    }
  }

  @Override
  public void set(int index, T element) {
    // 1. make sure the new element is not null
    Objects.requireNonNull(element);
    // 2. find the node at the specified index
    // 3. replace the node's data with the new element
  }

  @Override
  public T get(int index) {
    // 1. find the node at the specified index
    // 2. return its data
  }

  @Override
  public int indexOf(T element) {
    // 0. ensure the element is not null
    Objects.requireNonNull(element);

    // 1. starting from the head, follow links until
    //    we find element or reach the end of the list

    // 2. if we finish the loop without finding a match,
    //    it means the list doesn't contain our query
  }

  @Override
  public boolean contains(T element) {

  }

  @Override
  public T remove(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);
    
    if(index == 0) {
      // 1. special case:  remove the head
      // 1a. keep a reference to the removed element
      // 1b. rearrange the links to skip over removed
      // 1c. decrease the size of the list
      // 1d. return the removed element
    } else {
      // 2a. general case:  find the preceding element
      // 2b. keep a reference to the removed element
      // 2c. rearrange the links to skip over removed
      // 2c. decrease the size of the list
      // 2d. return the removed element
    }
  }

  @Override
  public void delete(T element) {
  }
  
}