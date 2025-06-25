package com.example.facade.service;

import com.example.facade.domain.Reservation;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void send(Reservation reservation) {
        System.out.println("알림 전송 완료 to user " + reservation.getUserId());
    }
}