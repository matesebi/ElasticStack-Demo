package com.example.matesebi.banking.api;

import com.example.matesebi.banking.api.dto.ChargeAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "banking", url = "${banking.url}/api/banking")
public interface BankingClient {

    @PostMapping("/charge/{accountId}")
    void charge(@PathVariable("accountId") String accountId, @RequestBody ChargeAccountRequest request);
}
