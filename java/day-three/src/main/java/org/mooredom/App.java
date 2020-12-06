package org.mooredom;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> input = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))
                .collect(Collectors.toList());
        TreeGrid grid = TreeGrid.from(input);
        List<Slope> slopes = Arrays.asList(
                new Slope(1, 1),
                new Slope(3, 1),
                new Slope(5, 1),
                new Slope(7, 1),
                new Slope(1, 2)
        );
        int productOfTreeCounts = slopes.stream()
                .map(slope -> countTreesForSlope(grid, slope))
                .reduce(1, (a, b) -> a * b);
        System.out.println("Final product: " + productOfTreeCounts);
    }

    private static int countTreesForSlope(TreeGrid grid, Slope slope) {
        Location currentLocation = Location.START;
        int treeCount = 0;
        while (currentLocation.getY() < grid.getGridTemplate().size() - slope.downSpaces) {
            currentLocation = currentLocation.moveRight(slope.rightSpaces).moveDown(slope.downSpaces);
            if (grid.isTreeAt(currentLocation)) {
                treeCount++;
            }
        }

        return treeCount;
    }
}
