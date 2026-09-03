package tuj.cis2168.experiments;

// import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.InputStreamReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
  // private static String readFileFromPathComplex(String path) throws IOException {
  //   StringBuilder result = new StringBuilder();

  //   try (
  //     // try-with-resources syntax will only close resources
  //     // declared explicitly -- do not use nested constructors
  //     var fis = new FileInputStream(path);
  //     var isr = new InputStreamReader(fis, "UTF-8");
  //     var br = new BufferedReader(isr)
  //   ) {
  //       String line;
  //       while ((line = br.readLine()) != null) {
  //           result.append(line).append("\n");
  //       }
  //   }
  //   return result.toString();
  // }
  
  public static void main() {
    try {
      String content = Files.readString(Path.of("./resources/example.txt"));
      System.out.println(content);
    } catch(IOException e) {
      System.out.println("File not found!");
    }
  }
}
