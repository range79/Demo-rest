package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;

public class UserMapper {


public static User toEntity(UserRequestDto userRequestDto) {
  User user = new User();
  user.setUsername(userRequestDto.getUsername());
  user.setPassword(userRequestDto.getPassword());
  return user;
}
public static UserResponseDto toUserResponseDto(User user) {
    UserResponseDto userResponseDto = new UserResponseDto(user.getId(), user.getUsername());
    return userResponseDto;
}

}
