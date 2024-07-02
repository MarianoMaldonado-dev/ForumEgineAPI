package com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

class ForumEngineExceptions {
    private final HttpStatus status;
    private final String message;
    private final LocalDateTime timestamp;

    public ForumEngineExceptions(HttpStatus status, String message, MethodArgumentNotValidException e) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // HTTP Getter
    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}