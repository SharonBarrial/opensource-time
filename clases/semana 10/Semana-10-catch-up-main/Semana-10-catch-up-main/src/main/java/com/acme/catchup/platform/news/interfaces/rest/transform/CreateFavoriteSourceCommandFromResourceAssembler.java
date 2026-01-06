package com.acme.catchup.platform.news.interfaces.rest.transform;

import com.acme.catchup.platform.news.domain.model.commands.CreateFavoriteSourceCommand;
import com.acme.catchup.platform.news.interfaces.rest.resources.CreateFavoriteSourceResource;

/**
 * Assembler for converting CreateFavoriteSourceResource objects to CreateFavoriteSourceCommand commands.
 *
 * <p>This assembler provides a method to convert a CreateFavoriteSourceResource object, which is typically used
 * in API requests, to a CreateFavoriteSourceCommand, which is used to execute business logic.</p>
 */
public class CreateFavoriteSourceCommandFromResourceAssembler {

    /**
     * Converts a CreateFavoriteSourceResource to a CreateFavoriteSourceCommand.
     *
     * @param resource the CreateFavoriteSourceResource to convert
     * @return the converted CreateFavoriteSourceCommand
     */
    public static CreateFavoriteSourceCommand toCommandFromResource(CreateFavoriteSourceResource resource) {
        return new CreateFavoriteSourceCommand(resource.newsApiKey(), resource.sourceId());
    }
}

