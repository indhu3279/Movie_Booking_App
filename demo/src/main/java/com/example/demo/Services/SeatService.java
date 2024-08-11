package com.example.demo.Services;


import com.example.demo.model.Seat;
import com.example.demo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats(){
        return seatRepository.findAll();
    }
    public List<Seat> findByShowId(int showId){
        return seatRepository.findByShowId(showId);
    }
}
