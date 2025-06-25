package com.example.demo.schedule;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
@Slf4j
@Getter
public class ScheduleCreateResponseDto {
    private Long id;
    private String userName;
    private String email;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ScheduleCreateResponseDto(Long id,String title, String content, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public static ScheduleCreateResponseDto toDto(Schedule saveSchedule) {
        log.info("this is dto");
        ScheduleCreateResponseDto dto =
                new ScheduleCreateResponseDto(saveSchedule.getId()

                , saveSchedule.getTitle(), saveSchedule.getContent(), saveSchedule.getCreatedAt(), saveSchedule.getUpdatedAt());
        return dto;
    }
}
