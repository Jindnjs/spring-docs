package com.example.facade;

import com.example.facade.domain.Reservation;
import com.example.facade.dto.ReserveRequestDto;
import com.example.facade.facade.ReservationFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FacadeApplicationTests {


    @Autowired
    private ReservationFacade reservationFacade;

    @Test
    void 예약_성공_흐름_테스트() {
        // given
        ReserveRequestDto request = new ReserveRequestDto();
        request.setUserId(1L);
        request.setPoint(1000);
        request.setCouponId(123L);
        request.setAmount(30000);
        request.setServiceName("피트니스");

        // when
        Reservation reservation = reservationFacade.reserve(request);

        // then
        assertNotNull(reservation);
        assertEquals("피트니스", reservation.getServiceName());
        System.out.println("예약 성공: ID = " + reservation.getId());
    }

}
