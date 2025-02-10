package com.example.demo.service.IMPL;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.exception.UpdateException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;

    public UserServiceIMPL(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));

    }

    @Override
    public User registerUser(User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }

        return userRepo.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        userRepo.deleteById(user.getId());
        return "user with "+user.getId()+" id deleted";
    }

    @Override
    public String changePassword(UserRequestDto userRequestDto) {
   User findUser =userRepo.findById(userRequestDto.getId()).orElseThrow(()->new RuntimeException("user not found"));

   if(findUser.getPassword().equals(userRequestDto.getPassword())
           &&findUser.getUsername().equals(userRequestDto.getUsername())){

       try {
           findUser.setPassword(userRequestDto.getNewPassword());

           userRepo.save(findUser);
           return "User "+findUser.getUsername()+" password changed";
       }catch (Exception e){
           throw new UpdateException(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

   }
   else {
       throw new UpdateException("Password does not match", HttpStatus.BAD_REQUEST);
   }
    }

    @Override
    public List<User> getAllUsers() {
        if (userRepo.findAll().isEmpty()) {
            throw new RuntimeException("user not found");
        }else {
            return userRepo.findAll();
        }
    }


}
