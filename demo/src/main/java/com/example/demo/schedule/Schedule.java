package com.example.demo.schedule;

import com.example.demo.common.BaseEntity;
import com.example.demo.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    public Schedule() {
    }

    public Schedule(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
