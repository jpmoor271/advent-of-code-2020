package org.mooredom;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) throws Exception {
    List<Integer> sortedSeatIds =
        Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
            .map(Seat::from)
            .mapToInt(Seat::getSeatId)
            .sorted()
            .boxed()
            .collect(Collectors.toList());

    int mySeatId = 0;
    int last = sortedSeatIds.get(0);
    for (int i = 1; i < sortedSeatIds.size(); i++) {
      int current = sortedSeatIds.get(i);
      if (current - last > 1) {
        mySeatId = current - 1;
        break;
      } else {
        last = current;
      }
    }

    System.out.println("mySeatId = " + mySeatId);
  }
}
