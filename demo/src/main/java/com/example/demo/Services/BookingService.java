package com.example.demo.Services;

import com.example.demo.model.Booking;
import com.example.demo.model.Seat;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
@Service
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    EmailService emailService = new EmailService();

    @Transactional
    public void createBooking(List<Long> seatIds, String emailId,Booking bookingRequest){
         logger.info("Received booking request for email: {}", emailId);
         if (emailId == null || emailId.isEmpty()) {
            throw new IllegalArgumentException("Email ID cannot be null or empty.");
        }
        try {
            List<Seat> seatsToBook = seatRepository.findAllBySeatIdIn(seatIds);

//             Check if any seat is already booked
            for (Seat seat : seatsToBook) {
                if (seat.getIsReserved()) {
                    throw new RuntimeException("One or more seats are already booked-1");
                }
            }

            // Mark the seats as reserved
            for (Seat seat : seatsToBook) {
                seat.setIsReserved(true);
            }

            // Save the seats and handle optimistic locking
            seatRepository.saveAll(seatsToBook);

            bookingRequest.setCreatedOn(new Date());
            bookingRequest.setBookingStatus("CONFIRMED");
            bookingRequest.setNumberOfSeats(seatsToBook.size());
            bookingRepository.save(bookingRequest);
            emailService.sendBookingConfirmation(emailId, "Your booking request is successful");

        } catch (ObjectOptimisticLockingFailureException e) {
            throw new RuntimeException("Concurrency conflict: One or more seats were already booked by another user-2");
        }
    }
}
