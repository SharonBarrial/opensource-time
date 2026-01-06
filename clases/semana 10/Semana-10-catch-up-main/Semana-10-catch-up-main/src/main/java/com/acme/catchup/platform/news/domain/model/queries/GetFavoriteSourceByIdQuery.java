/**
 * GetFavoriteSourceByIdQuery
 * @summary
 * GetFavoriteSourceByIdQuery is a record class that represents the query to get a favorite news source by ID.
 */
package com.acme.catchup.platform.news.domain.model.queries;

public record GetFavoriteSourceByIdQuery(Long id) {
    public GetFavoriteSourceByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
