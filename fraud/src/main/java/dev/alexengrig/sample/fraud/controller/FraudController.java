package dev.alexengrig.sample.fraud.controller;

import dev.alexengrig.sample.fraud.service.FraudCheckHistoryService;
import dev.alexengrig.sample.fraud.payload.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckHistoryService checkService;

    @PostMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Long customerId) {
        boolean isFraudulentCustomer = checkService.isFraudulentCustomer(customerId);
        return FraudCheckResponse.builder()
                .isFraudster(isFraudulentCustomer)
                .build();
    }

}
