package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Question;
import com.example.StackOverflow.models.QuestionVote;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.models.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QuestionVoteRepository extends JpaRepository<QuestionVote, UUID> {
    Optional<QuestionVote> findByUserAndQuestion(User user, Question question);

    Long countByVoteTypeAndQuestion(VoteType voteType, Question question);
}
