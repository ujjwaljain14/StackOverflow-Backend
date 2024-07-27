package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

public class QuestionVote extends BaseModel{

    @JsonIgnoreProperties({"user","answers","topics"})
    @ManyToOne
    private Question question;

    @JsonIgnoreProperties({"answerVotes","questionVotes","commentVotes"})
    @ManyToOne
    private User user;

    private VoteType voteType;

}
