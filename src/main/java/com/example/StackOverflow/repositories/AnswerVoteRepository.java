package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Answer;
import com.example.StackOverflow.models.AnswerVote;
import com.example.StackOverflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnswerVoteRepository extends JpaRepository<AnswerVote, UUID> {
    Optional<AnswerVote> findByUserAndAnswer(User user, Answer answer);
}
