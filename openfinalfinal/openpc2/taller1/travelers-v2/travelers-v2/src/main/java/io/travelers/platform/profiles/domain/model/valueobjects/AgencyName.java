package io.travelers.platform.profiles.domain.model.valueobjects;

public record AgencyName(String name) {

    public AgencyName {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("The name is required.");
        }
    }
    public String getAgencyName(){
        return name;
    }
}
