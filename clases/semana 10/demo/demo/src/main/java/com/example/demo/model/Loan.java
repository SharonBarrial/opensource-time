package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//Anotaciones lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones
@Entity
@Table(name = "loans")

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "title", length = 10, nullable = false)
    private String codeStudent;
    @Column(name= "loan_date", nullable = false)
    private LocalDate loanDate;
    @Column(name= "devolution_date", nullable = false)
    private LocalDate devolutionDate;
    @Column(name= "book_loan", nullable = false)
    private boolean bookLoan;

    //Relacion muchos a uno
    @ManyToOne
    //Relacion con la tabla books y la columna book_id de la tabla loans
    @JoinColumn(name = "book_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_BOOK_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Book book;
}
