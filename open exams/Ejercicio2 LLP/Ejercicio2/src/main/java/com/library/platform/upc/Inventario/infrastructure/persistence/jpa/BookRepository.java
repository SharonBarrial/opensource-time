package com.library.platform.upc.Inventario.infrastructure.persistence.jpa;


import com.library.platform.upc.Inventario.domain.model.aggregates.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
}