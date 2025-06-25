package com.example.exception.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v3")
public class V3Controller {

    private final V3Service v3Service;
    @GetMapping("/users")
    public ResponseEntity<?> getUser() {
        v3Service.findUser(null);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/schedules")
    public ResponseEntity<?> getSchedule() {
        v3Service.findSchedule(null);
        return ResponseEntity.ok().build();
    }
}
