package dev.alexengrig.sample.customer.converter;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class Customer2CustomerEntityConverter
        implements Converter<Customer, CustomerEntity> {

    @Override
    public CustomerEntity convert(Customer source) {
        Assert.notNull(source, "The source must not be null");
        return CustomerEntity.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .build();
    }

}
