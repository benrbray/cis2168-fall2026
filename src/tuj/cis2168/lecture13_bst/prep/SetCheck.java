package tuj.cis2168.lecture13_bst.prep;

import tuj.cis2168.lecture13_bst.Cis2168Set;

public class SetCheck {
  public static void main() {
    Cis2168Set<Integer> numbers = new SortedArraySet<>();

    numbers.add(8);
    numbers.add(4);
    numbers.add(5);
    numbers.add(3);
    numbers.add(8);
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);

    // Expect:  1 2 3 4 5 8
    System.out.println(numbers);

    for(int k = 0; k < 10; k++) {
      System.out.println(k + " in numbers?\t" + numbers.contains(k));
    }
  }


}
