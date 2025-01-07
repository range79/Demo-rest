package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.IMPL.UserServiceIMPL;
import com.example.demo.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/user")
public class UserController {

    private final UserServiceIMPL userServiceIMPL;

    public UserController( UserServiceIMPL userServiceIMPL) {
        this.userServiceIMPL = userServiceIMPL;
    }

    @GetMapping("/users")
    public Object getUsers() {
        try{
            return ResponseEntity.ok(userServiceIMPL.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        try{
            return userServiceIMPL.getUserById(id);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/user-role/{Role}")
    public Object getUserByRole(@PathVariable String Role) {
        return null;
    }


    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try{
            userServiceIMPL.registerUser(user);
            return ResponseEntity.ok("user created");
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        try{
            userServiceIMPL.deleteUser(id);
            return ResponseEntity.ok().body("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PatchMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        try{
            userServiceIMPL.updateUser(user);
            return ResponseEntity.ok().body("User updated successfully");
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
