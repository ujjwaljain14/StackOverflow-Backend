package com.example.StackOverflow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Vote extends BaseModel{

    @Column(nullable = false)
    private Integer upVotes;

    @Column(nullable = false)
    private Integer downVotes;

    @Column(nullable = false)
    private VoteType voteType;

    @Column(nullable = false, unique = true)
    private UUID voteId;

}

