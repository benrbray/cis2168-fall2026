package tuj.cis2168.lecture11.sec801;

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
    System.out.println(fruits);
    System.out.println(fruits.dequeue());
    System.out.println(fruits);
    System.out.println(fruits.dequeue());
    System.out.println(fruits);

    while(!fruits.isEmpty()){
      System.out.println(fruits.dequeue());
    }
  }
}
