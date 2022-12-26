package com.excercise.productservice.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request){
        ex.printStackTrace();
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Internal server error");
        return message;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ErrorMessage ArithmeticExceptionExceptionHandler(ArithmeticException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Tinh ngu 123");
        return message;
    }

    @ExceptionHandler(CommonBusinessException.class)
    public ErrorMessage commonBusinessExceptionHandler(Exception ex, WebRequest request){
        ex.printStackTrace();
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Internal server error");
        return message;
    }
}
