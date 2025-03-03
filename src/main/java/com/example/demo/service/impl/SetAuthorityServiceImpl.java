package com.example.demo.service.impl;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.SetAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class SetAuthorityServiceImpl implements SetAuthorityService {
    private final UserRepo userRepo;
    public SetAuthorityServiceImpl(UserRepo userRepo) {this.userRepo = userRepo;}


    @Override
    public UserResponseDto setModerator(Long id) {

        User user=  userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
        user.setRole(Role.ROLE_MODERATOR);
        return new UserResponseDto(user.getId(),user.getUsername(),user.getRole());

    }

    @Override
    public UserResponseDto setAdmin(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
        user.setRole(Role.ROLE_ADMIN);


        return new UserResponseDto(user.getId(),user.getUsername(),user.getRole());
    }






}

