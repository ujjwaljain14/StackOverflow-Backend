package com.example.StackOverflow.services;

import com.example.StackOverflow.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

}
