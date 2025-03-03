package com.example.demo.service.impl;

import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UpdateException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UpdateUserService;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {
    private final UserRepo userRepo;
    public UpdateUserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User findUser =userRepo.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));

        if(findUser.getPassword().equals(userRequestDto.getPassword())){

            try {
                findUser.setUsername(userRequestDto.getUsername());
                findUser.setPassword(userRequestDto.getNewPassword());

                userRepo.save(findUser);
                return new UserResponseDto(findUser.getId(),findUser.getUsername(),findUser.getRole());
            }catch (Exception e){
                throw new UpdateException(e.getMessage());
            }

        }
        else {
            return new UserResponseDto(findUser.getId(),findUser.getUsername(),findUser.getRole());
        }
    }

    @Override
    public UserResponseDto changePassword(Long id, ChangePasswordDto changePasswordDto) {
        User user =userRepo.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
        if(!user.getPassword().equalsIgnoreCase(changePasswordDto.getOldPassword()))
        {
            throw new UpdateException("old password does not match");
        }
        else {
            //change password if old password is true

            user.setPassword(changePasswordDto.getNewPassword());
            userRepo.save(user);
            return new UserResponseDto(user.getId(),user.getUsername(),user.getRole());
        }
    }
    }

