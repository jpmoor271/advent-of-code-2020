package org.mooredom;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class PassportFieldTest {

    @Test
    void testFactoryMethodForValidKeys() {
        for (PassportFieldType fieldType : PassportFieldType.values()) {
            PassportField field = PassportField.from(String.format("%s:test", fieldType.getValue()));
            assertThat(field.getType(), is(equalTo(fieldType)));
            assertThat(field.getValue(), is(equalTo("test")));
        }
    }

    @Test
    void testFactoryMethodForInvalidKey () {
        assertThrows(IllegalArgumentException.class, () -> PassportField.from("invalid:anything"));
    }
}
