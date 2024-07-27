package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Answer;
import com.example.StackOverflow.models.AnswerVote;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.models.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerVoteRepository extends JpaRepository<AnswerVote, UUID> {
    Optional<AnswerVote> findByUserAndAnswer(User user, Answer answer);

    Long countByVoteTypeAndAnswer(VoteType voteType, Answer answer);
}
