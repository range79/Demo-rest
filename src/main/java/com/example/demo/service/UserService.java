package com.example.demo.service;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponseDto;
import jakarta.validation.Valid;

public interface UserService {
    UserResponseDto registerUser(@Valid UserRegisterRequest user);
    UserResponseDto deleteUser(Long id);


}
