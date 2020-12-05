package org.mooredom;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class MinMaxCriteria implements PredicateCriteria {
    private static final Pattern REGEX_PATTERN = Pattern.compile("(?<minCount>\\d+)-(?<maxCount>\\d+) (?<matchString>\\w)");

    private int minCount;
    private int maxCount;
    private String matchString;

    @Override
    public void parse(String criteriaString) {
        Matcher matcher = REGEX_PATTERN.matcher(criteriaString);
        if (matcher.find()) {
            this.minCount = Integer.parseInt(matcher.group("minCount"));
            this.maxCount = Integer.parseInt(matcher.group("maxCount"));
            this.matchString = matcher.group("matchString");
        }
    }

    @Override
    public boolean matches(String candidate) {
        int matchCount = StringUtils.countMatches(candidate, matchString);
        return matchCount <= maxCount && matchCount >= minCount;
    }
}
