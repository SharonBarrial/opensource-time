package io.travelers.platform.profiles.domain.model.commands;

public class PopulateBusinessTableCommand {

    private final Long id;
    private final String name;

    public PopulateBusinessTableCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
