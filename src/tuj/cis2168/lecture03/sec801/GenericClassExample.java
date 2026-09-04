package tuj.cis2168.lecture03.sec801;

public class GenericClassExample {
  public static void main() {
    Pair<String, Float> pair1 = new Pair<String, Float>("Ben", 28.73848f);
    Pair<Integer, String> pair2 = new Pair<Integer, String>(4, "apple");
    System.out.println(pair1);
    System.out.println(pair2);
  }
}

class Pair<L, R> {
  private L left;
  private R right;

  Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  L getLeft() {
    return this.left;
  }

  R getRight() {
    return this.right;
  }

  public String toString() {
    return "Pair(left=" + this.left + ", right=" + this.right + ")";
  }
}

class PairStringInt {
  private String str;
  private Integer num;

  PairStringInt(String s, Integer i) {
    this.str = s;
    this.num = i;
  }

  String getString() {
    return this.str;
  }

  Integer getInt() {
    return this.num;
  }
}
