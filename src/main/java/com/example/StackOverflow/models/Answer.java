package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Answer extends BaseModel{

    @JsonIgnoreProperties("answers")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Question question;

    @Column(nullable = false)
    private String text;

    @JsonIgnoreProperties({"questions", "comments", "answers"})
    @ManyToOne
    private User user;

}
