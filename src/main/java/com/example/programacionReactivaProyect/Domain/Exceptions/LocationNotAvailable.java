package com.example.programacionReactivaProyect.Domain.Exceptions;

public class LocationNotAvailable extends RuntimeException {
    public LocationNotAvailable(String message) {
        super(message);
    }
}
