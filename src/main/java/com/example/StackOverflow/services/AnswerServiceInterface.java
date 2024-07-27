package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.AnswerDto;
import com.example.StackOverflow.models.Answer;

import java.util.List;

public interface AnswerServiceInterface {
    Answer postAnswer(String questionId, AnswerDto answerDto);

    List<Answer> getAnswers(String questionId);

    Answer editAnswer(String answerId, AnswerDto answerDto);
}
