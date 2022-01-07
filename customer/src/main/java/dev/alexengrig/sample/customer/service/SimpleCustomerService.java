package dev.alexengrig.sample.customer.service;

import dev.alexengrig.sample.customer.CustomerRepository;
import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import dev.alexengrig.sample.customer.mapper.CustomerMapper;
import dev.alexengrig.sample.customer.payload.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final RestTemplate restTemplate;

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = mapper.domainToEntity(customer);
        repository.saveAndFlush(entity);
        FraudCheckResponse checkResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud/check/{customerId}",
                FraudCheckResponse.class,
                entity.getId());
        if (checkResponse.isFraudster()) {
            throw new IllegalArgumentException("fraudster");
        }
    }

}
