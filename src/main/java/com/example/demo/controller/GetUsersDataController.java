package com.example.demo.controller;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.GetUserDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "get-users",description = "this controller get Users info except password")
@RestController
@RequestMapping("/getUSer")
public class GetUsersDataController {
    private GetUserDataService getUserDataService;
    public GetUsersDataController(GetUserDataService getUserDataService) {
        this.getUserDataService = getUserDataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(getUserDataService.getUserById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok().body(getUserDataService.getUsers());
    }
}
