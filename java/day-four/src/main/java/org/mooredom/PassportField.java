package org.mooredom;

import lombok.Data;

import java.util.Arrays;

@Data
public class PassportField {
    private final PassportFieldType type;
    private final String value;

    public PassportField(PassportFieldType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static PassportField from(String fieldString) {
        String[] fields = fieldString.split(":");
        String key = fields[0];
        String value = fields[1];

        Arrays.stream(PassportFieldType.values()).sequential()
                .filter(fieldType -> fieldType.getValue().equals(key))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return new PassportField(PassportFieldType.fromValue(key), value);
    }

    public boolean isValid() {
        return PassportFieldValidator.isValidField(this);
    }
}
