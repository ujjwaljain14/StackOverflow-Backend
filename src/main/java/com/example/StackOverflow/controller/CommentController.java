package com.example.StackOverflow.controller;

import com.example.StackOverflow.dto.CommentDto;
import com.example.StackOverflow.models.Comment;
import com.example.StackOverflow.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stackoverflow/comments")

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> postComment(@RequestBody CommentDto commentDto){
        try{
            Comment comment = commentService.postComment(commentDto);
            return ResponseEntity.ok().body(comment);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<?> getComments(@PathVariable("parentId") String commentId,@RequestParam("commentType") String commentType){
        try{
            List<Comment> comments = commentService.getComments(commentId,commentType);
            return ResponseEntity.ok().body(comments);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
