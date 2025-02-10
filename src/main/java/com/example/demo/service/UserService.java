package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User registerUser(User user);
    String deleteUser(Long id);
    String changePassword(UserRequestDto userRequestDto);
    List<User> getAllUsers();

}
