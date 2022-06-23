package com.example.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> handleNullPointerException() {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, "404", LocalDateTime.now(), "Location not available"));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException() {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, "404", LocalDateTime.now(), "Value not accepted, enter a valid value"));
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException() {
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "400", LocalDateTime.now(), "Incorrect URL, view valid endpoints at http://localhost:8080/swagger-ui.html"));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}