package org.mooredom;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TreeGridTest {

    @Test
    void testIsTreeAtForOneRowWithinTemplateRange () {
        TreeGrid grid = TreeGrid.from(Arrays.asList("#......."));
        assertTrue(grid.isTreeAt(Location.START));
        for (int i = 0; i < 7; i++) {
            assertFalse(grid.isTreeAt(Location.START.moveRight(1)));
        }
    }

    @Test
    void testIsTreeAtForOneRowBeyondTemplateRange () {
        String templateRow = "#.......";
        TreeGrid grid = TreeGrid.from(Arrays.asList(templateRow));
        assertTrue(grid.isTreeAt(Location.START));
        for (int i = 0; i < 10; i++) {
            Location nextExpectedTree = Location.START.moveRight(templateRow.length()*(i+1));
            assertTrue(grid.isTreeAt(nextExpectedTree));
            for (int j = 0; j < 7; j++) {
                assertFalse(grid.isTreeAt(nextExpectedTree.moveRight(1)));
            }
        }
    }

    @Test
    void testIsTreeAtForTwoRowTemplate () {
        String templateRowOne = ".......#";
        String templateRowTwo = "...#....";

        TreeGrid grid = TreeGrid.from(Arrays.asList(templateRowOne, templateRowTwo));
        Location firstTreeLocation = Location.START.moveRight(7);
        Location secondTreeLocation = Location.START.moveDown(1).moveRight(3);

        assertTrue(grid.isTreeAt(firstTreeLocation));
        assertTrue(grid.isTreeAt(secondTreeLocation));
    }

    @Test
    void testIsTreeAtBeyondLastTemplateRow () {
        TreeGrid grid = TreeGrid.from(Arrays.asList(
           "..#..#....#",
           "###...#..#.",
           "........#.."
        ));

        Location onTemplateTreeLocation = Location.START.moveDown(2).moveRight(8);
        assertTrue(grid.isTreeAt(onTemplateTreeLocation));

        Location offTemplateTreeLocation = Location.START.moveDown(3);
        assertThrows(InvalidTreeLocation.class, () -> grid.isTreeAt(offTemplateTreeLocation));
    }


}
