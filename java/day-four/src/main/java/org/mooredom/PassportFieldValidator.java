package org.mooredom;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportFieldValidator {
    private static final Pattern FOUR_DIGITS = Pattern.compile("\\d{4}");
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("(\\d{2,3})(in|cm)");
    private static final Pattern HAIR_COLOR_PATTERN = Pattern.compile("#[0-9a-f]{6}");
    private static final Pattern PASSPORT_ID_PATTERN = Pattern.compile("\\d{9}");

    private static final String CENTIMETERS = "cm";

    private static final List<String> EYE_COLORS = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    public static boolean isValidField(PassportField field) {
        switch (field.getType()) {
            case BYR:
                return matchesPattern(field.getValue(), FOUR_DIGITS) && isInRange(field.getValue(), 1920, 2002);
            case IYR:
                return matchesPattern(field.getValue(), FOUR_DIGITS) && isInRange(field.getValue(), 2010, 2020);
            case EYR:
                return matchesPattern(field.getValue(), FOUR_DIGITS) && isInRange(field.getValue(), 2020, 2030);
            case HGT:
                return isValidHeight(field.getValue());
            case HCL:
                return matchesPattern(field.getValue(), HAIR_COLOR_PATTERN);
            case ECL:
                return isValidEyeColor(field.getValue());
            case PID:
                return matchesPattern(field.getValue(), PASSPORT_ID_PATTERN);
            case CID:
                return true;
            default:
                return false;
        }
    }

    private static boolean matchesPattern(String value, Pattern pattern) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    private static boolean isValidEyeColor(String value) {
        return EYE_COLORS.stream().anyMatch(color -> color.equals(value));
    }

    private static boolean isValidHeight(String value) {
        Matcher matcher = HEIGHT_PATTERN.matcher(value);
        if (matcher.matches()) {
            String measure = matcher.group(1);
            String unit = matcher.group(2);
            if (CENTIMETERS.equals(unit)) {
                return isInRange(measure, 150, 193);
            } else { // INCHES
                return isInRange(measure, 59, 76);
            }
        } else {
            return false;
        }
    }

    private static boolean isInRange(String value, int min, int max) {
        try {
            int intValue = Integer.parseInt(value);
            return intValue <=max && intValue >= min;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
