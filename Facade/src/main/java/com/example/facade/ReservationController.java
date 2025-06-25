package com.example.facade;

import com.example.facade.domain.Reservation;
import com.example.facade.dto.ReserveRequestDto;
import com.example.facade.facade.ReservationFacade;
import com.example.facade.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final PointService pointService;
    private final CouponService couponService;
    private final PaymentService paymentService;
    private final ReservationService reservationService;
    private final NotificationService notificationService;

    @PostMapping("/before/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReserveRequestDto req) {
        pointService.deduct(req.getUserId(), req.getPoint());
        couponService.use(req.getCouponId());
        paymentService.pay(req.getAmount());
        Reservation reservation = reservationService.create(req);
        notificationService.send(reservation);
        return ResponseEntity.ok("예약 완료! ID: " + reservation.getId());
    }
}