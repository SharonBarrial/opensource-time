/**
 * GetFavoriteSourceByNewsApiKeyAndSourceIdQuery
 * @summary
 * GetFavoriteSourceByNewsApiKeyAndSourceIdQuery is a record class that represents the query to get a favorite news source by API key and source ID.
 */
package com.acme.catchup.platform.news.domain.model.queries;

public record GetFavoriteSourceByNewsApiKeyAndSourceIdQuery(String newsApiKey, String sourceId) {
    public GetFavoriteSourceByNewsApiKeyAndSourceIdQuery {
        if (newsApiKey == null) {
            throw new IllegalArgumentException("newsApiKey cannot be null");
        }
        if (sourceId == null) {
            throw new IllegalArgumentException("sourceId cannot be null");
        }
    }
}
