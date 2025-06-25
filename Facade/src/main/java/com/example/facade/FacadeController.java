package com.example.facade;

import com.example.facade.domain.Reservation;
import com.example.facade.dto.ReserveRequestDto;
import com.example.facade.facade.ReservationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FacadeController {

    private final ReservationFacade reservationFacade;

    @PostMapping("/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReserveRequestDto req) {
        Reservation result = reservationFacade.reserve(req);
        return ResponseEntity.ok("예약 완료! ID: " + result.getId());
    }

}
