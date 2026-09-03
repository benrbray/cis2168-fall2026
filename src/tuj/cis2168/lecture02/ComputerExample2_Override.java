package tuj.cis2168.lecture02;

public class ComputerExample2_Override {
  public static void main() {
    Computer myComputer = new Computer("Acme", "Intel", 2, 160, 2.4, 2000);
    Computer yourComputer = new Notebook("DellGate", "AMD", 4, 240, 1.8, 15.0, 7.5, 1400);

    System.out.println(myComputer.getClass());
    System.out.println(yourComputer.getClass());

    // System.out.println("My computer is:\n" + myComputer.toString());
    // System.out.println("Your computer is:\n" + yourComputer.toString());
  }

  public static double salePrice(Computer computer) {
    if(computer instanceof Notebook) {
      Notebook notebook = (Notebook) computer;
      notebook.specialNotebookMethod();
      return 100.00;
    } else {
      return 200.00;
    }
  }

  public static double salePriceWithoutInstanceOf(Computer computer) {
    return computer.getPrice();
  }
}

////////////////////////////////////////////////////////////

class Computer {

  private String manufacturer;
  private String processor;
  private int ramSize;
  private int diskSize;
  private double processorSpeed;
  protected double price;
  
  public Computer(
    String manufacturer, String processor,
    int ram, int disk, double procSpeed,
    double price
  ) {
    this.manufacturer = manufacturer;
    this.processor = processor;
    this.ramSize = ram;
    this.diskSize = disk;
    this.processorSpeed = procSpeed;
    this.price = price;
  }

  public double computePower() { return ramSize * processorSpeed; }
  public int getRamSize() { return ramSize; }
  public double getProcessorSpeed() { return processorSpeed; }
  public int getDiskSize() { return diskSize; }

  public double getPrice() {
    return this.price * 0.5;
  }
  
  // @Override
  // public String toString() {
  //   String result = "Manufacturer: " + manufacturer +
  //   "\nCPU: " + processor +
  //   "\nRAM: " + ramSize + " gigabytes" +
  //   "\nDisk: " + diskSize + " gigabytes" +
  //   "\nProcessor speed: " + processorSpeed + " gigahertz";
  //   return result;
  // }

  public int compareComputer(Computer otherComputer) {
    double thisPower = this.computePower();
    double otherPower = otherComputer.computePower();

    // return 0 if the computers are the same
    if(thisPower == otherPower) {
      return 0;
    } else if(thisPower > otherPower) {
      // return +1 if this computer is better
      return 1;
    } else {
      // return -1 if this computer is worse
      return -1;
    }
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
    double screenSize, double weight,
    double price
  ) {
    // call the superclass constructor
    super(manufacturer, processor, ram, disk, procSpeed, price);

    // initialize the remaining, new fields
    this.screenSize = screenSize;
    this.weight = weight;

    // Because the Computer fields are all private,
    // the subclass has no access to them!
    // (UNCOMMENT TO SEE THE ERROR!)
    // this.manufacturer = "Lenovo";
    
    // To make a field visible to subclasses,
    // use the "protected" visibility instead.
    
  }

  public void specialNotebookMethod() {

  }

  @Override
  public double getPrice() {
    // return this.price * 0.8;
    return super.getPrice() * 0.8;
  }

  @Override
  public String toString() {
    String result =
      super.toString() +
      "\nScreen size: " + this.screenSize + " inches" +
      "\nWeight: " + this.weight + " pounds";
    return result;
  }

  @Override
  public double computePower() { return 5; }
}