package io.travelers.platform.profiles.interfaces.rest.resources;

public record AgencyResource(
        Long id,
        Long businessId,
        String name,
        String streetAddress,
        String geolocation) {
}
