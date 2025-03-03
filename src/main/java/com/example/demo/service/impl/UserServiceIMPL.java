package com.example.demo.service.impl;

import com.example.demo.config.CustomPasswordEncoder;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.UserAlreadyRegisteredException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;
    private final CustomPasswordEncoder customPasswordEncoder;

    public UserServiceIMPL(UserRepo userRepo, CustomPasswordEncoder customPasswordEncoder) {
        this.userRepo = userRepo;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Override
    public UserResponseDto registerUser(UserRegisterRequest user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new UserAlreadyRegisteredException("User already exists with username: " + user.getUsername());
        }
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(customPasswordEncoder.passwordEncoder().encode(user.getPassword()))
            ;

            newUser.setRole(Role.ROLE_USER);
        User user1 =userRepo.save(newUser);
            return new UserResponseDto(user1.getId(), user1.getUsername(),user1.getRole());
        } catch (Exception e) {
            throw new DatabaseException("cant save user" + e.getMessage());
        }
    }

    @Override
    public UserResponseDto deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepo.deleteById(user.getId());
        return new UserResponseDto(user.getId(), user.getUsername(),user.getRole());
    }
}
