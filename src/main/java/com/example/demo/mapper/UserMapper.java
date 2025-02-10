package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.model.User;

public class UserMapper {


public static User toEntity(UserRequestDto userRequestDto) {
    return User.builder().id(userRequestDto.getId()).username(userRequestDto.getUsername()).password(userRequestDto.getPassword()).build();
}

}
