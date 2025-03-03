package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {
    @NotNull(message = "Old password can't be null")
    @NotBlank(message = "Old password can't be null")

    private String oldPassword;
    @NotNull(message = "new password can't be null")
    @NotBlank(message = "new password can't be blank")
    @Size(min = 8,message = "new password must be minimum 8 characters")
    private String newPassword;
}
