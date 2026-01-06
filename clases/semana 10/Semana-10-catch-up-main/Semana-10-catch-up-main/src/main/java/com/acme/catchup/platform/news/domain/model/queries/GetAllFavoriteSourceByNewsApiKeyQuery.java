/**
 * GetAllFavoriteSourceByNewsApiKeyQuery
 * @summary
 * GetAllFavoriteSourceByNewsApiKeyQuery is a record class that represents the query to get all favorite news sources by API key.
 */
package com.acme.catchup.platform.news.domain.model.queries;


//. Los records son especialmente útiles para clases de datos cuyos objetos se utilizan principalmente
// para transportar datos de manera inmutable.
public record GetAllFavoriteSourceByNewsApiKeyQuery(String newsApiKey) {
    public GetAllFavoriteSourceByNewsApiKeyQuery {
        if (newsApiKey == null || newsApiKey.isBlank()) {
            throw new IllegalArgumentException("API Key cannot be null or empty");
        }
    }
}

/*
Este bloque es un constructor compacto, una característica de los records.
No se declara explícitamente un parámetro; en su lugar, automáticamente toma los parámetros definidos en la declaración del record.
En este caso, verifica si el newsApiKey es null o vacío (isBlank()).
Si alguna de estas condiciones es verdadera, lanza una excepción IllegalArgumentException. Esto garantiza que el objeto GetAllFavoriteSourceByNewsApiKeyQuery no se pueda crear sin un valor válido para newsApiKey, fortaleciendo la integridad de los datos.
 */
