package com.example.StackOverflow.services;

import com.example.StackOverflow.models.User;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FollowService implements CommandLineRunner, FollowServiceInterface {

    private final UserRepository userRepository;

    public FollowService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateFollowingCount(User user){
        user.setFollowingCount((long) user.getFollowing().size());
        userRepository.save(user);
    }

    @Override
    public void updateFollowerCount(User user){
        user.setFollowingCount((long) user.getFollower().size());
        userRepository.save(user);
    }

    @Override
    public String follow(String userId, String targetUserId){
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        User targetUser = userRepository.findById(UUID.fromString(targetUserId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid follow user ID"));


        List<User> followings = user.getFollowing();
        if(followings.contains(targetUser)){
            return "User Already Followed";
        }
        followings.add(targetUser);
        user.setFollowing(followings);
        userRepository.save(user);

        List<User> followers = targetUser.getFollower();
        followers.add(user);
        targetUser.setFollower(followers);
        userRepository.save(targetUser);

        updateFollowerCount(targetUser);
        updateFollowingCount(user);

        return "User Followed";
    }

    @Override
    public String unfollow(String userId, String targetUserId){
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        User targetUser = userRepository.findById(UUID.fromString(targetUserId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid follow user ID"));

        List<User> followings = user.getFollowing();
        if(!followings.contains(targetUser)){
            return "User Already Not Followed";
        }
        followings.remove(targetUser);
        user.setFollowing(followings);
        userRepository.save(user);

        List<User> followers = targetUser.getFollower();
        followers.remove(user);
        targetUser.setFollower(followers);
        userRepository.save(targetUser);

        updateFollowerCount(targetUser);
        updateFollowingCount(user);

        return "User Unfollowed";
    }

    @Override
    public List<User> getFollowings(String userId) {
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        return user.getFollowing();
    }

    @Override
    public List<User> getFollowers(String userId) {
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        return user.getFollower();
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************Follow Service*************");

    }

}
