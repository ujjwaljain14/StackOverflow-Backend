package com.example.StackOverflow.controller;

import com.example.StackOverflow.dto.VoteDto;
import com.example.StackOverflow.models.AnswerVote;
import com.example.StackOverflow.models.CommentVote;
import com.example.StackOverflow.models.QuestionVote;
import com.example.StackOverflow.services.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stackoverflow/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/questions/{questionId}")
    public ResponseEntity<?> voteQuestion(@PathVariable String questionId, @RequestBody VoteDto voteDto) {
        try {
            QuestionVote vote = voteService.voteQuestion(questionId, voteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(vote);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/answers/{answerId}")
    public ResponseEntity<?> voteAnswer(@PathVariable String answerId, @RequestBody VoteDto voteDto) {
        try {
            AnswerVote vote = voteService.voteAnswer(answerId, voteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(vote);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/comments/{commentId}")
    public ResponseEntity<?> voteComment(@PathVariable String commentId, @RequestBody VoteDto voteDto) {
        try {
            CommentVote vote = voteService.voteComment(commentId, voteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(vote);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
