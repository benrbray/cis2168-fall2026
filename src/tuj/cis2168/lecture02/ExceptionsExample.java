package tuj.cis2168.lecture02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionsExample {
  public static void main() {
    // example1();
    example2();
  }

  // void exampleError() {
  //   // ERROR: Unhandled exception type IOException
  //   String content = Files.readString(Path.of("../../resources/example.txt"));
  //   System.out.println(content);
  // }

  static void example1() throws IOException {
    String content = Files.readString(Path.of("./resources/example.txt"));
    System.out.println(content);
  }

  static void example2() {
    try {
      String content = Files.readString(Path.of("/home/ben/temple/courses/2026fall/cis2168/code/shapes/resources/example.txt"));
      System.out.println(content);
    } catch(IOException e) {
      System.out.println("File not found!");
    }
  }
}
