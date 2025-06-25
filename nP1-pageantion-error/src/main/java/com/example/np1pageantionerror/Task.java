package com.example.np1pageantionerror;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    @BatchSize(size = 5)
    private List<Comment> comments = new ArrayList<>();

}