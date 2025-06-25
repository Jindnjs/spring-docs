package com.example.demo.user;

import lombok.Getter;

@Getter
public class UserCreateRequestDto {
    private String username;
    private String password;
    private String email;

    public User toEntity(){
        User user = new User(username, password, email);
        return user;
    }
}
