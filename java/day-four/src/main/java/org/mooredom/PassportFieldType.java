package org.mooredom;

import java.util.Arrays;

public enum PassportFieldType {
    BYR("byr"),
    IYR("iyr"),
    EYR("eyr"),
    HGT("hgt"),
    HCL("hcl"),
    ECL("ecl"),
    PID("pid"),
    CID("cid");

    private String value;

    PassportFieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static PassportFieldType fromValue(String value) {
        return Arrays.stream(PassportFieldType.values())
                .filter(fieldType -> fieldType.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
