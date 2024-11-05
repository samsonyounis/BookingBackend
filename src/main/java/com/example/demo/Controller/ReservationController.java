package com.example.demo.Controller;

import com.example.demo.Dto;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ReservationController {
    private final ReservationService reservationService;
@CrossOrigin
    @PostMapping("/reserve")
    public boolean saveReservation(@RequestBody Dto dto){
        log.info("saving reservation data: "+ dto);
        Reservation reservation = reservationService.saveReservation(dto);
        if (reservation != null){
            return true;
        }
        else {
            return false;
        }
    }
}
