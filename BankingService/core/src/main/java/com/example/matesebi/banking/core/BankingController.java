package com.example.matesebi.banking.core;

import com.example.matesebi.banking.api.dto.ChargeAccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController implements IBankingController {

    @ExceptionHandler(value = RuntimeException.class)
    private ResponseEntity<?> runtimeException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getLocalizedMessage());
    }

    @Override
    public void charge(String accountId, ChargeAccountRequest request) {
        if (accountId.length() % 2 == 1) {
            throw new RuntimeException("Invalid accountId");
        }
    }
}
