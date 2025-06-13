package com.example.aoptest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @PostMapping("/api/users/role")
    public ResponseEntity<String> changeUserRole(@CustomRequestBody UserRoleChangeRequest request) {
        log.info("=== 컨트롤러 메서드 실행 ===");
        log.info("컨트롤러에서 받은 데이터: userId={}, userRolde={}", request.getUserId(), request.getUserRole());
        log.info("=== 컨트롤러 메서드 완료 ===");
        return ResponseEntity.ok("Role changed successfully");
    }
}