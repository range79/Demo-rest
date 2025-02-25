package com.example.demo.service;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    UserResponseDto getUserById(Long id);
    UserResponseDto registerUser(@Valid UserRegisterRequest user);
    UserResponseDto deleteUser(Long id);
    UserResponseDto changePassword(Long id,UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();

}
