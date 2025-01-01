package com.example.demo.Service;

import com.example.demo.Model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User registerUser(User user);
    String deleteUser(Long id);
    String updateUser(User user);
    List<User> getAllUsers();

}
