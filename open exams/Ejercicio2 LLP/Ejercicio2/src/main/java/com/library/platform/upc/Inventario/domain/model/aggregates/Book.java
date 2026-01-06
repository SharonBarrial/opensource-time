package com.library.platform.upc.Inventario.domain.model.aggregates;

import com.library.platform.upc.Inventario.domain.model.entities.Genre;
import com.library.platform.upc.Inventario.domain.model.valueobjects.Status;
import com.library.platform.upc.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
public class Book extends AuditableAbstractAggregateRoot<Book> {
    @Setter
    @NotBlank
    @Size(max=13)
    @Column(unique = true)
    private String isbn;

    @Setter
    @NotBlank
    @Size(max=100)
    private String title;

    @Setter
    @NotBlank
    @Size(max=50)
    private String author;

    @Setter
    @Temporal(TemporalType.DATE)
    @PastOrPresent(message = "Published date must be in the past or present")
    private Date publishedDate;

    @Setter
    @NotBlank
    @Size(max=10)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    public Book(){
        this.genres = new HashSet<>();
    }

    public Book(String isbn, String title, String author, Date publishedDate, Status  status) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.status = status;
        this.genres =new HashSet<>();
    }

    public Book(String isbn, String title, String author, Date publishedDate, Status  status, List<Genre> genres) {
        this(isbn, title, author, publishedDate, status);
        addGenres(genres);
    }
    public Book addGenre(Genre genre) {
        this.genres.add(genre);
        return this;
    }
    public Book addGenres(List<Genre> genres) {
        var validatedGenres = Genre.validateGenreSet(genres);
        this.genres.addAll(validatedGenres);
        return this;
    }

}