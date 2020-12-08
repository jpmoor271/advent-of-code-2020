package org.mooredom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PassportTest {

    @Test
    void  testHasRequiredFields() {
        Passport passport = new Passport();
        Arrays.stream(PassportFieldType.values())
                .map(fieldType -> new PassportField(fieldType, "anything"))
                .forEach(passport::addField);
        Assertions.assertTrue(passport.hasRequiredFields());
    }

    @Test
    void testHasRequiredFieldsWithOnlyOneRequiredField () {
        Passport passport = new Passport();
        passport.addField(new PassportField(PassportFieldType.BYR, "anything"));
        Assertions.assertFalse(passport.hasRequiredFields());
    }

    @Test
    void testHasAllValidFields() {
        Passport passport = new Passport();
        passport.addField(PassportField.from("pid:087499704"));
        passport.addField(PassportField.from("hgt:74in"));
        passport.addField(PassportField.from("ecl:grn"));
        passport.addField(PassportField.from("iyr:2012"));
        passport.addField(PassportField.from("eyr:2030"));
        passport.addField(PassportField.from("byr:1980"));
        passport.addField(PassportField.from("hcl:#623a2f"));

        Assertions.assertTrue(passport.hasAllValidFields());
    }
}
