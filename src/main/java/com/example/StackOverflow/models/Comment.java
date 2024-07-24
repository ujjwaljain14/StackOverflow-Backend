package com.example.StackOverflow.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Comment extends BaseModel{

    @Column(nullable = false)
    private UUID parent;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommentType commentType;

}
