package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.AnswerDto;
import com.example.StackOverflow.models.*;
import com.example.StackOverflow.repositories.AnswerRepository;
import com.example.StackOverflow.repositories.QuestionRepository;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerService implements CommandLineRunner {

    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;


    public AnswerService(AnswerRepository answerRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public Answer postAnswer(String questionId, AnswerDto answerDto) {

        User user = userRepository.findById(UUID.fromString(answerDto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Question question = questionRepository.findById(UUID.fromString(questionId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));

        Answer answer = Answer.builder()
                .question(question)
                .text(answerDto.getText())
                .user(user)
                .build();
        answer.getQuestion().setQuestionStatus(QuestionStatus.ANSWERED);
        answerRepository.save(answer);

        return answer;
    }

    public List<Answer> getAnswers(String questionId) {
        Question question = questionRepository.findById(UUID.fromString(questionId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));

        return answerRepository.findAllByQuestion(question);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************Answer Service*************");
    }
}
