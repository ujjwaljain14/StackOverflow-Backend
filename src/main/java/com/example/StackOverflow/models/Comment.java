package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @OneToMany(mappedBy = "comment")
    @JsonIgnore
    private List<CommentVote> commentVotes;

}
