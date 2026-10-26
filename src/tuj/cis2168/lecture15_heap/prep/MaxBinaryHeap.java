package tuj.cis2168.lecture15_heap.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import tuj.cis2168.lecture15_heap.Cis2168MaxPriorityQueue;

public class MaxBinaryHeap<E extends Comparable<E>> implements Cis2168MaxPriorityQueue<E> {

  //////////////////////////////////////////////////////////

  /// Storage is an elastic array representing a complete
  /// binary tree, with elements in level order, satisfying
  /// the following _HEAP PROPERTY_.  For every index i,
  /// ```
  /// storage[i] >= storage[leftChild(i)]
  /// storage[i] >= storage[rightChild(i)]
  /// ```
  ArrayList<E> storage;

  // create empty binary heap
  MaxBinaryHeap() {
    this.storage = new ArrayList<>();
  }

  // naive solution using .push in a loop would be O(n log n)
  // but heapify is O(n)!
  MaxBinaryHeap(List<E> list) {
    // 1. insert all elements from the list in the order they come
    this.storage = new ArrayList<>(list);
    // 2. use heapifyDown to rearrange these new elements into
    //    a complete binary tree that satisfies the heap invariant
    this.heapifyDown();
  }

  //////////////////////////////////////////////////////////
  
  private int leftIndex(int i) {
    // left(0) = 1
    // left(i) = 2 + left(i-1)
    //         = 2 + 2 + left(i-2)
    //         = (2 + 2 + ... + 2) + left(0)
    //         = 2 * i + 1
    return 2 * i + 1;
  }

  private int rightIndex(int i) {
    // right(i) = left(i) + 1
    //          = 2*i + 2
    return 2 * i + 2;
  }

  private int parentIndex(int i) {
    return (i - 1) / 2;
  }

  private void swap(int i, int j) {
    E temp = this.storage.get(i);
    this.storage.set(i, this.storage.get(j));
    this.storage.set(j, temp);
  }

  //////////////////////////////////////////////////////////////////////////////

  // Called to restore the heap invariant when it may have
  // been violated by the insertion of MANY new elements,
  // for example when building a heap out of an array.
  private void heapifyDown() {
    // 1. `startIdx` is the last node in the complete binary tree with children
    int startIdx = (this.storage.size() / 2) - 1;

    // 2. bubble down all elements in the array, starting from the end
    for(int idx = startIdx; idx >= 0; idx--) {
      this.bubbleDown(idx);
    }
  }
  
  //////////////////////////////////////////////////////////////////////////////

  /// Called to restore the heap invariant when it may
  /// have been violated the insertion of an element.
  /// 
  /// Repeatedly swap the element at idx with its parent,
  /// until the heap invariant is restored.
  /// 
  /// Note:  Only makes changes to other indicies _before_ `idx`.
  private void bubbleUp(int idx) {
    E element = this.storage.get(idx);

    while(idx > 0) {
      E parent = this.storage.get(parentIndex(idx));
      
      // 2a. if the heap invariant is violated, swap `element` with `parent`
      if(element.compareTo(parent) > 0) {
        this.swap(idx, parentIndex(idx));
        idx = parentIndex(idx);
      } else {
        break;
      }
    }
  }

  /// Called to restore the heap invariant when it may have
  /// been violated the insertion or removal of an element.
  /// 
  /// Repeatedly swap the element at idx with its largest
  /// child, until the heap invariant is restored.
  /// 
  /// Note:  Only makes changes to other indicies _after_ `idx`.
  private void bubbleDown(int idx) {
    E element = this.storage.get(idx);

    while(true) {
      boolean hasLeft  = leftIndex(idx)  < this.storage.size();
      boolean hasRight = rightIndex(idx) < this.storage.size();
      
      // index of the largest child of idx
      int maxChildIdx;

      // Case 1a: Both Children
      if(hasRight) {
        E left  = this.storage.get(leftIndex(idx));
        E right = this.storage.get(rightIndex(idx));
        if(left.compareTo(right) > 0) {
          maxChildIdx = leftIndex(idx);
        } else {
          maxChildIdx = rightIndex(idx);
        }
      }
      // Case 1b: Only Left Child
      else if(hasLeft) {
        maxChildIdx = leftIndex(idx);
      }
      // Case 1c: No Children -- Done!
      else {
        break;
      }
      
      // 2. if the heap invariant is violated, swap `element` with `maxChild`
      E maxChild = this.storage.get(maxChildIdx);
      if(element.compareTo(maxChild) < 0) {
        this.swap(idx, maxChildIdx);
        idx = maxChildIdx;
      } else {
        // heap invariant is satisfied, so we're done bubbling!
        break;
      }
    }
  }

  //////////////////////////////////////////////////////////

  // aka push
  @Override
  public void insert(E element) {
    // 1. initially, insert new element at the end of the storage array
    this.storage.add(element);
    // 2. this insertion may violate the heap property, swap new
    //    element with its parent until the invariant is restored
    this.bubbleUp(this.storage.size() - 1);
  }

  // O(log n) (linear in the depth of the tree)
  @Override
  public E popMax() {
    // 0. if the heap had only one element, simply remove and return it
    if(this.storage.size() == 1) {
      return this.storage.removeLast();
    }
    // 1. keep a reference to the max element
    E max = this.storage.get(0);
    // 2. replace the _top_ with the _last_ element in the heap,
    //    so that the heap remains a complete binary tree
    this.storage.set(0, this.storage.removeLast());
    // 3. this swap may violate the heap invariant, so we must
    //    repeatedly swap the top with its child to restore it
    this.bubbleDown(0);
    // 4. return the max element
    return max;
  }

  // O(1)
  @Override
  public E peekMax() {
    return this.storage.get(0);
  }

  @Override
  public int size() {
    return this.storage.size();
  }
  
  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }
}
