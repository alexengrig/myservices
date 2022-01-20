package dev.alexengrig.myservices.fraud.controller;

import dev.alexengrig.myservices.fraud.payload.FraudCheckResponse;
import dev.alexengrig.myservices.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckHistoryService checkService;

    @GetMapping("/check/{customerId}")
    public FraudCheckResponse check(@PathVariable Long customerId) {
        log.info("Fraud checking by customer id: {}", customerId);
        boolean isFraudulentCustomer = checkService.isFraudulentCustomer(customerId);
        return FraudCheckResponse.builder()
                .isFraudster(isFraudulentCustomer)
                .build();
    }

}
