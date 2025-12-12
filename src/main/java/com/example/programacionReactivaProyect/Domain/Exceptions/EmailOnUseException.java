package com.example.programacionReactivaProyect.Domain.Exceptions;

public class EmailOnUseException extends RuntimeException {
    public EmailOnUseException(String message) {
        super(message);
    }
}
