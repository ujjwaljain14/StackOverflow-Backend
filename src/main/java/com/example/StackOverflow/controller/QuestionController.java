package com.example.StackOverflow.controller;

import com.example.StackOverflow.dto.QuestionDto;
import com.example.StackOverflow.models.Question;
import com.example.StackOverflow.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stackoverflow/questions")
public class QuestionController {

    QuestionService questionService;

    QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<?> createNewQuestion(@RequestBody QuestionDto questionDto){
        try{
            System.out.println(questionDto.toString());
            Question question = questionService.createNewQuestion(questionDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(question);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getQuestionsByStatus(@RequestParam(name = "status") String status){
        try {
            List<Question> questions = questionService.getQuestionsByStatus(status);
            return ResponseEntity.ok().body(questions);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/users/{userId}/followings")
    public ResponseEntity<?> getQuestionsByFollowing(@PathVariable(name = "userId") String userId){
        try {
            List<Question> questions = questionService.getQuestionsByFollowing(userId);
            return ResponseEntity.ok().body(questions);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchQuestions(@RequestParam(name = "title",required = false) String title, @RequestParam(name = "topicId",required = false) String topicId){
        try {
            List<Question> questions = questionService.searchQuestions(title,topicId);
            return ResponseEntity.ok().body(questions);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
