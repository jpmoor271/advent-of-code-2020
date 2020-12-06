package org.mooredom;

public class InvalidTreeLocation extends RuntimeException {
    private Location invalidLocation;

    public InvalidTreeLocation(Location invalidLocation) {
        this.invalidLocation = invalidLocation;
    }

    @Override
    public String getMessage() {
        return String.format("Invalid tree location @ {%d,%d}", invalidLocation.getX(), invalidLocation.getY());
    }
}
