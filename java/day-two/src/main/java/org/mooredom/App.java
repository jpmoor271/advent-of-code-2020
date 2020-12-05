package org.mooredom;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        long minMaxCriteriaMatches = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
                .map(record -> new InputRecord<MinMaxCriteria>(record, new MinMaxCriteria()))
                .filter(InputRecord::matchesCriteria)
                .count();
        System.out.printf("%d passwords match using min/max criteria\n", minMaxCriteriaMatches);

        long oneIndexCriteriaMatches = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
                .map(record -> new InputRecord<OneIndexMatchCriteria>(record, new OneIndexMatchCriteria()))
                .filter(InputRecord::matchesCriteria)
                .count();
        System.out.printf("%d passwords match using min/max criteria\n", oneIndexCriteriaMatches);
    }
}
