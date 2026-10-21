package tuj.cis2168.lecture14_bst.prep;

import tuj.cis2168.lecture14_bst.Cis2168Set;

public class BSTSetCheck {
  public static void main() {
    check("+");
    check("+M");
    check("+BANANA");
    check("+ABCDEF");
    check("+ZYXWVUTSR");

    check("+A", "?A", "-A", "?A");
    check("+BAC", "-A");
    check("+BAC", "-C");
    check("+BAC", "-B");
    check("+BAC", "-Z"); // remove something that doesn't exist
    check("+DBFACEG", "?C", "-C", "?C");
    check("+DBFACEG", "?D", "-D", "?D");
  }

  public static void check(String... commands) {
    Cis2168Set<Character> set = new BSTSet<>();

    System.out.println("-".repeat(20));

    for(var command : commands) {
      char cmd = command.charAt(0);
      char[] letters = command.substring(1).toCharArray();
      // add
      if(cmd == '+') {
        System.out.println(command);
        for(char c : letters) {
          set.add(c);
        }
        System.out.println(set);
      }
      // remove
      if(cmd == '-') {
        for(char c : letters) {
          System.out.println("remove(" + c + ")\t" + set.remove(c));
        }
        System.out.println(set);
      }
      // contains
      if(cmd == '?') {
        for(char c : letters) {
          System.out.println("contains(" + c + ")?\t" + set.contains(c));
        }
      }
    }
  }
}
