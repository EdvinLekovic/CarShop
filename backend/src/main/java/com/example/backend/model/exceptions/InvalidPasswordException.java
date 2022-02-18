package com.example.backend.model.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(){
        super("You enter invalid password. Please try again");
    }
}
