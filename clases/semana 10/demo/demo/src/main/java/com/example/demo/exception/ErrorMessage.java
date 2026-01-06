package com.example.demo.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private int satatusCode; //codigo de estado http de errores 404, 500, 200
    private String message; //mensaje de error
    private String description; //descripcion del error

    //formato de fecha y hora
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp; //fecha y hora del error
}
