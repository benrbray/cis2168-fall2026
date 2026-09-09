package tuj.cis2168.lecture05;

public class ElasticArray802Example {
  public static void main() {
    Cis2168List<String> example = new ElasticArray802<>();
    example.add("apricot");
    example.add("banana");
    example.add("cherry");

    System.out.println("Before");
    printList(example);

    example.insert(1, "avocado");

    System.out.println("\n\nAfter");
    printList(example);

    // 0 apricot
    // 1 avocado
    // 2 banana
    // 3 cherry

    example.remove(0);
    System.out.println("\n\nAfter Removal");
    printList(example);

  }

  public static <T> void printList(Cis2168List<T> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("idx=" + i + ":" + list.get(i));
    }
  }
}
