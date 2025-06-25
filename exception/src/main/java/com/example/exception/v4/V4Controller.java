package com.example.exception.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v4")
public class V4Controller {

    private final V4Service v4Service;
    @GetMapping("/users")
    public ResponseEntity<?> getUser() {
        v4Service.findUser(null);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/schedules")
    public ResponseEntity<?> getSchedule() {
        v4Service.findSchedule(null);
        return ResponseEntity.ok().build();
    }
}
