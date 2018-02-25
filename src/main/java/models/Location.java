package models;

import lombok.Data;

@Data
public class Location {
    private final Geography geography;

    public Location(Geography geography) {
        this.geography = geography;
    }
}
