package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);

    UserDetails getUserByUsername(@NotNull(message = "Username can;t be null") @Size(max = 23 ,message = "Max Username length is 23 letters") String username);
}
