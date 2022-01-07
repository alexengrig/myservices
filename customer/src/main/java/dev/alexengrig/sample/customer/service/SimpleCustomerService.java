package dev.alexengrig.sample.customer.service;

import dev.alexengrig.sample.customer.CustomerRepository;
import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import dev.alexengrig.sample.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = mapper.domainToEntity(customer);
        repository.save(entity);
    }

}
