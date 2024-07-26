package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    public List<Topic> findAllByNameStartsWith(String text);
}
