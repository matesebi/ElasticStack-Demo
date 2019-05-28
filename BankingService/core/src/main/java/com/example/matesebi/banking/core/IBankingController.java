package com.example.matesebi.banking.core;

import com.example.matesebi.banking.api.dto.ChargeAccountRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IBankingController {

    @PostMapping("/api/banking/charge/{accountId}")
    void charge(@PathVariable("accountId") String accountId, @RequestBody ChargeAccountRequest request);

}
