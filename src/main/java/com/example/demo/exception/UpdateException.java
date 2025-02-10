package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class UpdateException extends RuntimeException {
  private final HttpStatus status;
  public UpdateException(String message, HttpStatus status) {
        super("can't update User " + message);
        this.status = status;
    }
}
