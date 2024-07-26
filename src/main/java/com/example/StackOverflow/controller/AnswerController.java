package com.example.StackOverflow.controller;

import com.example.StackOverflow.dto.AnswerDto;
import com.example.StackOverflow.models.Answer;
import com.example.StackOverflow.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stackoverflow/answers")

public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/questions/{questionId}")
    public ResponseEntity<?> postAnswer(@PathVariable("questionId") String questionId, @RequestBody AnswerDto answerDto){

        try{
            Answer answer = answerService.postAnswer(questionId, answerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(answer);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/questions/{questionId}")
    public ResponseEntity<?> getAnswers(@PathVariable("questionId") String questionId){
        try{
            List<Answer> answers = answerService.getAnswers(questionId);
            return ResponseEntity.status(HttpStatus.CREATED).body(answers);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<?> editAnswer(@PathVariable("answerId") String answerId, @RequestBody AnswerDto answerDto){
        try{
            Answer answer = answerService.editAnswer(answerId,answerDto);
            return ResponseEntity.ok().body(answer);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
