package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//Rest Controller Advice: Es una anotación que permite manejar excepciones de manera global en todos los controladores.
//Sirve para centralizar el manejo de excepciones en un solo lugar y reutilizarlo en toda la aplicación.
@RestControllerAdvice
public class ControllerExceptionHandle {


    //ExceptionHandler: Es una anotación que permite manejar excepciones de un tipo específico.
    @ExceptionHandler(ResourceNotFoundException.class) //ResourceNotFoundException: Es una excepción personalizada que se lanza cuando un recurso no se encuentra en la base de datos.

    //ResponseStatus: Es una anotación que permite establecer el código de estado HTTP de la respuesta.
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;
    }

    //------------------------------------------------------------------------------------------------------------

    //ExceptionHandler: Es una anotación que permite manejar excepciones de un tipo específico.
    @ExceptionHandler(ValidationException.class) //ValidationException: Es una excepción personalizada que se lanza cuando se produce un error de validación en los datos de entrada.

    //ResponseStatus: Es una anotación que permite establecer el código de estado HTTP de la respuesta.
    @ResponseStatus(value= HttpStatus.BAD_REQUEST) //400
    public ErrorMessage validationException(ValidationException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;
    }


    //------------------------------------------------------------------------------------------------------------
    //ExceptionHandler: Es una anotación que permite manejar excepciones de un tipo específico.
    @ExceptionHandler(Exception.class) //Exception: Es una excepción genérica que se lanza cuando ocurre un error inesperado en la aplicación.

    //ResponseStatus: Es una anotación que permite establecer el código de estado HTTP de la respuesta.
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR) //500
    public ErrorMessage exception(Exception ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;
    }
}
