package com.example.StackOverflow.services;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements CommandLineRunner,UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewUser(User user){
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID userId){
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> updateUserById(Optional<User> user, User userUpdate){

        System.out.println("we are in here");
        if(userUpdate.getBio() != null) {
            user.get().setBio(userUpdate.getBio());
            System.out.println("hwre i come");
        }
        if(userUpdate.getEmail() != null) {
            user.get().setEmail(userUpdate.getEmail());
        }
        if(userUpdate.getUsername() != null) {
            user.get().setUsername(userUpdate.getUsername());
        }

        System.out.println("we are out of here---------------------------");

        return user;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************User Service***************");
    }
}
