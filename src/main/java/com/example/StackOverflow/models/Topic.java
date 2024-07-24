package com.example.StackOverflow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @ManyToMany(mappedBy = "topics")
    private List<Question> questions = new ArrayList<>();
}
