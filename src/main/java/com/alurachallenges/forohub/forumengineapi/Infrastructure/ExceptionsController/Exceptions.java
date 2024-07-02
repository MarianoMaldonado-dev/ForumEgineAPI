package com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.ForumEngineExceptions;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ForumEngineExceptions> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ForumEngineExceptions forumEngineExceptions = new ForumEngineExceptions(
                HttpStatus.BAD_REQUEST,
                ex.getBindingResult().getFieldErrors().stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .collect(Collectors.joining(", ")),
                ex);
        return ResponseEntity.status(forumEngineExceptions.getStatus()).body(forumEngineExceptions);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ForumEngineExceptions> handleGlobalException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + ex.getMessage());
    }
}