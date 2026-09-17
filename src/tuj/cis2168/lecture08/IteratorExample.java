package tuj.cis2168.lecture08;

public class IteratorExample {
  
}

interface Iterator<E> {
  boolean hasNext();
  E next();
}

interface Iterable<E> {
  Iterator<E> iterator();
}