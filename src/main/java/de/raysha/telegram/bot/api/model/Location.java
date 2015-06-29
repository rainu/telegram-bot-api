package de.raysha.telegram.bot.api.model;

/**
 * This object represents a point on the map.
 */
public class Location {
    /**
     * Longitude as defined by sender
     */
    private Float longitude;

    /**
     * Latitude as defined by sender
     */
    private Float latitude;

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
