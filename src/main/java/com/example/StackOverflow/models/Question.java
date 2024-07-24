package com.example.StackOverflow.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseModel{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;
    @ManyToMany
    @JoinTable(
           name = "question_tags",
           joinColumns = @JoinColumn(name = "question_id"),
           inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
}
