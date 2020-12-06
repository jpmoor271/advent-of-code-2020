package org.mooredom;

import lombok.Data;

@Data(staticConstructor = "at")
public class Location {
    private final int x;
    private final int y;

    public static final Location START = Location.at(0, 0);

    public Location moveRight(int spaces) {
        return Location.at(this.x + spaces, this.y);
    }


    public Location moveDown(int spaces) {
        return Location.at(this.x, this.y + spaces);
    }
}
