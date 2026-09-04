package tuj.cis2168.lecture03.sec802;

public class GenericClassExample {
  public static void main() {
    // example1();
    example2();
  }

  public static void example1() {
    PairStringInt pair1 = new PairStringInt("banana", 100);
    Pair<Float, String> pair2 = new Pair<Float, String>(10.5f, "apple");
    var pair3 =
      new Pair<String, Pair<Integer, Integer>>(
        "player",
        new Pair<Integer, Integer>(10, 20)
      );
    Pair<String, Pair<Integer, Integer>> pair4 =
      new Pair<>(
        "player",
        new Pair<Integer, Integer>(10, 20)
      );
  }

  public static void example2() {
    String message = "hello!";
    Integer number = 5;
    Missile missile = new Missile();

    printTwice(message);
    printTwice(number);
    printTwice(missile);
  }

  public static <T> void printTwice(T t) {
    System.out.println("one: " + t);
    System.out.println("two: " + t);
  }
}

class Missile {
  public void launch() {
    // launch a real missile in the real world
  }
}

class Pair<L, R> {
  private L left;
  private R right;

  Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  L getLeft(){
    return this.left;
  }

  R getRight() {
    return this.right;
  }
}

// abstract data type for lists
interface List<T> {
  void append(T element);
  void insert(int index, T element);
  T remove(int index);
  int size();
  // more methods to come later...
}

class ArrayList<T> implements List<T> {

  private int size;
  private T[] data;

  ArrayList() {
    // TODO: for next week
  }

  @Override
  public void append(T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'append'");
  }

  @Override
  public void insert(int index, T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int size() {
    
  }

}

class PairStringInt {
  private String left;
  private Integer right;

  PairStringInt(String left, Integer right) {
    this.left = left;
    this.right = right;
  }

  String getLeft(){
    return this.left;
  }

  Integer getRight() {
    return this.right;
  }
}