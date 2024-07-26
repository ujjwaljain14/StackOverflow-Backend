package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.CommentDto;
import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.models.CommentType;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.repositories.CommentRepository;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService implements CommandLineRunner {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public Comment postComment(CommentDto commentDto) {

        User user = userRepository.findById(UUID.fromString(commentDto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        CommentType commentType = CommentType.valueOf(commentDto.getCommentType().toUpperCase());

        UUID parentId = UUID.fromString(commentDto.getParentId());

        Comment comment = Comment.builder()
                            .user(user)
                            .parent(parentId)
                            .commentType(commentType)
                            .text(commentDto.getText())
                            .build();

        commentRepository.save(comment);
        return comment;
    }

    public List<Comment> getComments(String commentId, String commentType) {

        return commentRepository.findAllByParentAndCommentType(
                                    UUID.fromString(commentId), CommentType.valueOf(commentType.toUpperCase())
                                );

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************Comment Service*************");
    }


}
