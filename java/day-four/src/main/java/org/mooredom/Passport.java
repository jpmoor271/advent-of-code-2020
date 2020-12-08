package org.mooredom;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mooredom.PassportFieldType.*;

@Data
public class Passport {
    private static final List<PassportFieldType> REQUIRED_FIELD_TYPES =
            Arrays.stream(values()).sequential().filter(type -> type != CID).collect(Collectors.toList());

    private List<PassportField> fields = new ArrayList<>();

    public void addField(PassportField passportField) {
        this.fields.add(passportField);
    }

    public boolean hasRequiredFields() {
        return REQUIRED_FIELD_TYPES.stream().allMatch(this::hasFieldOfType);
    }

    private boolean hasFieldOfType(PassportFieldType type) {
        return fields.stream()
                .map(PassportField::getType)
                .anyMatch(fieldType -> fieldType.equals(type));
    }

    public boolean hasAllValidFields() {
        return fields.stream().allMatch(PassportField::isValid);
    }
}
