package tuj.cis2168.lecture03;

import java.util.Collection;
import java.util.SequencedCollection;

public class ElasticArrayExample {
  
}

////////////////////////////////////////////////////////////

interface Collection<E> {
  int size();
  int isEmpty();

  void add(E element);
  boolean remove(E element);
  void clear();
}

interface IntList {
  java.util.List x;
  SequencedCollection x;
  Collection x;
}