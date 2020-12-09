package org.mooredom;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) throws Exception {
    List<String> lines =
        Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
            .collect(Collectors.toList());

    List<GroupAnswers> groupAnswersList = new ArrayList<>();
    GroupAnswers groupAnswers = new GroupAnswers();
    for (String line : lines) {
      if (line.isBlank()) {
        groupAnswersList.add(groupAnswers);
        groupAnswers = new GroupAnswers();
      } else {
        groupAnswers.addAnswerSet(line);
      }
    }

    // If groupAnswers has answer sets, add it to the list
    if (groupAnswers.getUniqueAnswerCount() > 0) {
      groupAnswersList.add(groupAnswers);
    }

    int sumOfUniqueAnswers =
        groupAnswersList.stream().mapToInt(GroupAnswers::getUniqueAnswerCount).sum();
    System.out.println("sumOfUniqueAnswers = " + sumOfUniqueAnswers);

    int sumOfIntersectingAnswers =
        groupAnswersList.stream().mapToInt(GroupAnswers::getIntersectingAnswerCount).sum();
    System.out.println("sumOfIntersectingAnswers = " + sumOfIntersectingAnswers);
  }
}
