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

public class AnswerVote extends BaseModel{

    @ManyToOne
    @JsonIgnoreProperties({"user"})
    private Answer answer;

    @ManyToOne
    @JsonIgnoreProperties({"answerVotes","questionVotes","commentVotes"})
    private User user;

    private VoteType voteType;
}
