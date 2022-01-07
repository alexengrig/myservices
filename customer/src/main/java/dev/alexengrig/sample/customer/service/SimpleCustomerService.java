package dev.alexengrig.sample.customer.service;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import dev.alexengrig.sample.customer.mapper.CustomerMapper;
import dev.alexengrig.sample.customer.repository.CustomerRepository;
import dev.alexengrig.sample.fraud.client.FraudClient;
import dev.alexengrig.sample.fraud.payload.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final FraudClient fraudClient;

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = mapper.domainToEntity(customer);
        repository.saveAndFlush(entity);
        FraudCheckResponse checkResponse = fraudClient.check(entity.getId());
        if (checkResponse.isFraudster()) {
            throw new IllegalArgumentException("fraudster");
        }
    }

}
