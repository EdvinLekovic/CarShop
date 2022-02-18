package com.example.backend.model.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Car with " + id + "not found");
    }
}
