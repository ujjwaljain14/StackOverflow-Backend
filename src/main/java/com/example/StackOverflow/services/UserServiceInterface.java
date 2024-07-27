package com.example.StackOverflow.services;

import com.example.StackOverflow.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {
    void createNewUser(User user);

    Optional<User> getUserById(UUID userId);

    Optional<User> updateUserById(Optional<User> user, User userUpdate);
}
