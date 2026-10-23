package tuj.cis2168.lecture15_heap;

public interface Cis2168MaxPriorityQueue<E extends Comparable<E>> {
  void insert(E element);

  E popMax();

  E peekMax();

  int size();

  boolean isEmpty();
}
