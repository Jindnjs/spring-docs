package com.example.demo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponseDto> create(
            @RequestBody UserCreateRequestDto dto
    ){
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserCreateResponseDto> create(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(userService.getById(id));
    }

}
