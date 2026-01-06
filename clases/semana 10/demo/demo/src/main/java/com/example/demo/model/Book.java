package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Model: Es la representación de los datos que maneja el sistema.
//Anotaciones lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones
@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 22, nullable = false)
    private String title;
    @Column(name = "author", length = 14, nullable = false)
    private String editorial;


}
