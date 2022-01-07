package dev.alexengrig.sample.customer.mapper;

import dev.alexengrig.sample.customer.domain.Customer;
import dev.alexengrig.sample.customer.entity.CustomerEntity;
import dev.alexengrig.sample.customer.payload.CustomerRegistrationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity domainToEntity(Customer customer);

    Customer registrationRequestToDomain(CustomerRegistrationRequest request);

}
