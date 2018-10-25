package com.ttn.spring.RestSpringExercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentException extends RuntimeException {
    public StudentException(String message) {
        super(message);
    }
}
