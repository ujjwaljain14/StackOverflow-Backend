package com.example.StackOverflow.repositories;

import com.example.StackOverflow.models.Question;
import com.example.StackOverflow.models.QuestionStatus;
import com.example.StackOverflow.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {
    public List<Question> findAllQuestionsByQuestionStatus(QuestionStatus status);

    public List<Question> findAllByTitleContaining(String title);

    public List<Question> findAllByTopicsContaining(Topic topic);

//    @Query("SELECT q FROM Question q JOIN q.topics t WHERE q.title LIKE %:title%")
//    public List<Question> findAllByTitleContainingOrTopicsContaining(String title);

    public List<Question>  findAllQuestionsByTitleOrTopicsContaining(String title, Topic topic);


}
