package tuj.cis2168.lab04.optional;

import java.util.List;

public class Example {
  public static <T extends Comparable<T>> int indexOfMin(List<T> list) {
    if(list.size() == 0) { return -1; };

    int minIdx = 0;
    T minT = null;
    
    int idx = 0;
    for(T t : list) {
      if(minT == null || t.compareTo(minT) < 0) {
        minT = t;
        minIdx = idx;
      }
      idx += 1;
    }

    return minIdx;
  }
}
