package dev.alexengrig.myservices.customer.mapper;

import dev.alexengrig.myservices.customer.entity.CustomerEntity;
import dev.alexengrig.myservices.customer.domain.Customer;
import dev.alexengrig.myservices.customer.payload.CustomerRegistrationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity domainToEntity(Customer customer);

    Customer registrationRequestToDomain(CustomerRegistrationRequest request);

}
