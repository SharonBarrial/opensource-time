package com.example.demo.controller;


import com.example.demo.exception.ValidationException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest Controller for Book: Es una clase que se encarga de manejar las peticiones de los libros
//Diferencia con Rest controller Advice: Rest Controller Advice maneja las excepciones de la aplicación
@RestController
//RequestMapping: Es una anotación que se utiliza para mapear las peticiones web a los métodos de controlador en las clases de controlador.
@RequestMapping("/api/v1/library")
public class BookController {

    @Autowired
    private BookService bookService;
    private final BookRepository bookRepository;
    //Book Controller: Es un constructor que recibe un BookRepository como parámetro para
    //poder acceder a los métodos de consulta de la base de datos.
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    //Method: GET -> localhost:8080/api/v1/library/books
    //Transactional: Es una anotación que se utiliza para indicar que una transacción debe ser iniciada en un método.
    @Transactional(readOnly = true)
    @GetMapping("/books")
    //Get All Books: Método para obtener todos los libros
    public ResponseEntity<List<Book>> getAllBooks(){

        return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.OK); //200

    }



    //Method: GET -> localhost:8080/api/v1/library/books/filterByEditorial
    @Transactional(readOnly = true)
    @GetMapping("/books/filterByEditorial")
    //Get All Books By Editorial: Método para obtener todos los libros por editorial
    public ResponseEntity<List<Book>> getAllBooksByEditorial(@RequestParam(name = "editorial") String editorial){
        return new ResponseEntity<List<Book>>(bookRepository.findByEditorial(editorial), HttpStatus.OK); //200
    }

    //Create endpoints
    //Method: POST -> localhost:8080/api/v1/library/books
    @Transactional
    @PostMapping("/books")
    //Create Book: Método para crear un libro
    //RequestBody: Es una anotación que se utiliza para vincular los datos de la solicitud HTTP entrante con el parámetro del método de controlador.
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        existsByTitleAndEditorial(book);
        validateBook(book);
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.CREATED);//201
    }

    //Validate the book: Método para validar los datos de entrada de un libro
    private void validateBook(Book book){
        if(book.getTitle()==null || book.getTitle().trim().isEmpty()) {
            throw new ValidationException("The book title must be mandatory");
        }

        if(book.getTitle().length()>22){
            throw new ValidationException("The book title must not exceed 22 characters");
        }

        if (book.getEditorial()==null || book.getEditorial().trim().isEmpty()) {
            throw new ValidationException("The book editorial must be mandatory");
        }

        if (book.getEditorial().length()>14) {
            throw new ValidationException("The book editorial must not exceed 14 characters");
        }

    }

    //Exists by title and editorial: Método para verificar si un libro ya existe
    private void existsByTitleAndEditorial(Book book){
        if(bookRepository.existsByTitleAndEditorial(book.getTitle(), book.getEditorial())){
            throw new ValidationException("The book already exists");
        }
    }


}