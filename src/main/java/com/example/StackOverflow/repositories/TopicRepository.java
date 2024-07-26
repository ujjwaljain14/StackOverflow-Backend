package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {
    public List<Topic> findAllByNameStartsWith(String text);
}
