package com.example.StackOverflow.services;

import com.example.StackOverflow.models.Topic;

import java.util.List;

public interface TopicServiceInterface {
    Topic addTopic(Topic topic);

    List<Topic> getTopics();

    List<Topic> getTopicsLike(String text);
}
