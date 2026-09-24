package tuj.cis2168.lecture09;

import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList802<T> implements Cis2168List<T> {

  //////////////////////////////////////////////////////////
  
  private static class Node<T> {
    T data;

    Node<T> next;
    Node<T> prev;

    private Node(T data) {
      this(data, null, null);
    }

    private Node(T data, Node<T> next, Node<T> prev) {
      // it is forbidden to insert null data!!
      Objects.requireNonNull(data);
      this.data = data;

      this.next = next;
      this.prev = prev;
    }

  }
  
  //////////////////////////////////////////////////////////
  
  private Node<T> head;
  private Node<T> tail;

  /// The number of elements in the list.
  /// Equal to the number of `Node<T>` in the list,
  /// not counting the special head or tail nodes.
  private int count;

  //////////////////////////////////////////////////////////
  
  DoubleLinkedList802() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  //////////////////////////////////////////////////////////
  
  private static class NodeIterator<E> implements Iterator<E> {
    private Node<E> next;

    NodeIterator(DoubleLinkedList801<E> list) {
      this.next = list.head;
    }

    @Override
    public boolean hasNext() {
      // TODO
    }

    @Override
    public E next() {
      // TODO
    }
  }
  
  @Override
  public Iterator<T> iterator() {
    // TODO
  }
  
  //////////////////////////////////////////////////////////
  
  /// SAME AS A SINGLE LINKED LIST
  private Node<T> nodeAtIndex(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);
    // 1. starting from the head, follow links
    // until reaching the desired index
    Node<T> current = this.head;
    int i = 0;
    while(i < index) {
      current = current.next;
      i++;
    }

    return current;
  }

  /// Adds a double-link from before to after.
  /// Both `before` and `after` are allowed to be null.
  /// If `before` is null, `after` becomes the new `head`.
  /// If `after` is null, `before` becomes the new `tail`.
  /// 
  /// (This method is the ONLY method that is allowed to
  ///    modify the prev and next of Nodes!)
  /// 
  private void link(Node<T> before, Node<T> after) {
    if(before != null) {
      // TODO
    } else {
      // after should become the new head
    }

    if(after != null) {
      // TODO
    } else {
      // before should become the new tail
    }
  }

  /// Creates a new node for `element`, and inserts it
  /// after the given `before` node.  
  private void addAfter(Node<T> before, T element) {
    // Requirement: `before` cannot be null.
    Objects.requireNonNull(before);
    // 1. get a reference to the after node (possibly null)
    // 2. create a new node for the "middle"
    Node<T> middle = new Node<T>(element);
    // 3. link before <-> middle <-> after
    // 4. increase the size of this list
  }

  /// Creates a new node for `element`, and inserts it before
  /// the first element of the list, becoming the new head.
  private void addFirst(T element) {
    // 1. create a new node for the new element
    Node<T> node = new Node<>(element);
    // 2. link the new node to the old head
    //    (this.link updates tail if this.head == null)
    // 3. make this node the new head
    // 4. increase the size of this list
  }

  //////////////////////////////////////////////////////////

  // BELOW IS THE SINGLE LINKED LIST VERSION
  // @Override
  // public void add(T element) {
  //   // re-use the insert() method
  //   this.insert(this.count, element);
  // }

  @Override
  public void add(T element) {
    // We could re-use insert(), but inserting at the end
    // would be O(n), since insert() starts counting from
    // the head.  We can do better since we have a tail!

    // 1. create a new node for the new element
    // 2. link the new node to the old tail
    // 3. make this node the new tail
    // 4. increase the size of the list
  }

  @Override
  public T remove(int index) {
    // 0. ensure the index is valid
    Objects.checkIndex(index, this.count);
    // 1. find references to before, removed, after
    
    // 2. link before <-> after

    // 3. nullify removed node's references -- this is
    //    not strictly necessary -- but has some advantages:
    //    *  maintains invariant that x.next.prev = x
    //    *  invalidates iterators with references to the removed node

    // 4. decrease the size of the list
    // 5. return the removed data
  }

  //////////////////////////////////////////////////////////
  
  @Override
  public int size() {
    return this.count;
  }

  /// SAME AS SINGLE LINKED LIST
  @Override
  public void insert(int index, T element) {
    // 0. ensure 0 <= index <= this.count
    Objects.checkIndex(index, this.count+1);
    
    if(index == 0) {
      this.addFirst(element);
    } else {
      Node<T> node = this.nodeAtIndex(index - 1);
      this.addAfter(node, element);
    }
  }

  /// SAME AS SINGLE LINKED LIST
  @Override
  public void set(int index, T element) {
    // 1. make sure the new element is not null
    Objects.requireNonNull(element);
    // 2. find the node at the specified index
    Node<T> node = this.nodeAtIndex(index);
    // 3. replace the node's data with the new element
    node.data = element;
  }

  /// SAME AS SINGLE LINKED LIST
  @Override
  public T get(int index) {
    // 1. find the node at the specified index
    Node<T> node = this.nodeAtIndex(index);
    // 2. return its data
    return node.data;
  }

  /// SAME AS SINGLE LINKED LIST
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

  /// SAME AS SINGLE LINKED LIST
  @Override
  public boolean contains(T element) {
    return (this.indexOf(element) >= 0);
  }

  /// SAME AS SINGLE LINKED LIST
  @Override
  public void delete(T element) {
    // re-use the indexOf method
    int idx = this.indexOf(element);
    if(idx >= 0) {
      this.remove(idx);
    }
  }
  
}
