package dev.alexengrig.sample.customer.converter;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.payload.CustomerRegistrationRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CustomerRegistrationRequest2CustomerConverter
        implements Converter<CustomerRegistrationRequest, Customer> {

    @NonNull
    @Override
    public Customer convert(CustomerRegistrationRequest source) {
        Assert.notNull(source, "The source must not be null");
        return Customer.builder()
                .firstName(source.firstName())
                .lastName(source.lastName())
                .email(source.email())
                .build();
    }

}
