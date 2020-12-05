package org.mooredom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneIndexMatchCriteriaTest {

    @Test
    void testFactoryMethod () {
        OneIndexMatchCriteria criteria = new OneIndexMatchCriteria();
        criteria.parse("1-3 a");

        assertThat(criteria.getIndexes(), hasItem(0));
        assertThat(criteria.getIndexes(), hasItem(2));
        Assertions.assertEquals("a", criteria.getMatchString());
    }
}
