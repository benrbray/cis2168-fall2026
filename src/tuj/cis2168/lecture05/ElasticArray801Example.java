package tuj.cis2168.lecture05;

public class ElasticArray801Example {
  public static void main() {
    ElasticArray801<String> example = new ElasticArray801<>();
    example.add("apple");
    example.add("banana");
    example.add("cherry");
    example.add("durian");

    System.out.println("Length Before: " + example.size());
    printList(example);

    example.remove(1);
    System.out.println("Length After: " + example.size());
    printList(example);
  }

  public static <T> void printList(Cis2168List<T> list) {
    for(int i = 0; i < list.size(); i ++) {
      System.out.println(list.get(i));
    }
  }
}
