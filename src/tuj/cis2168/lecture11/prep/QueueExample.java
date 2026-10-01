package tuj.cis2168.lecture11.prep;

import tuj.cis2168.lecture11.Queue;

public class QueueExample {
  public static void main() {
    Queue<String> fruits = new CircularArrayQueue<>();
    fruits.enqueue("apple");
    System.out.println(fruits.dequeue());
    fruits.enqueue("banana");
    fruits.enqueue("cherry");
    fruits.enqueue("durian");
    fruits.enqueue("eggplant");
    fruits.enqueue("fig");
    System.out.println(fruits.dequeue());
    fruits.enqueue("gourd");

    while(!fruits.isEmpty()){
      System.out.println(fruits.dequeue());
    }
  }
}
