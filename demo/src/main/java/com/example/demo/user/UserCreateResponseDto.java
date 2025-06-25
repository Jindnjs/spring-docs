package com.example.demo.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCreateResponseDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserCreateResponseDto(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserCreateResponseDto toDto(User user) {
        return new UserCreateResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
