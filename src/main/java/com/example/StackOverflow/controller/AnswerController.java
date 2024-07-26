package com.example.StackOverflow.controller;

import com.example.StackOverflow.dto.AnswerDto;
import com.example.StackOverflow.models.Answer;
import com.example.StackOverflow.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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



}
