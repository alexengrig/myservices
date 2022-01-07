package dev.alexengrig.sample.customer.service;

import dev.alexengrig.sample.customer.CustomerRepository;
import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository repository;
    private final Converter<Customer, CustomerEntity> customerEntityConverter;

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = customerEntityConverter.convert(customer);
        repository.save(entity);
    }

}
