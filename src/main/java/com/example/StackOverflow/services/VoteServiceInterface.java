package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.VoteDto;
import com.example.StackOverflow.models.*;

public interface VoteServiceInterface {
    void updateVotesOnAnswer(Answer answer);

    void updateVotesOnQuestion(Question question);

    void updateVotesOnComment(Comment comment);

    QuestionVote voteQuestion(String questionId, VoteDto voteDto);

    AnswerVote voteAnswer(String answerId, VoteDto voteDto);

    CommentVote voteComment(String commentId, VoteDto voteDto);
}
