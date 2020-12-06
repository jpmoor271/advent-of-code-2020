package org.mooredom;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    void testStart () {
        assertEquals(0, Location.START.getX());
        assertEquals(0, Location.START.getY());
    }

    @Test
    void testMoveRight () {
        Location location = Location.START.moveRight(4);
        assertEquals(4, location.getX());
        assertEquals(0, location.getY());
    }
}
