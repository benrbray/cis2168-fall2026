package tuj.cis2168.lab02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Problem3 {
  public static void main(){ 
    // generate timestamp to use in file name
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String timestamp = LocalDateTime.now().format(formatter);
    String fileName = "data/growth_strategy_" + timestamp + ".csv";
    
    // run experiments and generate csv
    Path filePath = Path.of(fileName);
    generateRuntimeCsv(filePath);
    System.out.println("Saved results to file: " + filePath.toAbsolutePath());
  }

  public static long experiment(
    int numElements,
    ElasticArray.GrowthStrategy gs
  ) {
    // record the starting time, in nanoseconds
    long startNano = System.nanoTime();

    // TODO: Implement the steps below!
    //     1. create an empty ElasticArray<Integer>
    //     2. use a loop to append N=numElements random integers to the list

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
    csvLines.add("numElements,doublingRuntime,additiveRuntime");

    // range of values for numElements
    final int SIZE_MIN = 5000;
    final int SIZE_MAX = 150000;
    final int SIZE_STEP = 5000;
    
    // outer loop determines the size of each list
    for(int numElements = SIZE_MIN; numElements < SIZE_MAX; numElements += SIZE_STEP) {
    System.out.println("Running Experiment (" + numElements + " / " + SIZE_MAX + ")");

      // measure runtime with the doubling strategy
      long doublingRuntime = experiment(numElements, n -> n * 2);

      // measure runtime with the additive+1000 strategy
      long additiveRuntime = experiment(numElements, n -> n + 1000);

      // write new line to CSV
      csvLines.add(numElements + "," + doublingRuntime + "," + additiveRuntime);
    }

    // save the file
    try {
      Files.write(path, (Iterable<String>) csvLines::iterator);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
