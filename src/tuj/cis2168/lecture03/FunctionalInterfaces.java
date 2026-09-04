package tuj.cis2168.lecture03;

public class FunctionalInterfaces {
  public static void main() {
    Comparator<Integer> cmp1 = ((x, y) -> x - y);
  }
}

interface Comparator<U> {
  int compare(U left, U right);
}

class MaximumRecorder<U> {

  // initially null
  private U maximum = null;
  private Comparator<U> comparator;

  MaximumRecorder(
    Comparator<U> comparator
  ) {
    this.comparator = comparator;
  }

  public void observe(U observation) {
    // if the maximum is null, we haven't seen anything yet
    if(this.maximum == null) {
      this.maximum = observation;
      return;
    }

    // perform the comparison
    if(this.comparator.compare(this.maximum, observation) > 0) {
      this.maximum = observation;
    }
  }

  public U getLargest() {
    return this.maximum;
  }
}