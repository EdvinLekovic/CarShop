package com.example.backend.model.exceptions;

public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException() {
        super("The username you entered is not valid.");
    }
}
