package tuj.cis2168.lecture03.sec802;

public class MaximumRecorderExample {
  public static void main(){
    // example1();
    example2();
  }

  public static void example1() {
    MaximumRecorderInt recorder = new MaximumRecorderInt();

    recorder.observe(-3);
    recorder.observe(10);
    recorder.observe(2);
    recorder.observe(1);

    System.out.println("Largest number:" + recorder.getMaximum());
  }

  public static void example2() {
    GroceryItem[] groceryList = new GroceryItem[3];
    groceryList[0] = new GroceryItem("banana", 200);
    groceryList[1] = new GroceryItem("chocolate", 1000);
    groceryList[2] = new GroceryItem("apple", 100);

    MaximumRecorder<GroceryItem> recorder = new MaximumRecorder<>();

    // 1. show all the groceries to the recorder
    // value loop
    // for each loop
    for(var groceryItem : groceryList) {
      recorder.observe(groceryItem);
    }
    
    // 2. print the most expensive grocery item
    System.out.println("Most expensive grocery: " + recorder.getMaximum());

  }
}

class GroceryItem implements Comparable<GroceryItem> {
  public String name;
  public Integer price;

  GroceryItem(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public int compareTo(GroceryItem other) {
    // this
    // other
    // based on price
    if(this.price > other.price) {
      return +1;
    } else if(this.price < other.price) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return "GroceryItem[name=" + this.name + ", price=" + this.price + "]";
  }
}

interface Comparable<U> {
  // return - if this < other
  // return + if this > other
  // return 0 if this equals other
  int compareTo(U other);
}

class MaximumRecorder<U extends Comparable<U>> {

  private U maximum = null;

  public void observe(U observation) {
    // if we haven't seen anything yet, just use this one
    if (this.maximum == null) {
      this.maximum = observation;
      return;
    }

    // otherwise, compare this observation to the current max
    if (observation.compareTo(this.maximum) > 0) {
      this.maximum = observation;
    }
  }

  public U getMaximum() {
    return this.maximum;
  }
}


class MaximumRecorderInt {

  private Integer maximum = null;

  public void observe(Integer observation) {
    // if we haven't seen anything yet, just use this one
    if (this.maximum == null) {
      this.maximum = observation;
      return;
    }

    // otherwise, compare this observation to the current max
    if (observation > this.maximum) {
      this.maximum = observation;
    }
  }

  public Integer getMaximum() {
    return this.maximum;
  }
}
