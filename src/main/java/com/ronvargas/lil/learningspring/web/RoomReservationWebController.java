package com.ronvargas.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import com.ronvargas.lil.learningspring.business.domain.RoomReservation;
import com.ronvargas.lil.learningspring.business.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/reservations", method = RequestMethod.GET)
public class RoomReservationWebController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false)String dateString, Model model) {
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations;
        roomReservations = this.reservationService.getReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        
        return "reservations";
    }
}