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

    @Column
    private List<Topic> topics = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;

    @Column(nullable = false)
    @ManyToOne
    private User user;
}
