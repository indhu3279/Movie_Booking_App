package com.example.demo.controllers;


import com.example.demo.Services.SeatService;
import com.example.demo.model.Seat;
import com.example.demo.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/")
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }
    @GetMapping("/{showId}")
    public List<Seat> getSeatByShowId(@PathVariable int showId){
        return seatService.findByShowId(showId);
    }


}
