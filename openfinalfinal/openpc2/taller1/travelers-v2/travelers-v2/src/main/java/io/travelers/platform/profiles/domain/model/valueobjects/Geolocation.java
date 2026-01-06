package io.travelers.platform.profiles.domain.model.valueobjects;

public record Geolocation(
        Long latitude,
        Long longitude
) {
    public String getGeolocation(){
        return String.format("%s %s", latitude, longitude);
    }

    public Geolocation{
        if(latitude == null){
            throw new IllegalArgumentException("Latitude must not be null");
        }
        if(longitude == null){
            throw new IllegalArgumentException("Longitude must not be null");
        }
    }
}
