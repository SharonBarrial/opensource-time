package com.example.demo.service;

import com.example.demo.model.Book;

public interface BookService {

    //metodo abstracto: no tiene cuerpo y sirve para que las clases hijas lo implementen
    public abstract Book save(Book book);

}
