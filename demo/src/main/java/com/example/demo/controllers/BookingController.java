package com.example.demo.controllers;
import com.example.demo.Services.BookingService;
import com.example.demo.model.Booking;
import com.example.demo.model.Seat;
import com.example.demo.model.SeatListRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("")
    public ResponseEntity<Map<String, String>> bookSeats(@RequestBody SeatListRequest bookingRequest) {
        final Logger logger = LoggerFactory.getLogger(BookingService.class);
        List<Long> seatIds = bookingRequest.getSeatslist().stream().map(Seat::getSeatId)
                .collect(Collectors.toList());

        String emailId = bookingRequest.getEmailId();
        logger.info("Received booking request for email: {}", emailId);
        Booking booking = new Booking();
        booking.setShowId(bookingRequest.getSeatslist().get(0).getShowId());
        booking.setBookingNumber(generateBookingNumber());
        try {
            bookingService.createBooking(seatIds, emailId,booking);
            Map<String, String> response = new HashMap<>();

            response.put("message", "Booking successful");
            response.put("bookingNumber", booking.getBookingNumber());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    private String generateBookingNumber() {
        return "BOOK" + System.currentTimeMillis();  // Simple booking number generator
    }
}
