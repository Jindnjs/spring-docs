package com.example.facade.service;

import org.springframework.stereotype.Service;

@Service
public class CouponService {
    public void use(Long couponId) {
        System.out.println("쿠폰 사용 처리: " + couponId);
    }
}