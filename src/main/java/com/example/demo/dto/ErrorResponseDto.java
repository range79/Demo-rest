package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private LocalTime time;
}
