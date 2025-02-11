package com.example.demo.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super("Database error: " + message);
    }

}
