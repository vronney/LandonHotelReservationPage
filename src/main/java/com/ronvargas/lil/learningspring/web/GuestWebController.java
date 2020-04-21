package com.ronvargas.lil.learningspring.web;

import com.ronvargas.lil.learningspring.business.service.ReservationService;
import com.ronvargas.lil.learningspring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/guests", method = RequestMethod.GET)
public class GuestWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests (Model model) {
        List<Guest> guests = this.reservationService.getHotelGuest();
        model.addAttribute("guests", guests);

        return "guests";
    }
}
