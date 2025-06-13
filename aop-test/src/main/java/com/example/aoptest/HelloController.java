package com.example.aoptest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @PostMapping("/api/hello")
    public ResponseEntity<String> hello(@RequestBody HelloRequestDto request) {
        log.info("=== 컨트롤러 메서드 실행 ===");
        log.info("컨트롤러에서 받은 데이터: name={}, age={}", request.getName(), request.getAge());
        log.info("=== 컨트롤러 메서드 완료 ===");
        return ResponseEntity.ok("success");
    }
}
