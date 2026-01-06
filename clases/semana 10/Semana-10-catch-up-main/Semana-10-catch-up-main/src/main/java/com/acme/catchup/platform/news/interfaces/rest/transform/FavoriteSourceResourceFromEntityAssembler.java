package com.acme.catchup.platform.news.interfaces.rest.transform;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.interfaces.rest.resources.FavoriteSourceResource;

/**
 * Assembler for converting FavoriteSource entities to FavoriteSourceResource representations.
 *
 * <p>This assembler provides a method to convert a FavoriteSource entity to its corresponding FavoriteSourceResource,
 * which is used for API responses.</p>
 */
public class FavoriteSourceResourceFromEntityAssembler {

    /**
     * Converts a FavoriteSource entity to a FavoriteSourceResource.
     *
     * @param entity the FavoriteSource entity to convert
     * @return the converted FavoriteSourceResource
     */
    public static FavoriteSourceResource toResourceFromEntity(FavoriteSource entity) {
        return new FavoriteSourceResource(entity.getId(), entity.getNewsApiKey(), entity.getSourceId());
    }
}
