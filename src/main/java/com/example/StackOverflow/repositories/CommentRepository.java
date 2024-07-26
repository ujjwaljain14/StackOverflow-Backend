package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.models.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findAllByParentAndCommentType(UUID parent, CommentType commentType);
}
