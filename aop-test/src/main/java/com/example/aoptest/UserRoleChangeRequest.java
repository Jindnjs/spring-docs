package com.example.aoptest;

import lombok.Data;

@Data
public class UserRoleChangeRequest {
    private String userId;
    private String userRole;
}
