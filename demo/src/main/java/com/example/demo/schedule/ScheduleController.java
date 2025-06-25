package com.example.demo.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponseDto> create(
            @RequestBody ScheduleCreateRequestDto dto
    ){

        return ResponseEntity.ok(scheduleService.create(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleCreateResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.get());
    }
}
