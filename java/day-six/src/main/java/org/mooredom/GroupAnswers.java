package org.mooredom;

import java.util.*;

public class GroupAnswers {
  private final List<String> answerSets = new ArrayList<>();

  public void addAnswerSet(String answerSet) {
    answerSets.add(answerSet);
  }

  public int getUniqueAnswerCount() {
    Set<Character> uniqueAnswers = new HashSet<>();
    for (String answerSet : answerSets) {
      for (int i = 0; i < answerSet.length(); i++) {
        uniqueAnswers.add(answerSet.charAt(i));
      }
    }
    return uniqueAnswers.size();
  }

  public int getIntersectingAnswerCount() {
    Map<Character, Integer> intersectingAnswers = new HashMap<>();
    for (String answerSet : answerSets) {
      for (int i = 0; i < answerSet.length(); i++) {
        Character answer = answerSet.charAt(i);
        if (!intersectingAnswers.containsKey(answer)) {
          intersectingAnswers.put(answer, 0);
        }
        intersectingAnswers.put(answer, intersectingAnswers.get(answer) + 1);
      }
    }

    return (int) intersectingAnswers.entrySet().stream()
        .map(Map.Entry::getValue)
        .filter(entryCount -> answerSets.size() == entryCount)
        .count();
  }
}
