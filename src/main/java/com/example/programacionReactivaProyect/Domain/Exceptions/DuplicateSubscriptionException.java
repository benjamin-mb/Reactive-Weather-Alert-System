package com.example.programacionReactivaProyect.Domain.Exceptions;

public class DuplicateSubscriptionException extends RuntimeException {
    public DuplicateSubscriptionException(String message) {
        super(message);
    }
}
