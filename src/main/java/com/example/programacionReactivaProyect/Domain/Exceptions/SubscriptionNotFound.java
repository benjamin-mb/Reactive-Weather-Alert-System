package com.example.programacionReactivaProyect.Domain.Exceptions;

public class SubscriptionNotFound extends RuntimeException {
    public SubscriptionNotFound(String message) {
        super(message);
    }
}
