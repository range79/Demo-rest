package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super("User not found: " + message);
  }
}
