package com.example.facade.service;

import com.example.facade.domain.Reservation;
import com.example.facade.dto.ReserveRequestDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReservationService {
    private AtomicLong idGenerator = new AtomicLong();

    public Reservation create(ReserveRequestDto req) {
        System.out.println("예약 생성 완료 for user " + req.getUserId());
        return new Reservation(idGenerator.incrementAndGet(), req.getUserId(), req.getServiceName());
    }
}