package com.example.demo.controller;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/user")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public Object getUsers() {
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(userService.getUserById(id));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRegisterRequest user) {


        return ResponseEntity.ok(userService.registerUser(user));

    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok().body(userService.deleteUser(id));

    }
    @PatchMapping("/update")
    public ResponseEntity<Object> updatePassword(@RequestBody @Valid UserRequestDto userRequestDto) {


        userService.changePassword(userRequestDto);

        return ResponseEntity.ok().body(userService.changePassword(userRequestDto));

    }



}
