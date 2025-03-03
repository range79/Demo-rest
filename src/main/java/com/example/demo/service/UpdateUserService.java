package com.example.demo.service;

import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;

public interface UpdateUserService {
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    UserResponseDto changePassword(Long id, ChangePasswordDto changePasswordDto);
}
