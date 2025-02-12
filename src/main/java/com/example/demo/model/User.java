package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Username can;t be null")
    @Size(max = 23 ,message = "Max Username length is 23 letters")
    private String username;
    @Column(nullable = false)
    @Size(min = 8,message = "Please make your password 8+ characters for security reasons.")
    @NotBlank(message = "Password can't be blank")
    @NotNull(message = "Password can't be null")
    @Valid
    private String password;

}
