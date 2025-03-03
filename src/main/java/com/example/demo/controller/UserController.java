package com.example.demo.controller;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "register-delete",description = "this controller for registering and delete user's" +
        "only moderator or admin can use delete endpoint")
@RestController
@RequestMapping( "/user")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRegisterRequest user) {


        return ResponseEntity.ok(userService.registerUser(user));

    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long id) {

        return ResponseEntity.ok().body(userService.deleteUser(id));

    }





}
