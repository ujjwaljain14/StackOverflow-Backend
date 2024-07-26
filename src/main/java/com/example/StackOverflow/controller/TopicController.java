package com.example.StackOverflow.controller;

import com.example.StackOverflow.models.Topic;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.services.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stackoverflow/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<?> addTopic(@RequestBody Topic topic){
        try{
            Topic t = topicService.addTopic(topic);
            return ResponseEntity.status(HttpStatus.CREATED).body(t);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTopics(){
        try{
            List<Topic> topics = topicService.getTopics();
            return ResponseEntity.ok().body(topics);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/like/{text}")
    public ResponseEntity<?> getTopicsLike(@PathVariable("text") String text){
        try{
            List<Topic> topics = topicService.getTopicsLike(text);
            return ResponseEntity.ok().body(topics);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
