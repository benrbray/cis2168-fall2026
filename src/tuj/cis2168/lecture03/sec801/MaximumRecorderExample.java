package tuj.cis2168.lecture03.sec801;

public class MaximumRecorderExample {
  public static void main() {
    example2();
  }

  public static void example1() {
    // MaximumRecorderInt observer = new MaximumRecorderInt();

    // observer.observe(-3);
    // observer.observe(4);
    // observer.observe(10);
    // observer.observe(5);

    // System.out.println("The largest number seen so far is: " + observer.getMaximum());
  }

  public static void example2() {
    GroceryItem[] list = new GroceryItem[3];
    list[0] = new GroceryItem("banana", 250);
    list[1] = new GroceryItem("apple", 200);
    list[2] = new GroceryItem("chocolate", 1000);

    MaximumRecorder<GroceryItem> recorder = new MaximumRecorder<GroceryItem>();
    
    // value loop
    for(var grocery : list) {
      recorder.observe(grocery);
    }

    System.out.println("The most expensive grocery item is: " + recorder.getMaximum());
  }
}

interface Comparable<U> {
  // return - if this < other
  // return + if this > other
  // return 0  if this is equal to other
  int compareTo(U other);
}

class GroceryItem implements Comparable<GroceryItem> {
  public String name;
  public int price;

  GroceryItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public int compareTo(GroceryItem other) {
    return this.price - other.price;
  }
  
  @Override
  public String toString() {
    return "GroceryItem[name=" + this.name + ", price=" + this.price + "]";
  }
}

class MaximumRecorder<U extends Comparable<U>> {

  private U maximum = null;

  public void observe(U observation) {
    // if we haven't seen anything yet...
    if(this.maximum == null) {
      this.maximum = observation;
      return;
    }

    // compare new observation to current maximum
    if(observation.compareTo(this.maximum) > 0) {
      this.maximum = observation;
    }
  }

  public U getMaximum() {
    return this.maximum;
  }
}
