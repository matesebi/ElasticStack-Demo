package com.example.matesebi.ticketing;

import com.example.matesebi.banking.api.BankingClient;
import com.example.matesebi.banking.api.dto.ChargeAccountRequest;
import com.example.matesebi.movie.api.MovieClient;
import com.example.matesebi.ticketing.dto.TicketRequest;
import com.example.matesebi.ticketing.dto.TicketResponse;
import com.example.matesebi.ticketing.dto.TicketStatus;
import com.example.matesebi.ticketing.error.IllegalCountException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TicketingController {

    private static final int PRICE = 100;

    private MovieClient movieClient;
    private BankingClient bankingClient;


    public TicketingController(MovieClient movieClient, BankingClient bankingClient) {
        this.movieClient = movieClient;
        this.bankingClient = bankingClient;
    }

    @PostMapping(value = "/buy-ticket")
    public TicketResponse buyTicket(@RequestBody TicketRequest request) {
        if (request.getCount() < 1) {
            throw new IllegalCountException("Count is less than 1: " + request.getCount());
        }

        try {
            movieClient.getMovieById(request.getMovieId());
            bankingClient.charge(request.getAccountId(), new ChargeAccountRequest(BigDecimal.valueOf(PRICE * request.getCount())));

        } catch (Exception e) {
            return new TicketResponse(TicketStatus.FAILURE);
        }

        return new TicketResponse(TicketStatus.SUCCESS);
    }
}
