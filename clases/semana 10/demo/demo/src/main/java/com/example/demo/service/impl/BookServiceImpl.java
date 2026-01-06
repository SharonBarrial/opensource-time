package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Anotacion para indicar que es un servicio
@Service
public class BookServiceImpl implements BookService {

    //Anotacion para inyectar dependencias
    @Autowired
    private BookRepository bookRepository;

    //Override: sirve para indicar que se esta sobreescribiendo un metodo
    @Override
    //Metodo para guardar un libro
    public Book save(Book book)
    {
        return bookRepository.save(book);
    }
}
