package tuj.cis2168.lecture08;

import java.util.Iterator;
import java.util.Objects;

// interface Iterator<E> {
//   boolean hasNext();
//   E next();
// }

// interface Iterable<E> {
//   Iterator<E> iterator();
// }

public class SinglyLinkedList801<T> implements Cis2168List<T>, Iterable<T> {

  //////////////////////////////////////////////////////////
  
  private static class NodeIterator<T> implements Iterator<T> {

    private Node<T> nextNode;
    private int nextIndex;
    private SinglyLinkedList801<T> list;

    NodeIterator(SinglyLinkedList801<T> list) {
      this.list = list;
      this.nextIndex = 0;
      this.nextNode = this.list.head;
    }

    @Override
    public boolean hasNext() {
      return this.nextIndex < list.size();
    }

    @Override
    public T next() {
      // keep a reference to the data in the current node
      T data = this.nextNode.data;
      // update nextIndex, nextNode to point to the node after this one
      this.nextIndex++;
      this.nextNode = this.nextNode.next;
      
      return data;
    }

  }

  public Iterator<T> iterator() {
    return new NodeIterator<>(this);
  }
  
  //////////////////////////////////////////////////////////

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
  
  public SinglyLinkedList801() {
    this.head = new Node<>(null, null);
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  // O(1) constant
  /// Creates a new node for `element`, and inserts it after
  /// the specified `node` in the linked list.
  /// Requires that `element != null`.
  private void addAfter(Node<T> node, T element) {
    // 0. ensure the new element is not null
    Objects.requireNonNull(element); // O(1)
    // 1. insert a new node in between node and node.next
    node.next = new Node<>(element, node.next); // O(1)
    // 2. increase the size of the list
    this.count++; // O(1)
  }

  // O(1) constant
  /// Creates a new node for `element`, and uses
  /// it as the new `head` of this linked list.
  private void addFirst(T element) {
    // 0. ensure the new element is not null
    Objects.requireNonNull(element);
    // 1. replace the current head with a
    //    new node, linked to the old head
    this.head = new Node<>(element, this.head);
    // 2. increase the size of this list
    this.count++;
  }

  // TOTAL:  O(1) + O(1) + O(n)
  // GROWTH RATE:  O(n)
  private Node<T> nodeAtIndex(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);         // O(1)

    // 1. starting from the head, follow links
    //    until reaching the desired `index`
    Node<T> current = this.head;                   // O(1)
    
    // Loop Invariant:  `current` is the
    // node at index `i` in this list
    int i = 0;
    while(i < index) {                             // O(n)
      current = current.next;
      i++;
    }

    return current;
  }

  //////////////////////////////////////////////////////////

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public void add(T element) {
    // re-use the insert() method
    this.insert(this.count, element);
  }


  // GROWTH: O(n) linear
  @Override
  public void insert(int index, T element) {
    // 0. ensure the element is not null
    Objects.requireNonNull(element);        // O(1)
    // 1. ensure 0 <= index <= this.count
    Objects.checkIndex(index, this.count+1); // O(1)
    
    if(index == 0) {
      // 2. special case:  replacing the head
      this.addFirst(element); // O(1)
    } else {
      // 3. general case:  index > 0
      Node<T> node = this.nodeAtIndex(index - 1);  // O(n)
      this.addAfter(node, element); // O(1)
    }
  }

  // O(n)
  @Override
  public void set(int index, T element) {
    // 1. make sure the new element is not null
    Objects.requireNonNull(element);
    // 2. find the node at the specified index
    Node<T> node = this.nodeAtIndex(index);
    // 3. replace the node's data with the new element
    node.data = element;
  }

  // O(1) + O(n)
  // GROWTH:  O(n)
  @Override
  public T get(int index) {
    // 1. find the node at the specified index
    Node<T> node = this.nodeAtIndex(index);  // O(n)
    // 2. return its data
    return node.data; // O(1)
  }

  @Override
  public int indexOf(T element) {
    // 0. ensure the element is not null
    Objects.requireNonNull(element);
    // 1. starting from the head, follow links until
    //    we find element or reach the end of the list
    int idx = 0;
    Node<T> current = head;
    while(idx < this.count) {
      if(Objects.equals(current.data, element)) {
        return idx;
      }

      current = current.next;
      idx++;
    }

    // 2. if we finish the loop without finding a match,
    //    it means the list doesn't contain our query
    return -1;
  }

  @Override
  public boolean contains(T element) {
    return (this.indexOf(element) >= 0);
  }

  @Override
  public T remove(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);
    
    if(index == 0) {
      // 1. special case:  remove the head
      // 1a. keep a reference to the removed element
      T removed = this.head.data;
      // 1b. rearrange the links to skip over removed
      this.head = this.head.next;
      // 1c. decrease the size of the list
      this.count -= 1;
      // 1d. return the removed element
      return removed;
    } else {
      // 2a. general case:  find the preceding element
      Node<T> nodeBefore = this.nodeAtIndex(index-1);
      // 2b. keep a reference to the removed element
      T removed = nodeBefore.next.data;
      // 2c. rearrange the links to skip over removed
      nodeBefore.next = nodeBefore.next.next;
      // 2c. decrease the size of the list
      this.count -= 1;
      // 2d. return the removed element
      return removed;
    }
  }

  @Override
  public void delete(T element) {
    // re-use the indexOf method
    int idx = this.indexOf(element);
    if(idx >= 0) {
      this.remove(idx);
    }
  }
  
}
