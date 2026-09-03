package tuj.cis2168.lecture02;

public class ComputerExample1_Subclass {
  public static void main() {
    Computer myComputer = new Computer("Acme", "Intel", 2, 160, 2.4);
    Notebook yourComputer = new Notebook("DellGate", "AMD", 4, 240, 1.8, 15.0, 7.5);

    System.out.println("My computer is:\n" + myComputer.toString());
    System.out.println("\n");
    System.out.println("Your computer is:\n" + yourComputer.toString());
  }

  static void exampleParentChild() {
    Child child = new Child();
    System.out.println("Child's number is:" + child.getNumber());
  }
}

////////////////////////////////////////////////////////////

class Computer {

  protected String manufacturer;
  private String processor;
  private int ramSize;
  private int diskSize;
  private double processorSpeed;

  public Computer(
    String manufacturer, String processor,
    int ram, int disk, double procSpeed
  ) {
    this.manufacturer = manufacturer;
    this.processor = processor;
    this.ramSize = ram;
    this.diskSize = disk;
    this.processorSpeed = procSpeed;
  }

  public double computePower() { return ramSize * processorSpeed; }
  public int getRamSize() { return ramSize; }
  public double getProcessorSpeed() { return processorSpeed; }
  public int getDiskSize() { return diskSize; }
  
  public String toString() {
    String result = "Manufacturer: " + manufacturer +
    "\nCPU: " + processor +
    "\nRAM: " + ramSize + " gigabytes" +
    "\nDisk: " + diskSize + " gigabytes" +
    "\nProcessor speed: " + processorSpeed + " gigahertz";
    return result;
  }
}

class Notebook extends Computer {
  
  // every Notebook has two extra fields,
  // in addition to those inherited from Computer
  private double screenSize;
  private double weight;

  public Notebook(
    String manufacturer, String processor,
    int ram, int disk, double procSpeed,
    double screenSize, double weight
  ) {
    // call the superclass constructor
    super(manufacturer, processor, ram, disk, procSpeed);

    // initialize the remaining, new fields
    this.screenSize = screenSize;
    this.weight = weight;

    // Because the Computer fields are all private,
    // the subclass has no access to them!
    // (UNCOMMENT TO SEE THE ERROR!)
    this.manufacturer = "Lenovo";
    
    // To make a field visible to subclasses,
    // use the "protected" visibility instead.
    
  }
}

//////////////////////////////////

class Parent {
  private int number;

  Parent() {
    this.number = 5;
  }

  public int getNumber() {
    return this.number;
  }
}

class Child extends Parent {
  // If I don't call the constructor myself,
  // Java will call the zero-argument constructor.
  // Child() {
  //   super();
  // }
}