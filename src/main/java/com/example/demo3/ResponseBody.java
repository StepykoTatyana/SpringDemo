package com.example.demo3;

import java.util.UUID;

public class ResponseBody {
    private UUID token;
    private AvailableSeats ticket;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public AvailableSeats getTicket() {
        return ticket;
    }

    public void setTicket(AvailableSeats ticket) {
        this.ticket = ticket;
    }

    public ResponseBody() {
    }

    public ResponseBody(UUID token, AvailableSeats ticket) {
        this.token = token;
        this.ticket = ticket;
    }
}
