package io.travelers.platform.profiles.domain.model.commands;

public record CreateAgencyCommand(
        Long businessId,
        String name,
        String street,
        String number,
        String city,
        String postalCode,
        String country,
        Long latitude,
        Long longitude
) {
}
