package tuj.cis2168.lecture01;

public class Lecture01 {
  public static void main() {
    MakesNoise noiseMaker1 = new Dog("Snoopy");
    MakesNoise noiseMaker2 = new Car();

    System.out.println(noiseMaker1.noise());
    System.out.println(noiseMaker2.noise());
  }

  /**
   * Print the object's noise twice!
   */
  public static void doubleNoise(MakesNoise noiseMaker) {
    System.out.println(noiseMaker.noise());
    System.out.println(noiseMaker.noise());
  }
}

//////////////////////////////////////////////////

interface MakesNoise {
  String noise();
}

interface HasName {
  String getName();
}

class Dog implements MakesNoise, HasName {

  private String name;

  Dog(String name) {
    this.name = name;
  }

  @Override
  public String noise() {
    return "woof";
  }

  @Override
  public String getName() {
    return this.name;
  }
  
}

class Car implements MakesNoise {

  @Override
  public String noise() {
    return "beep beep";
  }
  
}

class Baby implements MakesNoise {

  @Override
  public String noise() {
    return "waaaaaaa";
  }
  
}

//////////////////////////////////////////////////

// interface MakesNoise {
//   String noise();
// }

// interface HasName {
//   String getName();
// }

// class Dog implements MakesNoise, HasName {

//   private String name;

//   Dog(String name) {
//     this.name = name;
//   }

//   @Override
//   public String noise() {
//     return "woof";
//   }

//   @Override
//   public String getName() {
//     return this.name;
//   }
// }

// class Car implements MakesNoise {
//   @Override
//   public String noise() {
//     return "beep beep";
//   }
// }

// // USER

// class Baby implements MakesNoise {
//   @Override
//   public String noise() {
//     return "waaaaaa";
//   }
// }

// //////////////////////////

// abstract class MakesNoiseAbstract {
//   public abstract String noise();
// }

// class Car extends MakesNoiseAbstract {}