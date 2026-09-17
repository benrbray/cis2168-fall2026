package tuj.cis2168.lecture07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import tuj.cis2168.lecture07.Cis2168List;
import tuj.cis2168.lecture07.ElasticArray;
import tuj.cis2168.lecture07.SinglyLinkedList;

public class ListAnalysis {
  public static void main(){ 
    // generate timestamp to use in file name
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String timestamp = LocalDateTime.now().format(formatter);
    String fileName = "growth_strategy_" + timestamp + ".csv";
    
    // run experiments and generate csv
    Path filePath = Path.of(fileName);
    generateRuntimeCsv(filePath);
    System.out.println("Saved results to file: " + filePath.toAbsolutePath());
  }

  public static long experiment(
    int numElements,
    Cis2168List<Integer> list
  ) {
    // record the starting time, in nanoseconds
    long startNano = System.nanoTime();

    // experiment
    for(int i = 0; i < numElements; i++) {
      list.insert(0, ThreadLocalRandom.current().nextInt());
    }

    // measure the elapsed time, in nanoseconds
    long finishNano = System.nanoTime();
    long elapsedTime = finishNano - startNano;
    return elapsedTime;
  }

  /// Produces a CSV (comma-separate value) file with
  /// the following three columns:
  ///   (numElements) the number of list elements
  ///   (doublingRuntime) runtime for the doubling growth strategy
  ///   (additiveRuntime) runtime for the additive+1000 growth strategy
  public static void generateRuntimeCsv(Path path) {
    // strings representing lines of CSV file
    List<String> csvLines = new ArrayList<String>();
    
    // header line
    csvLines.add("numElements,elasticRuntime,linkedRuntime");

    // range of values for numElements
    final int SIZE_MIN = 5000;
    final int SIZE_MAX = 50000;
    final int SIZE_STEP = 1000;
    
    // outer loop determines the size of each list
    for(int numElements = SIZE_MIN; numElements < SIZE_MAX; numElements += SIZE_STEP) {
      System.out.println("Running Experiment (" + numElements + " / " + SIZE_MAX + ")");

      // measure runtime with the doubling strategy
      long elasticRuntime = experiment(numElements, new ElasticArray<Integer>(n -> n * 2));
      long linkedRuntime = experiment(numElements, new SinglyLinkedList<Integer>());

      // write new line to CSV
      csvLines.add(numElements + "," + elasticRuntime + "," + linkedRuntime);
    }

    // save the file
    try {
      Files.write(path, (Iterable<String>) csvLines::iterator);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
