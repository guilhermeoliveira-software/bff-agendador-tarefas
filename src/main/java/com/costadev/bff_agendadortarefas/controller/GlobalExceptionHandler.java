package com.costadev.bff_agendadortarefas.controller;

import com.costadev.bff_agendadortarefas.infrastructure.exceptions.ConflictException;
import com.costadev.bff_agendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.costadev.bff_agendadortarefas.infrastructure.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handlerConflictionException(ConflictException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handlerUnhathorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}