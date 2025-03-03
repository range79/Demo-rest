package com.example.demo.service;

import com.example.demo.dto.UserResponseDto;

import java.util.List;

public interface GetUserDataService {
    List<UserResponseDto> getUsers();
    UserResponseDto getUserById(Long id);
}
