package tuj.cis2168.lecture05;

public class ElasticArrayExample {
  public static void main() {
    Cis2168List<String> example = new ElasticArray<>();

    example.add("apricot");
    example.add("banana");
    example.add("cherry");
    example.add("durian");
    example.add("elderberry");
    example.add("fig");

    System.out.println("Size: " + example.size());

    // remove 
    System.out.println("Removed: " + example.remove(3));
    System.out.println("Size: " + example.size());

    // insert
    example.insert(1, "avocado");
    System.out.println("example.get(0): " + example.get(0));
    System.out.println("example.get(1): " + example.get(1));
    System.out.println("example.get(2): " + example.get(2));
    System.out.println("Size: " + example.size());


  }
}
