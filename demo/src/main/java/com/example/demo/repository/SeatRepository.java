package com.example.demo.repository;


import com.example.demo.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowId(int showId);
    List<Seat> findAllBySeatIdIn(List<Long> seatIds);
}
