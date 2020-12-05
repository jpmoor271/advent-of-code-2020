package org.mooredom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class OneIndexMatchCriteria implements PredicateCriteria {
    private static final Pattern REGEX_PATTERN = Pattern.compile("(\\d+)-(\\d+) (\\w)");

    private List<Integer> indexes = new ArrayList<>();
    private String matchString;

    @Override
    public void parse(String criteriaString) {
        Matcher matcher = REGEX_PATTERN.matcher(criteriaString);
        if (matcher.find()) {
            this.getIndexes().add(Integer.parseInt(matcher.group(1)) - 1);
            this.getIndexes().add(Integer.parseInt(matcher.group(2)) - 1);
            this.setMatchString(matcher.group(3));
        }
    }

    @Override
    public boolean matches(String candidate) {
        return indexes.stream()
                .filter(index -> matchString.equals(String.valueOf(candidate.charAt(index))))
                .count() == 1;
    }
}
