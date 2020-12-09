package org.mooredom;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GroupAnswersTest {

  @Test
  void testGroupAnswersForSingleCharacterAnswerSets() {
    GroupAnswers answers = new GroupAnswers();
    answers.addAnswerSet("a");
    answers.addAnswerSet("b");
    answers.addAnswerSet("c");

    assertThat(answers.getUniqueAnswerCount(), is(equalTo(3)));
  }

  @Test
  void testUniqueAnswerCountForOverlappingAnswerSets() {
    GroupAnswers answers = new GroupAnswers();
    answers.addAnswerSet("abcx");
    answers.addAnswerSet("abcy");
    answers.addAnswerSet("abcz");

    assertThat(answers.getUniqueAnswerCount(), is(equalTo(6)));
  }

  @Test
  void testUniqueAnswerCountForSingleAnswerSet() {
    GroupAnswers answers = new GroupAnswers();
    answers.addAnswerSet("abc");

    assertThat(answers.getUniqueAnswerCount(), is(equalTo(3)));
  }

  @Test
  void testUniqueAnswerCountForDuplicateAnswerSets() {
    GroupAnswers answers = new GroupAnswers();
    answers.addAnswerSet("xyz");
    answers.addAnswerSet("xyz");
    answers.addAnswerSet("xyz");
    answers.addAnswerSet("xyz");

    assertThat(answers.getUniqueAnswerCount(), is(equalTo(3)));
  }

  @Test
  void testGroupAnswersIntersectionCountForAllIntersectingAnswers() {
    GroupAnswers answers = new GroupAnswers();
    answers.addAnswerSet("abcd");
    answers.addAnswerSet("abcd");
    answers.addAnswerSet("abcd");

    assertThat(answers.getIntersectingAnswerCount(), is(equalTo(4)));
  }

    @Test
    void testGroupAnswersIntersectionCountForNoIntersectingAnswers() {
        GroupAnswers answers = new GroupAnswers();
        answers.addAnswerSet("ab");
        answers.addAnswerSet("cd");
        answers.addAnswerSet("ef");
        answers.addAnswerSet("gh");

        assertThat(answers.getIntersectingAnswerCount(), is(equalTo(0)));
    }

    @Test
    void testGroupAnswersIntersectionCountForPartiallyIntersectingAnswers() {
        GroupAnswers answers = new GroupAnswers();
        answers.addAnswerSet("ab");
        answers.addAnswerSet("ad");
        answers.addAnswerSet("bd");
        answers.addAnswerSet("ef");

        assertThat(answers.getIntersectingAnswerCount(), is(equalTo(0)));
    }
}
