package com.example.StackOverflow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Topic extends BaseModel{

    @Column(nullable = false,unique = true)
    private String name;
}
