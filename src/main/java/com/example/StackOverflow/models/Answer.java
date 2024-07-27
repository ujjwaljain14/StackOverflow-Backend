package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Answer extends BaseModel{

    @JsonIgnoreProperties("answers")
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Question question;

    @Column(nullable = false)
    private String text;

    @JsonIgnoreProperties({"questions", "comments", "answers","answerVotes","questionVotes","commentVotes"})
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "answer")
    @JsonIgnore
    private List<AnswerVote> answerVotes;

}
