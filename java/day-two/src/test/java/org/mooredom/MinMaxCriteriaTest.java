package org.mooredom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinMaxCriteriaTest {

    @Test
    void testFactoryMethod () {
        MinMaxCriteria criteria = new MinMaxCriteria();
        criteria.parse("1-3 a");
        Assertions.assertEquals(1, criteria.getMinCount());
        Assertions.assertEquals(3, criteria.getMaxCount());
        Assertions.assertEquals("a", criteria.getMatchString());
    }
}
