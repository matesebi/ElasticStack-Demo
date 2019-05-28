package com.example.matesebi.ticketing.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IllegalCountException extends RuntimeException {

    public IllegalCountException(String message) {
        super(message);
    }
}
