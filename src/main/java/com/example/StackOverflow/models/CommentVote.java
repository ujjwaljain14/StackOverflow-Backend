package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CommentVote extends BaseModel {

    @ManyToOne
    @JsonIgnoreProperties({"user"})
    private Comment comment;

    @ManyToOne
    @JsonIgnoreProperties({"answerVotes","questionVotes","commentVotes"})
    private User user;

    private VoteType voteType;
}
