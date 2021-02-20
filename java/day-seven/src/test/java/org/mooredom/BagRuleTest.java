package org.mooredom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagRuleTest {

    @Test
    void testFactoryMethod() {
        BagRule rule = BagRule.from("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        assertThat(rule.getContainingBag().getType(), is(equalTo(BagType.LIGHT_RED)));
        assertThat(rule.getContainedBags(), hasSize(2));
    }
}
