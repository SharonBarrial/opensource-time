package io.travelers.platform.profiles.interfaces.rest.resources;

public record CreateAgencyResource(
        Long businessId,
        String name,
        String street,
        String number,
        String city,
        String postalCode,
        String country,
        Long latitude,
        Long longitude){
}
