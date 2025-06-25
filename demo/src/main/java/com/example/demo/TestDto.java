package com.example.demo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class TestDto {
    @NotNull(message = "이름은 필수입니다.")
    private String name;
    private int age;
}
