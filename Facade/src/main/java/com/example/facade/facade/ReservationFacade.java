package com.example.facade.facade;

import com.example.facade.domain.Reservation;
import com.example.facade.dto.ReserveRequestDto;
import com.example.facade.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationFacade {

    private final PointService pointService;
    private final CouponService couponService;
    private final PaymentService paymentService;
    private final ReservationService reservationService;
    private final NotificationService notificationService;

    @Transactional
    public Reservation reserve(ReserveRequestDto req) {
        pointService.deduct(req.getUserId(), req.getPoint());
        couponService.use(req.getCouponId());
        paymentService.pay(req.getAmount());
        Reservation reservation = reservationService.create(req);
        notificationService.send(reservation);
        return reservation;
    }
}