package com.example.demo.exception;

import com.example.demo.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(UpdateException.class)
    public ResponseEntity<Object> exception(Exception e) {
   //  ErrorResponseDto errorResponseDto = new ErrorResponseDto();

     return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
 }
}
