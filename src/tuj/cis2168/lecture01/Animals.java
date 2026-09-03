package tuj.cis2168.lecture01;

public class Animals {
  public static void main() {
    MakesNoise[] noiseMakers = { new Dog(), new Car(), new Dog() };

    for(var noiseMaker : noiseMakers) {
      System.out.println(noiseMaker.noise());
    }
  }
}

////////////////////////////////////////////////////////////

interface MakesNoise {
  String noise();
}

class Dog implements MakesNoise {
  public String noise() {
    return "woof";
  }
}

class Car implements MakesNoise {
  public String noise() {
    return "beep beep";
  }
}