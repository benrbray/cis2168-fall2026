package tuj.cis2168.lecture08;

import java.util.Iterator;

import tuj.cis2168.lecture08.SinglyLinkedList802;

public class IteratorExample {
  public static void main() {
    listExample();
  }

  public static void elasticArrayExample() {
    ElasticArray<String> fruits = new ElasticArray<>(n -> n * 2);
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Durian");
    fruits.add("Elderberry");

    // traditional O(n)
    for(int i = 0; i < fruits.size(); i++) {  // n times
      System.out.println(fruits.get(i));      // O(1)
    }

    // enhanced for loop with iterator O(n)
    for(var n : fruits) {
      System.out.println(n); // O(1)
    }
  }

  public static void singleLinkedListExample() {
    SinglyLinkedList802<String> names = new SinglyLinkedList802<>();
    names.add("Adam");
    names.add("Ben");
    names.add("Carl");
    names.add("Dave");
    names.add("Earl");

    // list has n element
    // if we used an ordinary index loop
    // GROWTH RATE: O(n^2)
    for(int i = 0; i < names.size(); i++) { // n times
      String n = names.get(i); // O(n)
      System.out.println("next: " + n); // O(1)
    }

    System.out.println("----");

    // using an iterator
    // O(1 + n + 1 + 1)
    // O(n)
    Iterator<String> it = names.iterator(); // O(1)
    while(it.hasNext()) {  // O(n)
      String s = it.next();  // O(1)
      System.out.println(s); // O(1)
    }

    // Java: enhanced for loop
    // for each loop
    // for in loop
    // O(n)
    for(String n : names) {
      System.out.println("next: " + n);
    }
  }

  public static void listExample() {
    Cis2168List<String> fruits = new ElasticArray<>(n -> n * 2);
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Durian");
    fruits.add("Elderberry");

    // Q:  Why doesn't this work?
    for(var n : fruits) {
      System.out.println(n);
    }
  }
}