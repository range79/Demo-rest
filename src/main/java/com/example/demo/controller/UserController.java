package com.example.demo.controller;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/user")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers() {

            return ResponseEntity.ok(userService.getAllUsers());

    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {

            return ResponseEntity.ok(userService.getUserById(id));

    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRegisterRequest user) {


        return ResponseEntity.ok(userService.registerUser(user));

    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long id) {

        return ResponseEntity.ok().body(userService.deleteUser(id));

    }
    @PatchMapping("/update/{id)")
    public ResponseEntity<UserResponseDto> updatePassword(
            @PathVariable Long id,
            @RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.ok().body(userService.changePassword(id,userRequestDto));

    }



}
