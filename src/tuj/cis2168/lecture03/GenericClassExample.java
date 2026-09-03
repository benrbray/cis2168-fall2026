package tuj.cis2168.lecture03;

public class GenericClassExample {
  public static void main() {
    examplePair();
    exampleMaximumRecorder();
  }

  public static void examplePair() {
    var pair = new Pair<String, Integer>("banana", 6);
    System.out.println(pair);
  }

  public static void exampleMaximumRecorder() {
    MaximumRecorder<Integer> recorder = new MaximumRecorder<Integer>();

    recorder.observe(-3);
    recorder.observe(7);
    recorder.observe(10);
    recorder.observe(2);
    recorder.observe(4);

    System.out.println("Largest Observation: " + recorder.getLargest());
  }
}

////////////////////////////////////////////////////////////

class Pair<L, R> {
  private L left;
  private R right;

  Pair(L left, R right) {
    this.left = left;
    this.right= right;
  }

  public L getLeft() {
    return this.left;
  }

  public R getRight() {
    return this.right;
  }

  public String toString() {
    return "Pair(Left=" + this.left + ", " + "Right=" + this.right + ")";
  }
}

////////////////////////////////////////////////////////////

// this interface is built in to Java,
// interface Comparable<T> {
//   /// Compares `this` to `other`.
//   /// If `this` is smaller, returns negative integer.
//   /// If `other` is smaller, returns positive integer.
//   /// If they are equal, returns `0`.
//   int compareTo(T other);
// }

// class that records the largest thing that it has seen
// 
class MaximumRecorder<U extends Comparable<U>> {

  // initially null
  private U maximum = null;

  public void observe(U observation) {
    // if the maximum is null, we haven't seen anything yet
    if(this.maximum == null) {
      this.maximum = observation;
      return;
    }

    // perform the comparison
    if(observation.compareTo(this.maximum) > 0) {
      this.maximum = observation;
    }
  }

  public U getLargest() {
    return this.maximum;
  }
}
