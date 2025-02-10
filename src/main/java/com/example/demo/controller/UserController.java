package com.example.demo.controller;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
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


    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        try{
            userService.registerUser(user);
            return ResponseEntity.ok("user created");
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUser(id);

            return ResponseEntity.ok().body("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PatchMapping
    public ResponseEntity<Object> updatePassword(@RequestBody UserRequestDto userRequestDto) {
        try{

            userService.changePassword(userRequestDto);

            return ResponseEntity.ok().body(userService.changePassword(userRequestDto));
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
