package com.example.StackOverflow.controller;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stackoverflow")
public class UserController {
    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody User user){
//        System.out.println(user.getId() + " " + user.getCreatedAt() + " " + user.getUpdatedAt() + " " + user.getUsername() + " " + user.getEmail() + " " + user.getBio());
        try{
            userService.createNewUser(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

}
