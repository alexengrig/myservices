package dev.alexengrig.sample.customer.controller;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.payload.CustomerRegistrationRequest;
import dev.alexengrig.sample.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final Converter<CustomerRegistrationRequest, Customer> customerConverter;

    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest request) {
        log.info("New customer registration: {}", request);
        Customer customer = customerConverter.convert(request);
        customerService.create(customer);
    }

}
