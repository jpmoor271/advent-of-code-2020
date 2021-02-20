package org.mooredom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class BagRule {
    private static final Pattern RULE_PATTERN = Pattern.compile("(\\w \\w) bags contain (.*).");

    private final Bag containingBag;
    private final List<Bag> containedBags = new ArrayList<>();

    public static BagRule from(String ruleString) {
        Matcher ruleMatcher = RULE_PATTERN.matcher(ruleString);
        if (ruleMatcher.matches()) {
            String containingBagString = ruleMatcher.group(1);
            String containedBagsString = ruleMatcher.group(2);
        }
    }
}
