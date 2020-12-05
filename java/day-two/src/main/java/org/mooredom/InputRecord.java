package org.mooredom;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class InputRecord<T extends PredicateCriteria> {
    private T criteria;
    private String criteriaString;
    private String password;


    public InputRecord(String input, T criteria) {
        String[] components = input.split(":");
        if (components.length == 2) {
            this.password = StringUtils.strip(components[1]);
            this.criteria = criteria;
            this.criteria.parse(components[0]);
        } else {
            throw new IllegalArgumentException(String.format("Cannot parse record from input [%s]", input));
        }
    }

    public boolean matchesCriteria() {
        return criteria.matches(password);
    }
}
