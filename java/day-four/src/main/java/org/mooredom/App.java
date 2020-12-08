package org.mooredom;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
                .collect(Collectors.toList());

        List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();
        for (String line : lines) {
            if (line.isBlank()) {
                passports.add(passport);
                passport = new Passport();
            } else {
                Arrays.stream(line.split(" ")).map(PassportField::from).forEach(passport::addField);
            }
        }

        // If passport has fields, add it to passports list
        if (passport.getFields().size() > 0) {
            passports.add(passport);
        }

        long countValidPassports = passports.stream()
                .filter(Passport::hasRequiredFields)
                .filter(Passport::hasAllValidFields)
                .count();
        System.out.println("countValidPassports = " + countValidPassports);
    }
}
