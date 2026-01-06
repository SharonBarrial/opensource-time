/**
 * CreateFavoriteSourceCommand
 * @summary
 * CreateFavoriteSourceCommand is a record class that represents the command to create a favorite news source.
 */
package com.acme.catchup.platform.news.domain.model.commands;

/**
 * Command to create a FavoriteSource.
 *
 * <p>The CreateFavoriteSourceCommand record encapsulates the data required to create a FavoriteSource.
 * It validates that the newsApiKey and sourceId are not null or empty.</p>
 *
 * @param newsApiKey The API key for the news source.
 * @param sourceId The identifier of the news source.
 * @throws IllegalArgumentException if newsApiKey or sourceId is null or empty.
 */

/*Esta clase encapsula los datos necesarios para crear un objeto FavoriteSource */
public record CreateFavoriteSourceCommand(String newsApiKey, String sourceId) {

    //Valida que los campos newsApiKey y sourceId no sean nulos o vacíos
    //Los campos son necesarios para crear un objeto FavoriteSource
    public CreateFavoriteSourceCommand {
        if (newsApiKey == null || newsApiKey.isBlank()) {
            throw new IllegalArgumentException("newsApiKey cannot be null or empty");
        }
        if (sourceId == null || sourceId.isBlank()) {
            throw new IllegalArgumentException("sourceId cannot be null or empty");
        }
    }

}
