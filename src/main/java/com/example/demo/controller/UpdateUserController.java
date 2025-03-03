package com.example.demo.controller;

import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UpdateUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "update-user",description = "update user's password or update user object")
@RestController
@RequestMapping("/user")
public class UpdateUserController {
private final UpdateUserService updateUserService;
public UpdateUserController(UpdateUserService updateUserService) {
    this.updateUserService = updateUserService;
}



    @PatchMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updatePassword(
            @PathVariable Long id,
            @RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.ok().body(updateUserService.updateUser(id,userRequestDto));

    }

    @PatchMapping("/changePassword/{id}")
    public ResponseEntity<UserResponseDto> changePassword(@PathVariable Long id, @RequestBody @Valid ChangePasswordDto changePasswordDto) {
        return ResponseEntity.ok().body(updateUserService.changePassword(id,changePasswordDto));
    }
}
