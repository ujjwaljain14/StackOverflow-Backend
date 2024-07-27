package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.QuestionDto;
import com.example.StackOverflow.models.Question;

import java.util.List;

public interface QuestionServiceInterface {
    Question createNewQuestion(QuestionDto questionDto);

    List<Question> getQuestionsByStatus(String status);

    List<Question> getQuestionsByFollowing(String userId);

    List<Question> searchQuestions(String title, String topicId);
}
