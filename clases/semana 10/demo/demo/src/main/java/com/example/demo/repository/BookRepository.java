package com.example.demo.repository;


import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Que son los repositorios? Son interfaces que extienden de JpaRepository,
// que es una interfaz de Spring Data JPA que nos proporciona métodos
// para realizar operaciones CRUD en la base de datos.
public interface BookRepository extends JpaRepository<Book, Long> {

    //prefijos de los métodos de consulta: find, read, get, query, count, exists, delete
    List<Book> findByEditorial(String editorial);

    boolean existsByTitleAndEditorial(String title, String editorial);

}
