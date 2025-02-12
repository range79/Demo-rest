package com.example.demo.service.IMPL;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.UpdateException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
@Service
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;

    public UserServiceIMPL(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));

    }

    @Override
    public UserResponseDto registerUser( UserRegisterRequest user) {


        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            userRepo.save(newUser);
            return new UserResponseDto(newUser.getId(),user.getUsername());
        }catch (Exception e){
            throw new DatabaseException("cant save user"+e.getMessage());
        }


    }

    @Override
    public UserResponseDto deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
        userRepo.deleteById(user.getId());
        return new UserResponseDto(user.getId(),user.getUsername());
    }

    @Override
    public UserResponseDto changePassword(UserRequestDto userRequestDto) {
        User findUser =userRepo.findById(userRequestDto.getId()).orElseThrow(()->new UserNotFoundException("user not found"));

        if(findUser.getPassword().equals(userRequestDto.getPassword())
                &&findUser.getUsername().equals(userRequestDto.getUsername())){

            try {
                findUser.setPassword(userRequestDto.getNewPassword());

                userRepo.save(findUser);
                return new UserResponseDto(findUser.getId(),findUser.getUsername());
            }catch (Exception e){
                throw new UpdateException(e.getMessage());
            }

        }
        else {
            return new UserResponseDto(findUser.getId(),findUser.getUsername());
        }
    }

    @Override
    public List<User> getAllUsers() {
        if (userRepo.findAll().isEmpty()) {
            throw new UserNotFoundException("users not found");
        }else {
            return userRepo.findAll();
        }
    }


}
