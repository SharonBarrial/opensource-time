package com.example.demo.controller;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.Book;
import com.example.demo.model.Loan;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LoanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


//Para que sirve @RestController en Spring Boot:  @RestController es una anotación de marcador que se usa para crear un controlador RESTful en Spring Boot.
//Controller: Es una clase que se encarga de manejar las peticiones
@RestController

@RequestMapping("/api/v1/loans")

public class LoanController {
    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    //Loan Controller: Es un constructor que recibe un LoanRepository y un BookRepository como parámetros para
    public LoanController(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    //Method: GET -> localhost:8080/api/v1/loans/filterByCodeStudent
    @Transactional(readOnly = true)
    @GetMapping("/filterByCodeStudent")
    //Get All Loans By Code Student: Método para obtener todos los préstamos por código de estudiante
    public ResponseEntity<List<Loan>> getAllLoansByCodeStudent(@RequestParam(value = "codeStudent") String codeStudent) {

        return new ResponseEntity<List<Loan>>(loanRepository.findByCodeStudent(codeStudent), HttpStatus.OK); //200

    }


    //Method: POST -> localhost:8080/api/v1/loans/books/1

    //Transactional: Es una anotación que se utiliza para indicar que una transacción debe ser iniciada en un método.
    @Transactional
    @PostMapping("/books/{id}")
    //Create Loan: Método para crear un préstamo
    public ResponseEntity<Loan> createLoan(@PathVariable(name = "id") Long bookId, @RequestBody Loan loan) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ValidationException("The book with id=" + bookId + " is not found"));
        existsByCodeStudentAndBookAndBookLoan(loan, book);
        validateLoan(loan);
        loan.setLoanDate(LocalDate.now());
        loan.setDevolutionDate(LocalDate.now().plusDays(3));
        loan.setBookLoan(true); //boolean
        return new ResponseEntity<Loan>(loanRepository.save(loan), HttpStatus.CREATED); //201

    }

    //Validate Loan: Método para validar un préstamo
    private void validateLoan(Loan loan) {
        if (loan.getCodeStudent() == null || loan.getCodeStudent().trim().isEmpty()) {
            throw new ValidationException("The student code must be mandatory");
        }

        if (loan.getCodeStudent().length() < 10) {
            throw new ValidationException("The student code must have 10 characters");
        }
    }

    //Exists by code student and book and book loan: Método para validar si existe un préstamo de un libro por un estudiante
    private void existsByCodeStudentAndBookAndBookLoan(Loan loan, Book book) {

        if (loanRepository.existsByCodeStudentAndBookAndBookLoan(loan.getCodeStudent(), book, true)) {

            throw new ValidationException("The loan already exists of book with id=" + book.getId() +
                    " by student code=" + loan.getCodeStudent());

        }

    }
}
