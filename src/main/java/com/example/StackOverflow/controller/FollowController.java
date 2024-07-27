package com.example.StackOverflow.controller;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.services.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stackoverflow/users")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/{userId}/follow")
    public ResponseEntity<?> followUser(@PathVariable("userId") String userId, @RequestParam String targetUserId) {
        try {
            String message = followService.follow(userId, targetUserId);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/unfollow")
    public ResponseEntity<?> unfollowUser(@PathVariable("userId") String userId, @RequestParam String targetUserId) {
        try {
            String message = followService.unfollow(userId, targetUserId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{userId}/followings")
    public ResponseEntity<?> getFollowings(@PathVariable("userId") String userId) {
        try {

            List<User> followings = followService.getFollowings(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(followings);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{userId}/followers")
    public ResponseEntity<?> getFollowers(@PathVariable("userId") String userId) {
        try {
            List<User> followers = followService.getFollowers(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(followers);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
