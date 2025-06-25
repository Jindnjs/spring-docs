package com.example.facade.dto;

import lombok.Data;

@Data
public class ReserveRequestDto {
    private Long userId;
    private int point;
    private Long couponId;
    private int amount;
    private String serviceName;
}
