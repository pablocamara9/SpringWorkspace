package com.example.monumentos.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(MonumentoNotFoundException.class)
    public ProblemDetail handleProductNotFound(MonumentoNotFoundException ex) {

        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Monumento no encontrado");
        result.setType(URI.create("https://www.salesianos-triana/errors/product-not-found"));
        result.setProperty("author", "Don Bosco");
        return result;
    }

}
