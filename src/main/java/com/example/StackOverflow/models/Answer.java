package com.example.StackOverflow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Answer extends BaseModel{

    @Column(nullable = false,unique = true)
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Question question;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private User user;

}
