package com.example.StackOverflow.services;

import com.example.StackOverflow.models.User;

import java.util.List;

public interface FollowServiceInterface {
    void updateFollowingCount(User user);

    void updateFollowerCount(User user);

    String follow(String userId, String targetUserId);

    String unfollow(String userId, String targetUserId);

    List<User> getFollowings(String userId);

    List<User> getFollowers(String userId);
}
