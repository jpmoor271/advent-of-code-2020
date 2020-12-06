package org.mooredom;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "from")
public class TreeGrid {
    private static final Character TREE_SYMBOL = '#';
    
    private final List<String> gridTemplate;

    public boolean isTreeAt(Location gridLocation) {
        if (gridLocation.getY() > gridTemplate.size() - 1) {
            throw new InvalidTreeLocation(gridLocation);
        }

        String rowTemplate = gridTemplate.get(gridLocation.getY());
        Character locationSymbol = rowTemplate.charAt(gridLocation.getX() % rowTemplate.length());
        return TREE_SYMBOL.equals(locationSymbol);
    }
}
