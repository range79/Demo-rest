package com.example.demo.service;

import com.example.demo.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailService implements UserDetailsService {
    private UserRepo userRepo;
    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userRepo.existsByUsername(username)==false) {
            throw new UsernameNotFoundException(username);
        }
        else {
            return userRepo.getUserByUsername(username);
        }

    }
}
