package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(max = 23 ,message = "Max Username length is 23 letters")
    private String username;
    @Column(nullable = false)
    @Size(min = 8,message = "Please make your password 8+ characters for security reasons.")
    private String password;

}
