package tuj.cis2168.lecture02;

public class FoodExample {
  public static void main() {
    Food f = new Carrot();
    f.percentProtein();
    // f.percentProtein();
  }
}

////////////////////////////////////////////////////////////

abstract class Food {
  public final String name;
  private double calories;

  public double getCalories () {
    return calories;
  }

  protected Food (String name, double calories) {
    this.name = name;
    this.calories = calories;
  }
  
  public abstract double percentProtein();
  public abstract double percentFat();
  public abstract double percentCarbs();
}

class Carrot extends Food {

  public Carrot() {
    super("carrot", 100);

    System.out.println(this.percentCarbs());
  }

  @Override
  public double percentProtein() {
    return 0.2;
  }

  @Override
  public double percentFat() {
    return 0.3;
  }

  @Override
  public double percentCarbs() {
    return 0.5;
  }
  
}