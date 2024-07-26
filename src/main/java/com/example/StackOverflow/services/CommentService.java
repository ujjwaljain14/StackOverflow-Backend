package com.example.StackOverflow.services;

import com.example.StackOverflow.repositories.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CommandLineRunner {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************Comment Service*************");
    }

}
