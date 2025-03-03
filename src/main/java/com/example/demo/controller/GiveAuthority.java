package com.example.demo.controller;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.SetAuthorityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Auth-user", description = "Give roles to users for moderation")
@RestController
public class GiveAuthority {
    private final SetAuthorityService setAuthorityService;
    public GiveAuthority(SetAuthorityService setAuthorityService) {
        this.setAuthorityService = setAuthorityService;
    }
    @PreAuthorize("ROLE_KING")
    @PatchMapping("/set-admin/{id}")
    public ResponseEntity<UserResponseDto> giveAdmin(@PathVariable Long id)
    {
        return ResponseEntity.ok(setAuthorityService.setAdmin(id));
    }
    @PreAuthorize("ROLE_ADMIN")
    @PatchMapping("/set-moderator/{id}")
    public ResponseEntity<UserResponseDto> giveModerator(@PathVariable Long id)
    {
        return ResponseEntity.ok(setAuthorityService.setModerator(id));
    }




}
