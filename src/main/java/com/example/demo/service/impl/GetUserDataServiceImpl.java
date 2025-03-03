package com.example.demo.service.impl;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.GetUserDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GetUserDataServiceImpl implements GetUserDataService {
    private final UserRepo userRepo;
    public GetUserDataServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        if (userRepo.findAll().isEmpty()) {
            throw new UserNotFoundException("users not found");
        }else {
            return userRepo.findAll().stream().map(user-> new UserResponseDto(user.getId()
                    ,user.getUsername(),user.getRole())).collect(Collectors.toList());
        }
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return UserMapper.toUserResponseDto(userRepo.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not found")));
    }


}
