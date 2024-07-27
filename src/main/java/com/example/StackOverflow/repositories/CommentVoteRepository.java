package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.models.CommentVote;
import com.example.StackOverflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CommentVoteRepository extends JpaRepository<CommentVote, UUID> {
    Optional<CommentVote> findByUserAndComment(User user, Comment comment);
}
