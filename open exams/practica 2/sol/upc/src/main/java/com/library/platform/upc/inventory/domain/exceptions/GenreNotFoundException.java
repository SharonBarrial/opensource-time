package com.library.platform.upc.inventory.domain.exceptions;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(Long genreId) {
        super("Genre with id " + genreId + " not found");
    }
}
