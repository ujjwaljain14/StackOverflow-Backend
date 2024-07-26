package com.example.StackOverflow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

public class Topic extends BaseModel{

    @Column(unique = true,nullable = false)
    private String name;

    @JsonIgnoreProperties("topics")
    @ManyToMany(mappedBy = "topics",fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();
}
