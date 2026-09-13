package tuj.cis2168.lab02;

import java.util.List;

interface Predicate<T> {
  boolean test(T t);
}

public class Problem2 {

  public static void main() {
    List<Integer> numbers = List.of(8, 3, 2, -1, 7, 4, 5);
    Predicate<Integer> isEven = (x -> x % 2 == 0);
    List<Integer> evenNumbers = filter(numbers, isEven);

    System.out.println("Original: " + numbers);
    System.out.println("Even: " + evenNumbers);
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> pred) {
    // TODO: Implement me!
  }
}

