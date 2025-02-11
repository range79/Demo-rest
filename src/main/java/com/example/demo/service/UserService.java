package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    UserResponseDto registerUser(User user);
    UserResponseDto deleteUser(Long id);
    UserResponseDto changePassword(UserRequestDto userRequestDto);
    List<User> getAllUsers();

}
