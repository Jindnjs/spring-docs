package com.example.facade.domain;

import lombok.Data;

@Data
public class Reservation {
    private Long id;
    private Long userId;
    private String serviceName;

    public Reservation(Long id, Long userId, String serviceName) {
        this.id = id;
        this.userId = userId;
        this.serviceName = serviceName;
    }
}
