package com.example.demo.schedule;

import lombok.Getter;

@Getter
public class ScheduleCreateRequestDto {

    private String title;
    private String content;
    private Long userId;

}
