package com.library.platform.upc.inventory.domain.exceptions;

public class SameIsbnException extends RuntimeException{
    public SameIsbnException(String isbn) {
        super("Another book with the same ISBN: " + isbn + " already exists");
    }
}
