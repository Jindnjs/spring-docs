package com.example.facade.service;

import org.springframework.stereotype.Service;

@Service
public class PointService {
    public void deduct(Long userId, int point) {
        System.out.println("포인트 차감: " + point + " for user " + userId);
    }
}