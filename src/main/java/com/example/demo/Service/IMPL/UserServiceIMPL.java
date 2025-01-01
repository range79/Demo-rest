package com.example.demo.Service.IMPL;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    private UserRepo userRepo;

    public UserServiceIMPL(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));

    }

    @Override
    public User registerUser(User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }

        return userRepo.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        userRepo.deleteById(user.getId());
        return "user with "+user.getId()+" id deleted";
    }

    @Override
    public String updateUser(User user) {
        User exitinguser = userRepo.findById(user.getId()).orElseThrow(()->new RuntimeException("user not found"));
        exitinguser.setUsername(user.getUsername());
        exitinguser.setPassword(user.getPassword());
        return "User with "+exitinguser.getId()+" id updated";

    }

    @Override
    public List<User> getAllUsers() {
        if (userRepo.findAll().isEmpty()) {
            throw new RuntimeException("user not found");
        }else {
            return userRepo.findAll();
        }
    }


}
