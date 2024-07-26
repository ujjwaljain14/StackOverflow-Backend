package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Answer;
import com.example.StackOverflow.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    List<Answer> findAllByQuestion(Question question);
}
