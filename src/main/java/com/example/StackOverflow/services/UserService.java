package com.example.StackOverflow.services;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserById(UUID userId){
        return userRepository.findById(userId);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************************");
    }
}
