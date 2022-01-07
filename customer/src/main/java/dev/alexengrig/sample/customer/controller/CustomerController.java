package dev.alexengrig.sample.customer.controller;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.mapper.CustomerMapper;
import dev.alexengrig.sample.customer.payload.CustomerRegistrationRequest;
import dev.alexengrig.sample.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;

    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest request) {
        log.info("New customer registration: {}", request);
        Customer customer = mapper.registrationRequestToDomain(request);
        service.create(customer);
    }

}
