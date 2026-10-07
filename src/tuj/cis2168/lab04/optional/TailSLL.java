package tuj.cis2168.lab04.optional;

import java.util.Iterator;
import java.util.Objects;

// PRACTICE PROBLEM:
// Modify our SingleLinkedList implementation and all its methods to keep track
// of the tail node in addition to a head. Then, use your modified linked list
// to implement a queue that has O(1) constant runtime for both push() and pop().

public class TailSLL<T> implements Cis2168List<T>, Iterable<T> {

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
  
  private static class NodeIterator<E> implements Iterator<E> {
    private Node<E> next;
    private int nextIndex;
    private TailSLL<E> list;

    NodeIterator(TailSLL<E> list){
      this.next = list.head;
      this.nextIndex = 0;
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return nextIndex < list.size();
    }

    @Override
    public E next() {
      E data = next.data;
      this.next = this.next.next;
      this.nextIndex++;

      return data;
    }

    ////////////////////////////////////////////////////////
    /// NEW ////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    @Override
    public void remove() {
      // 1. To remove 
    }
    ////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////

  }

  @Override
  public Iterator<T> iterator() {
    return new NodeIterator<>(this);
  }

  //////////////////////////////////////////////////////////

  /// The first node in the linked list.
  private Node<T> head;

  /// NEW: The last node in the linked list.
  private Node<T> tail;
  
  /// The number of elements in the list.
  /// Equal to the number of `Node<T>`s in the list,
  /// not including the tail node.
  private int count;

  //////////////////////////////////////////////////////////
  
  public TailSLL() {
    this.head = new Node<>(null, null);
    this.tail = null;
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
