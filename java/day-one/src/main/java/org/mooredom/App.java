package org.mooredom;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static final int TARGET_SUM = 2020;

    public static void main(String[] args) throws Exception {
        List<Integer> sortedList = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
                .mapToInt(Integer::valueOf)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i) + sortedList.get(j) == TARGET_SUM) {
                    int product = sortedList.get(i) * sortedList.get(j);
                    System.out.println(String.format("%d * %d = %d", sortedList.get(i), sortedList.get(j), product));
                    break;
                }
            }
        }

        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                for (int k = j + 1; k < sortedList.size(); k++) {
                    if (sortedList.get(i) + sortedList.get(j) + sortedList.get(k) == TARGET_SUM) {
                        long product = sortedList.get(i) * sortedList.get(j) * sortedList.get(k);
                        System.out.println(String.format("%d * %d * %d = %d", sortedList.get(i), sortedList.get(j), sortedList.get(k), product));
                        break;
                    }
                }
            }
        }
    }
}
