package com.example.StackOverflow.services;

import com.example.StackOverflow.models.Topic;
import com.example.StackOverflow.repositories.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements CommandLineRunner {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic addTopic(Topic topic) {
        topicRepository.save(topic);
        return topicRepository.getReferenceById((topic.getId()));
    }

    public List<Topic> getTopics() {
        return topicRepository.findAll(
                Sort.by(Sort.Direction.ASC,"name")
            );
    }

    public List<Topic> getTopicsLike(String text) {
        return topicRepository.findAllByNameStartsWith(text);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************Topic Service**************");
    }
}
