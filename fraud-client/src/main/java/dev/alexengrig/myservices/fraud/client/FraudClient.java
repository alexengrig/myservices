package dev.alexengrig.myservices.fraud.client;

import dev.alexengrig.myservices.fraud.payload.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("/api/v1/fraud/check/{customerId}")
    FraudCheckResponse check(@PathVariable("customerId") Long customerId);

}
