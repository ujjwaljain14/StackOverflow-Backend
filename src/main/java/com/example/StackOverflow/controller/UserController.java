package com.example.StackOverflow.controller;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stackoverflow/users")
public class UserController {

    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody User user){
//        System.out.println(user.getId() + " " + user.getCreatedAt() + " " + user.getUpdatedAt() + " " + user.getUsername() + " " + user.getEmail() + " " + user.getBio());
        try{
            userService.createNewUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId){
        try{
            UUID uuid = UUID.fromString(userId);
            System.out.println(uuid.toString());
            Optional<User> user = userService.getUserById(UUID.fromString(userId));
            if(user.isPresent()){
                return ResponseEntity.ok().body(user);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // not working properly

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUserById(@PathVariable("userId") String userId, @RequestBody(required = false) User updateUser){
        try{
            UUID uuid = UUID.fromString(userId);
            Optional<User> user = userService.getUserById(UUID.fromString(userId));
            if(user.isPresent()){
                user = userService.updateUserById(user,updateUser);
                return ResponseEntity.ok().body(user);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
