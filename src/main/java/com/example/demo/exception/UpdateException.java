package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class UpdateException extends RuntimeException {

  public UpdateException(String message) {
        super("can't update User " + message);

    }
}
