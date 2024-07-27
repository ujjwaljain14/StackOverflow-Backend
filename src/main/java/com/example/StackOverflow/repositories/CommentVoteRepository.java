package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.models.CommentVote;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.models.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentVoteRepository extends JpaRepository<CommentVote, UUID> {
    Optional<CommentVote> findByUserAndComment(User user, Comment comment);

    Long countByVoteTypeAndComment(VoteType voteType, Comment comment);
}
