package org.mooredom;

public interface PredicateCriteria {
    void parse(String criteriaString);
    boolean matches(String candidate);
}
