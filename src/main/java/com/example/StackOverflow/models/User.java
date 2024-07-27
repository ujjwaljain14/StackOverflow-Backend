package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    private String bio;

    @JsonIgnoreProperties("user")
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

    @JsonIgnoreProperties("user")
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnoreProperties("user")
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<AnswerVote> answerVotes;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<QuestionVote> questionVotes;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<CommentVote> commentVotes;

}
