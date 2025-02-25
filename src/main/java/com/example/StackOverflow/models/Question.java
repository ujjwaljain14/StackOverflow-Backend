package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)


public class Question extends BaseModel{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("questions")
    @JoinTable(
           name = "question_tags",
           joinColumns = @JoinColumn(name = "question_id"),
           inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics;

    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;

    @JsonIgnoreProperties({"questions","comments","answers"})
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @JsonIgnoreProperties("question")
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private List<QuestionVote> questionVotes;

    @Builder.Default
    private Long upvote = 0L;

    @Builder.Default
    private Long downvote = 0L;

}
