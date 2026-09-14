package tuj.cis2168.lab01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem3Solution {
  public static void main() {
  // build list of first and last names
    List<Pair<String, String>> names = new ArrayList<>();
    names.add(new Pair<>("Simon", "Peyton Jones"));
    names.add(new Pair<>("Simon", "Marlow"));
    names.add(new Pair<>("Daan", "Leijen"));
    names.add(new Pair<>("Robin", "Milner"));
    names.add(new Pair<>("John", "Backus"));
    names.add(new Pair<>("John", "Hughes"));
    names.add(new Pair<>("John", "Reynolds"));
    names.add(new Pair<>("Philip", "Wadler"));

    // sort!
    PairComparator<String, String> pc = new PairComparator<>();
    names.sort(pc);

    // print!
    for(var name : names) {
      System.out.println(name.getLeft() + " " + name.getRight());
    }
  }
}

class PairComparator<
  L extends Comparable<L>,
  R extends Comparable<R>
> implements Comparator<Pair<L, R>> {

  @Override
  public int compare(Pair<L, R> a, Pair<L, R> b) {
    // first, compare left side
    int leftCompare = a.getLeft().compareTo(b.getLeft());
    if(leftCompare != 0) { return leftCompare; }

    // if left sides are equal, compare right side
    int rightCompare = a.getRight().compareTo(b.getRight());
    return rightCompare;
  }

}

// Definitions of Comparable<T> and Comparator<T> are
// shown below, but this file uses the built-in ones:
//     java.util.Comparator<T>
//     java.lang.Comparable<T>

// interface Comparator<T> {
//   /// if `left > right`, returns a positive number
//   /// if `left < right`, returns a negative number
//   /// otherwise, returns zero
//   int compare(T left, T right);
// }

// interface Comparable<T> {
//   /// if `this > other`, returns a positive number
//   /// if `this < other`, returns a negative number
//   /// otherwise, returns zero
//   int compareTo(T other);
// }

// class PairComparator<
//   L extends Comparable<L>,
//   R extends Comparable<R>
// > implements Comparator<Pair<L,R>> {

//   @Override
//   public int compare(Pair<L, R> a, Pair<L, R> b) {
//     // first, compare left side
//     int leftCompare = a.getLeft().compareTo(b.getLeft());
//     if(leftCompare != 0) { return leftCompare; }

//     // if left sides are equal, compare right side
//     int rightCompare = a.getRight().compareTo(b.getRight());
//     return rightCompare;
//   }
  
// }

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