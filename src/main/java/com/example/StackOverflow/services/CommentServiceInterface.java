package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.CommentDto;
import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.repositories.CommentRepository;
import com.example.StackOverflow.repositories.UserRepository;

import java.util.List;

public interface CommentServiceInterface {

    Comment postComment(CommentDto commentDto);

    List<Comment> getComments(String commentId, String commentType);
}
