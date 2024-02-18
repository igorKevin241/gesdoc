package com.igor.gesdoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<CodeErreur> notFound(EntityNotFoundException exception){
        return new ResponseEntity<>(new CodeErreur(404,exception.getMessage()), HttpStatus.NOT_FOUND);

    }
}
