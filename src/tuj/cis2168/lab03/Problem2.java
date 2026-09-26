package tuj.cis2168.lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

////////////////////////////////////////////////////////////

public class Problem2 {
  public static void main() {
    mapExample();
  }

  public static void pairExample() {
    List<String> foods = new ArrayList<>(List.of("Milk", "Bread", "Bananas"));
    List<Integer> prices = new ArrayList<>(List.of(120, 400, 370, 290, 500, 730));
    Iterator<Pair<String, Integer>> pairs = new PairIterator<>(foods.iterator(), prices.iterator());

    printIterator(pairs);

    // Expected Output:
    // Pair[left=Milk, right=120]
    // Pair[left=Bread, right=400]
    // Pair[left=Bananas, right=370]
  }

  public static void doubleExample() {
    List<String> foods = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));
    Iterator<String> doubled = new DoubleIterator<>(foods.iterator());
    printIterator(doubled);

    // Expected Output:
    // Apple
    // Apple
    // Banana
    // Banana
    // Cherry
    // Cherry
  }

  public static void filterExample() {
    List<Integer> numbers = new ArrayList<>(List.of(5, 3, 4, 2, 1, 9, 7, 8));
    Iterator<Integer> evenNumbers = new FilterIterator<>(numbers.iterator(), n -> n % 2 == 0);
    printIterator(evenNumbers);

    // Expected Output: 4, 2, 8
  }

  public static void mapExample() {
    List<String> animals = new ArrayList<>(List.of("Dog", "Orangutan", "Elephant", "Lion", "Pigeon"));
    Iterator<Integer> wordLengths = new MapIterator<>(animals.iterator(), s -> s.length());
    printIterator(wordLengths);

    // Expected Output: 3, 9, 8, 4, 6
  }

  public static <E> void printIterator(Iterator<E> it) {
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

////////////////////////////////////////////////////////////

class Pair<L, R> {
  private L left;
  private R right;

  Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  public L getLeft()  { return this.left;  }
  public R getRight() { return this.right; }

  @Override
  public String toString() {
    return "Pair[left=" + this.left +", right=" + this.right + "]";
  }
}

class PairIterator<A,B> implements Iterator<Pair<A,B>> {
  PairIterator(Iterator<A> iterA, Iterator<B> iterB) {
    // TODO: Implement me!
  }

  @Override
  public boolean hasNext() {
    // TODO: Implement me!
    throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
  }

  @Override
  public Pair<A, B> next() {
    // TODO: Implement me!
    throw new UnsupportedOperationException("Unimplemented method 'next'");
  }
}

////////////////////////////////////////////////////////////

class DoubleIterator<E> implements Iterator<E> {

  DoubleIterator(Iterator<E> it) {
    // TODO: Implement me!
  }

  @Override
  public boolean hasNext() {
    // TODO: Implement me!
    throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
  }

  @Override
  public E next() {
    // TODO: Implement me!
    throw new UnsupportedOperationException("Unimplemented method 'next'");
  }
}

////////////////////////////////////////////////////////////

@FunctionalInterface 
interface Predicate<T> {
  boolean test(T t);
}

class FilterIterator<E> implements Iterator<E> {
  FilterIterator(Iterator<E> it, Predicate<E> pred) {
    // TODO: Implement me!
  }
}

////////////////////////////////////////////////////////////

@FunctionalInterface
interface Function<A,B> {
  B apply(A input);
}

class MapIterator<A,B> implements Iterator<B> {
  // TODO: Implement me!
}