package com.library.platform.upc.inventory.domain.model.aggregates;

import com.library.platform.upc.inventory.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.inventory.domain.model.commands.UpdateBookCommand;
import com.library.platform.upc.inventory.domain.model.entities.Genre;
import com.library.platform.upc.inventory.domain.model.valueobjects.Status;
import com.library.platform.upc.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Entity
public class Book extends AuditableAbstractAggregateRoot<Book> {

    @NotNull(message = "ISBN is required")
    @Size(max = 13, message = "ISBN must be maximum 13 characters")
    @Column(unique = true)
    @Getter
    private String isbn;
    @NotNull(message = "Title is required")
    @Size(max = 100, message = "Title must be maximum 100 characters")
    @Getter
    private String title;
    @NotNull(message = "Author is required")
    @Size(max = 50, message = "Author must be maximum 50 characters")
    @Getter
    private String author;
    @NotNull(message = "Published date is required")
    @PastOrPresent(message = "Published date must be in the past or be today")
    @Getter
    private Date publishedDate;
    @NotNull(message = "Status is required")
    @Embedded
    private Status status;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    @Getter
    private Genre genre;

    public Book() {
    }

    public Book(CreateBookCommand command, Genre genre) {
        this.isbn = command.isbn();
        this.title = command.title();
        this.author = command.author();
        this.publishedDate = command.publishedDate();
        this.status = new Status(command.status());
        this.genre = genre;
    }

    public Book update(UpdateBookCommand command, Genre genre) {
        this.isbn = command.isbn();
        this.title = command.title();
        this.author = command.author();
        this.publishedDate = command.publishedDate();
        this.status = new Status(command.status());
        this.genre = genre;
        return this;
    }

    public String getStatus() {
        return status.status();
    }
}
