package io.travelers.platform.profiles.domain.exceptions;

public class BusinessNotFoundException extends RuntimeException{
    public BusinessNotFoundException(Long aLong) {
        super("Business with id " + aLong + " not found");
    }
}
