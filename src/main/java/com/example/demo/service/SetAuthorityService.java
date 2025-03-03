package com.example.demo.service;

import com.example.demo.dto.UserResponseDto;

public interface SetAuthorityService {
    UserResponseDto setModerator(Long id);
    UserResponseDto setAdmin(Long id);

}
