package com.example.demo.model;

import java.util.List;

public class SeatListRequest {
    private List<Seat> seatslist;
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Seat> getSeatslist() {
        return seatslist;
    }

    public void setSeatslist(List<Seat> seatslist) {
        this.seatslist = seatslist;
    }
}
