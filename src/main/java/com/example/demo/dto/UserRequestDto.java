package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "ID can't be blank")
    @NotNull(message = "ID can't be null")
    private Long id;
    @NotBlank(message = "Username can't be blank")
    @NotNull(message = "Username can't be null")
    private String username;
    @NotNull(message = "Password can't be null")
    @NotBlank(message = "Password can't be blank")
    private String password;
    @Size(min = 8,message = "For security reasons new password must be 8 characters")
    private String newPassword;


}
