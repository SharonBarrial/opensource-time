package com.library.platform.upc.inventory.infrastructure.persistence.jpa.repositories;

import com.library.platform.upc.inventory.domain.model.aggregates.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findByIsbn(String isbn);
}
