package org.mooredom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFieldValidatorTest {

    @Test
    void testIsValidBirthYearForValidValue() {
        for (int year = 1920; year <= 2002; year++) {
            PassportField field = new PassportField(PassportFieldType.BYR, Integer.toString(year));
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidBirthYearForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.BYR, "2020");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));

        field = new PassportField(PassportFieldType.BYR, "not a number");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidIssueYearForValidValue() {
        for (int year = 2010; year <= 2020; year++) {
            PassportField field = new PassportField(PassportFieldType.IYR, Integer.toString(year));
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidIssueYearForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.IYR, "2008");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));

        field = new PassportField(PassportFieldType.IYR, "not a number");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidExpirationYearForValidValue() {
        for (int year = 2020; year <= 2030; year++) {
            PassportField field = new PassportField(PassportFieldType.EYR, Integer.toString(year));
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidExpirationYearForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.EYR, "2018");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));

        field = new PassportField(PassportFieldType.EYR, "not a number");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidHeightInInchesForValidValue() {
        for (int inches = 59; inches <= 76; inches++) {
            PassportField field = new PassportField(PassportFieldType.HGT, String.format("%din", inches));
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidHeightInInchesForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.HGT, "25in");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));

        field = new PassportField(PassportFieldType.HGT, "not a number");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidHeightInCentimetersForValidValue() {
        for (int centimeters = 150; centimeters <= 193; centimeters++) {
            PassportField field = new PassportField(PassportFieldType.HGT, String.format("%dcm", centimeters));
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidHeightInCentimetersForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.HGT, "99cm");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));

        field = new PassportField(PassportFieldType.HGT, "not a number");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidHairColorForValidValue() {
        PassportField field = new PassportField(PassportFieldType.HCL, "#00df7a");
        Assertions.assertTrue(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidHairColorForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.HCL, "#56gha9");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidEyeColorForValidValue() {
        String[] eyeColors = new String[] {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        for (String color : eyeColors) {
            PassportField field = new PassportField(PassportFieldType.ECL, color);
            Assertions.assertTrue(PassportFieldValidator.isValidField(field));
        }
    }

    @Test
    void testIsValidEyeColorForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.ECL, "org");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidPassportIdForValidValue() {
        PassportField field = new PassportField(PassportFieldType.PID, "123456789");
        Assertions.assertTrue(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidPassportIdForInvalidValue() {
        PassportField field = new PassportField(PassportFieldType.PID, "abcdefghi");
        Assertions.assertFalse(PassportFieldValidator.isValidField(field));
    }

    @Test
    void testIsValidCountryIdForValidValue() {
        PassportField field = new PassportField(PassportFieldType.CID, "anything at all");
        Assertions.assertTrue(PassportFieldValidator.isValidField(field));
    }
}
