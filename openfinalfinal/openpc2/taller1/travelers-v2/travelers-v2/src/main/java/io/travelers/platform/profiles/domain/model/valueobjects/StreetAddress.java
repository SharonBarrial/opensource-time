package io.travelers.platform.profiles.domain.model.valueobjects;

public record StreetAddress(
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {

    public String getStreetAddress() {
        return String.format("%s %s, %s, %s, %s", street, number, city, postalCode, country);
    }

    public StreetAddress{
        if(street ==null|| street.isBlank()){
            throw new IllegalArgumentException("Street must not be null or blank");
        }
        if(city ==null|| city.isBlank()){
            throw new IllegalArgumentException("City must not be null or blank");
        }
        if(postalCode ==null|| postalCode.isBlank()){
            throw new IllegalArgumentException("Postal code must not be null or blank");
        }
        if(country ==null|| country.isBlank()){
            throw new IllegalArgumentException("Country must not be null or blank");
        }
    }
}
